package com.lucasrznd.projedulerbackend.dtos.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record LancamentoHoraRequest(
        @Schema(description = "Id da Atividade", example = "1")
        @NotNull(message = "Id da Atividade não pode ser nulo.")
        Long atividadeId,

        @Schema(description = "Descrição", example = "Mentoria com os trainees realizada")
        @NotBlank(message = "Descrição não pode estar em branco.")
        String descricao,

        @Schema(description = "Data de Início", example = "2025/01/01")
        @NotNull(message = "Data de Início não pode ser nula.")
        LocalDateTime dataInicio,

        @Schema(description = "Data de Fim", example = "2025/01/01")
        @NotNull(message = "Data de Fim não pode ser nula.")
        LocalDateTime dataFim) {
}
