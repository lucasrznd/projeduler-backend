package com.lucasrznd.projedulerbackend.dtos.response;

import java.time.LocalDateTime;

public record UsuarioAtividadeResponse(Long id,
                                       UsuarioResponse usuario,
                                       AtividadeResponse atividade,
                                       LocalDateTime dataEntrada) {
}
