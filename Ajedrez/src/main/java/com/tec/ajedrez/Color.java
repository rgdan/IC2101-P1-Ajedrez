package com.tec.ajedrez;

public enum Color {
    BLANCO, 
    NEGRO;

    public Color getOpuesto() {
        return (this == BLANCO) ? NEGRO : BLANCO;
    }
}