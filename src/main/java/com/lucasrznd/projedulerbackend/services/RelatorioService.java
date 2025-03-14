package com.lucasrznd.projedulerbackend.services;

import com.lucasrznd.projedulerbackend.dtos.response.AtividadePorStatusResponse;
import com.lucasrznd.projedulerbackend.dtos.response.HorasPorMesResponse;
import com.lucasrznd.projedulerbackend.dtos.response.HorasPorProjetoResponse;
import com.lucasrznd.projedulerbackend.dtos.response.TopUsuarioResponse;
import com.lucasrznd.projedulerbackend.repositories.AtividadeRepository;
import com.lucasrznd.projedulerbackend.repositories.LancamentoHoraRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.*;

@Service
@RequiredArgsConstructor
public class RelatorioService {

    private final LancamentoHoraRepository lancamentoHoraRepository;
    private final AtividadeRepository atividadeRepository;

    /**
     * Busca horas trabalhadas por projeto com base nos filtros informados
     */
    public List<HorasPorProjetoResponse> buscarHorasPorProjeto(
            LocalDate dataInicio, LocalDate dataFim, Long projetoId, Long usuarioId, String status) {

        // Definir datas padrão se não forem fornecidas
        if (dataInicio == null) {
            dataInicio = LocalDate.now().minusMonths(3);
        }
        if (dataFim == null) {
            dataFim = LocalDate.now();
        }

        // Converter para DateTime para comparação com os timestamps
        LocalDateTime dataInicioDateTime = dataInicio.atStartOfDay();
        LocalDateTime dataFimDateTime = dataFim.atTime(23, 59, 59);

        // Buscar dados do banco
        List<Object[]> resultados = lancamentoHoraRepository.buscarHorasPorProjeto(
                dataInicioDateTime, dataFimDateTime, projetoId, usuarioId, status);

        // Converter resultados para DTOs
        List<HorasPorProjetoResponse> dtos = new ArrayList<>();
        for (Object[] resultado : resultados) {
            HorasPorProjetoResponse dto = new HorasPorProjetoResponse(((Number) resultado[0]).longValue(), (String) resultado[1], ((Number) resultado[2]).doubleValue());
            dtos.add(dto);
        }

        return dtos;
    }

    /**
     * Busca horas trabalhadas por mês com base nos filtros informados
     */
    public List<HorasPorMesResponse> buscarHorasPorMes(
            LocalDate dataInicio, LocalDate dataFim, Long projetoId, Long usuarioId, String status) {

        // Definir datas padrão se não forem fornecidas
        if (dataInicio == null) {
            dataInicio = LocalDate.now().minusMonths(6);
        }
        if (dataFim == null) {
            dataFim = LocalDate.now();
        }

        // Converter para DateTime para comparação com os timestamps
        LocalDateTime dataInicioDateTime = dataInicio.atStartOfDay();
        LocalDateTime dataFimDateTime = dataFim.atTime(23, 59, 59);

        // Buscar dados do banco
        List<Object[]> resultados = lancamentoHoraRepository.buscarHorasPorMes(
                dataInicioDateTime, dataFimDateTime, projetoId, usuarioId, status);

        // Converter resultados para DTOs
        Map<String, Double> horasPorMes = new LinkedHashMap<>();

        // Inicializar mapa com todos os meses no período (para garantir meses sem dados)
        for (int i = 0; i <= dataFim.getMonthValue() - dataInicio.getMonthValue() +
                (dataFim.getYear() - dataInicio.getYear()) * 12; i++) {
            LocalDate mesAtual = dataInicio.plusMonths(i);
            String nomeMes = mesAtual.getMonth().getDisplayName(TextStyle.SHORT, new Locale("pt", "BR")) + "/" +
                    String.format("%02d", mesAtual.getYear() % 100);
            horasPorMes.put(nomeMes, 0.0);
        }

        // Preencher com dados reais
        for (Object[] resultado : resultados) {
            int ano = ((Number) resultado[0]).intValue();
            int mes = ((Number) resultado[1]).intValue();
            double horas = ((Number) resultado[2]).doubleValue();

            Month month = Month.of(mes);
            String nomeMes = month.getDisplayName(TextStyle.SHORT, new Locale("pt", "BR")) + "/" +
                    String.format("%02d", ano % 100);

            horasPorMes.put(nomeMes, horas);
        }

        // Converter mapa para lista de DTOs
        List<HorasPorMesResponse> dtos = new ArrayList<>();
        for (Map.Entry<String, Double> entry : horasPorMes.entrySet()) {
            HorasPorMesResponse dto = new HorasPorMesResponse(entry.getKey(), entry.getValue());
            dtos.add(dto);
        }

        return dtos;
    }

    /**
     * Busca atividades por status com base nos filtros informados
     */
    public List<AtividadePorStatusResponse> buscarAtividadesPorStatus(
            LocalDate dataInicio, LocalDate dataFim, Long projetoId, Long usuarioId, String status) {

        // Definir datas padrão se não forem fornecidas
        if (dataInicio == null) {
            dataInicio = LocalDate.now().minusMonths(3);
        }
        if (dataFim == null) {
            dataFim = LocalDate.now();
        }

        // Buscar dados do banco
        List<Object[]> resultados = atividadeRepository.contarAtividadesPorStatus(
                dataInicio, dataFim, projetoId, usuarioId, status);

        // Converter resultados para DTOs
        List<AtividadePorStatusResponse> dtos = new ArrayList<>();
        for (Object[] resultado : resultados) {
            AtividadePorStatusResponse dto = new AtividadePorStatusResponse((String) resultado[0], ((Number) resultado[1]).intValue());
            dtos.add(dto);
        }

        return dtos;
    }

    /**
     * Busca top usuários por horas trabalhadas com base nos filtros informados
     */
    public List<TopUsuarioResponse> buscarTopUsuariosPorHoras(
            LocalDate dataInicio, LocalDate dataFim, Long projetoId, Long usuarioId, String status) {

        // Definir datas padrão se não forem fornecidas
        if (dataInicio == null) {
            dataInicio = LocalDate.now().minusMonths(3);
        }
        if (dataFim == null) {
            dataFim = LocalDate.now();
        }

        // Converter para DateTime para comparação com os timestamps
        LocalDateTime dataInicioDateTime = dataInicio.atStartOfDay();
        LocalDateTime dataFimDateTime = dataFim.atTime(23, 59, 59);

        // Buscar dados do banco
        List<Object[]> resultados = lancamentoHoraRepository.buscarTopUsuariosPorHoras(
                dataInicioDateTime, dataFimDateTime, projetoId, usuarioId, status, 10);

        // Converter resultados para DTOs
        List<TopUsuarioResponse> dtos = new ArrayList<>();
        for (Object[] resultado : resultados) {
            TopUsuarioResponse dto = new TopUsuarioResponse(
                    ((Number) resultado[0]).longValue(),
                    (String) resultado[1],
                    (((Number) resultado[2]).doubleValue()));
            dtos.add(dto);
        }

        return dtos;
    }
}
