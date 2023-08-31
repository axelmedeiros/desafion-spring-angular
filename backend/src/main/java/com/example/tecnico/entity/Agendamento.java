package com.example.tecnico.entity;


import com.example.tecnico.util.Status;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Agendamento {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String horario;

    @Column
    private String status;

    @ManyToOne
    private Medico medico;
}
