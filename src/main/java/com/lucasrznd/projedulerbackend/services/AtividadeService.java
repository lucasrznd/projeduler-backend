package com.lucasrznd.projedulerbackend.services;

import com.lucasrznd.projedulerbackend.dtos.request.AtividadeRequest;
import com.lucasrznd.projedulerbackend.dtos.response.AtividadeResponse;
import com.lucasrznd.projedulerbackend.exceptions.ResourceNotFoundException;
import com.lucasrznd.projedulerbackend.mappers.AtividadeMapper;
import com.lucasrznd.projedulerbackend.models.Atividade;
import com.lucasrznd.projedulerbackend.repositories.AtividadeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AtividadeService {

    private final AtividadeRepository repository;
    private final AtividadeMapper mapper;

    public AtividadeResponse save(final AtividadeRequest request) {
        Atividade atividade = mapper.toModel(request);
        atividade.setDataCriacao(LocalDateTime.now());

        return mapper.toResponse(repository.save(atividade));
    }

    public List<AtividadeResponse> findAll() {
        return repository.findAll().stream().map(mapper::toResponse).toList();
    }

    public AtividadeResponse update(Long id, AtividadeRequest request) {
        Atividade atividade = find(id);

        return mapper.toResponse(repository.save(mapper.update(request, atividade)));
    }

    public void delete(final Long id) {
        repository.delete(find(id));
    }

    private Atividade find(final Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Atividade não encontrada. Id: " + id + ", Tipo: " + AtividadeResponse.class.getSimpleName()));
    }
}
