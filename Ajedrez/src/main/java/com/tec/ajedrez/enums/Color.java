package com.tec.ajedrez.enums;

public enum Color {
    BLANCO, 
    NEGRO;

    public Color getOpuesto() {
        return (this == BLANCO) ? NEGRO : BLANCO;
    }
}