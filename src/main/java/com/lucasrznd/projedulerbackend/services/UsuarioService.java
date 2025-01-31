package com.lucasrznd.projedulerbackend.services;

import com.lucasrznd.projedulerbackend.dtos.request.UsuarioRequest;
import com.lucasrznd.projedulerbackend.dtos.response.UsuarioResponse;
import com.lucasrznd.projedulerbackend.exceptions.ResourceNotFoundException;
import com.lucasrznd.projedulerbackend.mappers.UsuarioMapper;
import com.lucasrznd.projedulerbackend.models.Usuario;
import com.lucasrznd.projedulerbackend.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository repository;
    private final UsuarioMapper mapper;
    private final BCryptPasswordEncoder encoder;

    public UsuarioResponse create(final UsuarioRequest request) {
        verifyIfEmailAlreadyExists(request.email(), null);

        Usuario usuario = mapper.toModel(request);
        if (Objects.isNull(usuario.getDataCriacao())) {
            usuario.setDataCriacao(LocalDateTime.now());
        }
        usuario.setSenha(encoder.encode(usuario.getSenha()));

        return mapper.toResponse(repository.save(usuario));
    }

    public List<UsuarioResponse> findAll() {
        return repository.findAll().stream().map(mapper::toResponse).toList();
    }

    public UsuarioResponse update(final Long id, final UsuarioRequest request) {
        Usuario usuario = find(id);
        verifyIfEmailAlreadyExists(request.email(), id);

        return mapper.toResponse(
                repository.save(
                        mapper.update(request, usuario)
                                .withSenha(request.senha() != null ? encoder.encode(request.senha())
                                : usuario.getSenha()))
        );
    }

    public void delete(final Long id) {
        repository.delete(find(id));
    }

    private Usuario find(final Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado. Id: " + id + ", Tipo: " + UsuarioResponse.class.getSimpleName()));
    }

    private void verifyIfEmailAlreadyExists(final String email, Long id) {
        repository.findByEmail(email)
                .filter(user -> !user.getId().equals(id))
                .ifPresent(user -> {
                    throw new DataIntegrityViolationException("Email [ " + email + " ] já existe");
                });
    }
}
