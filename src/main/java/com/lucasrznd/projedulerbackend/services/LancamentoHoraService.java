package com.lucasrznd.projedulerbackend.services;

import com.lucasrznd.projedulerbackend.dtos.request.LancamentoHoraRequest;
import com.lucasrznd.projedulerbackend.dtos.response.LancamentoHoraResponse;
import com.lucasrznd.projedulerbackend.exceptions.ResourceNotFoundException;
import com.lucasrznd.projedulerbackend.mappers.LancamentoHoraMapper;
import com.lucasrznd.projedulerbackend.models.LancamentoHora;
import com.lucasrznd.projedulerbackend.models.Usuario;
import com.lucasrznd.projedulerbackend.repositories.LancamentoHoraRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Locale;

@Service
@RequiredArgsConstructor
public class LancamentoHoraService {

    private final LancamentoHoraRepository repository;
    private final LancamentoHoraMapper mapper;
    private final UsuarioService usuarioService;

    public LancamentoHoraResponse save(final LancamentoHoraRequest request, UserDetails user) {
        Usuario usuario = usuarioService.findByEmail(user.getUsername());
        verificarSeLancamentoJaExiste(request.dataInicio(), request.dataFim(), usuario.getId());

        LancamentoHora lancamentoHora = mapper.toModel(request);
        lancamentoHora.setUsuario(usuario);
        lancamentoHora.setDataInicio(truncarSegundos(request.dataInicio()));
        lancamentoHora.setDataFim(truncarSegundos(request.dataFim()));
        lancamentoHora.setDataRegistro(LocalDateTime.now());

        return mapper.toResponse(repository.save(lancamentoHora));
    }

    public List<LancamentoHoraResponse> findAll(UserDetails user) {
        Usuario usuario = usuarioService.findByEmail(user.getUsername());

        if (usuario.getPerfil().equals("ADMIN")) {
            return repository.findAllLancamentos().stream().map(mapper::toResponse).toList();
        }

        return repository.findByUsuarioId(usuario.getId()).stream().map(mapper::toResponse).toList();
    }

    public List<LancamentoHoraResponse> findUltimosCinco(UserDetails user) {
        Usuario usuario = usuarioService.findByEmail(user.getUsername());

        if (usuario.getPerfil().equals("ADMIN")) {
            return repository.findUltimosCinco().stream().map(mapper::toResponse).toList();
        }

        return repository.findUltimosCincoByUsuarioId(usuario.getId()).stream().map(mapper::toResponse).toList();
    }

    public String getTotalHorasLancadasMes(UserDetails user) {
        Usuario usuario = usuarioService.findByEmail(user.getUsername());

        if (usuario.getPerfil().equals("ADMIN")) {
            return calcularTotalHoras(repository.findLancamentosMesAtual());
        }

        return calcularTotalHoras(repository.findLancamentosMesAtualByUsuarioId(usuario.getId()));
    }

    public String getTotalHorasLancadasSemana(UserDetails user) {
        Usuario usuario = usuarioService.findByEmail(user.getUsername());

        if (usuario.getPerfil().equals("ADMIN")) {
            return calcularTotalHoras(repository.findLancamentosSemanaAtual());
        }

        return calcularTotalHoras(repository.findLancamentosSemanaAtualByUsuarioId(usuario.getId()));
    }

    public String getTotalHorasLancadasHoje(UserDetails user) {
        Usuario usuario = usuarioService.findByEmail(user.getUsername());

        if (usuario.getPerfil().equals("ADMIN")) {
            return calcularTotalHoras(repository.findLancamentosDiaAtual());
        }

        return calcularTotalHoras(repository.findLancamentosDiaAtualByUsuarioId(usuario.getId()));
    }

    public String getMediaHorasLancadasPorMes() {
        List<LancamentoHora> lancamentos = repository.findLancamentosMesAtual();
        return String.format("%.2f", Double.parseDouble(calcularTotalHoras(lancamentos)) / lancamentos.size());
    }

    public LancamentoHoraResponse update(Long id, LancamentoHoraRequest request) {
        LancamentoHora lancamentoHora = find(id);

        return mapper.toResponse(repository.save(mapper.update(request, lancamentoHora)));
    }

    @Transactional
    public void delete(final Long id) {
        LancamentoHora lancamentoHora = find(id);

        repository.delete(lancamentoHora);
    }

    private LancamentoHora find(final Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Lançamento de Hora não encontrado. Id: " + id + ", Tipo: " + LancamentoHoraResponse.class.getSimpleName()));
    }

    private void verificarSeLancamentoJaExiste(LocalDateTime dataInicio, LocalDateTime dataFim, Long usuarioId) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");

        repository.findByDataInicioAndDataFimAndUsuarioId(truncarSegundos(dataInicio), truncarSegundos(dataFim), usuarioId)
                .ifPresent(lancamento -> {
                    throw new DataIntegrityViolationException("Lançamento para o horário [" + dtf.format(dataInicio) + " - " + dtf.format(dataFim) + "] já existe.");
                });
    }

    private LocalDateTime truncarSegundos(LocalDateTime data) {
        return data.truncatedTo(ChronoUnit.SECONDS);
    }

    private String calcularTotalHoras(List<LancamentoHora> lancamentos) {
        Double total = lancamentos.stream()
                .filter(l -> l.getDataInicio() != null && l.getDataFim() != null)
                .mapToDouble(l -> Duration.between(l.getDataInicio(), l.getDataFim()).toMinutes() / 60D)
                .sum();

        return String.format(Locale.US, "%.2f", total);
    }
}
