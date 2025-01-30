package com.lucasrznd.projedulerbackend.repositories;

import com.lucasrznd.projedulerbackend.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
