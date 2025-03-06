package com.lucasrznd.projedulerbackend.security;

import com.lucasrznd.projedulerbackend.services.UsuarioAtivoService;
import com.lucasrznd.projedulerbackend.services.UsuarioService;
import com.lucasrznd.projedulerbackend.utils.JWTUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class AtividadeUsuarioFilter extends OncePerRequestFilter {

    private final UsuarioAtivoService usuarioAtivoService;
    private final JWTUtils jwtUtils;
    private final UsuarioService usuarioService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = SecurityFilter.recoverToken(request);

        if (token != null) {
            String login = jwtUtils.validateToken(token);

            if (login != null) {
                UserDetails usuario = usuarioService.findByEmail(login);

                if (usuario != null && SecurityContextHolder.getContext().getAuthentication() != null) {
                    usuarioAtivoService.registrarAtividadeDoUsuario(usuario.getUsername());
                }
            }
        }

        filterChain.doFilter(request, response);
    }
}
