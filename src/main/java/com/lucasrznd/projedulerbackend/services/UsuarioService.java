package com.lucasrznd.projedulerbackend.services;

import com.lucasrznd.projedulerbackend.dtos.request.UsuarioRequest;
import com.lucasrznd.projedulerbackend.dtos.response.UsuarioResponse;
import com.lucasrznd.projedulerbackend.exceptions.BusinessRuleException;
import com.lucasrznd.projedulerbackend.exceptions.ResourceNotFoundException;
import com.lucasrznd.projedulerbackend.mappers.UsuarioMapper;
import com.lucasrznd.projedulerbackend.models.Usuario;
import com.lucasrznd.projedulerbackend.repositories.ProjetoRepository;
import com.lucasrznd.projedulerbackend.repositories.UsuarioAtividadeRepository;
import com.lucasrznd.projedulerbackend.repositories.UsuarioProjetoRepository;
import com.lucasrznd.projedulerbackend.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository repository;
    private final UsuarioMapper mapper;
    private final BCryptPasswordEncoder encoder;

    private final ProjetoRepository projetoRepository;
    private final UsuarioProjetoRepository usuarioProjetoRepository;
    private final UsuarioAtividadeRepository usuarioAtividadeRepository;

    public UsuarioResponse create(final UsuarioRequest request) {
        verifyIfEmailAlreadyExists(request.email(), null);

        Usuario usuario = mapper.toModel(request);
        if (Objects.isNull(usuario.getDataCriacao())) {
            usuario.setDataCriacao(LocalDateTime.now());
        }
        usuario.setSenha(encoder.encode(usuario.getSenha()));

        return mapper.toResponse(repository.save(usuario));
    }

    public List<UsuarioResponse> findAll() {
        return repository.findAll().stream().map(mapper::toResponse).toList();
    }

    public List<UsuarioResponse> findAllByProjetoId(Long projetoId) {
        return repository.findByProjetoId(projetoId).stream().map(mapper::toResponse).toList();
    }

    public List<UsuarioResponse> findUsuariosDisponiveisByProjetoId(Long projetoId) {
        List<Usuario> usuarios = repository.findAll();
        List<Usuario> usuariosNoProjeto = repository.findByProjetoId(projetoId);

        return usuarios.stream()
                .filter(usuario -> usuariosNoProjeto.stream().noneMatch(up -> up.getId().equals(usuario.getId())))
                .map(mapper::toResponse)
                .toList();
    }

    public List<UsuarioResponse> findAllByAtividadeId(Long atividadeId) {
        return repository.findAllByAtividadeId(atividadeId).stream().map(mapper::toResponse).toList();
    }

    public Usuario findByEmail(String email) {
        return repository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado."));
    }

    public UsuarioResponse update(final Long id, final UsuarioRequest request) {
        Usuario usuario = find(id);
        verifyIfEmailAlreadyExists(request.email(), id);

        return mapper.toResponse(
                repository.save(
                        mapper.update(request, usuario)
                                .withSenha(request.senha() != null ? encoder.encode(request.senha())
                                        : usuario.getSenha()))
        );
    }

    /**
     * Realiza a exclusão lógica (soft delete) de um usuário e todos os seus registros relacionados.
     * Esta operação marca o usuário como inativo no sistema, mas mantém seus dados históricos.
     * Todas as operações são executadas dentro de uma única transação para garantir a integridade dos dados.
     *
     * <p>Antes da exclusão, é realizada uma validação para garantir que o usuário não seja
     * responsável por projetos ativos, evitando inconsistências nos dados.</p>
     *
     * @param id Identificador único do usuário a ser excluído logicamente
     * @throws ResourceNotFoundException se o usuário com o ID especificado não existir
     * @throws BusinessRuleException     se o usuário for responsável por projetos ativos
     */
    @Transactional
    public void delete(final Long id) {
        Usuario usuario = find(id);
        validarExclusao(usuario.getId());
        LocalDateTime dataExclusao = LocalDateTime.now();

        // Desativa registros relacionados
        cascadeSoftDelete(usuario.getId(), dataExclusao);

        repository.softDeleteById(usuario.getId(), dataExclusao);
    }

    /**
     * Executa a exclusão lógica em cascata de todos os registros relacionados a um usuário.
     * Este método marca como inativos os registros de:
     * <ul>
     *     <li>Associações entre usuários e projetos</li>
     *     <li>Atividades associadas ao usuário</li>
     *     <li>Lançamentos de horas realizados pelo usuário</li>
     * </ul>
     *
     * <p>Todos os registros são marcados com a mesma data e hora de exclusão para
     * manter a consistência temporal da operação.</p>
     *
     * @param id Identificador único do usuário cujos registros relacionados serão excluídos logicamente
     */
    private void cascadeSoftDelete(final Long id, final LocalDateTime dataExclusao) {
        usuarioProjetoRepository.softDeleteAllByUsuarioId(id, dataExclusao);
        usuarioAtividadeRepository.softDeleteAllByUsuarioId(id, dataExclusao);
    }

    public Usuario find(final Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado. Id: " + id));
    }

    private void verifyIfEmailAlreadyExists(final String email, Long id) {
        repository.findByEmail(email)
                .filter(user -> !user.getId().equals(id))
                .ifPresent(user -> {
                    throw new BusinessRuleException("Email [ " + email + " ] já existe.");
                });
    }

    private void validarExclusao(Long id) {
        Long qtdProjetosAtivos = projetoRepository.countProjetosByUsuarioResponsavelId(id);
        if (qtdProjetosAtivos > 0) {
            throw new DataIntegrityViolationException("Não é possível remover o usuário pois ele é responsável por " + qtdProjetosAtivos + " projeto(s) ativo(s).");
        }
    }
}
