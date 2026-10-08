package com.behrmann.agendadortarefas.business;

import com.behrmann.agendadortarefas.business.dto.TarefasDTO;
import com.behrmann.agendadortarefas.business.mapper.TarefasConverter;
import com.behrmann.agendadortarefas.infrastructure.entity.TarefasEntity;
import com.behrmann.agendadortarefas.infrastructure.enums.StatusNotificacaoEnum;
import com.behrmann.agendadortarefas.infrastructure.repository.TarefasRepository;
import com.behrmann.agendadortarefas.infrastructure.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TarefasService {

    private final TarefasRepository tarefasRepository;
    private final TarefasConverter tarefaConverter;
    private final JwtUtil jwtUtil;

    public TarefasDTO gravarTarefa(String token, TarefasDTO tarefasDTO){
        String email = jwtUtil.extrairEmailToken(token.substring(7));

        tarefasDTO.setDataCriacao(LocalDateTime.now());
        tarefasDTO.setStatusNotificacaoEnum(StatusNotificacaoEnum.PENDENTE);
        tarefasDTO.setEmailUsuario(email);
        TarefasEntity tarefasEntity = tarefaConverter.paraTarefaEntity(tarefasDTO);

        return tarefaConverter.paraTarefasDTO(tarefasRepository.save(tarefasEntity));
    }
}
