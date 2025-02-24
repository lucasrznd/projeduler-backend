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

    List<LancamentoHora> findByUsuarioId(Long id);

}
