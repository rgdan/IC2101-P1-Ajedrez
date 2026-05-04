package com.tec.ajedrez;

import com.tec.ajedrez.enums.Color;
import com.tec.ajedrez.piezas.*;
import java.io.Serializable;

public class Tablero implements Serializable {

    /* La matriz 8x8: tablero[fila][columna], fila 0 = lado blanco */
    private Casilla[][] casillas;

    /* CONSTRUCTOR */
    public Tablero() {
        casillas = new Casilla[8][8];
        // Crear todas las casillas vacías
        for (int fila = 0; fila < 8; fila++) {
            for (int col = 0; col < 8; col++) {
                casillas[fila][col] = new Casilla(fila, col);
            }
        }
    }

    /* Coloca todas las piezas en su posición inicial */
    public void inicializarTablero() {

        // ---- Peones ----
        for (int col = 0; col < 8; col++) {
            Peon peonBlanco = new Peon(Color.BLANCO, casillas[1][col], true);
            casillas[1][col].setPieza(peonBlanco);

            Peon peonNegro = new Peon(Color.NEGRO, casillas[6][col], true);
            casillas[6][col].setPieza(peonNegro);
        }

        // ---- Piezas blancas (fila 0) ----
        casillas[0][0].setPieza(new Torre  (Color.BLANCO, casillas[0][0], true));
        casillas[0][1].setPieza(new Caballo(Color.BLANCO, casillas[0][1], true));
        casillas[0][2].setPieza(new Alfil  (Color.BLANCO, casillas[0][2], true));
        casillas[0][3].setPieza(new Reina  (Color.BLANCO, casillas[0][3], true));
        casillas[0][4].setPieza(new Rey    (Color.BLANCO, casillas[0][4], true));
        casillas[0][5].setPieza(new Alfil  (Color.BLANCO, casillas[0][5], true));
        casillas[0][6].setPieza(new Caballo(Color.BLANCO, casillas[0][6], true));
        casillas[0][7].setPieza(new Torre  (Color.BLANCO, casillas[0][7], true));

        // ---- Piezas negras (fila 7) ----
        casillas[7][0].setPieza(new Torre  (Color.NEGRO, casillas[7][0], true));
        casillas[7][1].setPieza(new Caballo(Color.NEGRO, casillas[7][1], true));
        casillas[7][2].setPieza(new Alfil  (Color.NEGRO, casillas[7][2], true));
        casillas[7][3].setPieza(new Reina  (Color.NEGRO, casillas[7][3], true));
        casillas[7][4].setPieza(new Rey    (Color.NEGRO, casillas[7][4], true));
        casillas[7][5].setPieza(new Alfil  (Color.NEGRO, casillas[7][5], true));
        casillas[7][6].setPieza(new Caballo(Color.NEGRO, casillas[7][6], true));
        casillas[7][7].setPieza(new Torre  (Color.NEGRO, casillas[7][7], true));
    }

    /**
     * Revisa si hay alguna pieza interpuesta en el camino recto u diagonal
     * entre 'origen' y 'destino' (excluyendo ambos extremos).
     * Solo debe llamarse para piezas que NO son Caballo.
     *
     * @return true si el camino está libre, false si hay algo en medio.
     */
    public boolean caminoLibre(Casilla origen, Casilla destino) {

        int filaO = origen.getFila();
        int colO  = origen.getColumna();
        int filaD = destino.getFila();
        int colD  = destino.getColumna();

        // Calcular dirección de avance (-1, 0 o 1) para fila y columna
        int stepFila = Integer.signum(filaD - filaO);
        int stepCol  = Integer.signum(colD  - colO);

        int fila = filaO + stepFila;
        int col  = colO  + stepCol;

        // Recorrer casillas intermedias (sin incluir el destino)
        while (fila != filaD || col != colD) {
            if (casillas[fila][col].estaOcupada()) {
                return false; // hay algo en medio
            }
            fila += stepFila;
            col  += stepCol;
        }

        return true;
    }

    /* GETTER */
    public Casilla getCasilla(int fila, int columna) {
        return casillas[fila][columna];
    }
}
