package com.lucasrznd.projedulerbackend.controllers;

import com.lucasrznd.projedulerbackend.dtos.response.AtividadePorStatusResponse;
import com.lucasrznd.projedulerbackend.dtos.response.HorasPorMesResponse;
import com.lucasrznd.projedulerbackend.dtos.response.HorasPorProjetoResponse;
import com.lucasrznd.projedulerbackend.dtos.response.TopUsuarioResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Tag(name = "RelatorioController", description = "Controller responsavél pelas operações de Relatórios")
@RequestMapping("/relatorios")
public interface RelatorioController {

    @GetMapping("/horas-por-projeto")
    ResponseEntity<List<HorasPorProjetoResponse>> getHorasPorProjeto(@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicio,
                                                                     @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFim,
                                                                     @RequestParam(required = false) Long projetoId,
                                                                     @RequestParam(required = false) Long usuarioId,
                                                                     @RequestParam(required = false) String status);

    @GetMapping("/horas-por-mes")
    ResponseEntity<List<HorasPorMesResponse>> getHorasPorMes(@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicio,
                                                             @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFim,
                                                             @RequestParam(required = false) Long projetoId,
                                                             @RequestParam(required = false) Long usuarioId,
                                                             @RequestParam(required = false) String status);

    @GetMapping("/atividades-por-status")
    ResponseEntity<List<AtividadePorStatusResponse>> getAtividadesPorStatus(@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicio,
                                                                            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFim,
                                                                            @RequestParam(required = false) Long projetoId,
                                                                            @RequestParam(required = false) Long usuarioId,
                                                                            @RequestParam(required = false) String status);

    @GetMapping("/top-usuarios-por-horas")
    ResponseEntity<List<TopUsuarioResponse>> getTopUsuariosPorHoras(@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicio,
                                                                    @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFim,
                                                                    @RequestParam(required = false) Long projetoId,
                                                                    @RequestParam(required = false) Long usuarioId,
                                                                    @RequestParam(required = false) String status);

}
