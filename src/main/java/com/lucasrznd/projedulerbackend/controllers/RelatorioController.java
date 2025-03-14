package com.lucasrznd.projedulerbackend.controllers;

import com.lucasrznd.projedulerbackend.dtos.response.AtividadePorStatusResponse;
import com.lucasrznd.projedulerbackend.dtos.response.HorasPorMesResponse;
import com.lucasrznd.projedulerbackend.dtos.response.HorasPorProjetoResponse;
import com.lucasrznd.projedulerbackend.dtos.response.TopUsuarioResponse;
import com.lucasrznd.projedulerbackend.exceptions.StandardError;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Tag(name = "RelatorioController", description = "Controller responsavél pelas operações de Relatórios")
@RequestMapping("/relatorios")
public interface RelatorioController {

    @Operation(summary = "Buscar horas por projeto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Horas por projeto encontradas", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, array = @ArraySchema(schema = @Schema(implementation = HorasPorProjetoResponse.class)))),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class)))
    })
    @GetMapping("/horas-por-projeto")
    ResponseEntity<List<HorasPorProjetoResponse>> getHorasPorProjeto(@AuthenticationPrincipal UserDetails user,
                                                                     @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicio,
                                                                     @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFim,
                                                                     @RequestParam(required = false) Long projetoId,
                                                                     @RequestParam(required = false) Long usuarioId,
                                                                     @RequestParam(required = false) String status);

    @Operation(summary = "Buscar horas por mes")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Horas por mes encontradas", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, array = @ArraySchema(schema = @Schema(implementation = HorasPorMesResponse.class)))),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class)))
    })
    @GetMapping("/horas-por-mes")
    ResponseEntity<List<HorasPorMesResponse>> getHorasPorMes(@AuthenticationPrincipal UserDetails user,
                                                             @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicio,
                                                             @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFim,
                                                             @RequestParam(required = false) Long projetoId,
                                                             @RequestParam(required = false) Long usuarioId,
                                                             @RequestParam(required = false) String status);

    @Operation(summary = "Buscar atividades por status")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Atividades por status encontradas", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, array = @ArraySchema(schema = @Schema(implementation = AtividadePorStatusResponse.class)))),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class)))
    })
    @GetMapping("/atividades-por-status")
    ResponseEntity<List<AtividadePorStatusResponse>> getAtividadesPorStatus(@AuthenticationPrincipal UserDetails user,
                                                                            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicio,
                                                                            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFim,
                                                                            @RequestParam(required = false) Long projetoId,
                                                                            @RequestParam(required = false) Long usuarioId,
                                                                            @RequestParam(required = false) String status);

    @Operation(summary = "Buscar top usuários por horas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Top usuários encontrados", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, array = @ArraySchema(schema = @Schema(implementation = TopUsuarioResponse.class)))),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class)))
    })
    @GetMapping("/top-usuarios-por-horas")
    ResponseEntity<List<TopUsuarioResponse>> getTopUsuariosPorHoras(@AuthenticationPrincipal UserDetails user,
                                                                    @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicio,
                                                                    @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFim,
                                                                    @RequestParam(required = false) Long projetoId,
                                                                    @RequestParam(required = false) Long usuarioId,
                                                                    @RequestParam(required = false) String status);

}
