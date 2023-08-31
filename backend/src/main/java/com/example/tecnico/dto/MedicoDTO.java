package com.example.tecnico.dto;

import lombok.Data;

@Data
public class MedicoDTO {
    private Long id;

    private String nome;

    private String especialidade;

    private Long unidadeSaude;
}
