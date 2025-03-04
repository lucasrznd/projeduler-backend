package com.lucasrznd.projedulerbackend.controllers.impl;

import com.lucasrznd.projedulerbackend.controllers.DashboardController;
import com.lucasrznd.projedulerbackend.dtos.response.UsuarioAtivoResponse;
import com.lucasrznd.projedulerbackend.services.DashboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class DashboardControllerImpl implements DashboardController {

    private final DashboardService service;

    @Override
    public ResponseEntity<Map<String, Object>> getMetricasDashboard(UserDetails user) {
        return ResponseEntity.ok().body(service.getMetricasDashboard(user));
    }

    @Override
    public ResponseEntity<Map<String, Object>> getMetricasDashboardAdmin(UserDetails user) {
        return ResponseEntity.ok().body(service.getMetricasDashboardAdmin(user));
    }

    @Override
    public ResponseEntity<UsuarioAtivoResponse> getUsuariosAtivos() {
        return ResponseEntity.ok().body(service.getUsuariosAtivos());
    }
}
