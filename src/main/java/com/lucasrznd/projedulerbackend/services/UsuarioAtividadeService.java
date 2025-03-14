package com.lucasrznd.projedulerbackend.services;

import com.lucasrznd.projedulerbackend.dtos.request.UsuarioAtividadeRequest;
import com.lucasrznd.projedulerbackend.dtos.response.UsuarioAtividadeResponse;
import com.lucasrznd.projedulerbackend.mappers.UsuarioAtividadeMapper;
import com.lucasrznd.projedulerbackend.models.Atividade;
import com.lucasrznd.projedulerbackend.models.Notificacao;
import com.lucasrznd.projedulerbackend.models.Usuario;
import com.lucasrznd.projedulerbackend.models.UsuarioAtividade;
import com.lucasrznd.projedulerbackend.repositories.UsuarioAtividadeRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.hibernate.service.spi.ServiceException;
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

    @Transactional
    public UsuarioAtividadeResponse save(final UsuarioAtividadeRequest request) {
        try {
            Usuario usuario = usuarioService.find(request.usuarioId());
            Atividade atividade = atividadeService.find(request.atividadeId());

            UsuarioAtividade usuarioAtividade = mapper.toModel(request);
            usuarioAtividade.setUsuario(usuario);
            usuarioAtividade.setAtividade(atividade);
            usuarioAtividade.setDataEntrada(LocalDateTime.now());

            UsuarioAtividade entidadeSalva = repository.save(usuarioAtividade);

            // Notificar sobre associação
            criarNotificacaoAssociacao(usuario, atividade);

            return mapper.toResponse(entidadeSalva);
        } catch (EntityNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new ServiceException("Não foi possível completar a associação usuário-atividade", e);
        }
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

    private void criarNotificacaoAssociacao(Usuario usuario, Atividade atividade) {
        Notificacao notificacao = new Notificacao();
        notificacao.setUsuario(usuario);
        notificacao.setMensagem(notificacaoService.criarMensagem("", atividade.getNome()));
        notificacao.setTipo("NOVA_ATIVIDADE");
        notificacao.setDataCriacao(LocalDateTime.now());
        notificacao.setLida(false);
        notificacao.setAtividade(atividade);

        notificacaoService.save(notificacao);
    }
}
