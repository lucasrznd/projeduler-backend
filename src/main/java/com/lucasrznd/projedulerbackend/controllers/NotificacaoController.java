package com.lucasrznd.projedulerbackend.controllers;

import com.lucasrznd.projedulerbackend.dtos.response.NotificacaoResponse;
import com.lucasrznd.projedulerbackend.exceptions.StandardError;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Tag(name = "NotificacoesController", description = "Controller responsavél pelas notificações dos usuários")
@RequestMapping("/notificacoes")
public interface NotificacaoController {

    @Operation(summary = "Listar todas notificações")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Notificações encontradas", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, array = @ArraySchema(schema = @Schema(implementation = NotificacaoResponse.class)))),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class)))
    })
    @GetMapping
    ResponseEntity<List<NotificacaoResponse>> listarNotificacoes(@AuthenticationPrincipal UserDetails user);

    @PutMapping("/{notificacaoId}/marcar-lida")
    ResponseEntity<Void> marcarComoLida(@Parameter(description = "Notificação Id", required = true, example = "1")
                                        @PathVariable(name = "notificacaoId") Long notificacaoId);

}
