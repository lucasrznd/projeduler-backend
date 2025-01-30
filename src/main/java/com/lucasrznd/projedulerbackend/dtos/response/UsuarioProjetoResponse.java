package com.lucasrznd.projedulerbackend.dtos.response;

import java.time.LocalDate;

public record UsuarioProjetoResponse(Long id,
                                     UsuarioResponse usuario,
                                     ProjetoResponse projeto,
                                     LocalDate dataEntrada) {
}
