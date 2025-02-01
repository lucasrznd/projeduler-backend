package com.lucasrznd.projedulerbackend.services;

import com.lucasrznd.projedulerbackend.dtos.request.UsuarioProjetoRequest;
import com.lucasrznd.projedulerbackend.dtos.response.UsuarioProjetoResponse;
import com.lucasrznd.projedulerbackend.exceptions.ResourceNotFoundException;
import com.lucasrznd.projedulerbackend.mappers.UsuarioProjetoMapper;
import com.lucasrznd.projedulerbackend.models.UsuarioProjeto;
import com.lucasrznd.projedulerbackend.repositories.UsuarioProjetoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioProjetoService {

    private final UsuarioProjetoRepository repository;
    private final UsuarioProjetoMapper mapper;

    public UsuarioProjetoResponse save(final UsuarioProjetoRequest request) {
        UsuarioProjeto usuarioProjeto = mapper.toModel(request);

        return mapper.toResponse(repository.save(usuarioProjeto));
    }

    public List<UsuarioProjetoResponse> findAll() {
        return repository.findAll().stream().map(mapper::toResponse).toList();
    }

    public UsuarioProjetoResponse update(Long id, UsuarioProjetoRequest request) {
        UsuarioProjeto usuarioProjeto = find(id);

        return mapper.toResponse(repository.save(mapper.update(request, usuarioProjeto)));
    }

    public void delete(final Long id) {
        repository.delete(find(id));
    }

    private UsuarioProjeto find(final Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário de projeto não encontrado. Id: " + id + ", Tipo: " + UsuarioProjetoResponse.class.getSimpleName()));
    }
}
