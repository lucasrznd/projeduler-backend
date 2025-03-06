package com.lucasrznd.projedulerbackend.dtos.response;

import java.time.LocalDateTime;

public record NotificacaoResponse(Long id,
                                  String mensagem,
                                  String tipo,
                                  LocalDateTime dataCriacao,
                                  boolean lida) {
}
