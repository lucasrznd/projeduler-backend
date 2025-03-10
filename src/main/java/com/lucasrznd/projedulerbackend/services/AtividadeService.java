package com.lucasrznd.projedulerbackend.services;

import com.lucasrznd.projedulerbackend.dtos.request.AtividadeRequest;
import com.lucasrznd.projedulerbackend.dtos.response.AtividadeResponse;
import com.lucasrznd.projedulerbackend.exceptions.ResourceNotFoundException;
import com.lucasrznd.projedulerbackend.mappers.AtividadeMapper;
import com.lucasrznd.projedulerbackend.models.Atividade;
import com.lucasrznd.projedulerbackend.models.Usuario;
import com.lucasrznd.projedulerbackend.repositories.AtividadeRepository;
import com.lucasrznd.projedulerbackend.repositories.UsuarioAtividadeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AtividadeService {

    private final AtividadeRepository repository;
    private final AtividadeMapper mapper;
    private final UsuarioService usuarioService;

    private final UsuarioAtividadeRepository usuarioAtividadeRepository;

    public AtividadeResponse save(final AtividadeRequest request) {
        Atividade atividade = mapper.toModel(request);
        atividade.setDataCriacao(LocalDateTime.now());

        return mapper.toResponse(repository.save(atividade));
    }

    public List<AtividadeResponse> findAll(UserDetails user) {
        Usuario usuario = usuarioService.findByEmail(user.getUsername());

        if (usuario.getPerfil().equals("ADMIN")) {
            return repository.findAllAtividades().stream().map(mapper::toResponse).toList();
        }

        return repository.findByUsuarioResponsavelId(usuario.getId()).stream().map(mapper::toResponse).toList();
    }

    public Long countAllByStatus(String status, UserDetails user) {
        Usuario usuario = usuarioService.findByEmail(user.getUsername());

        if (usuario.getPerfil().equals("ADMIN")) {
            return repository.countAllByStatus(status);
        }

        return repository.countAllByStatusAndUsuarioId(status, usuario.getId());
    }

    public List<AtividadeResponse> findAllAtrasadas(UserDetails user) {
        Usuario usuario = usuarioService.findByEmail(user.getUsername());

        if (usuario.getPerfil().equals("ADMIN")) {
            return repository.findAllAtrasadas().stream().map(mapper::toResponse).toList();
        }

        return repository.findAllAtrasadasByUsuarioId(usuario.getId()).stream().map(mapper::toResponse).toList();
    }

    public Long countAllPendentes(UserDetails user) {
        Usuario usuario = usuarioService.findByEmail(user.getUsername());

        if (usuario.getPerfil().equals("ADMIN")) {
            return repository.countAllByStatus("ABERTA");
        }

        return repository.countAllByStatusAndUsuarioId("ABERTA", usuario.getId());
    }

    public Long countAllAtrasdas(UserDetails user) {
        Usuario usuario = usuarioService.findByEmail(user.getUsername());

        if (usuario.getPerfil().equals("ADMIN")) {
            return repository.countAllAtrasadas();
        }

        return repository.countAllAtrasadasByUsuarioId(usuario.getId());
    }

    public AtividadeResponse update(Long id, AtividadeRequest request) {
        Atividade atividade = find(id);

        return mapper.toResponse(repository.save(mapper.update(request, atividade)));
    }

    /**
     * Realiza a exclusão lógica (soft delete) de uma atividade específica e suas associações com usuários.
     * Esta operação marca a atividade como inativa no sistema, preservando seu histórico para consultas futuras.
     * Todas as operações são executadas dentro de uma única transação para garantir a integridade dos dados.
     *
     * <p>O processo de exclusão inclui os seguintes passos:</p>
     * <ol>
     *     <li>Recuperação da atividade pelo seu identificador</li>
     *     <li>Exclusão lógica de todas as associações entre usuários e a atividade</li>
     *     <li>Exclusão lógica da atividade em si</li>
     * </ol>
     *
     * <p>A mesma data e hora de exclusão é aplicada a todos os registros para manter a consistência
     * temporal da operação.</p>
     *
     * @param id Identificador único da atividade a ser excluída logicamente
     * @throws ResourceNotFoundException se a atividade com o ID especificado não existir
     */
    @Transactional
    public void delete(final Long id) {
        Atividade atividade = find(id);
        LocalDateTime dataExclusao = LocalDateTime.now();

        // Soft delete nos relacionamentos de usuários em atividades
        usuarioAtividadeRepository.softDeleteAllByAtividadeId(atividade.getId(), dataExclusao);

        repository.softDeleteById(atividade.getId(), dataExclusao);
    }

    /**
     * Realiza a exclusão lógica (soft delete) de todas as atividades associadas a um projeto específico
     * e suas associações com usuários.
     * Esta operação é geralmente executada como parte do processo de exclusão de um projeto.
     * Todas as operações são executadas dentro de uma única transação para garantir a integridade dos dados.
     *
     * <p>O processo de exclusão inclui os seguintes passos:</p>
     * <ol>
     *     <li>Exclusão lógica de todas as associações entre usuários e as atividades do projeto</li>
     *     <li>Exclusão lógica de todas as atividades vinculadas ao projeto</li>
     * </ol>
     *
     * <p>A mesma data e hora de exclusão é aplicada a todos os registros para manter a consistência
     * temporal da operação e facilitar auditorias futuras.</p>
     *
     * @param projetoId Identificador único do projeto cujas atividades serão excluídas logicamente
     * @param dataExclusao Data e hora em que a exclusão lógica está sendo realizada
     */
    @Transactional
    public void softDeleteAllByProjetoId(Long projetoId, LocalDateTime dataExclusao) {
        // Soft delete nos relacionamentos do usuário em atividades
        usuarioAtividadeRepository.softDeleteAllByProjetoId(projetoId, dataExclusao);

        repository.softDeleteAllByProjetoId(projetoId, dataExclusao);
    }

    public Atividade find(final Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Atividade não encontrada. Id: " + id));
    }
}
