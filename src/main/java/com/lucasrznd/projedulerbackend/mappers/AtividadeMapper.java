package com.lucasrznd.projedulerbackend.mappers;

import com.lucasrznd.projedulerbackend.dtos.request.AtividadeRequest;
import com.lucasrznd.projedulerbackend.dtos.response.AtividadeResponse;
import com.lucasrznd.projedulerbackend.models.Atividade;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        uses = {ProjetoMapper.class, UsuarioMapper.class})
public interface AtividadeMapper {

    AtividadeResponse toResponse(final Atividade atividade);

    @Mapping(target = "id", ignore = true)
    Atividade toModel(final AtividadeRequest atividadeRequest);

    Atividade update(final AtividadeRequest atividadeRequest, @MappingTarget Atividade atividade);

}
