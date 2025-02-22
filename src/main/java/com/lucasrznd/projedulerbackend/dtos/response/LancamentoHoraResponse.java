package com.lucasrznd.projedulerbackend.dtos.response;

import java.time.LocalDateTime;

public record LancamentoHoraResponse(Long id,
                                     AtividadeResponse atividade,
                                     UsuarioResponse usuario,
                                     String descricao,
                                     LocalDateTime dataInicio,
                                     LocalDateTime dataFim,
                                     LocalDateTime dataRegistro) {
}
