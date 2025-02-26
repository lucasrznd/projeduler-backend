package com.lucasrznd.projedulerbackend.repositories;

import com.lucasrznd.projedulerbackend.models.UsuarioAtividade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioAtividadeRepository extends JpaRepository<UsuarioAtividade, Long> {

    Optional<UsuarioAtividade> findByUsuarioIdAndAtividadeId(Long usuarioId, Long atividadeId);

}
