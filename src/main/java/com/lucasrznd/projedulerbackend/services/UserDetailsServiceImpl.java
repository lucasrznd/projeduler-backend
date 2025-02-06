package com.lucasrznd.projedulerbackend.services;

import com.lucasrznd.projedulerbackend.models.Usuario;
import com.lucasrznd.projedulerbackend.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final var entity = repository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado: " + username));

        return new Usuario(entity.getId(),
                entity.getNome(),
                entity.getEmail(),
                entity.getSenha(),
                entity.getDataCriacao(),
                entity.getUltimoLogin(),
                entity.getPerfil());
    }
}
