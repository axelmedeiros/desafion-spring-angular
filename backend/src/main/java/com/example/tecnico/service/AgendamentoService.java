package com.example.tecnico.service;

import com.example.tecnico.dto.AgendamentoDTO;
import com.example.tecnico.entity.Agendamento;
import com.example.tecnico.entity.Medico;
import com.example.tecnico.mapper.Mapper;
import com.example.tecnico.repository.AgendamentoRepository;
import com.example.tecnico.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository repository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private Mapper mapper;

    public List<Agendamento> list() {
        return this.repository.findAll();
    }
    public Agendamento create(AgendamentoDTO dto) {
        Medico medico = medicoRepository.findById(dto.getMedicoId());
        if (medico == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Médico não encontrado");
        } else {
            this.validateHorario(dto);
            return this.repository.save(this.mapper.dtoToAgendamento(dto, medico));
        }
    }

    public void validateHorario(AgendamentoDTO dto) {
        HashMap<String, Agendamento> horarios = new HashMap<String, Agendamento>();
        for (var horario: this.repository.findByMedicId(dto.getMedicoId())) {
            horarios.put(horario.getHorario(), horario);
        }

        var checkConflito = horarios.getOrDefault(dto.getHorario(), null);
        if (checkConflito != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Horário já cadastrado");
        }
    }
}
