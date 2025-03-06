package com.lucasrznd.projedulerbackend.controllers.impl;

import com.lucasrznd.projedulerbackend.controllers.NotificacaoController;
import com.lucasrznd.projedulerbackend.dtos.response.NotificacaoResponse;
import com.lucasrznd.projedulerbackend.services.NotificacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class NotificacaoControllerImpl implements NotificacaoController {

    private final NotificacaoService service;

    @Override
    public ResponseEntity<List<NotificacaoResponse>> listarNotificacoes(UserDetails user) {
        return ResponseEntity.ok().body(service.findAll(user));
    }

    @Override
    public ResponseEntity<Void> marcarComoLida(Long notificacaoId) {
        service.marcarComoLida(notificacaoId);

        return ResponseEntity.ok().build();
    }
}
