/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tec.ajedrez.interfaz;
import javax.swing.SwingUtilities;
/**
 *
 * @author Santi
 */
public class MainInterfaz {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            InterfazAjedrez ventana = new InterfazAjedrez();
            ventana.setVisible(true);
        });

    }
}
