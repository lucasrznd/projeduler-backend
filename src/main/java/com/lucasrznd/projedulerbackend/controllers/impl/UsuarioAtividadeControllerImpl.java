package com.lucasrznd.projedulerbackend.controllers.impl;

import com.lucasrznd.projedulerbackend.controllers.UsuarioAtividadeController;
import com.lucasrznd.projedulerbackend.dtos.request.UsuarioAtividadeRequest;
import com.lucasrznd.projedulerbackend.dtos.response.UsuarioAtividadeResponse;
import com.lucasrznd.projedulerbackend.services.UsuarioAtividadeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequiredArgsConstructor
public class UsuarioAtividadeControllerImpl implements UsuarioAtividadeController {

    private final UsuarioAtividadeService service;

    @Override
    public ResponseEntity<UsuarioAtividadeResponse> create(UsuarioAtividadeRequest request) {
        return ResponseEntity.status(CREATED).body(service.save(request));
    }

    @Override
    public ResponseEntity<List<UsuarioAtividadeResponse>> saveAll(List<UsuarioAtividadeRequest> request) {
        return ResponseEntity.status(CREATED).body(service.saveAll(request));
    }

    @Override
    public ResponseEntity<List<UsuarioAtividadeResponse>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @Override
    public ResponseEntity<Void> delete(Long usuarioId, Long atividadeId) {
        service.delete(usuarioId, atividadeId);

        return ResponseEntity.noContent().build();
    }
}
