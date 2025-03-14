package com.lucasrznd.projedulerbackend.services;

import com.lucasrznd.projedulerbackend.dtos.response.NotificacaoResponse;
import com.lucasrznd.projedulerbackend.exceptions.ResourceNotFoundException;
import com.lucasrznd.projedulerbackend.mappers.NotificacaoMapper;
import com.lucasrznd.projedulerbackend.models.Notificacao;
import com.lucasrznd.projedulerbackend.models.Usuario;
import com.lucasrznd.projedulerbackend.repositories.NotificacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;

@Service
@RequiredArgsConstructor
public class NotificacaoService {

    private final NotificacaoRepository repository;
    private final NotificacaoMapper mapper;
    private final UsuarioService usuarioService;
    private final MessageSource messageSource;

    public void save(final Notificacao notificacao) {
        notificacao.setDataCriacao(LocalDateTime.now());
        notificacao.setLida(false);

        repository.save(notificacao);
    }

    public List<NotificacaoResponse> findAll(UserDetails user) {
        Usuario usuario = usuarioService.findByEmail(user.getUsername());

        return repository.findAllByUsuarioId(usuario.getId()).stream().map(mapper::toResponse).toList();
    }

    public void marcarComoLida(Long notificacaoId) {
        Notificacao notificacao = find(notificacaoId);
        notificacao.setLida(true);

        repository.save(notificacao);
    }

    public String criarMensagem(String projetoNome, String atividadeNome) {
        Locale locale = LocaleContextHolder.getLocale();
        return !projetoNome.isEmpty()
                ? messageSource.getMessage("notification.project.added",
                new Object[]{projetoNome}, locale)
                : messageSource.getMessage("notification.activity.added",
                new Object[]{atividadeNome}, locale);
    }

    private Notificacao find(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Notificação não encontrada. Id: " + id));
    }
}
