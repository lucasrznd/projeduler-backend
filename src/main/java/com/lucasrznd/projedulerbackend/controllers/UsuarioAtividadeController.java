package com.lucasrznd.projedulerbackend.controllers;

import com.lucasrznd.projedulerbackend.dtos.request.UsuarioAtividadeRequest;
import com.lucasrznd.projedulerbackend.dtos.response.UsuarioAtividadeResponse;
import com.lucasrznd.projedulerbackend.exceptions.StandardError;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Tag(name = "UsuarioAtividadeController", description = "Controller responsavél pelas operações de atividades do usuário")
@RequestMapping("/usuario-atividades")
public interface UsuarioAtividadeController {

    @Operation(summary = "Atribuir novo usuário a atividade")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Usuário atribuído a atividade", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = UsuarioAtividadeResponse.class))),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class)))
    })
    @PostMapping
    ResponseEntity<UsuarioAtividadeResponse> create(@RequestBody @Valid final UsuarioAtividadeRequest request);

    @Operation(summary = "Salvar lista de usuários atribuídos as atividades")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Usuários atribuídos a atividade", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, array = @ArraySchema(schema = @Schema(implementation = UsuarioAtividadeResponse.class)))),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class)))
    })
    @PostMapping("/salvar-todos")
    ResponseEntity<List<UsuarioAtividadeResponse>> saveAll(@RequestBody @Valid final List<UsuarioAtividadeRequest> request);

    @Operation(summary = "Buscar todos usuários das atividades")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuários das atividades encontrados", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, array = @ArraySchema(schema = @Schema(implementation = UsuarioAtividadeResponse.class)))),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class)))
    })
    @GetMapping
    ResponseEntity<List<UsuarioAtividadeResponse>> findAll();

    @Operation(summary = "Remover usuário da atividade")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Usuário da atividade removido"),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class))),
            @ApiResponse(responseCode = "404", description = "Usuário da atividade não encontrado", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, array = @ArraySchema(schema = @Schema(implementation = StandardError.class))))
    })
    @DeleteMapping("/{usuarioId}/{atividadeId}")
    ResponseEntity<Void> delete(@Parameter(description = "Usuario Id", required = true, example = "1")
                                @PathVariable(name = "usuarioId") Long usuarioId,
                                @Parameter(description = "Atividade Id", required = true, example = "1")
                                @PathVariable(name = "atividadeId") Long atividadeId);

}
