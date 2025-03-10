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
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@SQLDelete(sql = "UPDATE tb_projeto SET ativo = false, data_exclusao = CURRENT_TIMESTAMP WHERE id = ?")
@Where(clause = "ativo = true")
@Table(name = "tb_projeto")
public class Projeto extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    private LocalDate dataInicio;

    private LocalDate dataFim;

    private String status;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Usuario usuarioResponsavel;

    @Column(nullable = false)
    private LocalDateTime dataCriacao;

    private String prioridade;

}
