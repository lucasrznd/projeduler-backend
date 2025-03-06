package com.lucasrznd.projedulerbackend.dtos.request;

import lombok.Builder;

@Builder
public record NotificacaoRequest(Long usuarioId,
                                 String mensagem,
                                 String tipo,
                                 Long projetoId,
                                 Long atividadeId) {
}
