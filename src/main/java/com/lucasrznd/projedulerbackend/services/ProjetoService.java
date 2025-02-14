package com.lucasrznd.projedulerbackend.services;

import com.lucasrznd.projedulerbackend.dtos.request.ProjetoRequest;
import com.lucasrznd.projedulerbackend.dtos.response.ProjetoResponse;
import com.lucasrznd.projedulerbackend.exceptions.ResourceNotFoundException;
import com.lucasrznd.projedulerbackend.mappers.ProjetoMapper;
import com.lucasrznd.projedulerbackend.models.Projeto;
import com.lucasrznd.projedulerbackend.models.Usuario;
import com.lucasrznd.projedulerbackend.repositories.ProjetoRepository;
import com.lucasrznd.projedulerbackend.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjetoService {

    private final ProjetoRepository repository;
    private final ProjetoMapper mapper;
    private final UsuarioRepository usuarioRepository;

    public ProjetoResponse save(final ProjetoRequest request) {
        Projeto projeto = mapper.toModel(request);
        projeto.setDataCriacao(LocalDateTime.now());

        return mapper.toResponse(repository.save(projeto));
    }

    /**
     * Retorna uma lista de projetos acessíveis pelo usuário autenticado.
     * <p>
     * - Se o usuário for ADMIN, retorna todos os projetos do sistema.
     * - Caso contrário, retorna apenas os projetos nos quais o usuário está associado.
     * </p>
     *
     * @param user Objeto {@link UserDetails} representando o usuário autenticado.
     * @return Lista de {@link ProjetoResponse} contendo os projetos visíveis ao usuário.
     * @throws UsernameNotFoundException Se o usuário autenticado não for encontrado no banco de dados.
     */
    public List<ProjetoResponse> findAll(UserDetails user) {
        Usuario usuario = usuarioRepository.findByEmail(user.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado."));

        if (usuario.getPerfil().equals("ADMIN")) {
            return repository.findAll().stream().map(mapper::toResponse).toList();
        }

        return repository.findByUsuarioId(usuario.getId()).stream().map(mapper::toResponse).toList();
    }

    public ProjetoResponse update(Long id, ProjetoRequest request) {
        Projeto projeto = find(id);

        return mapper.toResponse(repository.save(mapper.update(request, projeto)));
    }

    public void delete(final Long id) {
        repository.delete(find(id));
    }

    private Projeto find(final Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Projeto não encontrado. Id: " + id + ", Tipo: " + ProjetoResponse.class.getSimpleName()));
    }
}
