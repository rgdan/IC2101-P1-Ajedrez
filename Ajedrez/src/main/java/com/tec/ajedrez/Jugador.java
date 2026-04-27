/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tec.ajedrez;

/**
 *
 * @author ulate
 */
public class Jugador {
    //Aqui uso un Enum para clasificar el estado del jugador y que sea mas facil hacerlo
    public enum Estado {
        EN_JUEGO,   
        GANADOR,   
        PERDEDOR    
    }

    // Atributos
    private String nombre;
    private final Color color;
    private Estado estado;
    //metodos 
       public boolean estaEnJuego() {
        return estado == Estado.EN_JUEGO;
    }

    public void marcarComoGanador() {
        this.estado = Estado.GANADOR;
    }

    public void marcarComoPerdedor() {
        this.estado = Estado.PERDEDOR;
    }

    // Constructor
    public Jugador(String nombre, Color color) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del jugador no puede ser nulo o vacío.");
        }
        if (color == null) {
            throw new IllegalArgumentException("El color del jugador no puede ser nulo.");
        }
        this.nombre = nombre.trim();
        this.color  = color;
        this.estado = Estado.EN_JUEGO;
    }

    //Set y gets 
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del jugador no puede ser nulo o vacío.");
        }
        this.nombre = nombre.trim();
    }
    public Color getColor() {
        return color;
    }

    public Estado getEstado() {
        return estado;
    }
    
    public void setEstado(Estado estado) {
        if (estado == null) {
            throw new IllegalArgumentException("El estado del jugador no puede ser nulo.");
        }
        this.estado = estado;
    }
    //Esto es para cuando usemos la interfaz y queramos imprimir se haga de mayor manera.

    @Override
    public String toString() {
        return String.format("Jugador[nombre='%s', color=%s, estado=%s]",
                nombre, color.getNombre(), estado);
    }
}