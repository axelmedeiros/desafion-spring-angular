package com.example.tecnico.mapper;

import com.example.tecnico.dto.MedicoDTO;
import com.example.tecnico.entity.Medico;
import com.example.tecnico.entity.UnidadeSaude;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
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
}
