package com.lucasrznd.projedulerbackend.dtos.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

public record RefreshTokenRequest(

        @Schema(description = "Refresh Token")
        @NotBlank(message = "Refresh Token não pode estar em branco.")
        String refreshToken) {
}
