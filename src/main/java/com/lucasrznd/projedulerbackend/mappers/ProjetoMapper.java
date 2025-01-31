package com.lucasrznd.projedulerbackend.mappers;

import com.lucasrznd.projedulerbackend.dtos.request.ProjetoRequest;
import com.lucasrznd.projedulerbackend.dtos.response.ProjetoResponse;
import com.lucasrznd.projedulerbackend.models.Projeto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        uses = {UsuarioMapper.class})
public interface ProjetoMapper {

    ProjetoResponse toResponse(final Projeto projeto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "dataCriacao", ignore = true)
    @Mapping(target = "usuarioResponsavel.id", source = "usuarioResponsavelId")
    Projeto toModel(final ProjetoRequest projetoRequest);

    Projeto update(final ProjetoRequest projetoRequest, @MappingTarget Projeto projeto);

}
