package com.lucasrznd.projedulerbackend.mappers;

import com.lucasrznd.projedulerbackend.dtos.request.NotificacaoRequest;
import com.lucasrznd.projedulerbackend.dtos.response.NotificacaoResponse;
import com.lucasrznd.projedulerbackend.models.Notificacao;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        uses = {AtividadeMapper.class})
public interface NotificacaoMapper {

    NotificacaoResponse toResponse(final Notificacao notificacao);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "usuario.id", source = "usuarioId")
    @Mapping(target = "projeto.id", source = "projetoId")
    @Mapping(target = "atividade.id", source = "projetoId")
    Notificacao toModel(final NotificacaoRequest request);

}
