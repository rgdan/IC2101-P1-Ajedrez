/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.tec.ajedrez;
import com.tec.ajedrez.enums.Color;
/**
 *
 * @author Usuario
 */
public class Ajedrez {

    public static void main(String[] args) {
    Jugador j1 = new Jugador("Juan", Color.BLANCO);
    Jugador j2 = new Jugador("Pedro", Color.NEGRO);

    Partida partida = new Partida(j1, j2);

    // 🔹 Hacer un movimiento antes de guardar
    boolean mov1 = partida.realizarMovimiento(1, 0, 2, 0);
    System.out.println("Movimiento antes de guardar: " + mov1);

    // 🔹 Guardar
    GestorArchivos.guardarPartida(partida, "partida.dat");

    // 🔹 Cargar
    Partida cargada = GestorArchivos.cargarPartida("partida.dat");

    if (cargada != null) {

        // 🔥 Intentar seguir jugando DESPUÉS de cargar
        boolean mov2 = cargada.realizarMovimiento(6, 0, 5, 0);
        System.out.println("Movimiento después de cargar: " + mov2);
    }
}
}
