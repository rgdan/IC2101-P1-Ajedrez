package com.tec.ajedrez;

import com.tec.ajedrez.controlador.ControladorAjedrez;
import com.tec.ajedrez.interfaz.InterfazAjedrez;
import com.tec.ajedrez.enums.Color;
import javax.swing.UIManager;

public class Ajedrez {

    public static void main(String[] args) {

        // fix for macOS so colors show up properly
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        Jugador j1 = new Jugador("Blanco", Color.BLANCO);
        Jugador j2 = new Jugador("Negro", Color.NEGRO);

        Partida partida = new Partida(j1, j2);

        InterfazAjedrez vista = new InterfazAjedrez();
        ControladorAjedrez controlador = new ControladorAjedrez(vista, partida);

        vista.setVisible(true);
    }
}
