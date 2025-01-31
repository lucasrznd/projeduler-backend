package com.lucasrznd.projedulerbackend.services;

import com.lucasrznd.projedulerbackend.dtos.request.ProjetoRequest;
import com.lucasrznd.projedulerbackend.dtos.response.ProjetoResponse;
import com.lucasrznd.projedulerbackend.exceptions.ResourceNotFoundException;
import com.lucasrznd.projedulerbackend.mappers.ProjetoMapper;
import com.lucasrznd.projedulerbackend.models.Projeto;
import com.lucasrznd.projedulerbackend.repositories.ProjetoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjetoService {

    private final ProjetoRepository repository;
    private final ProjetoMapper mapper;

    public ProjetoResponse save(final ProjetoRequest request) {
        Projeto projeto = mapper.toModel(request);
        projeto.setDataCriacao(LocalDateTime.now());

        return mapper.toResponse(repository.save(projeto));
    }

    public List<ProjetoResponse> findAll() {
        return repository.findAll().stream().map(mapper::toResponse).toList();
    }

    public ProjetoResponse update(Long id, ProjetoRequest request) {
        Projeto projeto = find(id);

        return mapper.toResponse(repository.save(mapper.update(request, projeto)));
    }

    public void delete(final Long id) {
        repository.delete(find(id));
    }

    private Projeto find(final Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Projeto não encontrado. Id: " + id + ", Tipo: " + ProjetoResponse.class.getSimpleName()));
    }
}
