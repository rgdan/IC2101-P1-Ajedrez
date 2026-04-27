
package com.tec.ajedrez;

public class Casilla {

    private int fila;
    private int columna;
    private Pieza pieza;
    
    //Metodos
    
    // is the cell empty?
    public boolean estaVacia() {
        return pieza == null;
    }

    //Indica si la casilla contiene una pieza del color indicado
    public boolean tieneColor(Color color) {
        return estaOcupada() && pieza.getColor() == color;
    }
    
    //Elimina la pieza de la casilla y la retorna
    public Pieza quitarPieza() {
        Pieza piezaRemovida = this.pieza;
        this.pieza = null;
        return piezaRemovida;
    }

    // Constructor
    public Casilla(int fila, int columna) {
        this.fila    = fila;
        this.columna = columna;
        this.pieza   = null; 
    }

    
    //sets y gets
    public int getFila() {
        return fila;
    }
    public int getColumna() {
        return columna;
    }
    public Pieza getPieza() {
        return pieza;
    }
    public void setPieza(Pieza pieza) {
        this.pieza = pieza;
    }
    
       public String getNotacionAlgebraica() {
        return "" + LETRAS_COLUMNA[columna] + (fila + 1);
    }

    //Esto es para cuando usemos la interfaz y queramos imprimir se haga de mayor manera.

    public String toString() {
        String contenido = estaVacia() ? "vacía" : pieza.toString();
        return String.format("Casilla[%s | %s]", getNotacionAlgebraica(), contenido);
    }
}
