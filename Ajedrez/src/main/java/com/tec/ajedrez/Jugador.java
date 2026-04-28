
package com.tec.ajedrez;

public class Jugador {

    // Atributos
    private String nombre;
    private Color color;
    private Estado estado;
    
    /* CONSTRUCTOR */
    
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
    
   /* METODOS */
    
    public boolean estaEnJuego() {
        return estado == Estado.EN_JUEGO;
    }

    public void marcarComoGanador() {
        this.estado = Estado.GANADOR;
    }

    public void marcarComoPerdedor() {
        this.estado = Estado.PERDEDOR;
    }

    /* SETTERS Y GETTERS */
    
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
}