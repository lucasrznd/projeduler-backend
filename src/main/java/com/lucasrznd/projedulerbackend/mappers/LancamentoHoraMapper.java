package com.lucasrznd.projedulerbackend.mappers;

import com.lucasrznd.projedulerbackend.dtos.request.LancamentoHoraRequest;
import com.lucasrznd.projedulerbackend.dtos.response.LancamentoHoraResponse;
import com.lucasrznd.projedulerbackend.models.Atividade;
import com.lucasrznd.projedulerbackend.models.LancamentoHora;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        uses = {AtividadeMapper.class, ProjetoMapper.class, UsuarioMapper.class})
public interface LancamentoHoraMapper {

    LancamentoHoraResponse toResponse(final LancamentoHora lancamentoHora);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "atividade.id", source = "atividadeId")
    @Mapping(target = "usuario.id", source = "usuarioId")
    LancamentoHora toModel(final LancamentoHoraRequest lancamentoHoraRequest);

    @Mapping(target = "atividade", source = "atividadeId", qualifiedByName = "mapAtividade")
    @Mapping(target = "usuario", source = "usuarioId", qualifiedByName = "mapUsuarioResponsavel")
    LancamentoHora update(final LancamentoHoraRequest request, @MappingTarget LancamentoHora lancamentoHora);

    @Named("mapAtividade")
    default Atividade mapAtividade(Long atividadeId) {
        if (atividadeId == null) {
            return null;
        }
        Atividade atividade = new Atividade();
        atividade.setId(atividadeId);
        return atividade;
    }

}
