package com.lucasrznd.projedulerbackend.dtos.response;

public record UsuarioResponse(Long id,
                              String nome,
                              String email,
                              String dataCriacao,
                              String ultimoLogin,
                              String perfil) {
}
