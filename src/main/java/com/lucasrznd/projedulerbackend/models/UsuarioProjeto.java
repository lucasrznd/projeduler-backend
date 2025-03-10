package com.lucasrznd.projedulerbackend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@SQLDelete(sql = "UPDATE tb_usuario_projeto SET ativo = false, data_exclusao = CURRENT_TIMESTAMP WHERE id = ?")
@Where(clause = "ativo = true")
@Table(name = "tb_usuario_projeto")
public class UsuarioProjeto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Projeto projeto;

    @Column(nullable = false)
    private LocalDate dataEntrada;

}
