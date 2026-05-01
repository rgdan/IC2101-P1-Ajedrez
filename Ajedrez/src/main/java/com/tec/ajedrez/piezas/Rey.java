package com.tec.ajedrez.piezas;

import com.tec.ajedrez.Casilla;
import com.tec.ajedrez.enums.Color;

public class Rey extends Pieza {

    /* CONSTRUCTOR */
    public Rey(Color color, Casilla posicionActual, boolean estaActiva) {
        super(color, posicionActual, estaActiva);
    }

    @Override
    public boolean validarMovimiento(Casilla destino) {

        Casilla actual = getPosicionActual();

        int diffFila   = Math.abs(actual.getFila()    - destino.getFila());
        int diffColumna = Math.abs(actual.getColumna() - destino.getColumna());

        // El rey se mueve exactamente 1 casilla en cualquier dirección (incluso diagonal)
        if (diffFila > 1 || diffColumna > 1 || (diffFila == 0 && diffColumna == 0)) {
            return false;
        }

        // No puede capturar una pieza del mismo color
        if (destino.estaOcupada() && destino.getPieza().getColor() == this.getColor()) {
            return false;
        }

        return true;
    }
}
