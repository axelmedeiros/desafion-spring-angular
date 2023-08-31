package com.example.tecnico.controller;


import com.example.tecnico.dto.MedicoDTO;
import com.example.tecnico.entity.Medico;
import com.example.tecnico.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/medico")
@RestController
public class MedicoController {
    @Autowired
    private MedicoService service;
    @PostMapping
    public Medico create(@RequestBody @Valid MedicoDTO dto) {
        return this.service.create(dto);
    }

    @GetMapping
    public List<Medico> list() {
        return this.service.list();
    }
}
