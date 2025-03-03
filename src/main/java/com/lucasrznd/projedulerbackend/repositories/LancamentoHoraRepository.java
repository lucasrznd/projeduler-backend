package com.lucasrznd.projedulerbackend.repositories;

import com.lucasrznd.projedulerbackend.models.LancamentoHora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LancamentoHoraRepository extends JpaRepository<LancamentoHora, Long> {

    @Query("SELECT lh FROM LancamentoHora lh ORDER BY lh.dataRegistro DESC")
    List<LancamentoHora> findAllLancamentos();

    @Query("SELECT lh FROM LancamentoHora lh ORDER BY lh.dataRegistro DESC LIMIT 5")
    List<LancamentoHora> findUltimosCinco();

    @Query("SELECT lh FROM LancamentoHora lh WHERE lh.usuario.id = :usuarioId ORDER BY lh.dataRegistro DESC LIMIT 5")
    List<LancamentoHora> findUltimosCincoByUsuarioId(Long usuarioId);

    @Query("SELECT lh FROM LancamentoHora lh WHERE lh.usuario.id = :usuarioId ORDER BY lh.dataRegistro DESC")
    List<LancamentoHora> findByUsuarioId(Long usuarioId);

    @Query("SELECT lh FROM LancamentoHora lh WHERE MONTH(lh.dataRegistro) = MONTH(CURRENT_DATE) AND YEAR(lh.dataRegistro) = YEAR(CURRENT_DATE)")
    List<LancamentoHora> findLancamentosMesAtual();

    @Query("SELECT lh FROM LancamentoHora lh WHERE MONTH(lh.dataRegistro) = MONTH(CURRENT_DATE) AND YEAR(lh.dataRegistro) = YEAR(CURRENT_DATE) AND lh.usuario.id = :usuarioId")
    List<LancamentoHora> findLancamentosMesAtualByUsuarioId(Long usuarioId);

    @Query("SELECT lh FROM LancamentoHora lh WHERE WEEK(lh.dataRegistro) = WEEK(CURRENT_DATE) AND YEAR(lh.dataRegistro) = YEAR(CURRENT_DATE)")
    List<LancamentoHora> findLancamentosSemanaAtual();

    @Query("SELECT lh FROM LancamentoHora lh WHERE WEEK(lh.dataRegistro) = WEEK(CURRENT_DATE) AND YEAR(lh.dataRegistro) = YEAR(CURRENT_DATE) AND lh.usuario.id = :usuarioId")
    List<LancamentoHora> findLancamentosSemanaAtualByUsuarioId(Long usuarioId);

    @Query("SELECT lh FROM LancamentoHora lh WHERE DAY(lh.dataRegistro) = DAY(CURRENT_DATE) AND YEAR(lh.dataRegistro) = YEAR(CURRENT_DATE)")
    List<LancamentoHora> findLancamentosDiaAtual();

    @Query("SELECT lh FROM LancamentoHora lh WHERE DAY(lh.dataRegistro) = DAY(CURRENT_DATE) AND YEAR(lh.dataRegistro) = YEAR(CURRENT_DATE) AND lh.usuario.id = :usuarioId")
    List<LancamentoHora> findLancamentosDiaAtualByUsuarioId(Long usuarioId);

}
