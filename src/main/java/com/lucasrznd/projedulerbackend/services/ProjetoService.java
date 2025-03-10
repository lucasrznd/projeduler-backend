package com.lucasrznd.projedulerbackend.services;

import com.lucasrznd.projedulerbackend.dtos.request.ProjetoRequest;
import com.lucasrznd.projedulerbackend.dtos.response.ProjetoResponse;
import com.lucasrznd.projedulerbackend.exceptions.ResourceNotFoundException;
import com.lucasrznd.projedulerbackend.mappers.ProjetoMapper;
import com.lucasrznd.projedulerbackend.models.Projeto;
import com.lucasrznd.projedulerbackend.models.Usuario;
import com.lucasrznd.projedulerbackend.repositories.ProjetoRepository;
import com.lucasrznd.projedulerbackend.repositories.UsuarioProjetoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjetoService {

    private final ProjetoRepository repository;
    private final ProjetoMapper mapper;
    private final UsuarioService usuarioService;
    private final AtividadeService atividadeService;

    private final UsuarioProjetoRepository usuarioProjetoRepository;

    public ProjetoResponse save(final ProjetoRequest request) {
        Projeto projeto = mapper.toModel(request);
        projeto.setDataCriacao(LocalDateTime.now());

        return mapper.toResponse(repository.save(projeto));
    }

    /**
     * Retorna uma lista de projetos acessíveis pelo usuário autenticado.
     * <p>
     * - Se o usuário for ADMIN, retorna todos os projetos do sistema.
     * - Caso contrário, retorna apenas os projetos nos quais o usuário está associado.
     * </p>
     *
     * @param user Objeto {@link UserDetails} representando o usuário autenticado.
     * @return Lista de {@link ProjetoResponse} contendo os projetos visíveis ao usuário.
     * @throws UsernameNotFoundException Se o usuário autenticado não for encontrado no banco de dados.
     */
    public List<ProjetoResponse> findAll(UserDetails user) {
        Usuario usuario = usuarioService.findByEmail(user.getUsername());

        if (usuario.getPerfil().equals("ADMIN")) {
            return repository.findAllProjetos().stream().map(mapper::toResponse).toList();
        }

        return repository.findByUsuarioId(usuario.getId()).stream().map(mapper::toResponse).toList();
    }

    public Long countAllByStatus(String status, UserDetails user) {
        Usuario usuario = usuarioService.findByEmail(user.getUsername());

        if (usuario.getPerfil().equals("ADMIN")) {
            return repository.countAllByStatus(status);
        }

        return repository.countAllByStatusAndUsuarioId(status, usuario.getId());
    }

    public ProjetoResponse update(Long id, ProjetoRequest request) {
        Projeto projeto = find(id);

        return mapper.toResponse(repository.save(mapper.update(request, projeto)));
    }

    /**
     * Realiza a exclusão lógica (soft delete) de um projeto e todos os seus registros associados.
     * Esta operação marca o projeto como inativo no sistema, preservando seu histórico para consultas futuras.
     * Todas as operações são executadas dentro de uma única transação para garantir a integridade dos dados.
     *
     * <p>O processo de exclusão inclui os seguintes passos:</p>
     * <ol>
     *     <li>Recuperação do projeto pelo seu identificador</li>
     *     <li>Execução da exclusão lógica em cascata dos registros associados (atividades e usuários relacionados)</li>
     *     <li>Exclusão lógica do projeto em si</li>
     * </ol>
     *
     * <p>A mesma data e hora de exclusão é aplicada a todos os registros para manter a consistência
     * temporal da operação.</p>
     *
     * @param id Identificador único do projeto a ser excluído logicamente
     * @throws ResourceNotFoundException se o projeto com o ID especificado não existir
     */
    @Transactional
    public void delete(final Long id) {
        Projeto projeto = find(id);
        LocalDateTime dataExclusao = LocalDateTime.now();

        // Deleta todas as atividades associadas ao projeto
        cascadeSoftDelete(projeto.getId(), dataExclusao);

        repository.softDeleteById(projeto.getId(), dataExclusao);
    }

    /**
     * Executa a exclusão lógica em cascata de todos os registros relacionados a um projeto.
     * Este método coordena a exclusão lógica de:
     * <ul>
     *     <li>Todas as atividades vinculadas ao projeto (que por sua vez desencadeiam a exclusão dos lançamentos de horas)</li>
     *     <li>Todas as associações entre usuários e o projeto</li>
     * </ul>
     *
     * <p>Este método é utilizado como parte da exclusão completa de um projeto, garantindo
     * que todos os registros associados sejam desativados de forma consistente.</p>
     *
     * @param id Identificador único do projeto cujos registros associados serão excluídos logicamente
     * @param dataExclusao Data e hora em que a exclusão lógica está sendo realizada
     */
    public void cascadeSoftDelete(final Long id, final LocalDateTime dataExclusao) {
        atividadeService.softDeleteAllByProjetoId(id, dataExclusao);
        usuarioProjetoRepository.softDeleteAllByProjetoId(id, dataExclusao);
    }

    public Projeto find(final Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Projeto não encontrado. Id: " + id + ", Tipo: " + ProjetoResponse.class.getSimpleName()));
    }
}
