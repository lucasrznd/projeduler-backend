package com.lucasrznd.projedulerbackend.dtos.response;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record ProjetoResponse(Long id,
                              String nome,
                              String descricao,
                              LocalDate dataInicio,
                              LocalDate dataFim,
                              String status,
                              UsuarioResponse usuario,
                              LocalDateTime dataCriacao,
                              String prioridade) {
}
