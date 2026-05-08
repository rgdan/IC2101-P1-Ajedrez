/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tec.ajedrez.controlador;
import com.tec.ajedrez.Jugador;
import com.tec.ajedrez.Partida;
import com.tec.ajedrez.enums.Color;
import com.tec.ajedrez.interfaz.InterfazAjedrez;
/**
 *
 * @author Santi
 */
public class ControladorAjedrez {
    private Partida partida;
    private InterfazAjedrez vista;
    public ControladorAjedrez(InterfazAjedrez vista) {
        this.vista = vista;
    }
}
