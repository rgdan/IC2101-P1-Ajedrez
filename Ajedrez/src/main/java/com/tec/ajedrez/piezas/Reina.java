package com.tec.ajedrez.piezas;

import com.tec.ajedrez.Casilla;
import com.tec.ajedrez.enums.Color;

public class Reina extends Pieza {
    
    /* CONSTRUCTOR */
    public Reina(Color color, Casilla posicionActual, boolean estaActiva) {
        super(color, posicionActual, estaActiva);
    }
    
    public boolean movimientosRectos(Casilla destino) {
        
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

        return true;
    }
    
    public boolean movimientosDiagonales(Casilla destino) {
        
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

        return true;
    }
    
    @Override
    public boolean validarMovimiento(Casilla destino) {
        
        // si no es diagonal o horizontal
        if (!movimientosDiagonales(destino) && !movimientosRectos(destino)){
            return false;
        }
        
        // asegurar que no pegamos con un friendly
        if (destino.estaOcupada() && destino.getPieza().getColor() == this.getColor()) {
            return false;
        }
        
        return true;
    }
}