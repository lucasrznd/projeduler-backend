package com.lucasrznd.projedulerbackend.dtos.response;

public record TopUsuarioResponse(Long usuarioId,
                                 String nomeUsuario,
                                 Double totalHoras) {
}
