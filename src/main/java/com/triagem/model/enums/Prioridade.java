package com.triagem.model.enums;

public enum Prioridade implements Comparable<Prioridade> {
    VERMELHA(1),
    AMARELA(2),
    VERDE(3);

    private final int valor;

    Prioridade(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
} 