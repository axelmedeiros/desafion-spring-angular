package com.example.tecnico.dto;

import com.example.tecnico.util.Status;
import lombok.Data;

@Data
public class AgendamentoDTO {

    private Long id;

    private String horario;


    private Status status;

    private Long medicoId;
}
