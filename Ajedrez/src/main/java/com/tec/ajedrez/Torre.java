package com.tec.ajedrez;

public class Torre extends Pieza {
    
    /* CONSTRUCTOR */
    public Torre(Color color, Casilla posicionActual, boolean estaActiva) {
        super(color, posicionActual, estaActiva);
    }
    
    @Override
    public boolean validarMovimiento(Casilla destino) {
        
        //conseguir pos actual
        Casilla actual = getPosicionActual();

        // revisar si es la misma pos
        if (actual.getFila() == destino.getFila() && actual.getColumna() == destino.getColumna()) {
            return false;
        }

        // revisar si es en la misma fila o columna
        boolean mismaFila = actual.getFila() == destino.getFila();
        boolean mismaColumna = actual.getColumna() == destino.getColumna();

        if (!mismaFila && !mismaColumna) {
            return false;
        }

        // verificar que la pos final no esté ocupada por una pieza del mismo color
        if (destino.estaOcupada() && destino.getPieza().getColor() == this.getColor()) {
            return false;
        }

        return true;
    }
}