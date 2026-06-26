package com.tec.ajedrez.piezas;

import com.tec.ajedrez.Casilla;
import com.tec.ajedrez.enums.Color;

public class Peon extends Pieza {

    /* CONSTRUCTOR */
    public Peon(Color color, Casilla posicionActual, boolean estaActiva) {
        super(color, posicionActual, estaActiva);
    }

    @Override
    public boolean validarMovimiento(Casilla destino) {

        Casilla actual = getPosicionActual();
        int filaActual = actual.getFila();
        int colActual  = actual.getColumna();
        int filaDestino = destino.getFila();
        int colDestino  = destino.getColumna();

        // Blanco avanza hacia filas mayores (0→7), Negro hacia filas menores (7→0)
        int direccion = (getColor() == Color.BLANCO) ? 1 : -1;

        int diffFila = filaDestino - filaActual;
        int diffCol  = Math.abs(colDestino - colActual);

        // Avance simple: 1 casilla al frente, columna igual, destino vacío
        if (diffFila == direccion && diffCol == 0 && !destino.estaOcupada()) {
            return true;
        }

        // Avance doble inicial: 2 casillas al frente, columna igual, destino vacío
        boolean esFilaInicial = (getColor() == Color.BLANCO && filaActual == 1) || (getColor() == Color.NEGRO && filaActual == 6);
        if (esFilaInicial && diffFila == 2 * direccion && diffCol == 0 && !destino.estaOcupada()) {
            return true;
        }

        // Captura diagonal: 1 casilla al frente en diagonal, destino ocupado por enemigo
        if (diffFila == direccion && diffCol == 1 && destino.estaOcupada()
                && destino.getPieza().getColor() != this.getColor()) {
            return true;
        }

        return false;
    }

    public boolean isEsPrimerMovimiento() {
        Casilla actual = getPosicionActual();
        if (actual == null) return false;
        int filaActual = actual.getFila();
        return (getColor() == Color.BLANCO && filaActual == 1) || (getColor() == Color.NEGRO && filaActual == 6);
    }
}
