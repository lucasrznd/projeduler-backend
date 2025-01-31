package com.lucasrznd.projedulerbackend.services;

import com.lucasrznd.projedulerbackend.dtos.request.LancamentoHoraRequest;
import com.lucasrznd.projedulerbackend.dtos.response.LancamentoHoraResponse;
import com.lucasrznd.projedulerbackend.exceptions.ResourceNotFoundException;
import com.lucasrznd.projedulerbackend.mappers.LancamentoHoraMapper;
import com.lucasrznd.projedulerbackend.models.LancamentoHora;
import com.lucasrznd.projedulerbackend.repositories.LancamentoHoraRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LancamentoHoraService {

    private final LancamentoHoraRepository repository;
    private final LancamentoHoraMapper mapper;

    public LancamentoHoraResponse save(final LancamentoHoraRequest request) {
        LancamentoHora lancamentoHora = mapper.toModel(request);
        lancamentoHora.setDataRegistro(LocalDateTime.now());

        return mapper.toResponse(repository.save(lancamentoHora));
    }

    public List<LancamentoHoraResponse> findAll() {
        return repository.findAll().stream().map(mapper::toResponse).toList();
    }

    public LancamentoHoraResponse update(Long id, LancamentoHoraRequest request) {
        LancamentoHora lancamentoHora = find(id);

        return mapper.toResponse(repository.save(mapper.update(request, lancamentoHora)));
    }

    public void delete(final Long id) {
        repository.delete(find(id));
    }

    private LancamentoHora find(final Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Lançamento de Hora não encontrado. Id: " + id + ", Tipo: " + LancamentoHoraResponse.class.getSimpleName()));
    }
}
