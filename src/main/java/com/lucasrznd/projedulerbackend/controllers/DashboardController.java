package com.lucasrznd.projedulerbackend.controllers;

import com.lucasrznd.projedulerbackend.dtos.response.UsuarioAtivoResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Tag(name = "DashboardController", description = "Controller responsavél pelo dashboard")
@RequestMapping("/dashboard")
public interface DashboardController {

    @GetMapping("/metricas")
    ResponseEntity<Map<String, Object>> getMetricasDashboard(@AuthenticationPrincipal UserDetails user);

    @GetMapping("/metricas-admin")
    ResponseEntity<Map<String, Object>> getMetricasDashboardAdmin(@AuthenticationPrincipal UserDetails user);

    @GetMapping("/usuarios-ativos")
    ResponseEntity<UsuarioAtivoResponse> getUsuariosAtivos();

}
