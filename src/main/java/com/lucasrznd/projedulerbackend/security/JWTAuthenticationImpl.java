package com.lucasrznd.projedulerbackend.security;

import com.lucasrznd.projedulerbackend.dtos.request.AuthenticateRequest;
import com.lucasrznd.projedulerbackend.dtos.response.AuthenticationResponse;
import com.lucasrznd.projedulerbackend.models.Usuario;
import com.lucasrznd.projedulerbackend.repositories.UsuarioRepository;
import com.lucasrznd.projedulerbackend.utils.JWTUtils;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class JWTAuthenticationImpl {

    private final AuthenticationManager authenticationManager;
    private final JWTUtils jwtUtils;
    private UsuarioRepository repository;

    @Value("${api.security.access-token.expiration}")
    private Long accessTokenExpiration;

    @Value("${api.security.refresh-token.expiration}")
    private Long refreshTokenExpiration;

    public JWTAuthenticationImpl(AuthenticationManager authenticationManager, JWTUtils jwtUtils, UsuarioRepository repository) {
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
        this.repository = repository;
    }

    public AuthenticationResponse login(AuthenticateRequest request) {
        try {
            var usernamePassword = new UsernamePasswordAuthenticationToken(request.email(), request.senha());
            var auth = authenticationManager.authenticate(usernamePassword);

            String token = jwtUtils.generateToken((Usuario) auth.getPrincipal(), accessTokenExpiration);
            String refreshToken = jwtUtils.generateToken((Usuario) auth.getPrincipal(), refreshTokenExpiration);

            log.info("Usuário autenticado com sucesso: {}", request.email());
            return new AuthenticationResponse(token, refreshToken);
        } catch (BadCredentialsException ex) {
            log.error("Erro na autenticação de usuário: {}", request.email());
            throw new BadCredentialsException("Email ou senha inválidos.");
        }
    }

    public AuthenticationResponse refreshToken(String refreshToken) {
        String login = jwtUtils.validateToken(refreshToken);
        Usuario usuario = repository.findByEmail(login).orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado: " + login));

        var authentication = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());

        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new AuthenticationResponse(jwtUtils.generateToken(usuario, accessTokenExpiration), refreshToken);
    }
}
