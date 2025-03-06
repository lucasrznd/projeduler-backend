package com.lucasrznd.projedulerbackend.services;

import com.lucasrznd.projedulerbackend.dtos.request.NotificacaoRequest;
import com.lucasrznd.projedulerbackend.dtos.request.UsuarioProjetoRequest;
import com.lucasrznd.projedulerbackend.dtos.response.UsuarioProjetoResponse;
import com.lucasrznd.projedulerbackend.exceptions.ResourceNotFoundException;
import com.lucasrznd.projedulerbackend.mappers.UsuarioProjetoMapper;
import com.lucasrznd.projedulerbackend.models.Projeto;
import com.lucasrznd.projedulerbackend.models.Usuario;
import com.lucasrznd.projedulerbackend.models.UsuarioProjeto;
import com.lucasrznd.projedulerbackend.repositories.UsuarioProjetoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioProjetoService {

    private final UsuarioProjetoRepository repository;
    private final UsuarioProjetoMapper mapper;
    private final UsuarioService usuarioService;
    private final ProjetoService projetoService;
    private final NotificacaoService notificacaoService;

    public UsuarioProjetoResponse save(final UsuarioProjetoRequest request) {
        Usuario usuario = usuarioService.find(request.usuarioId());
        Projeto projeto = projetoService.find(request.projetoId());

        UsuarioProjeto usuarioProjeto = mapper.toModel(request);
        usuarioProjeto.setUsuario(usuario);
        usuarioProjeto.setProjeto(projeto);
        usuarioProjeto.setDataEntrada(LocalDate.now());

        // Criar notificação de projeto para o usuário
        NotificacaoRequest notificacao = new NotificacaoRequest(usuario.getId(),
                notificacaoService.criarMensagem(projeto.getNome(), ""),
                "NOVO_PROJETO",
                projeto.getId(), null
        );
        notificacaoService.save(notificacao);

        return mapper.toResponse(repository.save(usuarioProjeto));
    }

    public List<UsuarioProjetoResponse> findAll() {
        return repository.findAll().stream().map(mapper::toResponse).toList();
    }

    public UsuarioProjetoResponse update(Long id, UsuarioProjetoRequest request) {
        UsuarioProjeto usuarioProjeto = find(id);

        return mapper.toResponse(repository.save(mapper.update(request, usuarioProjeto)));
    }

    public void delete(final Long usuarioId, final Long projetoId) {
        repository.delete(findByUsuarioIdAndProjetoId(usuarioId, projetoId));
    }

    private UsuarioProjeto findByUsuarioIdAndProjetoId(Long usuarioId, Long projetoId) {
        return repository.findByUsuarioIdAndProjetoId(usuarioId, projetoId)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário de projeto não encontrado. Tipo: " + UsuarioProjetoResponse.class.getSimpleName()));
    }

    private UsuarioProjeto find(final Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário de projeto não encontrado. Id: " + id + ", Tipo: " + UsuarioProjetoResponse.class.getSimpleName()));
    }
}
