package com.lucasrznd.projedulerbackend.dtos.response;

import java.time.LocalDateTime;

public record UsuarioResponse(Long id,
                              String nome,
                              String email,
                              LocalDateTime dataCriacao,
                              LocalDateTime ultimoLogin,
                              String perfil,
                              boolean ativo) {
}
