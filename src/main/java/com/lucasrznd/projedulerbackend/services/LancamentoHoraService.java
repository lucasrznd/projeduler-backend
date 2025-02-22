package com.lucasrznd.projedulerbackend.services;

import com.lucasrznd.projedulerbackend.dtos.request.LancamentoHoraRequest;
import com.lucasrznd.projedulerbackend.dtos.response.LancamentoHoraResponse;
import com.lucasrznd.projedulerbackend.exceptions.ResourceNotFoundException;
import com.lucasrznd.projedulerbackend.mappers.LancamentoHoraMapper;
import com.lucasrznd.projedulerbackend.models.LancamentoHora;
import com.lucasrznd.projedulerbackend.models.Usuario;
import com.lucasrznd.projedulerbackend.repositories.LancamentoHoraRepository;
import com.lucasrznd.projedulerbackend.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LancamentoHoraService {

    private final LancamentoHoraRepository repository;
    private final LancamentoHoraMapper mapper;
    private final UsuarioRepository usuarioRepository;

    public LancamentoHoraResponse save(final LancamentoHoraRequest request, UserDetails user) {
        Usuario usuario = usuarioRepository.findByEmail(user.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado."));

        LancamentoHora lancamentoHora = mapper.toModel(request);
        lancamentoHora.setUsuario(usuario);
        lancamentoHora.setDataRegistro(LocalDateTime.now());

        return mapper.toResponse(repository.save(lancamentoHora));
    }

    public List<LancamentoHoraResponse> findAll() {
        return repository.findAll().stream().map(mapper::toResponse).toList();
    }

    public LancamentoHoraResponse update(Long id, LancamentoHoraRequest request) {
        LancamentoHora lancamentoHora = find(id);

        return mapper.toResponse(repository.save(mapper.update(request, lancamentoHora)));
    }

    public void delete(final Long id) {
        repository.delete(find(id));
    }

    private LancamentoHora find(final Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Lançamento de Hora não encontrado. Id: " + id + ", Tipo: " + LancamentoHoraResponse.class.getSimpleName()));
    }
}
