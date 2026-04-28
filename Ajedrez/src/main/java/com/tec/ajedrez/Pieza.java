
package com.tec.ajedrez;

public abstract class Pieza {
    
    /* ATRIBUTOS */
    
    private Color color;
    private Casilla posicionActual;
    private boolean estaActiva;
    
    /* CONSTRUCTOR */

    public Pieza(Color color, Casilla posicionActual, boolean estaActiva) {
        this.color = color;
        this.posicionActual = posicionActual;
        this.estaActiva = estaActiva;
    }
    
    /* METODOS */
    
    public abstract boolean validarMovimiento(Casilla destino);
    
}
