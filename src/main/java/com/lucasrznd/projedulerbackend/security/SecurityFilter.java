package com.lucasrznd.projedulerbackend.security;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lucasrznd.projedulerbackend.exceptions.SecurityError;
import com.lucasrznd.projedulerbackend.repositories.UsuarioRepository;
import com.lucasrznd.projedulerbackend.utils.JWTUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;

@Log4j2
@Component
@RequiredArgsConstructor
public class SecurityFilter extends OncePerRequestFilter {

    private final JWTUtils jwtUtils;
    private final UsuarioRepository repository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            var token = this.recoverToken(request);
            if (token != null) {
                var email = jwtUtils.validateToken(token);
                UserDetails user = repository.findByEmail(email)
                        .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado: " + email));

                var authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }

            filterChain.doFilter(request, response);
        } catch (JWTVerificationException e) {
            log.error(e.getMessage());
            sendErrorResponse(response, UNAUTHORIZED, e.getMessage(), request);
        } catch (UsernameNotFoundException e) {
            log.error("Erro de autenticação: {}", e.getMessage());
            sendErrorResponse(response, UNAUTHORIZED, "Usuário não encontrado.", request);
        } catch (BadCredentialsException e) {
            log.error("Credenciais inválidas: {}", e.getMessage());
            sendErrorResponse(response, UNAUTHORIZED, "Email ou senha inválidos.", request);
        } catch (Exception e) {
            log.error("Erro inesperado: {}", e.getMessage());
            sendErrorResponse(response, INTERNAL_SERVER_ERROR, "Erro interno no servidor.", request);
        }
    }

    private String recoverToken(HttpServletRequest request) {
        var authHeader = request.getHeader("Authorization");
        if (authHeader == null) return null;

        return authHeader.replace("Bearer ", "");
    }

    private void sendErrorResponse(HttpServletResponse response, HttpStatus status, String message, HttpServletRequest request) throws IOException {
        response.setStatus(status.value());
        response.setContentType("application/json");

        SecurityError errorResponse = SecurityError.builder()
                .status(status.value())
                .error(status.getReasonPhrase())
                .message(message)
                .path(request.getRequestURI())
                .build();

        response.getWriter().write(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(errorResponse));
    }
}
