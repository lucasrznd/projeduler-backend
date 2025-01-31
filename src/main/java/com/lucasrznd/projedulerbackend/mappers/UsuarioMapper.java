package com.lucasrznd.projedulerbackend.mappers;

import com.lucasrznd.projedulerbackend.dtos.request.UsuarioRequest;
import com.lucasrznd.projedulerbackend.dtos.response.UsuarioResponse;
import com.lucasrznd.projedulerbackend.models.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface UsuarioMapper {

    UsuarioResponse toResponse(final Usuario usuario);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "dataCriacao", ignore = true)
    Usuario toModel(final UsuarioRequest usuarioRequest);

    Usuario update(UsuarioRequest usuarioRequest, @MappingTarget Usuario usuario);

}
