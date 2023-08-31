package com.example.tecnico.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Medico {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String nome;

    @Column
    private String especialidade;

    @ManyToOne
    private UnidadeSaude unidadeSaude;

    @OneToMany
    private List<Agendamento> agendamentos;
}
