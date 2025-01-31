package com.lucasrznd.projedulerbackend.dtos.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.With;

import java.time.LocalDate;

@With
public record ProjetoRequest(
        @Schema(description = "Nome", example = "Projeto Trainee")
        @NotBlank(message = "Nome não pode estar em branco.")
        String nome,

        @Schema(description = "Descrição", example = "Este projeto é destinado ao programa de trainee..")
        String descricao,

        @Schema(description = "Data de Início", example = "2025/01/01")
        LocalDate dataInicio,

        @Schema(description = "Data de Fim", example = "2025/01/01")
        LocalDate dataFim,

        @Schema(description = "Status", example = "[\"PLANEJADO\", \"ANDAMENTO\", \"CONCLUIDO\", \"CANCELADO\"]")
        @NotBlank(message = "Status não pode estar em branco.")
        String status,

        @Schema(description = "Id do Usuário Responsavél", example = "1")
        @NotNull(message = "Id do Usuário Responsavél não pode ser nulo.")
        Long usuarioResponsavelId,

        @Schema(description = "Prioridade", example = "[\"BAIXA\", \"MEDIA\", \"ALTA\"]")
        String prioridade) {
}
