package com.lucasrznd.projedulerbackend.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AtividadeUsuario {

    private String email;
    private Long ultimaAtividade;

}