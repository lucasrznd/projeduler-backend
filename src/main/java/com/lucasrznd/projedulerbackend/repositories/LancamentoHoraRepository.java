package com.lucasrznd.projedulerbackend.repositories;

import com.lucasrznd.projedulerbackend.models.LancamentoHora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LancamentoHoraRepository extends JpaRepository<LancamentoHora, Long> {
}
