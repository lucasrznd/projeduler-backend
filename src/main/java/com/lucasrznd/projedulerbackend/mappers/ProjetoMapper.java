package com.lucasrznd.projedulerbackend.mappers;

import com.lucasrznd.projedulerbackend.dtos.request.ProjetoRequest;
import com.lucasrznd.projedulerbackend.dtos.response.ProjetoResponse;
import com.lucasrznd.projedulerbackend.models.Projeto;
import com.lucasrznd.projedulerbackend.models.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
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

    @Mapping(target = "usuarioResponsavel", source = "usuarioResponsavelId", qualifiedByName = "mapUsuarioResponsavel")
    Projeto update(final ProjetoRequest projetoRequest, @MappingTarget Projeto projeto);

    @Named("mapUsuarioResponsavel")
    default Usuario mapUsuarioResponsavel(Long usuarioResponsavelId) {
        if (usuarioResponsavelId == null) {
            return null;
        }
        Usuario usuario = new Usuario();
        usuario.setId(usuarioResponsavelId);
        return usuario;
    }

}
