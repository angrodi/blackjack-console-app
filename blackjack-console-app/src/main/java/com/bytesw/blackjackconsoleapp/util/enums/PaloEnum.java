package com.bytesw.blackjackconsoleapp.util.enums;

public enum PaloEnum {

    ESPADA("♠"),
    DIAMANTE("♦"),
    TREBOL("♣"),
    CORAZON("♥");

    private final String valor;

    PaloEnum(String valor) {
        this.valor = valor;
    }

    public String getValue() {
        return valor;
    }
}
