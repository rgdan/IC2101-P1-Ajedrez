package com.tec.ajedrez;

import com.tec.ajedrez.piezas.Pieza;

public class Movimiento {

    private Casilla origen;
    private Casilla destino;
    private Pieza pieza;

    /* CONSTRUCTOR */
    public Movimiento(Casilla origen, Casilla destino, Pieza pieza) {
        this.origen  = origen;
        this.destino = destino;
        this.pieza   = pieza;
    }

    /* GETTERS */
    public Casilla getOrigen()  { return origen;  }
    public Casilla getDestino() { return destino; }
    public Pieza   getPieza()   { return pieza;   }

}
