package com.lucasrznd.projedulerbackend.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@With
@Entity
@Table(name = "tb_notificacao")
public class Notificacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Usuario usuario;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String mensagem;

    @Column(nullable = false)
    private String tipo;

    @Column(nullable = false)
    private LocalDateTime dataCriacao;

    private boolean lida;

    @ManyToOne
    @JoinColumn(name = "projeto_id")
    @JsonIgnoreProperties("notificacoes")
    private Projeto projeto;

    @ManyToOne
    @JoinColumn(name = "atividade_id")
    @JsonIgnoreProperties("notificacoes")
    private Atividade atividade;

}
