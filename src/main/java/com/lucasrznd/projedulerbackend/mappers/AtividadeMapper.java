package com.lucasrznd.projedulerbackend.mappers;

import com.lucasrznd.projedulerbackend.dtos.request.AtividadeRequest;
import com.lucasrznd.projedulerbackend.dtos.response.AtividadeResponse;
import com.lucasrznd.projedulerbackend.models.Atividade;
import com.lucasrznd.projedulerbackend.models.Projeto;
import org.mapstruct.*;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        uses = {ProjetoMapper.class, UsuarioMapper.class})
public interface AtividadeMapper {

    AtividadeResponse toResponse(final Atividade atividade);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "projeto.id", source = "projetoId")
    Atividade toModel(final AtividadeRequest atividadeRequest);

    @Mapping(target = "projeto", source = "projetoId", qualifiedByName = "mapProjeto")
    Atividade update(final AtividadeRequest atividadeRequest, @MappingTarget Atividade atividade);

    @Named("mapProjeto")
    default Projeto mapProjeto(Long projetoId) {
        if (projetoId == null) {
            return null;
        }
        Projeto projeto = new Projeto();
        projeto.setId(projetoId);
        return projeto;
    }

}
