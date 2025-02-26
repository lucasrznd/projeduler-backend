package com.lucasrznd.projedulerbackend.repositories;

import com.lucasrznd.projedulerbackend.models.Atividade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AtividadeRepository extends JpaRepository<Atividade, Long> {

    @Query("SELECT a FROM Atividade a ORDER BY a.dataCriacao DESC")
    List<Atividade> findAllAtividades();

    @Query("SELECT a FROM Atividade a INNER JOIN UsuarioAtividade ua ON a.id =  ua.atividade.id WHERE ua.usuario.id = :usuarioId ORDER BY ua.dataEntrada")
    List<Atividade> findByUsuarioResponsavelId(Long usuarioId);

}
