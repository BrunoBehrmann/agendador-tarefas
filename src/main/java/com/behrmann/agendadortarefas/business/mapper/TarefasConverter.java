package com.behrmann.agendadortarefas.business.mapper;

import com.behrmann.agendadortarefas.business.dto.TarefasDTO;
import com.behrmann.agendadortarefas.infrastructure.entity.TarefasEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TarefasConverter {

    TarefasEntity paraTarefaEntity(TarefasDTO tarefasDTO);

    TarefasDTO paraTarefasDTO(TarefasEntity tarefasEntity);

}
