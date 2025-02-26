package com.lucasrznd.projedulerbackend.repositories;

import com.lucasrznd.projedulerbackend.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(String email);

    @Query("SELECT u FROM Usuario u JOIN UsuarioProjeto up ON u.id = up.usuario.id WHERE up.projeto.id = :projetoId")
    List<Usuario> findByProjetoId(Long projetoId);

    @Query("SELECT u FROM Usuario u JOIN UsuarioAtividade ua ON u.id = ua.usuario.id WHERE ua.atividade.id = :atividadeId")
    List<Usuario> findAllByAtividadeId(Long atividadeId);

}
