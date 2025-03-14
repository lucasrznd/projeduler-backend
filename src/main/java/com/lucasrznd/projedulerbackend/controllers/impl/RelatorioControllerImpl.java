package com.lucasrznd.projedulerbackend.controllers.impl;

import com.lucasrznd.projedulerbackend.controllers.RelatorioController;
import com.lucasrznd.projedulerbackend.dtos.response.AtividadePorStatusResponse;
import com.lucasrznd.projedulerbackend.dtos.response.HorasPorMesResponse;
import com.lucasrznd.projedulerbackend.dtos.response.HorasPorProjetoResponse;
import com.lucasrznd.projedulerbackend.dtos.response.TopUsuarioResponse;
import com.lucasrznd.projedulerbackend.services.RelatorioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class RelatorioControllerImpl implements RelatorioController {

    private final RelatorioService relatorioService;

    @Override
    public ResponseEntity<List<HorasPorProjetoResponse>> getHorasPorProjeto(UserDetails user, LocalDate dataInicio, LocalDate dataFim, Long projetoId, Long usuarioId, String status) {
        return ResponseEntity.ok().body(relatorioService.buscarHorasPorProjeto(user, dataInicio, dataFim, projetoId, usuarioId, status));
    }

    @Override
    public ResponseEntity<List<HorasPorMesResponse>> getHorasPorMes(UserDetails user, LocalDate dataInicio, LocalDate dataFim, Long projetoId, Long usuarioId, String status) {
        return ResponseEntity.ok().body(relatorioService.buscarHorasPorMes(user, dataInicio, dataFim, projetoId, usuarioId, status));
    }

    @Override
    public ResponseEntity<List<AtividadePorStatusResponse>> getAtividadesPorStatus(UserDetails user, LocalDate dataInicio, LocalDate dataFim, Long projetoId, Long usuarioId, String status) {
        return ResponseEntity.ok().body(relatorioService.buscarAtividadesPorStatus(user, dataInicio, dataFim, projetoId, usuarioId, status));
    }

    @Override
    public ResponseEntity<List<TopUsuarioResponse>> getTopUsuariosPorHoras(UserDetails user, LocalDate dataInicio, LocalDate dataFim, Long projetoId, Long usuarioId, String status) {
        return ResponseEntity.ok().body(relatorioService.buscarTopUsuariosPorHoras(user, dataInicio, dataFim, projetoId, usuarioId, status));
    }
}
