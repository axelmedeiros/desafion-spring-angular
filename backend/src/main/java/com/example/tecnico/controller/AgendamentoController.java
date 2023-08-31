package com.example.tecnico.controller;

import com.example.tecnico.dto.AgendamentoDTO;
import com.example.tecnico.dto.MedicoDTO;
import com.example.tecnico.entity.Agendamento;
import com.example.tecnico.entity.Medico;
import com.example.tecnico.service.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/agendamento")
@RestController
public class AgendamentoController {

    @Autowired
    private AgendamentoService service;

    @GetMapping
    public List<Agendamento> listar() {
        return service.list();
    }

    @PostMapping
    public Agendamento create(@RequestBody @Valid AgendamentoDTO dto) {
        return this.service.create(dto);
    }
}
