package com.lucasrznd.projedulerbackend.services;

import com.lucasrznd.projedulerbackend.models.AtividadeUsuario;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class UsuarioAtivoService {

    private final Map<String, AtividadeUsuario> usuariosAtivos = new ConcurrentHashMap<>();
    private final long limiteInatividade = 60 * 60 * 1000; // 30 minutos em ms

    public void limparUsuariosInativos() {
        long horaAtual = System.currentTimeMillis();
        usuariosAtivos.entrySet().removeIf(entry ->
                (horaAtual - entry.getValue().getUltimaAtividade()) > limiteInatividade);
    }

    public void registrarAtividadeDoUsuario(String email) {
        usuariosAtivos.put(email, new AtividadeUsuario(email, System.currentTimeMillis()));
    }

    public List<AtividadeUsuario> getUsuariosAtivos() {
        return new ArrayList<>(usuariosAtivos.values());
    }

    public int getContagemUsuariosAtivos() {
        return usuariosAtivos.size();
    }
}