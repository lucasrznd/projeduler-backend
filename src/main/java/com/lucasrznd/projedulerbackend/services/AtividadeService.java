package com.lucasrznd.projedulerbackend.services;

import com.lucasrznd.projedulerbackend.dtos.request.AtividadeRequest;
import com.lucasrznd.projedulerbackend.dtos.response.AtividadeResponse;
import com.lucasrznd.projedulerbackend.exceptions.ResourceNotFoundException;
import com.lucasrznd.projedulerbackend.mappers.AtividadeMapper;
import com.lucasrznd.projedulerbackend.models.Atividade;
import com.lucasrznd.projedulerbackend.models.Usuario;
import com.lucasrznd.projedulerbackend.repositories.AtividadeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AtividadeService {

    private final AtividadeRepository repository;
    private final AtividadeMapper mapper;
    private final UsuarioService usuarioService;

    public AtividadeResponse save(final AtividadeRequest request) {
        Atividade atividade = mapper.toModel(request);
        atividade.setDataCriacao(LocalDateTime.now());

        return mapper.toResponse(repository.save(atividade));
    }

    public List<AtividadeResponse> findAll(UserDetails user) {
        Usuario usuario = usuarioService.findByEmail(user.getUsername());

        if (usuario.getPerfil().equals("ADMIN")) {
            return repository.findAllAtividades().stream().map(mapper::toResponse).toList();
        }

        return repository.findByUsuarioResponsavelId(usuario.getId()).stream().map(mapper::toResponse).toList();
    }

    public Long countAllByStatus(String status, UserDetails user) {
        Usuario usuario = usuarioService.findByEmail(user.getUsername());

        if (usuario.getPerfil().equals("ADMIN")) {
            return repository.countAllByStatus(status);
        }

        return repository.countAllByStatusAndUsuarioId(status, usuario.getId());
    }

    public Long countAllPendentes(UserDetails user) {
        Usuario usuario = usuarioService.findByEmail(user.getUsername());

        if (usuario.getPerfil().equals("ADMIN")) {
            return repository.countAllByStatus("ABERTA");
        }

        return repository.countAllByStatusAndUsuarioId("ABERTA", usuario.getId());
    }

    public Long countAllAtrasdas(UserDetails user) {
        Usuario usuario = usuarioService.findByEmail(user.getUsername());

        if (usuario.getPerfil().equals("ADMIN")) {
            return repository.countAllAtrasadas();
        }

        return repository.countAllAtrasadasByUsuarioId(usuario.getId());
    }

    public AtividadeResponse update(Long id, AtividadeRequest request) {
        Atividade atividade = find(id);

        return mapper.toResponse(repository.save(mapper.update(request, atividade)));
    }

    public void delete(final Long id) {
        repository.delete(find(id));
    }

    public Atividade find(final Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Atividade não encontrada. Id: " + id + ", Tipo: " + AtividadeResponse.class.getSimpleName()));
    }
}
