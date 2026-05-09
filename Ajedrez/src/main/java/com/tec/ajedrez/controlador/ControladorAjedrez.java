/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tec.ajedrez.controlador;
import com.tec.ajedrez.Partida;
import com.tec.ajedrez.interfaz.InterfazAjedrez;
/**
 *
 * @author Santi
 */
public class ControladorAjedrez {
    private Partida partida;
    private InterfazAjedrez vista;
    public ControladorAjedrez(InterfazAjedrez vista, Partida partida) {
        this.vista = vista;
        this.partida=partida;
        inicializarEventos();
    }
    private void inicializarEventos() {
        vista.getCasilla00().addActionListener(e -> System.out.println("0,0"));
        vista.getCasilla01().addActionListener(e -> System.out.println("0,1"));
        vista.getCasilla02().addActionListener(e -> System.out.println("0,2"));
        vista.getCasilla03().addActionListener(e -> System.out.println("0,3"));
        vista.getCasilla04().addActionListener(e -> System.out.println("0,4"));
        vista.getCasilla05().addActionListener(e -> System.out.println("0,5"));
        vista.getCasilla06().addActionListener(e -> System.out.println("0,6"));
        vista.getCasilla07().addActionListener(e -> System.out.println("0,7"));

        vista.getCasilla10().addActionListener(e -> System.out.println("1,0"));
        vista.getCasilla11().addActionListener(e -> System.out.println("1,1"));
        vista.getCasilla12().addActionListener(e -> System.out.println("1,2"));
        vista.getCasilla13().addActionListener(e -> System.out.println("1,3"));
        vista.getCasilla14().addActionListener(e -> System.out.println("1,4"));
        vista.getCasilla15().addActionListener(e -> System.out.println("1,5"));
        vista.getCasilla16().addActionListener(e -> System.out.println("1,6"));
        vista.getCasilla17().addActionListener(e -> System.out.println("1,7"));

        vista.getCasilla20().addActionListener(e -> System.out.println("2,0"));
        vista.getCasilla21().addActionListener(e -> System.out.println("2,1"));
        vista.getCasilla22().addActionListener(e -> System.out.println("2,2"));
        vista.getCasilla23().addActionListener(e -> System.out.println("2,3"));
        vista.getCasilla24().addActionListener(e -> System.out.println("2,4"));
        vista.getCasilla25().addActionListener(e -> System.out.println("2,5"));
        vista.getCasilla26().addActionListener(e -> System.out.println("2,6"));
        vista.getCasilla27().addActionListener(e -> System.out.println("2,7"));

        vista.getCasilla30().addActionListener(e -> System.out.println("3,0"));
        vista.getCasilla31().addActionListener(e -> System.out.println("3,1"));
        vista.getCasilla32().addActionListener(e -> System.out.println("3,2"));
        vista.getCasilla33().addActionListener(e -> System.out.println("3,3"));
        vista.getCasilla34().addActionListener(e -> System.out.println("3,4"));
        vista.getCasilla35().addActionListener(e -> System.out.println("3,5"));
        vista.getCasilla36().addActionListener(e -> System.out.println("3,6"));
        vista.getCasilla37().addActionListener(e -> System.out.println("3,7"));

        vista.getCasilla40().addActionListener(e -> System.out.println("4,0"));
        vista.getCasilla41().addActionListener(e -> System.out.println("4,1"));
        vista.getCasilla42().addActionListener(e -> System.out.println("4,2"));
        vista.getCasilla43().addActionListener(e -> System.out.println("4,3"));
        vista.getCasilla44().addActionListener(e -> System.out.println("4,4"));
        vista.getCasilla45().addActionListener(e -> System.out.println("4,5"));
        vista.getCasilla46().addActionListener(e -> System.out.println("4,6"));
        vista.getCasilla47().addActionListener(e -> System.out.println("4,7"));

        vista.getCasilla50().addActionListener(e -> System.out.println("5,0"));
        vista.getCasilla51().addActionListener(e -> System.out.println("5,1"));
        vista.getCasilla52().addActionListener(e -> System.out.println("5,2"));
        vista.getCasilla53().addActionListener(e -> System.out.println("5,3"));
        vista.getCasilla54().addActionListener(e -> System.out.println("5,4"));
        vista.getCasilla55().addActionListener(e -> System.out.println("5,5"));
        vista.getCasilla56().addActionListener(e -> System.out.println("5,6"));
        vista.getCasilla57().addActionListener(e -> System.out.println("5,7"));

        vista.getCasilla60().addActionListener(e -> System.out.println("6,0"));
        vista.getCasilla61().addActionListener(e -> System.out.println("6,1"));
        vista.getCasilla62().addActionListener(e -> System.out.println("6,2"));
        vista.getCasilla63().addActionListener(e -> System.out.println("6,3"));
        vista.getCasilla64().addActionListener(e -> System.out.println("6,4"));
        vista.getCasilla65().addActionListener(e -> System.out.println("6,5"));
        vista.getCasilla66().addActionListener(e -> System.out.println("6,6"));
        vista.getCasilla67().addActionListener(e -> System.out.println("6,7"));

        vista.getCasilla70().addActionListener(e -> System.out.println("7,0"));
        vista.getCasilla71().addActionListener(e -> System.out.println("7,1"));
        vista.getCasilla72().addActionListener(e -> System.out.println("7,2"));
        vista.getCasilla73().addActionListener(e -> System.out.println("7,3"));
        vista.getCasilla74().addActionListener(e -> System.out.println("7,4"));
        vista.getCasilla75().addActionListener(e -> System.out.println("7,5"));
        vista.getCasilla76().addActionListener(e -> System.out.println("7,6"));
        vista.getCasilla77().addActionListener(e -> System.out.println("7,7"));

    }
}
