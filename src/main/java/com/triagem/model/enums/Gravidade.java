package com.triagem.model.enums;

public enum Gravidade implements Comparable<Gravidade> {
    LEVE(1),
    MODERADA(2),
    GRAVE(3);

    private final int valor;

    Gravidade(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
} 