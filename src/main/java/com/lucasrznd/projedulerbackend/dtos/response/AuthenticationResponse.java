package com.lucasrznd.projedulerbackend.dtos.response;

public record AuthenticationResponse(String token,
                                     String refreshToken) {
}
