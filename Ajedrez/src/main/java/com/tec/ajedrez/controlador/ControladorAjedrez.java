/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tec.ajedrez.controlador;
import com.tec.ajedrez.Partida;
import com.tec.ajedrez.interfaz.InterfazAjedrez;
import com.tec.ajedrez.GestorArchivos;
import com.tec.ajedrez.Casilla;
import com.tec.ajedrez.piezas.Pieza;
import com.tec.ajedrez.piezas.Peon;
import com.tec.ajedrez.piezas.Rey;
import com.tec.ajedrez.piezas.Torre;
import com.tec.ajedrez.piezas.Caballo;
import com.tec.ajedrez.piezas.Alfil;
import com.tec.ajedrez.piezas.Reina;
import com.tec.ajedrez.enums.Color;
import javax.swing.JFileChooser;
import com.tec.ajedrez.Movimiento;
/**
 *
 * @author Santi
 */
public class ControladorAjedrez {
    private Partida partida;
    private InterfazAjedrez vista;
    private int filaOrigen = -1;
    private int colOrigen = -1;
    private boolean partidaTerminada = false;
    private javax.swing.JButton[][] botones;
    public ControladorAjedrez(InterfazAjedrez vista, Partida partida) {
        this.vista = vista;
        this.partida=partida;
        cargarBotones();
        inicializarEventos();
        actualizarTablero();
    }
    private void actualizarTablero(){
        for(int fila=0;fila<8;fila++){
            for(int columna=0;columna<8;columna++){
                Casilla casilla= partida.getTablero().getCasilla(fila,columna);
                if(casilla.estaOcupada()){
                    Pieza pieza=casilla.getPieza();
                    botones[fila][columna].setText("");
                    botones[fila][columna].setIcon(obtenerIcono(pieza, botones[fila][columna].getWidth(), botones[fila][columna].getHeight()));
                }else{
                    botones[fila][columna].setText("");
                    botones[fila][columna].setIcon(null);
                }
            }
        }
    }
    private javax.swing.ImageIcon obtenerIcono(Pieza pieza, int width, int height) {
        Color color = pieza.getColor();
        String colorStr = (color == Color.BLANCO) ? "white" : "black";
        String tipoStr = "";
        if (pieza instanceof Torre) {
            tipoStr = "rook";
        } else if (pieza instanceof Caballo) {
            tipoStr = "knight";
        } else if (pieza instanceof Alfil) {
            tipoStr = "bishop";
        } else if (pieza instanceof Reina) {
            tipoStr = "queen";
        } else if (pieza instanceof Rey) {
            tipoStr = "king";
        } else if (pieza instanceof Peon) {
            tipoStr = "pawn";
        }
        
        if (tipoStr.isEmpty()) return null;
        
        String filename = colorStr + "-" + tipoStr + ".png";
        String path = "/com/tec/ajedrez/sprites/" + filename;
        
        javax.swing.ImageIcon icon = null;
        java.net.URL imgURL = ControladorAjedrez.class.getResource(path);
        if (imgURL != null) {
            icon = new javax.swing.ImageIcon(imgURL);
        } else {
            // Fallback to filesystem
            java.io.File file = new java.io.File("src/main/java/com/tec/ajedrez/sprites/" + filename);
            if (!file.exists()) {
                file = new java.io.File("Ajedrez/src/main/java/com/tec/ajedrez/sprites/" + filename);
            }
            if (file.exists()) {
                icon = new javax.swing.ImageIcon(file.getAbsolutePath());
            }
        }

        if (icon != null) {
            int targetW = width > 20 ? (int)(width * 0.8) : 60;
            int targetH = height > 20 ? (int)(height * 0.8) : 60;
            java.awt.Image img = icon.getImage();
            java.awt.Image newImg = img.getScaledInstance(targetW, targetH, java.awt.Image.SCALE_SMOOTH);
            return new javax.swing.ImageIcon(newImg);
        } else {
            System.err.println("No se pudo encontrar el sprite: " + filename);
            return null;
        }
    }
    private void cargarBotones() {
        botones = new javax.swing.JButton[][] {
            {vista.getCasilla00(), vista.getCasilla01(), vista.getCasilla02(), vista.getCasilla03(), vista.getCasilla04(), vista.getCasilla05(), vista.getCasilla06(), vista.getCasilla07()},
            {vista.getCasilla10(), vista.getCasilla11(), vista.getCasilla12(), vista.getCasilla13(), vista.getCasilla14(), vista.getCasilla15(), vista.getCasilla16(), vista.getCasilla17()},
            {vista.getCasilla20(), vista.getCasilla21(), vista.getCasilla22(), vista.getCasilla23(), vista.getCasilla24(), vista.getCasilla25(), vista.getCasilla26(), vista.getCasilla27()},
            {vista.getCasilla30(), vista.getCasilla31(), vista.getCasilla32(), vista.getCasilla33(), vista.getCasilla34(), vista.getCasilla35(), vista.getCasilla36(), vista.getCasilla37()},
            {vista.getCasilla40(), vista.getCasilla41(), vista.getCasilla42(), vista.getCasilla43(), vista.getCasilla44(), vista.getCasilla45(), vista.getCasilla46(), vista.getCasilla47()},
            {vista.getCasilla50(), vista.getCasilla51(), vista.getCasilla52(), vista.getCasilla53(), vista.getCasilla54(), vista.getCasilla55(), vista.getCasilla56(), vista.getCasilla57()},
            {vista.getCasilla60(), vista.getCasilla61(), vista.getCasilla62(), vista.getCasilla63(), vista.getCasilla64(), vista.getCasilla65(), vista.getCasilla66(), vista.getCasilla67()},
            {vista.getCasilla70(), vista.getCasilla71(), vista.getCasilla72(), vista.getCasilla73(), vista.getCasilla74(), vista.getCasilla75(), vista.getCasilla76(), vista.getCasilla77()}
        };
    }

    private void inicializarEventos() {
      vista.getCasilla00().addActionListener(e -> manejarClick(0, 0));
        vista.getCasilla01().addActionListener(e -> manejarClick(0, 1));
        vista.getCasilla02().addActionListener(e -> manejarClick(0, 2));
        vista.getCasilla03().addActionListener(e -> manejarClick(0, 3));
        vista.getCasilla04().addActionListener(e -> manejarClick(0, 4));
        vista.getCasilla05().addActionListener(e -> manejarClick(0, 5));
        vista.getCasilla06().addActionListener(e -> manejarClick(0, 6));
        vista.getCasilla07().addActionListener(e -> manejarClick(0, 7));

        vista.getCasilla10().addActionListener(e -> manejarClick(1, 0));
        vista.getCasilla11().addActionListener(e -> manejarClick(1, 1));
        vista.getCasilla12().addActionListener(e -> manejarClick(1, 2));
        vista.getCasilla13().addActionListener(e -> manejarClick(1, 3));
        vista.getCasilla14().addActionListener(e -> manejarClick(1, 4));
        vista.getCasilla15().addActionListener(e -> manejarClick(1, 5));
        vista.getCasilla16().addActionListener(e -> manejarClick(1, 6));
        vista.getCasilla17().addActionListener(e -> manejarClick(1, 7));

        vista.getCasilla20().addActionListener(e -> manejarClick(2, 0));
        vista.getCasilla21().addActionListener(e -> manejarClick(2, 1));
        vista.getCasilla22().addActionListener(e -> manejarClick(2, 2));
        vista.getCasilla23().addActionListener(e -> manejarClick(2, 3));
        vista.getCasilla24().addActionListener(e -> manejarClick(2, 4));
        vista.getCasilla25().addActionListener(e -> manejarClick(2, 5));
        vista.getCasilla26().addActionListener(e -> manejarClick(2, 6));
        vista.getCasilla27().addActionListener(e -> manejarClick(2, 7));

        vista.getCasilla30().addActionListener(e -> manejarClick(3, 0));
        vista.getCasilla31().addActionListener(e -> manejarClick(3, 1));
        vista.getCasilla32().addActionListener(e -> manejarClick(3, 2));
        vista.getCasilla33().addActionListener(e -> manejarClick(3, 3));
        vista.getCasilla34().addActionListener(e -> manejarClick(3, 4));
        vista.getCasilla35().addActionListener(e -> manejarClick(3, 5));
        vista.getCasilla36().addActionListener(e -> manejarClick(3, 6));
        vista.getCasilla37().addActionListener(e -> manejarClick(3, 7));

        vista.getCasilla40().addActionListener(e -> manejarClick(4, 0));
        vista.getCasilla41().addActionListener(e -> manejarClick(4, 1));
        vista.getCasilla42().addActionListener(e -> manejarClick(4, 2));
        vista.getCasilla43().addActionListener(e -> manejarClick(4, 3));
        vista.getCasilla44().addActionListener(e -> manejarClick(4, 4));
        vista.getCasilla45().addActionListener(e -> manejarClick(4, 5));
        vista.getCasilla46().addActionListener(e -> manejarClick(4, 6));
        vista.getCasilla47().addActionListener(e -> manejarClick(4, 7));

        vista.getCasilla50().addActionListener(e -> manejarClick(5, 0));
        vista.getCasilla51().addActionListener(e -> manejarClick(5, 1));
        vista.getCasilla52().addActionListener(e -> manejarClick(5, 2));
        vista.getCasilla53().addActionListener(e -> manejarClick(5, 3));
        vista.getCasilla54().addActionListener(e -> manejarClick(5, 4));
        vista.getCasilla55().addActionListener(e -> manejarClick(5, 5));
        vista.getCasilla56().addActionListener(e -> manejarClick(5, 6));
        vista.getCasilla57().addActionListener(e -> manejarClick(5, 7));

        vista.getCasilla60().addActionListener(e -> manejarClick(6, 0));
        vista.getCasilla61().addActionListener(e -> manejarClick(6, 1));
        vista.getCasilla62().addActionListener(e -> manejarClick(6, 2));
        vista.getCasilla63().addActionListener(e -> manejarClick(6, 3));
        vista.getCasilla64().addActionListener(e -> manejarClick(6, 4));
        vista.getCasilla65().addActionListener(e -> manejarClick(6, 5));
        vista.getCasilla66().addActionListener(e -> manejarClick(6, 6));
        vista.getCasilla67().addActionListener(e -> manejarClick(6, 7));

        vista.getCasilla70().addActionListener(e -> manejarClick(7, 0));
        vista.getCasilla71().addActionListener(e -> manejarClick(7, 1));
        vista.getCasilla72().addActionListener(e -> manejarClick(7, 2));
        vista.getCasilla73().addActionListener(e -> manejarClick(7, 3));
        vista.getCasilla74().addActionListener(e -> manejarClick(7, 4));
        vista.getCasilla75().addActionListener(e -> manejarClick(7, 5));
        vista.getCasilla76().addActionListener(e -> manejarClick(7, 6));
        vista.getCasilla77().addActionListener(e -> manejarClick(7, 7));
        
        vista.getBtnGuardar().addActionListener(e -> {
            JFileChooser selector = new JFileChooser();
            int resultado = selector.showSaveDialog(vista);
            if (resultado == JFileChooser.APPROVE_OPTION) {
                String ruta =selector.getSelectedFile().getAbsolutePath();
                if (!ruta.endsWith(".dat")) {
                    ruta += ".dat";
                }
                GestorArchivos.guardarPartida(partida, ruta);
                javax.swing.JOptionPane.showMessageDialog(vista,"Partida guardada correctamente.");
            }
        });

        vista.getBtnCargar().addActionListener(e -> {
            JFileChooser selector = new JFileChooser();
            int resultado = selector.showOpenDialog(vista);
            if (resultado == JFileChooser.APPROVE_OPTION) {
                String ruta =selector.getSelectedFile().getAbsolutePath();
                Partida partidaCargada =GestorArchivos.cargarPartida(ruta);
                if (partidaCargada != null) {
                    partida = partidaCargada;
                    actualizarTablero();
                    actualizarHistorial();
                    vista.getLabelTurno().setText("Turno: " + partida.getTurnoActual().getColor());
                    vista.getLabelTurno().setText("Turno: "+ partida.getTurnoActual().getColor());
                    javax.swing.JOptionPane.showMessageDialog(vista,"Partida cargada correctamente.");
                } else {
                    javax.swing.JOptionPane.showMessageDialog(vista,"No se pudo cargar la partida.");
                }
            }
        });

    }
    private void manejarClick(int fila, int columna) {
            if (partidaTerminada) {
                javax.swing.JOptionPane.showMessageDialog(vista,"La partida ya terminó.");
                return;
            }

        if (filaOrigen == -1) {
            filaOrigen = fila;
            colOrigen = columna;
            System.out.println("Origen: " + filaOrigen + "," + colOrigen);
        } else {
            boolean movimientoValido = partida.realizarMovimiento(filaOrigen,colOrigen, fila,columna);
            if (movimientoValido) {
                vista.getAreaMovimientos().append(filaOrigen + "," + colOrigen+ " -> "+ fila + "," + columna + "\n" );
                revisarPromocion(fila, columna);
                actualizarTablero();
                revisarJaque();
                vista.getLabelTurno().setText("Turno: " +partida.getTurnoActual().getColor());
                System.out.println("Movimiento realizado");
            } else {
                javax.swing.JOptionPane.showMessageDialog(vista,"Movimiento inválido");
            }
            filaOrigen = -1;
            colOrigen = -1;
        }
    }
    private void revisarPromocion(int fila, int columna) {
        Casilla casillaDestino =partida.getTablero().getCasilla(fila, columna);
        if (!casillaDestino.estaOcupada()) {
            return;
        }
        Pieza piezaMovida = casillaDestino.getPieza();
        if (piezaMovida instanceof Peon) {
            if (fila == 0 || fila == 7) {
                String[] opciones = {"reina", "torre", "alfil", "caballo"};
                String piezaElegida = (String) javax.swing.JOptionPane.showInputDialog(vista,"Elige la pieza para promocionar:","Promoción de peón",javax.swing.JOptionPane.QUESTION_MESSAGE,null,opciones,"reina");
                if (piezaElegida != null) {
                    partida.promocionPeon(piezaMovida, piezaElegida);
                    javax.swing.JOptionPane.showMessageDialog( vista,"Peón promocionado a " + piezaElegida);
                }
            }
        }
    }
    private void revisarJaque() {
        for (int fila = 0; fila < 8; fila++) {
            for (int columna = 0; columna < 8; columna++) {
                Casilla casilla =partida.getTablero().getCasilla(fila, columna);
                if (!casilla.estaOcupada()) {
                    continue;
                }
                Pieza pieza = casilla.getPieza();
                if (pieza instanceof Rey) {
                    Rey rey = (Rey) pieza;
                    if (partida.esJaqueMate(rey)) {
                        partidaTerminada = true;
                        javax.swing.JOptionPane.showMessageDialog(vista,"JAQUE MATE. Ganador: " + partida.getTurnoActual().getNombre());
                        return;
                    }
                    if (partida.esJaque(rey)) {
                        javax.swing.JOptionPane.showMessageDialog(vista,"JAQUE");
                        return;
                    }
                }
            }
        }
    }
    private void actualizarHistorial() {

        vista.getAreaMovimientos().setText("");

        for (Movimiento mov : partida.getHistorial()) {

            int filaOrigen = mov.getOrigen().getFila();
            int colOrigen = mov.getOrigen().getColumna();

            int filaDestino = mov.getDestino().getFila();
            int colDestino = mov.getDestino().getColumna();

            vista.getAreaMovimientos().append( filaOrigen + "," + colOrigen+ " -> "+ filaDestino + "," + colDestino + "\n");
        }
    }
}
