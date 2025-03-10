package com.lucasrznd.projedulerbackend.repositories;

import com.lucasrznd.projedulerbackend.models.Atividade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AtividadeRepository extends JpaRepository<Atividade, Long> {

    @Query("SELECT a FROM Atividade a ORDER BY a.dataCriacao DESC")
    List<Atividade> findAllAtividades();

    @Query("SELECT a FROM Atividade a INNER JOIN UsuarioAtividade ua ON a.id =  ua.atividade.id WHERE ua.usuario.id = :usuarioId ORDER BY ua.dataEntrada")
    List<Atividade> findByUsuarioResponsavelId(Long usuarioId);

    @Query("SELECT COUNT(*) FROM Atividade a JOIN UsuarioAtividade ua ON a.id = ua.atividade.id WHERE a.status = :status")
    Long countAllByStatus(String status);

    @Query("SELECT COUNT(*) FROM Atividade a JOIN UsuarioAtividade ua ON a.id = ua.atividade.id WHERE a.status = :status AND ua.usuario.id = :usuarioId")
    Long countAllByStatusAndUsuarioId(String status, Long usuarioId);

    @Query("SELECT COUNT(*) FROM Atividade a WHERE a.dataFim < NOW() AND a.status != 'CONCLUIDA'")
    Long countAllAtrasadas();

    @Query("SELECT COUNT(*) FROM Atividade a INNER JOIN UsuarioAtividade ua ON a.id = ua.usuario.id WHERE a.dataFim < NOW() AND a.status != 'CONCLUIDA' AND ua.usuario.id = :usuarioId")
    Long countAllAtrasadasByUsuarioId(Long usuarioId);

    @Query("SELECT a FROM Atividade a WHERE a.dataFim < NOW() AND a.status != 'CONCLUIDA'")
    List<Atividade> findAllAtrasadas();

    @Query("SELECT a FROM Atividade a INNER JOIN UsuarioAtividade ua ON a.id = ua.usuario.id WHERE a.dataFim < NOW() AND a.status != 'CONCLUIDA' AND ua.usuario.id = :usuarioId")
    List<Atividade> findAllAtrasadasByUsuarioId(Long usuarioId);

    @Modifying
    @Query("UPDATE Atividade a SET a.ativo = false, a.dataExclusao =:dataExclusao WHERE a.id =:id")
    void softDeleteById(Long id, LocalDateTime dataExclusao);

    @Modifying
    @Query("UPDATE Atividade a SET a.ativo = false, a.dataExclusao = :dataExclusao WHERE a.projeto.id = :projetoId")
    void softDeleteAllByProjetoId(Long projetoId, LocalDateTime dataExclusao);

}
