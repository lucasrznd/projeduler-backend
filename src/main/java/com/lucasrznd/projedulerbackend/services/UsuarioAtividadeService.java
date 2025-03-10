package com.lucasrznd.projedulerbackend.services;

import com.lucasrznd.projedulerbackend.dtos.request.NotificacaoRequest;
import com.lucasrznd.projedulerbackend.dtos.request.UsuarioAtividadeRequest;
import com.lucasrznd.projedulerbackend.dtos.response.UsuarioAtividadeResponse;
import com.lucasrznd.projedulerbackend.mappers.UsuarioAtividadeMapper;
import com.lucasrznd.projedulerbackend.models.Atividade;
import com.lucasrznd.projedulerbackend.models.Usuario;
import com.lucasrznd.projedulerbackend.models.UsuarioAtividade;
import com.lucasrznd.projedulerbackend.repositories.UsuarioAtividadeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioAtividadeService {

    private final UsuarioAtividadeRepository repository;
    private final UsuarioAtividadeMapper mapper;
    private final UsuarioService usuarioService;
    private final AtividadeService atividadeService;
    private final NotificacaoService notificacaoService;

    public UsuarioAtividadeResponse save(final UsuarioAtividadeRequest request) {
        Usuario usuario = usuarioService.find(request.usuarioId());
        Atividade atividade = atividadeService.find(request.atividadeId());

        UsuarioAtividade usuarioAtividade = mapper.toModel(request);
        usuarioAtividade.setUsuario(usuario);
        usuarioAtividade.setAtividade(atividade);
        usuarioAtividade.setDataEntrada(LocalDateTime.now());

        // Criar notificação de atividade para o usuário
        NotificacaoRequest notificacao = new NotificacaoRequest(usuario.getId(),
                notificacaoService.criarMensagem("", atividade.getNome()),
                "NOVO_PROJETO",
                atividade.getId(), null
        );
        notificacaoService.save(notificacao);

        return mapper.toResponse(repository.save(usuarioAtividade));
    }

    public List<UsuarioAtividadeResponse> saveAll(final List<UsuarioAtividadeRequest> requests) {
        List<UsuarioAtividade> usuarioAtividades = mapper.toModelList(requests);
        usuarioAtividades.forEach(usuarioAtividade -> {
            usuarioAtividade.setDataEntrada(LocalDateTime.now());
        });

        return repository.saveAll(usuarioAtividades).stream().map(mapper::toResponse).toList();
    }

    public List<UsuarioAtividadeResponse> findAll() {
        return repository.findAll().stream().map(mapper::toResponse).toList();
    }

    @Transactional
    public void delete(final Long usuarioId, final Long atividadeId) {
        UsuarioAtividade usuarioAtividade = findByUsuarioIdAndAtividadeId(usuarioId, atividadeId);

        repository.softDeleteById(usuarioAtividade.getId(), LocalDateTime.now());
    }

    private UsuarioAtividade findByUsuarioIdAndAtividadeId(final Long usuarioId, final Long atividadeId) {
        return repository.findByUsuarioIdAndAtividadeId(usuarioId, atividadeId)
                .orElseThrow(() -> new RuntimeException("Usuário da atividade não encontrado. Id: " + usuarioId));
    }
}
