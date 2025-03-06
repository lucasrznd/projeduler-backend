package com.lucasrznd.projedulerbackend.dtos.response;

import com.lucasrznd.projedulerbackend.models.AtividadeUsuario;

import java.util.List;

public record UsuarioAtivoResponse(Integer quantidade,
                                   List<AtividadeUsuario> usuariosAtivos) {
}
