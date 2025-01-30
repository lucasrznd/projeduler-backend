package com.lucasrznd.projedulerbackend.dtos.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record UsuarioProjetoRequest(
        @Schema(description = "Id do Usuário", example = "1")
        @NotNull(message = "Id do Usuário não pode ser nulo.")
        Long usuarioId,

        @Schema(description = "Id do Projeto", example = "1")
        @NotNull(message = "Id do Projeto não pode ser nulo.")
        Long projetoId,

        @Schema(description = "Data de Entrada", example = "2025/01/01")
        @NotNull(message = "Data de Entrada não pode ser nula.")
        LocalDate dataEntrada) {
}
