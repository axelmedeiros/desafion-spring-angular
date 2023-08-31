package com.example.tecnico.mapper;

import com.example.tecnico.dto.AgendamentoDTO;
import com.example.tecnico.dto.MedicoDTO;
import com.example.tecnico.entity.Agendamento;
import com.example.tecnico.entity.Medico;
import com.example.tecnico.entity.UnidadeSaude;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class Mapper {
    public Medico dtoToMedico(MedicoDTO dto, UnidadeSaude unidadeSaude) {
        if (dto == null) {
            return null;
        } else {
            Medico medico = new Medico();
            BeanUtils.copyProperties(dto, medico);
            medico.setUnidadeSaude(unidadeSaude);
            return medico;
        }
    }

    public Agendamento dtoToAgendamento(AgendamentoDTO dto, Medico medico) {
        if (dto == null) {
            return null;
        } else {
            Agendamento agendamento = new Agendamento();
            BeanUtils.copyProperties(dto, agendamento);
            agendamento.setMedico(medico);
            agendamento.setStatus(dto.getStatus().getDescricao());
            return agendamento;
        }
    }
}
