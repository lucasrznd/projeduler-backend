package com.lucasrznd.projedulerbackend.controllers.impl;

import com.lucasrznd.projedulerbackend.controllers.UsuarioController;
import com.lucasrznd.projedulerbackend.dtos.request.UsuarioRequest;
import com.lucasrznd.projedulerbackend.dtos.response.UsuarioResponse;
import com.lucasrznd.projedulerbackend.services.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequiredArgsConstructor
public class UsuarioControllerImpl implements UsuarioController {

    private final UsuarioService service;

    @Override
    public ResponseEntity<UsuarioResponse> create(UsuarioRequest request) {
        return ResponseEntity.status(CREATED).body(service.create(request));
    }

    @Override
    public ResponseEntity<List<UsuarioResponse>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @Override
    public ResponseEntity<List<UsuarioResponse>> findUsuariosDisponiveis(Long projetoId) {
        return ResponseEntity.ok().body(service.findUsuariosDisponiveis(projetoId));
    }

    @Override
    public ResponseEntity<UsuarioResponse> update(Long id, UsuarioRequest request) {
        return ResponseEntity.ok().body(service.update(id, request));
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}
