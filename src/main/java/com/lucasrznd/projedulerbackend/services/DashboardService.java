package com.lucasrznd.projedulerbackend.services;

import com.lucasrznd.projedulerbackend.dtos.response.UsuarioAtivoResponse;
import com.lucasrznd.projedulerbackend.models.AtividadeUsuario;
import com.lucasrznd.projedulerbackend.models.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class DashboardService {

    private final ProjetoService projetoService;
    private final UsuarioService usuarioService;
    private final AtividadeService atividadeService;
    private final LancamentoHoraService lancamentoHoraService;
    private final UsuarioAtivoService usuarioAtivoService;

    public Map<String, Object> getMetricasDashboard(UserDetails user) {
        Usuario usuario = usuarioService.findByEmail(user.getUsername());
        Map<String, Object> metricas = new HashMap<>();

        metricas.put("projetosEmAndamento", projetoService.countAllByStatus("EM ANDAMENTO", usuario));
        metricas.put("atividadesPendentes", atividadeService.countAllPendentes(usuario));
        metricas.put("horasLancadasMes", lancamentoHoraService.getTotalHorasLancadasMes(usuario));
        metricas.put("horasLancadasSemana", lancamentoHoraService.getTotalHorasLancadasSemana(usuario));
        metricas.put("horasLancadasHoje", lancamentoHoraService.getTotalHorasLancadasHoje(usuario));
        metricas.put("atividadesAtrasadas", atividadeService.countAllAtrasdas(usuario));

        return metricas;
    }

    public Map<String, Object> getMetricasDashboardAdmin(UserDetails user) {
        Usuario usuario = usuarioService.findByEmail(user.getUsername());
        Map<String, Object> metricas = new HashMap<>();

        metricas.put("usuariosAtivos", getUsuariosAtivos().quantidade());
        metricas.put("mediaHorasMes", lancamentoHoraService.getMediaHorasLancadasPorMes());

        metricas.put("projetosPlanejados", projetoService.countAllByStatus("PLANEJADO", usuario));
        metricas.put("projetosEmAndamento", projetoService.countAllByStatus("EM ANDAMENTO", usuario));
        metricas.put("projetosConcluidos", projetoService.countAllByStatus("CONCLUIDO", usuario));
        metricas.put("projetosCancelados", projetoService.countAllByStatus("CANCELADO", usuario));

        metricas.put("atividadesAbertas", atividadeService.countAllByStatus("ABERTA", usuario));
        metricas.put("atividadesEmAndamento", atividadeService.countAllByStatus("EM ANDAMENTO", usuario));
        metricas.put("atividadesConcluidas", atividadeService.countAllByStatus("CONCLUIDA", usuario));
        metricas.put("atividadesPausadas", atividadeService.countAllByStatus("PAUSADA", usuario));

        return metricas;
    }

    public UsuarioAtivoResponse getUsuariosAtivos() {
        return new UsuarioAtivoResponse(usuarioAtivoService.getContagemUsuariosAtivos(), usuarioAtivoService.getUsuariosAtivos());
    }
}
