package com.lucasrznd.projedulerbackend.controllers.impl;

import com.lucasrznd.projedulerbackend.controllers.AuthController;
import com.lucasrznd.projedulerbackend.dtos.request.AuthenticateRequest;
import com.lucasrznd.projedulerbackend.dtos.request.RefreshTokenRequest;
import com.lucasrznd.projedulerbackend.dtos.response.AuthenticationResponse;
import com.lucasrznd.projedulerbackend.security.JWTAuthenticationImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthControllerImpl implements AuthController {

    private final JWTAuthenticationImpl service;

    @Override
    public ResponseEntity<AuthenticationResponse> login(AuthenticateRequest request) {
        return ResponseEntity.ok().body(service.login(request));
    }

    @Override
    public ResponseEntity<AuthenticationResponse> refreshToken(RefreshTokenRequest request) {
        return ResponseEntity.ok().body(service.refreshToken(request.refreshToken()));
    }

}
