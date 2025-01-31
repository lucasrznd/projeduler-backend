package com.lucasrznd.projedulerbackend.dtos.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.With;

@With
public record UsuarioRequest(
        @Schema(description = "Nome", example = "Lucas Rezende")
        @NotBlank(message = "Nome não pode estar em branco.")
        String nome,

        @Schema(description = "E-mail", example = "usuario@email.com")
        @Email(message = "E-mail inválido.")
        @NotBlank(message = "E-mail não pode estar em branco.")
        String email,

        @Schema(description = "Senha")
        @NotBlank(message = "Senha não pode estar em branco.")
        String senha,

        @Schema(description = "Perfil", example = "[ADMIN, USUARIO]")
        @NotBlank(message = "Perfil não pode estar em branco.")
        String perfil) {
}
