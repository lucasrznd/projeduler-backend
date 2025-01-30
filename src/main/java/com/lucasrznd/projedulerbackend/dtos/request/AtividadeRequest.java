package com.lucasrznd.projedulerbackend.dtos.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record AtividadeRequest(
        @Schema(description = "Id do Projeto", example = "1")
        @NotNull(message = "Id do Projeto não pode ser nulo.")
        Long projetoId,

        @Schema(description = "Nome", example = "Mentoria no discord")
        @NotBlank(message = "Nome não pode estar em branco.")
        String nome,

        @Schema(description = "Descrição", example = "Realizar mentoria no discord com os trainees..")
        String descricao,

        @Schema(description = "Data de Início", example = "2025/01/01")
        LocalDate dataInicio,

        @Schema(description = "Data de Fim", example = "2025/02/01")
        LocalDate dataFim,

        @Schema(description = "Status", example = "[\"PLANEJADA\", \"ANDAMENTO\", \"CONCLUIDA\", \"PAUSADA\"]")
        @NotBlank(message = "Status não pode estar em branco.")
        String status,

        @Schema(description = "Id do Usuário Responsavél", example = "1")
        @NotNull(message = "Id do Usuário Responsavél não pode ser nulo.")
        Long usuarioResponsavelId) {
}
