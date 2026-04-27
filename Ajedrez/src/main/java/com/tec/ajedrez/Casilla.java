/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.tec.ajedrez;

/**
 *
 * @author ulate
 */
public class Casilla {
    //Primero voy a inicializar las constantes del tamaño y las letras que usamos en el tablero
    private static final int TAMANIO_TABLERO = 8;
    private static final char[] LETRAS_COLUMNA = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
    // Atributos
    private final int fila;
    private final int columna;
    private Pieza pieza;
    //metodos 
    //metodo para ver si la casilla esta vacia
    public boolean estaVacia() {
        return pieza == null;
    }
    //metodo para ver si la casilla esta ocupada
    public boolean estaOcupada() {
        return pieza != null;
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
        validarCoordenada(fila,    "fila");
        validarCoordenada(columna, "columna");
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
    //validaciones
    //valido a ver si esta en el rango deseado 0-7 y no en algun otro
    private void validarCoordenada(int valor, String nombre) {
        if (valor < 0 || valor >= TAMANIO_TABLERO) {
            throw new IllegalArgumentException(
                    String.format("El valor de '%s' debe estar entre 0 y %d, pero se recibió: %d",
                            nombre, TAMANIO_TABLERO - 1, valor));
        }
    }
    //Esto es para cuando usemos la interfaz y queramos imprimir se haga de mayor manera.

    @Override
    public String toString() {
        String contenido = estaVacia() ? "vacía" : pieza.toString();
        return String.format("Casilla[%s | %s]", getNotacionAlgebraica(), contenido);
    }
}
