package com.lucasrznd.projedulerbackend.controllers.impl;

import com.lucasrznd.projedulerbackend.controllers.AtividadeController;
import com.lucasrznd.projedulerbackend.dtos.request.AtividadeRequest;
import com.lucasrznd.projedulerbackend.dtos.response.AtividadeResponse;
import com.lucasrznd.projedulerbackend.services.AtividadeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequiredArgsConstructor
public class AtividadeControllerImpl implements AtividadeController {

    private final AtividadeService service;

    @Override
    public ResponseEntity<AtividadeResponse> create(AtividadeRequest request) {
        return ResponseEntity.status(CREATED).body(service.save(request));
    }

    @Override
    public ResponseEntity<List<AtividadeResponse>> findAll(UserDetails user) {
        return ResponseEntity.ok(service.findAll(user));
    }

    @Override
    public ResponseEntity<AtividadeResponse> update(Long id, AtividadeRequest request) {
        return ResponseEntity.ok(service.update(id, request));
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}
