package com.example.tecnico.util;


public enum Status {
    AGENDADO("AGENDADO"),
    CONCLUIDO("CONCLUIDO"),
    CANCELADO("CANCELADO"),
    OUTRO("OUTRO");
    private String descricao;

    Status(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return this.descricao;
    }
}
