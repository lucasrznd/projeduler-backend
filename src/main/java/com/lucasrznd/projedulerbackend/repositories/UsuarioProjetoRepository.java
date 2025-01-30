package com.lucasrznd.projedulerbackend.repositories;

import com.lucasrznd.projedulerbackend.models.UsuarioProjeto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioProjetoRepository extends JpaRepository<UsuarioProjeto, Long> {
}
