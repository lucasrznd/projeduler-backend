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

import java.time.LocalDateTime;

@Log4j2
@Service
public class JWTAuthenticationImpl {

    private final AuthenticationManager authenticationManager;
    private final JWTUtils jwtUtils;
    private final UsuarioRepository repository;

    @Value("${api.security.access-token.expiration}")
    private Long accessTokenExpiration;

    @Value("${api.security.refresh-token.expiration}")
    private Long refreshTokenExpiration;

    public JWTAuthenticationImpl(AuthenticationManager authenticationManager, JWTUtils jwtUtils, UsuarioRepository repository) {
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
        this.repository = repository;
    }

    /**
     * Realiza a autenticação do usuário e gera tokens JWT de acesso e refresh.
     * <p>
     * O método valida as credenciais do usuário, gerando um token de acesso e um refresh token
     * para a sessão autenticada. Após a autenticação bem-sucedida, a data do último login do usuário
     * é atualizada no banco de dados.
     * </p>
     *
     * @param request Objeto {@link AuthenticateRequest} contendo o email e senha do usuário.
     * @return {@link AuthenticationResponse} contendo os tokens JWT gerados para o usuário.
     * @throws BadCredentialsException Se as credenciais do usuário forem inválidas.
     */
    public AuthenticationResponse login(AuthenticateRequest request) {
        try {
            var usernamePassword = new UsernamePasswordAuthenticationToken(request.email(), request.senha());
            var auth = authenticationManager.authenticate(usernamePassword);

            String token = jwtUtils.generateToken((Usuario) auth.getPrincipal(), accessTokenExpiration);
            String refreshToken = jwtUtils.generateToken((Usuario) auth.getPrincipal(), refreshTokenExpiration);

            updateLastLogin((Usuario) auth.getPrincipal());

            log.info("Usuário autenticado com sucesso: {}", request.email());
            return new AuthenticationResponse(token, refreshToken);
        } catch (BadCredentialsException ex) {
            log.error("Erro na autenticação de usuário: {}", request.email());
            throw new BadCredentialsException("Email ou senha inválidos.");
        }
    }

    /**
     * Gera um novo token de acesso utilizando um refresh token válido.
     * <p>
     * O método valida o refresh token fornecido, recupera o usuário associado e gera um novo token de acesso.
     * Após isso, o último login do usuário é atualizado no banco de dados. O refresh token permanece válido,
     * permitindo que o mesmo seja retornado na resposta.
     * </p>
     *
     * @param refreshToken O token de refresh fornecido pelo cliente para gerar um novo token de acesso.
     * @return {@link AuthenticationResponse} contendo o novo token de acesso gerado e o refresh token original.
     * @throws UsernameNotFoundException Se o usuário associado ao refresh token não for encontrado no banco de dados.
     */
    public AuthenticationResponse refreshToken(String refreshToken) {
        String login = jwtUtils.validateToken(refreshToken);
        Usuario usuario = repository.findByEmail(login)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado."));

        var authentication = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());

        SecurityContextHolder.getContext().setAuthentication(authentication);

        updateLastLogin(usuario);

        return new AuthenticationResponse(jwtUtils.generateToken(usuario, accessTokenExpiration), refreshToken);
    }

    private void updateLastLogin(Usuario usuario) {
        usuario.setUltimoLogin(LocalDateTime.now());
        repository.save(usuario);
    }
}
