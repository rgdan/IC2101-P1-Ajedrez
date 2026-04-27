package com.tec.ajedrez;

public class Casilla {

    private int fila;
    private int columna;
    private Pieza pieza;

    /* CONSTRUCTOR */
    
    public Casilla(int fila, int columna) {
        if (fila < 0 || fila > 7) {
            throw new IllegalArgumentException("La fila debe estar entre 0 y 7.");
        }
        if (columna < 0 || columna > 7) {
            throw new IllegalArgumentException("La columna debe estar entre 0 y 7.");
        }
        this.fila = fila;
        this.columna = columna;
        this.pieza = null;
}
    
    /* METODOS */

    // Verificar si la casilla esta ocupada
    public boolean estaOcupada() {
        return pieza != null;
    }

    // Ver si la casilla esta ocupada por cierto color
    public boolean tieneColor(Color color) {
        return estaOcupada() && pieza.getColor() == color;
    }

    // Colocar pieza si la casilla no esta ocupada
    public boolean colocarPieza(Pieza pieza) {
        if (!estaOcupada()) {
            this.pieza = pieza;
            return true;
        } else {
            return false;
        }
    }

    // Quitar pieza si la casilla esta ocupada
    public Pieza quitarPieza() {
        if (pieza == null) {
            return null;
        }
        Pieza piezaRemovida = this.pieza;
        this.pieza = null;
        return piezaRemovida;
    }
    
    /* SETTERS Y GETTERS */

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public Pieza getPieza() {
        return pieza;
    }

    public void setPieza(Pieza pieza) {
        this.pieza = pieza;
    }
}