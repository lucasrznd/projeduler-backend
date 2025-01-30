package com.lucasrznd.projedulerbackend.mappers;

import com.lucasrznd.projedulerbackend.dtos.request.UsuarioProjetoRequest;
import com.lucasrznd.projedulerbackend.dtos.response.UsuarioProjetoResponse;
import com.lucasrznd.projedulerbackend.models.UsuarioProjeto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        uses = {ProjetoMapper.class, UsuarioMapper.class})
public interface UsuarioProjetoMapper {

    UsuarioProjetoResponse toResponse(final UsuarioProjeto usuarioProjeto);

    @Mapping(target = "id", ignore = true)
    UsuarioProjeto toModel(final UsuarioProjetoRequest usuarioProjetoRequest);

    UsuarioProjeto update(final UsuarioProjetoRequest request, @MappingTarget UsuarioProjeto usuarioProjeto);

}
