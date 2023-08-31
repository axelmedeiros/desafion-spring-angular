package com.example.tecnico.service;

import com.example.tecnico.dto.MedicoDTO;
import com.example.tecnico.entity.Medico;
import com.example.tecnico.entity.UnidadeSaude;
import com.example.tecnico.mapper.Mapper;
import com.example.tecnico.repository.MedicoRepository;
import com.example.tecnico.repository.UnidadeSaudeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class MedicoService {
    @Autowired
    private MedicoRepository repository;

    @Autowired
    private UnidadeSaudeRepository saudeRepository;

    @Autowired
    private Mapper mapper;

    @Transactional
    public Medico create(MedicoDTO dto) {
        UnidadeSaude saude = saudeRepository.findById(dto.getUnidadeSaude());
        if (saude == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Unidade de saúde não pode ser nula");
        } else {
            return this.repository.save(this.mapper.dtoToMedico(dto, saude));
        }
    }

    @Transactional
    public List<Medico> list() {
        return this.repository.findAll();
    }
}
