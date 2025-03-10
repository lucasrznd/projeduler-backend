package com.lucasrznd.projedulerbackend.repositories;

import com.lucasrznd.projedulerbackend.models.UsuarioProjeto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface UsuarioProjetoRepository extends JpaRepository<UsuarioProjeto, Long> {

    Optional<UsuarioProjeto> findByUsuarioIdAndProjetoId(Long usuarioId, Long projetoId);

    @Modifying
    @Query("UPDATE UsuarioProjeto up SET up.ativo = false, up.dataExclusao = :dataExclusao WHERE up.id = :id")
    void softDeleteById(Long id, LocalDateTime dataExclusao);

    @Modifying
    @Query("UPDATE UsuarioProjeto up SET up.ativo = false, up.dataExclusao = :dataExclusao WHERE up.usuario.id = :usuarioId")
    void softDeleteAllByUsuarioId(Long usuarioId, LocalDateTime dataExclusao);

    @Modifying
    @Query("UPDATE UsuarioProjeto up SET up.ativo = false, up.dataExclusao = :dataExclusao WHERE up.projeto.id =:projetoId")
    void softDeleteAllByProjetoId(Long projetoId, LocalDateTime dataExclusao);

}
