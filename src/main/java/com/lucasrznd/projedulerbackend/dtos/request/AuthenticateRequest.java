package com.lucasrznd.projedulerbackend.dtos.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AuthenticateRequest(
        @Schema(description = "E-mail do usuário", example = "lucas@gmail.com")
        @NotBlank(message = "E-mail não pode estar em branco.")
        @Email(message = "E-mail inválido.")
        String email,

        @Schema(description = "Senha")
        @NotBlank(message = "Senha não pode estar em branco.")
        @Size(min = 4, max = 20, message = "Senha deve conter entre 6 a 20 caracteres.")
        String senha) {
}
