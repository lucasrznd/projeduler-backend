package com.lucasrznd.projedulerbackend.repositories;

import com.lucasrznd.projedulerbackend.models.LancamentoHora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface LancamentoHoraRepository extends JpaRepository<LancamentoHora, Long> {

    @Query("SELECT lh FROM LancamentoHora lh WHERE lh.usuario.ativo = true AND lh.atividade.ativo = true AND lh.atividade.projeto.ativo = true ORDER BY lh.dataRegistro DESC")
    List<LancamentoHora> findAllLancamentos();

    @Query("SELECT lh FROM LancamentoHora lh WHERE lh.usuario.ativo = true AND lh.atividade.ativo = true AND lh.atividade.projeto.ativo = true ORDER BY lh.dataRegistro DESC LIMIT 5")
    List<LancamentoHora> findUltimosCinco();

    @Query("SELECT lh FROM LancamentoHora lh WHERE lh.usuario.id = :usuarioId AND lh.usuario.ativo = true  AND lh.atividade.ativo = true AND lh.atividade.projeto.ativo = true ORDER BY lh.dataRegistro DESC LIMIT 5")
    List<LancamentoHora> findUltimosCincoByUsuarioId(Long usuarioId);

    @Query("SELECT lh FROM LancamentoHora lh WHERE lh.usuario.id = :usuarioId AND lh.usuario.ativo = true AND lh.atividade.ativo = true AND lh.atividade.projeto.ativo = true ORDER BY lh.dataRegistro DESC")
    List<LancamentoHora> findByUsuarioId(Long usuarioId);

    @Query("SELECT lh FROM LancamentoHora lh WHERE lh.dataInicio = :dataInicio AND lh.dataFim = :dataFim AND lh.usuario.id = :usuarioId AND lh.usuario.ativo = true AND lh.atividade.ativo = true AND lh.atividade.projeto.ativo = true")
    Optional<LancamentoHora> findByDataInicioAndDataFimAndUsuarioId(LocalDateTime dataInicio, LocalDateTime dataFim, Long usuarioId);

    @Query("SELECT lh FROM LancamentoHora lh WHERE MONTH(lh.dataRegistro) = MONTH(CURRENT_DATE) " +
            "AND YEAR(lh.dataRegistro) = YEAR(CURRENT_DATE) " +
            "AND lh.usuario.ativo = true AND lh.atividade.ativo = true " +
            "AND lh.atividade.projeto.ativo = true")
    List<LancamentoHora> findLancamentosMesAtual();

    @Query("SELECT lh FROM LancamentoHora lh WHERE MONTH(lh.dataRegistro) = MONTH(CURRENT_DATE) " +
            "AND YEAR(lh.dataRegistro) = YEAR(CURRENT_DATE) AND lh.usuario.id = :usuarioId " +
            "AND lh.usuario.ativo = true  AND lh.atividade.ativo = true " +
            "AND lh.atividade.projeto.ativo = true")
    List<LancamentoHora> findLancamentosMesAtualByUsuarioId(Long usuarioId);

    @Query("SELECT lh FROM LancamentoHora lh WHERE WEEK(lh.dataRegistro) = WEEK(CURRENT_DATE)" +
            " AND YEAR(lh.dataRegistro) = YEAR(CURRENT_DATE) AND MONTH(lh.dataRegistro) = MONTH(CURRENT_DATE) " +
            "AND lh.usuario.ativo = true AND lh.atividade.ativo = true" +
            " AND lh.atividade.projeto.ativo = true")
    List<LancamentoHora> findLancamentosSemanaAtual();

    @Query("SELECT lh FROM LancamentoHora lh WHERE WEEK(lh.dataRegistro) = WEEK(CURRENT_DATE) " +
            "AND YEAR(lh.dataRegistro) = YEAR(CURRENT_DATE) AND MONTH(lh.dataRegistro) = MONTH(CURRENT_DATE) " +
            "AND lh.usuario.id = :usuarioId AND lh.usuario.ativo = true " +
            "AND lh.atividade.ativo = true AND lh.atividade.projeto.ativo = true")
    List<LancamentoHora> findLancamentosSemanaAtualByUsuarioId(Long usuarioId);

    @Query("SELECT lh FROM LancamentoHora lh WHERE DAY(lh.dataRegistro) = DAY(CURRENT_DATE) " +
            "AND YEAR(lh.dataRegistro) = YEAR(CURRENT_DATE) AND MONTH(lh.dataRegistro) = MONTH(CURRENT_DATE)" +
            "AND lh.usuario.ativo = true AND lh.atividade.ativo = true" +
            " AND lh.atividade.projeto.ativo = true")
    List<LancamentoHora> findLancamentosDiaAtual();

    @Query("SELECT lh FROM LancamentoHora lh WHERE DATE(lh.dataRegistro) = CURRENT_DATE " +
            "AND lh.usuario.id = :usuarioId AND lh.usuario.ativo = true " +
            "AND lh.atividade.ativo = true AND lh.atividade.projeto.ativo = true")
    List<LancamentoHora> findLancamentosDiaAtualByUsuarioId(Long usuarioId);

    @Query(value = "SELECT p.id, p.nome, SUM(TIMESTAMPDIFF(SECOND, lh.data_inicio, lh.data_fim) / 3600.0) as total_horas " +
            "FROM tb_lancamento_hora lh " +
            "JOIN tb_atividade a ON lh.atividade_id = a.id " +
            "JOIN tb_projeto p ON a.projeto_id = p.id " +
            "WHERE lh.data_inicio >= :dataInicio AND lh.data_fim <= :dataFim " +
            "AND (:projetoId IS NULL OR p.id = :projetoId) " +
            "AND (:usuarioId IS NULL OR lh.usuario_id = :usuarioId) " +
            "AND (:status IS NULL OR a.status = :status) " +
            "AND p.ativo = 1 AND a.ativo = 1 " +
            "GROUP BY p.id, p.nome " +
            "ORDER BY total_horas DESC", nativeQuery = true)
    List<Object[]> buscarHorasPorProjeto(
            @Param("dataInicio") LocalDateTime dataInicio,
            @Param("dataFim") LocalDateTime dataFim,
            @Param("projetoId") Long projetoId,
            @Param("usuarioId") Long usuarioId,
            @Param("status") String status);

    @Query(value = "SELECT YEAR(lh.data_inicio) as ano, MONTH(lh.data_inicio) as mes, " +
            "SUM(TIMESTAMPDIFF(SECOND, lh.data_inicio, lh.data_fim) / 3600.0) as total_horas " +
            "FROM tb_lancamento_hora lh " +
            "JOIN tb_atividade a ON lh.atividade_id = a.id " +
            "JOIN tb_projeto p ON a.projeto_id = p.id " +
            "WHERE lh.data_inicio >= :dataInicio AND lh.data_fim <= :dataFim " +
            "AND (:projetoId IS NULL OR p.id = :projetoId) " +
            "AND (:usuarioId IS NULL OR lh.usuario_id = :usuarioId) " +
            "AND (:status IS NULL OR a.status = :status) " +
            "AND p.ativo = 1 AND a.ativo = 1 " +
            "GROUP BY YEAR(lh.data_inicio), MONTH(lh.data_inicio) " +
            "ORDER BY ano, mes", nativeQuery = true)
    List<Object[]> buscarHorasPorMes(
            @Param("dataInicio") LocalDateTime dataInicio,
            @Param("dataFim") LocalDateTime dataFim,
            @Param("projetoId") Long projetoId,
            @Param("usuarioId") Long usuarioId,
            @Param("status") String status);

    @Query(value = "SELECT u.id, u.nome, SUM(TIMESTAMPDIFF(SECOND, lh.data_inicio, lh.data_fim) / 3600.0) as total_horas " +
            "FROM tb_lancamento_hora lh " +
            "JOIN tb_usuario u ON lh.usuario_id = u.id " +
            "JOIN tb_atividade a ON lh.atividade_id = a.id " +
            "JOIN tb_projeto p ON a.projeto_id = p.id " +
            "WHERE lh.data_inicio >= :dataInicio AND lh.data_fim <= :dataFim " +
            "AND (:projetoId IS NULL OR p.id = :projetoId) " +
            "AND (:usuarioId IS NULL OR lh.usuario_id = :usuarioId) " +
            "AND (:status IS NULL OR a.status = :status) " +
            "AND p.ativo = 1 AND a.ativo = 1 AND u.ativo = 1 " +
            "GROUP BY u.id, u.nome " +
            "ORDER BY total_horas DESC " +
            "LIMIT :limite", nativeQuery = true)
    List<Object[]> buscarTopUsuariosPorHoras(
            @Param("dataInicio") LocalDateTime dataInicio,
            @Param("dataFim") LocalDateTime dataFim,
            @Param("projetoId") Long projetoId,
            @Param("usuarioId") Long usuarioId,
            @Param("status") String status,
            @Param("limite") int limite);

}
