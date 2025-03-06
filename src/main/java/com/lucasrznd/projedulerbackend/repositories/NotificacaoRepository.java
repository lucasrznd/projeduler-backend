package com.lucasrznd.projedulerbackend.repositories;

import com.lucasrznd.projedulerbackend.models.Notificacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificacaoRepository extends JpaRepository<Notificacao, Long> {

    @Query("SELECT n FROM Notificacao n WHERE n.usuario.id = :usuarioId AND n.lida = false ORDER BY n.dataCriacao DESC")
    List<Notificacao> findAllByUsuarioId(Long usuarioId);

}
