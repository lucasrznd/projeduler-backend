package com.lucasrznd.projedulerbackend.controllers.impl;

import com.lucasrznd.projedulerbackend.controllers.ProjetoController;
import com.lucasrznd.projedulerbackend.dtos.request.ProjetoRequest;
import com.lucasrznd.projedulerbackend.dtos.response.ProjetoResponse;
import com.lucasrznd.projedulerbackend.services.ProjetoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequiredArgsConstructor
public class ProjetoControllerImpl implements ProjetoController {

    private final ProjetoService service;

    @Override
    public ResponseEntity<ProjetoResponse> create(ProjetoRequest request) {
        return ResponseEntity.status(CREATED).body(service.save(request));
    }

    @Override
    public ResponseEntity<List<ProjetoResponse>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @Override
    public ResponseEntity<ProjetoResponse> update(Long id, ProjetoRequest request) {
        return ResponseEntity.ok().body(service.update(id, request));
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}
