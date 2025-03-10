package com.lucasrznd.projedulerbackend.repositories;

import com.lucasrznd.projedulerbackend.models.UsuarioAtividade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface UsuarioAtividadeRepository extends JpaRepository<UsuarioAtividade, Long> {

    Optional<UsuarioAtividade> findByUsuarioIdAndAtividadeId(Long usuarioId, Long atividadeId);

    @Modifying
    @Query("UPDATE UsuarioAtividade ua SET ua.ativo = false, ua.dataExclusao =:dataExclusao WHERE ua.id = :id")
    void softDeleteById(Long id, LocalDateTime dataExclusao);

    @Modifying
    @Query("UPDATE UsuarioAtividade ua SET ua.ativo = false, ua.dataExclusao =:dataExclusao WHERE ua.usuario.id = :usuarioId")
    void softDeleteAllByUsuarioId(Long usuarioId, LocalDateTime dataExclusao);

    @Modifying
    @Query("UPDATE UsuarioAtividade ua SET ua.ativo = false, ua.dataExclusao =:dataExclusao WHERE ua.atividade.id =:atividadeId")
    void softDeleteAllByAtividadeId(Long atividadeId, LocalDateTime dataExclusao);

    @Modifying
    @Query("UPDATE UsuarioAtividade ua SET ua.ativo = false, ua.dataExclusao = :dataExclusao " +
            "WHERE ua.atividade.id IN (SELECT a.id FROM Atividade a WHERE a.projeto.id = :projetoId AND a.ativo = true) " +
            "AND ua.ativo = true")
    void softDeleteAllByProjetoId(Long projetoId, LocalDateTime dataExclusao);

}
