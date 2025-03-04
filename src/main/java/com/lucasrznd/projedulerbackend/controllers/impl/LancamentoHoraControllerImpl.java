package com.lucasrznd.projedulerbackend.controllers.impl;

import com.lucasrznd.projedulerbackend.controllers.LancamentoHoraController;
import com.lucasrznd.projedulerbackend.dtos.request.LancamentoHoraRequest;
import com.lucasrznd.projedulerbackend.dtos.response.LancamentoHoraResponse;
import com.lucasrznd.projedulerbackend.services.LancamentoHoraService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequiredArgsConstructor
public class LancamentoHoraControllerImpl implements LancamentoHoraController {

    private final LancamentoHoraService service;

    @Override
    public ResponseEntity<LancamentoHoraResponse> create(LancamentoHoraRequest request, UserDetails user) {
        return ResponseEntity.status(CREATED).body(service.save(request, user));
    }

    @Override
    public ResponseEntity<List<LancamentoHoraResponse>> findAll(UserDetails user) {
        return ResponseEntity.ok().body(service.findAll(user));
    }

    @Override
    public ResponseEntity<List<LancamentoHoraResponse>> findUltimosCinco(UserDetails user) {
        return ResponseEntity.ok().body(service.findUltimosCinco(user));
    }

    @Override
    public ResponseEntity<LancamentoHoraResponse> update(Long id, LancamentoHoraRequest request) {
        return ResponseEntity.ok().body(service.update(id, request));
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}
