package com.lucasrznd.projedulerbackend.controllers;

import com.lucasrznd.projedulerbackend.dtos.request.AuthenticateRequest;
import com.lucasrznd.projedulerbackend.dtos.request.RefreshTokenRequest;
import com.lucasrznd.projedulerbackend.dtos.response.AuthenticationResponse;
import com.lucasrznd.projedulerbackend.exceptions.StandardError;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Tag(name = "AuthController", description = "Controller de autenticação")
@RequestMapping("/auth")
public interface AuthController {

    @Operation(summary = "Autenticar usuário")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuário autenticado", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = AuthenticationResponse.class))),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class))),
            @ApiResponse(responseCode = "401", description = "Bad credentials", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class))),
            @ApiResponse(responseCode = "404", description = "Usuario não encontrado", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class)))
    })
    @PostMapping("/login")
    ResponseEntity<AuthenticationResponse> login(@Valid @RequestBody final AuthenticateRequest request);

    @Operation(summary = "Refresh token")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuário autenticado", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = AuthenticationResponse.class))),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class))),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class))),
            @ApiResponse(responseCode = "404", description = "Usuario não encontrado", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class))),
    })
    @PostMapping("/refresh-token")
    ResponseEntity<AuthenticationResponse> refreshToken(@Valid @RequestBody final RefreshTokenRequest request);

}
