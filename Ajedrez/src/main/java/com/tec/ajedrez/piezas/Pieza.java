
package com.tec.ajedrez.piezas;

import com.tec.ajedrez.Casilla;
import com.tec.ajedrez.enums.Color;

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
    
    /* GETTER AND SETTERS */
    
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Casilla getPosicionActual() {
        return posicionActual;
    }

    public void setPosicionActual(Casilla posicionActual) {
        this.posicionActual = posicionActual;
    }

    public boolean isEstaActiva() {
        return estaActiva;
    }

    public void setEstaActiva(boolean estaActiva) {
        this.estaActiva = estaActiva;
    }
    
    
    
}
