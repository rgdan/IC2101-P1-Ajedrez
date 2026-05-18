/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.tec.ajedrez;
import com.tec.ajedrez.controlador.ControladorAjedrez;
import com.tec.ajedrez.interfaz.InterfazAjedrez;
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
        InterfazAjedrez vista = new InterfazAjedrez();
        ControladorAjedrez controlador = new ControladorAjedrez(vista, partida);
        vista.setVisible(true);
    }
}