package com.tec.ajedrez.piezas;

import com.tec.ajedrez.Casilla;
import com.tec.ajedrez.enums.Color;

public class Peon extends Pieza {

    private boolean esPrimerMovimiento;

    /* CONSTRUCTOR */
    public Peon(Color color, Casilla posicionActual, boolean estaActiva) {
        super(color, posicionActual, estaActiva);
        this.esPrimerMovimiento = true;
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
            esPrimerMovimiento = false;
            return true;
        }

        // Avance doble inicial: 2 casillas al frente, columna igual, destino vacío
        if (esPrimerMovimiento && diffFila == 2 * direccion && diffCol == 0 && !destino.estaOcupada()) {
            esPrimerMovimiento = false;
            return true;
        }

        // Captura diagonal: 1 casilla al frente en diagonal, destino ocupado por enemigo
        if (diffFila == direccion && diffCol == 1 && destino.estaOcupada()
                && destino.getPieza().getColor() != this.getColor()) {
            esPrimerMovimiento = false;
            return true;
        }

        return false;
    }

    public boolean isEsPrimerMovimiento() {
        return esPrimerMovimiento;
    }
}
