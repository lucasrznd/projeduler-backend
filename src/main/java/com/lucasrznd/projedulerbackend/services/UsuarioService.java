package com.lucasrznd.projedulerbackend.services;

import com.lucasrznd.projedulerbackend.dtos.request.UsuarioRequest;
import com.lucasrznd.projedulerbackend.dtos.response.UsuarioResponse;
import com.lucasrznd.projedulerbackend.exceptions.ResourceNotFoundException;
import com.lucasrznd.projedulerbackend.mappers.UsuarioMapper;
import com.lucasrznd.projedulerbackend.models.Usuario;
import com.lucasrznd.projedulerbackend.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository repository;
    private final UsuarioMapper mapper;

    public UsuarioResponse create(final UsuarioRequest request) {
        return mapper.toResponse(repository.save(mapper.toModel(request.withDataCriacao(LocalDateTime.now()))));
    }

    public List<UsuarioResponse> findAll() {
        return repository.findAll().stream().map(mapper::toResponse).toList();
    }

    public UsuarioResponse update(final Long id, final UsuarioRequest request) {
        Usuario usuario = find(id);

        return mapper.toResponse(repository.save(mapper.update(request, usuario)));
    }

    public void delete(final Long id) {
        repository.delete(find(id));
    }

    private Usuario find(final Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado. Id: " + id + ", Tipo: " + UsuarioResponse.class.getSimpleName()));
    }
}
