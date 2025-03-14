package com.lucasrznd.projedulerbackend.services;

import com.lucasrznd.projedulerbackend.dtos.request.UsuarioProjetoRequest;
import com.lucasrznd.projedulerbackend.dtos.response.UsuarioProjetoResponse;
import com.lucasrznd.projedulerbackend.exceptions.ResourceNotFoundException;
import com.lucasrznd.projedulerbackend.mappers.UsuarioProjetoMapper;
import com.lucasrznd.projedulerbackend.models.Notificacao;
import com.lucasrznd.projedulerbackend.models.Projeto;
import com.lucasrznd.projedulerbackend.models.Usuario;
import com.lucasrznd.projedulerbackend.models.UsuarioProjeto;
import com.lucasrznd.projedulerbackend.repositories.UsuarioProjetoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioProjetoService {

    private final UsuarioProjetoRepository repository;
    private final UsuarioProjetoMapper mapper;
    private final UsuarioService usuarioService;
    private final ProjetoService projetoService;
    private final NotificacaoService notificacaoService;

    @Transactional
    public UsuarioProjetoResponse save(final UsuarioProjetoRequest request) {
        try {
            Usuario usuario = usuarioService.find(request.usuarioId());
            Projeto projeto = projetoService.find(request.projetoId());

            UsuarioProjeto usuarioProjeto = mapper.toModel(request);
            usuarioProjeto.setUsuario(usuario);
            usuarioProjeto.setProjeto(projeto);
            usuarioProjeto.setDataEntrada(LocalDate.now());

            UsuarioProjeto entidadeSalva = repository.save(usuarioProjeto);

            // Notificar sobre associação
            criarNotificacaoAssociacao(usuario, projeto);

            return mapper.toResponse(entidadeSalva);
        } catch (EntityNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new ServiceException("Não foi possível completar a associação usuário-projeto", e);
        }
    }

    public List<UsuarioProjetoResponse> findAll() {
        return repository.findAll().stream().map(mapper::toResponse).toList();
    }

    public UsuarioProjetoResponse update(Long id, UsuarioProjetoRequest request) {
        UsuarioProjeto usuarioProjeto = find(id);

        return mapper.toResponse(repository.save(mapper.update(request, usuarioProjeto)));
    }

    @Transactional
    public void delete(final Long usuarioId, final Long projetoId) {
        UsuarioProjeto usuarioProjeto = findByUsuarioIdAndProjetoId(usuarioId, projetoId);

        repository.softDeleteById(usuarioProjeto.getId(), LocalDateTime.now());
    }

    private UsuarioProjeto findByUsuarioIdAndProjetoId(Long usuarioId, Long projetoId) {
        return repository.findByUsuarioIdAndProjetoId(usuarioId, projetoId)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário de projeto não encontrado. Tipo: " + UsuarioProjetoResponse.class.getSimpleName()));
    }

    private UsuarioProjeto find(final Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário de projeto não encontrado. Id: " + id + ", Tipo: " + UsuarioProjetoResponse.class.getSimpleName()));
    }

    private void criarNotificacaoAssociacao(Usuario usuario, Projeto projeto) {
        Notificacao notificacao = new Notificacao();
        notificacao.setUsuario(usuario);
        notificacao.setMensagem(notificacaoService.criarMensagem(projeto.getNome(), ""));
        notificacao.setTipo("NOVO_PROJETO");
        notificacao.setDataCriacao(LocalDateTime.now());
        notificacao.setLida(false);
        notificacao.setProjeto(projeto);

        notificacaoService.save(notificacao);
    }
}
