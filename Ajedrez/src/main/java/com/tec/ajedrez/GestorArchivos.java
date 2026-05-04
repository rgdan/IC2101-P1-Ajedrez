/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tec.ajedrez;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/**
 *
 * @author Santi
 */
public class GestorArchivos {
    public static void guardarPartida(Partida partida, String ruta) {
        try {
            ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(ruta));
            salida.writeObject(partida);
            salida.close();
            System.out.println("Partida guardada correctamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar la partida.");
            e.printStackTrace();
        }
    }

    public static Partida cargarPartida(String ruta) {
        try {
            ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(ruta));
            Partida partida = (Partida) entrada.readObject();
            entrada.close();
            System.out.println("Partida cargada correctamente.");
            return partida;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar la partida.");
            e.printStackTrace();
            return null;
        }
    }
}
