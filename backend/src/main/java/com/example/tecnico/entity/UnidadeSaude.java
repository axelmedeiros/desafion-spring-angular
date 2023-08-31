package com.example.tecnico.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class UnidadeSaude {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String nome;

    @OneToMany
    private List<Medico> medicos;
}
