package com.lucasrznd.projedulerbackend.dtos.response;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record LancamentoHoraResponse(Long id,
                                     AtividadeResponse atividade,
                                     UsuarioResponse usuario,
                                     String descricao,
                                     LocalDate dataInicio,
                                     LocalDate dataFim,
                                     LocalDateTime dataRegistro) {
}
