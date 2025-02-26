package com.lucasrznd.projedulerbackend.services;

import com.lucasrznd.projedulerbackend.dtos.request.UsuarioAtividadeRequest;
import com.lucasrznd.projedulerbackend.dtos.response.UsuarioAtividadeResponse;
import com.lucasrznd.projedulerbackend.mappers.UsuarioAtividadeMapper;
import com.lucasrznd.projedulerbackend.models.Atividade;
import com.lucasrznd.projedulerbackend.models.Usuario;
import com.lucasrznd.projedulerbackend.models.UsuarioAtividade;
import com.lucasrznd.projedulerbackend.repositories.UsuarioAtividadeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioAtividadeService {

    private final UsuarioAtividadeRepository repository;
    private final UsuarioAtividadeMapper mapper;
    private final UsuarioService usuarioService;
    private final AtividadeService atividadeService;

    public UsuarioAtividadeResponse save(final UsuarioAtividadeRequest request) {
        Usuario usuario = usuarioService.find(request.usuarioId());
        Atividade atividade = atividadeService.find(request.atividadeId());

        UsuarioAtividade usuarioAtividade = mapper.toModel(request);
        usuarioAtividade.setUsuario(usuario);
        usuarioAtividade.setAtividade(atividade);
        usuarioAtividade.setDataEntrada(LocalDateTime.now());

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

    public void delete(final Long usuarioId, final Long atividadeId) {
        repository.delete(findByUsuarioIdAndAtividadeId(usuarioId, atividadeId));
    }

    private UsuarioAtividade findByUsuarioIdAndAtividadeId(final Long usuarioId, final Long atividadeId) {
        return repository.findByUsuarioIdAndAtividadeId(usuarioId, atividadeId)
                .orElseThrow(() -> new RuntimeException("Usuário da atividade não encontrado. Id: " + usuarioId));
    }
}
