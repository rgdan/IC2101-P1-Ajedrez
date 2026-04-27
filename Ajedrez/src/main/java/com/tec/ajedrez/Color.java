/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tec.ajedrez;

/**
 *
 * @author ulate
 */
public enum Color {
// Aqui tenemos las opciones del Enum(con una sola letra para no tener que digitar para la palabra completa)
    BLANCO("Blanco", "B"),
    NEGRO("Negro", "N");

    // Atributos(el nombre y el simbolo)
    private final String nombre; //este es para cuando necesitemos hacer un mensaje
    private final String simbolo; // este es para cuando usemos la logica, usamos el simbolo
    //metodos
    //Este metodo esta hecho especificamente para cuando un jugador termine su turno pasarle el turno al rival, por ello opuesto
    //aqui utilizo el operador ternario ?: que es como un if / else, si es adirmativo devuelve lo del ? y si no lo que esta despues de los dos puntos
    public Color getOpuesto() {
        return (this == BLANCO) ? NEGRO : BLANCO;
    }

    // Constructor
    Color(String nombre, String simbolo) {
        this.nombre = nombre;
        this.simbolo = simbolo;
    }
    //gets
    public String getNombre() {
        return nombre;
    }

    public String getSimbolo() {
        return simbolo;
    }
    //Esto es para cuando usemos la interfaz y queramos imprimir se haga de mayor manera.
    @Override
    public String toString() {
        return nombre;
    }
}
