package com.tec.ajedrez.piezas;

import com.tec.ajedrez.Casilla;
import com.tec.ajedrez.enums.Color;

public class Caballo extends Pieza {
    
    /* CONSTRUCTOR */
    public Caballo(Color color, Casilla posicionActual, boolean estaActiva) {
        super(color, posicionActual, estaActiva);
    }
    
    @Override
    public boolean validarMovimiento(Casilla destino) {
        
        // get current pos
        Casilla casillaActual = getPosicionActual();

        int diferenciaFilas = Math.abs(casillaActual.getFila() - destino.getFila());
        int diferenciaColumnas = Math.abs(casillaActual.getColumna() - destino.getColumna());

        // if we moved 2 rows and 1 columna orrrrr 1 row and 2 columnas we moved in the l shape
        boolean esMovimientoEnL = (diferenciaFilas == 2 && diferenciaColumnas == 1) || (diferenciaFilas == 1 && diferenciaColumnas == 2);

        if (esMovimientoEnL == false) {
            return false;
        }

        // asegurar que no pegamos con un friendly
        if (destino.estaOcupada() && destino.getPieza().getColor() == this.getColor()) {
            return false;
        }

        return true;
    }
}