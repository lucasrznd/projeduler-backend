package com.lucasrznd.projedulerbackend.dtos.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

public record UsuarioAtividadeRequest(
        @Schema(description = "Id do Usuário", example = "1")
        @NotNull(message = "Id do Usuário não pode ser nulo.")
        Long usuarioId,

        @Schema(description = "Id da Atividade", example = "1")
        @NotNull(message = "Id da Atividade não pode ser nulo.")
        Long atividadeId) {
}
