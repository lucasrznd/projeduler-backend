package com.lucasrznd.projedulerbackend.mappers;

import com.lucasrznd.projedulerbackend.dtos.request.UsuarioProjetoRequest;
import com.lucasrznd.projedulerbackend.dtos.response.UsuarioProjetoResponse;
import com.lucasrznd.projedulerbackend.models.UsuarioProjeto;
import org.mapstruct.*;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        uses = {ProjetoMapper.class, AtividadeMapper.class})
public interface UsuarioProjetoMapper {

    UsuarioProjetoResponse toResponse(final UsuarioProjeto usuarioProjeto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "usuario.id", source = "usuarioId")
    @Mapping(target = "projeto.id", source = "projetoId")
    UsuarioProjeto toModel(final UsuarioProjetoRequest usuarioProjetoRequest);

    @Mapping(target = "usuario", source = "usuarioId", qualifiedByName = "mapUsuarioResponsavel")
    @Mapping(target = "projeto", source = "projetoId", qualifiedByName = "mapProjeto")
    UsuarioProjeto update(final UsuarioProjetoRequest request, @MappingTarget UsuarioProjeto usuarioProjeto);

}
