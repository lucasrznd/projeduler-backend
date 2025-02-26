package com.lucasrznd.projedulerbackend.mappers;

import com.lucasrznd.projedulerbackend.dtos.request.UsuarioAtividadeRequest;
import com.lucasrznd.projedulerbackend.dtos.response.UsuarioAtividadeResponse;
import com.lucasrznd.projedulerbackend.models.UsuarioAtividade;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        uses = {ProjetoMapper.class, LancamentoHoraMapper.class})
public interface UsuarioAtividadeMapper {

    UsuarioAtividadeResponse toResponse(final UsuarioAtividade usuarioAtividade);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "usuario.id", source = "usuarioId")
    @Mapping(target = "atividade.id", source = "atividadeId")
    UsuarioAtividade toModel(final UsuarioAtividadeRequest request);

    @Mapping(target = "usuario", source = "usuarioId", qualifiedByName = "mapUsuarioResponsavel")
    @Mapping(target = "atividade", source = "atividadeId", qualifiedByName = "mapAtividade")
    UsuarioAtividade update(final UsuarioAtividadeRequest request, @MappingTarget final UsuarioAtividade usuarioAtividade);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "usuario.id", source = "usuarioId")
    @Mapping(target = "atividade.id", source = "atividadeId")
    List<UsuarioAtividade> toModelList(final List<UsuarioAtividadeRequest> request);

}
