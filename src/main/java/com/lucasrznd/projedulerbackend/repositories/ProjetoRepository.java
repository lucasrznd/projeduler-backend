package com.lucasrznd.projedulerbackend.repositories;

import com.lucasrznd.projedulerbackend.models.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjetoRepository extends JpaRepository<Projeto, Long> {

    @Query("SELECT p FROM Projeto p JOIN UsuarioProjeto up ON up.projeto.id = p.id WHERE up.usuario.id = :usuarioId")
    List<Projeto> findByUsuarioId(@Param("usuarioId") Long usuarioId);

}
