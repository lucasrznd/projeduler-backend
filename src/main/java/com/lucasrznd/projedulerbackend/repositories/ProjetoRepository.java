package com.lucasrznd.projedulerbackend.repositories;

import com.lucasrznd.projedulerbackend.models.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjetoRepository extends JpaRepository<Projeto, Long> {

    @Query("SELECT p FROM Projeto p ORDER BY p.dataCriacao DESC")
    List<Projeto> findAllProjetos();

    @Query("SELECT COUNT(*) FROM Projeto p INNER JOIN UsuarioProjeto up ON p.id = up.projeto.id WHERE p.status != 'CANCELADO' AND p.usuarioResponsavel.id = :usuarioId")
    Long countProjetosByUsuarioResponsavelId(Long usuarioId);

    @Query("SELECT p FROM Projeto p JOIN UsuarioProjeto up ON up.projeto.id = p.id WHERE up.usuario.id = :usuarioId ORDER BY up.dataEntrada DESC")
    List<Projeto> findByUsuarioId(@Param("usuarioId") Long usuarioId);

    @Query("SELECT COUNT(*) FROM Projeto p WHERE p.status = :status ORDER BY p.dataCriacao")
    Long countAllByStatus(String status);

    @Query("SELECT COUNT(*) FROM Projeto p JOIN UsuarioProjeto up ON up.projeto.id = p.id WHERE p.status = :status AND up.usuario.id = :usuarioId")
    Long countAllByStatusAndUsuarioId(String status, Long usuarioId);

}
