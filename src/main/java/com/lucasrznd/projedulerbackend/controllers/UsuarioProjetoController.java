package com.lucasrznd.projedulerbackend.controllers;

import com.lucasrznd.projedulerbackend.dtos.request.UsuarioProjetoRequest;
import com.lucasrznd.projedulerbackend.dtos.response.UsuarioProjetoResponse;
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

@Tag(name = "UsuarioProjetoController", description = "Controller responsavél pelas operações de usuários de projeto")
@RequestMapping("/usuario-projetos")
public interface UsuarioProjetoController {

    @Operation(summary = "Criar novo usuário do projeto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Usuário do projeto criado", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = UsuarioProjetoResponse.class))),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class)))
    })
    @PostMapping
    ResponseEntity<UsuarioProjetoResponse> create(@RequestBody @Valid final UsuarioProjetoRequest request);

    @Operation(summary = "Buscar todos usuários do projeto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuários do projeto encontrados", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, array = @ArraySchema(schema = @Schema(implementation = UsuarioProjetoResponse.class)))),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class)))
    })
    @GetMapping
    ResponseEntity<List<UsuarioProjetoResponse>> findAll();

    @Operation(summary = "Atualizar usuário do projeto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuário do projeto atualizado", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = UsuarioProjetoResponse.class))),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class))),
            @ApiResponse(responseCode = "404", description = "Usuário do projeto não encontrado", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class)))
    })
    @PutMapping("/{id}")
    ResponseEntity<UsuarioProjetoResponse> update(@Parameter(description = "Usuario Projeto Id", required = true, example = "1")
                                                  @PathVariable(name = "id") Long id,
                                                  @RequestBody @Valid UsuarioProjetoRequest request);

    @Operation(summary = "Remover usuário do projeto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Usuário do projeto removido"),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class))),
            @ApiResponse(responseCode = "404", description = "Usuário do projeto não encontrado", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, array = @ArraySchema(schema = @Schema(implementation = StandardError.class))))
    })
    @DeleteMapping("/{usuarioId}/{projetoId}")
    ResponseEntity<Void> delete(@Parameter(description = "Usuario Id", required = true, example = "1")
                                @PathVariable(name = "usuarioId") Long usuarioId,
                                @Parameter(description = "Projeto Id", required = true, example = "1")
                                @PathVariable(name = "projetoId") Long projetoId);

}
