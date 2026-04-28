package com.tec.ajedrez.piezas;

import com.tec.ajedrez.Casilla;
import com.tec.ajedrez.enums.Color;

public class Alfil extends Pieza {
    
    /* CONSTRUCTOR */
    public Alfil(Color color, Casilla posicionActual, boolean estaActiva) {
        super(color, posicionActual, estaActiva);
    }
    
    @Override
    public boolean validarMovimiento(Casilla destino) {
        
        // conseguir pos actual
        Casilla actual = getPosicionActual();

        // calcular la diferencia del actual con el destino
        // si el movimiento es valido se sigue que |filaActual - filaDestino| = |columnaActual - columnaDestino|
        int diffFila = Math.abs(actual.getFila() - destino.getFila());
        int diffColumna = Math.abs(actual.getColumna() - destino.getColumna());

        // si la primera es 0 se seleciono el mismo espacio y si no se cumple segunda condicion no es un movimiento diagonal
        if (diffFila == 0 || diffFila != diffColumna) {
            return false;
        }

        // verificar que no caiga en una pieza del mismo color en el destino
        if (destino.estaOcupada() && destino.getPieza().getColor() == this.getColor()) {
            return false;
        }

        return true;
    }
}