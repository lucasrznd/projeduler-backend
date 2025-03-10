package com.lucasrznd.projedulerbackend.models;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity {

    private boolean ativo = true;

    @Column(name = "data_exclusao")
    private LocalDateTime dataExclusao;
}
