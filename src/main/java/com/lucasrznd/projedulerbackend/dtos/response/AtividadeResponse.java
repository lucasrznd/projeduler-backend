package com.lucasrznd.projedulerbackend.dtos.response;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record AtividadeResponse(Long id,
                                ProjetoResponse projeto,
                                String nome,
                                String descricao,
                                LocalDate dataInicio,
                                LocalDate dataFim,
                                String status,
                                UsuarioResponse usuarioResponsavel,
                                LocalDateTime dataCriacao) {
}
