package com.tec.ajedrez;

import com.tec.ajedrez.enums.*;
import com.tec.ajedrez.piezas.*;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

public class Partida implements Serializable {
    private Tablero tablero;
    private Jugador jugadorBlanco;
    private Jugador jugadorNegro;
    private Jugador turnoActual;
    private List<Movimiento> historial;
    private EstadoPartida estado;

    /* CONSTRUCTOR */
    public Partida(Jugador jugadorBlanco, Jugador jugadorNegro) {
        this.jugadorBlanco = jugadorBlanco;
        this.jugadorNegro  = jugadorNegro;
        this.tablero       = new Tablero();
        this.historial     = new ArrayList<>();
        this.turnoActual   = jugadorBlanco; // blancas empiezan
        tablero.inicializarTablero();
    }

    /**
     * Intenta realizar un movimiento.
     * @return true si el movimiento fue válido y se ejecutó, false si no.
     */
    public boolean realizarMovimiento(int filaOrigen, int colOrigen, int filaDestino, int colDestino) {
        Casilla origen  = tablero.getCasilla(filaOrigen, colOrigen);
        Casilla destino = tablero.getCasilla(filaDestino, colDestino);
        // 1. debe haber una pieza en el origen
        if (!origen.estaOcupada()) {
            return false;
        }
        Pieza pieza = origen.getPieza();
        // 2. el jugador solo puede mover sus propias piezas
        if (pieza.getColor() != turnoActual.getColor()) {
            return false;
        }
        // 3. la pieza debe considerar valido el movimiento
        if (!pieza.validarMovimiento(destino)) {
            return false;
        }
        // 4. si no es caballo, el camino debe estar libre
        if (!(pieza instanceof Caballo) && !tablero.caminoLibre(origen, destino)) {
            return false;
        }
        // guardar datos para poder deshacer si el rey queda en jaque
        Pieza piezaCapturada = destino.getPieza();
        Casilla posicionOriginal = pieza.getPosicionActual();
        // 5. probar movimiento temporalmente
        origen.quitarPieza();
        destino.setPieza(pieza);
        pieza.setPosicionActual(destino);
        // 6. revisar si mi propio rey queda en jaque
        Rey miRey = buscarRey(pieza.getColor());
        if (miRey != null && esJaque(miRey)) {
            // deshacer movimiento
            origen.setPieza(pieza);
            destino.setPieza(piezaCapturada);
            pieza.setPosicionActual(posicionOriginal);

            return false;
        }
        // 7. si no quedó en jaque, el movimiento se acepta
        historial.add(new Movimiento(origen, destino, pieza));
        // 8. cambiar turno
        turnoActual = (turnoActual == jugadorBlanco) ? jugadorNegro : jugadorBlanco;
        return true;
    }

    /**
     * Revisa si el jugador está en jaque
     * @return true si el jugador está en jaque, false si no
     */
    public boolean esJaque(Rey rey) {
        // sacar pos del rey
        Casilla casillaDelRey = rey.getPosicionActual();
        Color colorDelRey = rey.getColor();

        // revisar tablero entero para ver si alguna pieza puede atacar al rey
        for (int fila = 0; fila < 8; fila++) {
            for (int columna = 0; columna < 8; columna++) {

                Casilla casillaAtacante = tablero.getCasilla(fila, columna);

                // Si la casilla no está ocupada, continuar
                if (!casillaAtacante.estaOcupada()) {
                    continue;
                }

                Pieza piezaEnemiga = casillaAtacante.getPieza();

                // Solo nos interesan las piezas del oponente
                if (piezaEnemiga.getColor() == colorDelRey) {
                    continue;
                }

                // Validar si el patrón de movimiento de la pieza llega al rey
                if (!piezaEnemiga.validarMovimiento(casillaDelRey)) {
                    continue;
                }

                // Si es caballo, no se revisa el camino
                if (piezaEnemiga instanceof Caballo) {
                    return true;
                }

                // Si no es caballo, verificar si el camino está libre
                if (!tablero.caminoLibre(casillaAtacante, casillaDelRey)) {
                    continue;
                }

                return true;
            }
        }

        return false;
    }
    private Rey buscarRey(Color color) {
        for (int fila = 0; fila < 8; fila++) {
            for (int columna = 0; columna < 8; columna++) {
                Casilla casilla = tablero.getCasilla(fila, columna);
                if (casilla.estaOcupada()) {
                    Pieza pieza = casilla.getPieza();
                    if (pieza instanceof Rey && pieza.getColor() == color) {
                        return (Rey) pieza;
                    }
                }
            }
        }

    return null;
}
    
    /**
     * Revisa si el jugador está en jaque mate
     * @return true si el jugador está en jaque mate, false si no
     */
    public boolean esJaqueMate(Rey reyEnPeligro) {
        
        // si no esta en jaque, pues tampoco en jaque mate
        if (esJaque(reyEnPeligro) == false) {
            return false;
        }

        // color del rey acutal
        Color colorDelRey = reyEnPeligro.getColor();

        // verificar todo el tablero
        for (int filaOrigen = 0; filaOrigen < 8; filaOrigen++) {
            for (int columnaOrigen = 0; columnaOrigen < 8; columnaOrigen++) {

                // get casilla
                Casilla casillaOrigen = tablero.getCasilla(filaOrigen, columnaOrigen);

                // si esta vacia, skip
                if (casillaOrigen.estaOcupada() == false){
                    continue;
                }

                Pieza miPieza = casillaOrigen.getPieza();
                
                // si no es una de mis piezas, skip
                if (miPieza.getColor() != colorDelRey){
                    continue;
                }

                // revisar cada casilla con pieza anterior
                for (int filaDestino = 0; filaDestino < 8; filaDestino++) {
                    for (int columnaDestino = 0; columnaDestino < 8; columnaDestino++) {

                        Casilla casillaDestino = tablero.getCasilla(filaDestino, columnaDestino);

                        // revisar si movimiento es valido
                        if (miPieza.validarMovimiento(casillaDestino) == false){
                            continue;
                        }

                        // revisar si hay camino libre
                        boolean hayCaminoLibre = (miPieza instanceof Caballo) || tablero.caminoLibre(casillaOrigen, casillaDestino);
                        
                        if (hayCaminoLibre == false){
                            continue;
                        }

                        // PROBAR MOVIMIENTO
                        Pieza piezaOriginalEnDestino = casillaDestino.getPieza();
                        Casilla posicionOriginalDeMiPieza = miPieza.getPosicionActual();

                        // mover pieza
                        casillaDestino.setPieza(miPieza);
                        casillaOrigen.quitarPieza();
                        miPieza.setPosicionActual(casillaDestino);

                        // revisar si moviendo sigue en jaque
                        boolean sigueEnJaque = esJaque(reyEnPeligro);

                        // deshacer movimiento de prueba
                        casillaOrigen.setPieza(miPieza);
                        casillaDestino.setPieza(piezaOriginalEnDestino);
                        miPieza.setPosicionActual(posicionOriginalDeMiPieza);

                        // si se encuentra algun movimiento que salve al rey todavla no es jaque mate
                        if (sigueEnJaque == false) {
                            return false;
                        }
                    }
                }
            }
        }

        // si ya probamos todo, pues si es jaque mate
        return true;
    }

    // Método para promocionar un peón
    public void promocionPeon(Pieza peon, String tipoPieza) {

        // verificar que sea peon
        if (!(peon instanceof Peon)) {
            throw new IllegalArgumentException("Error: Solo un Peón puede ser promocionado.");
        }

        Casilla posicionActual = peon.getPosicionActual();
        int fila = posicionActual.getFila();

        //validar que esté en fila correcta para ser promocionado
        if (fila != 0 && fila != 7) {
            throw new IllegalStateException("Error: El peón debe estar en la fila 0 o 7 para promocionar. Fila actual: " + fila);
        }

        Color colorPeon = peon.getColor();
        Pieza nuevaPieza;

        // encontrar a que pieza se quiere cambiar
        switch (tipoPieza.toLowerCase()) {
            case "reina":
                nuevaPieza = new Reina(colorPeon, posicionActual, true);
                break;
            case "torre":
                nuevaPieza = new Torre(colorPeon, posicionActual, true);
                break;
            case "alfil":
                nuevaPieza = new Alfil(colorPeon, posicionActual, true);
                break;
            case "caballo":
                nuevaPieza = new Caballo(colorPeon, posicionActual, true);
                break;
            default:
                // si la opcion es rara
                throw new IllegalArgumentException("Error: '" + tipoPieza + "' no es una pieza válida para promoción.");
        }

        // cambiar la pieza
        posicionActual.setPieza(nuevaPieza);
        peon.setEstaActiva(false);
    }
    /* GETTERS */
    public Jugador getTurnoActual()      { return turnoActual; }
    public List<Movimiento> getHistorial() { return historial;  }
    public Tablero getTablero()          { return tablero;     }

    /* SETTERS */
    public void setEstado(EstadoPartida estado) { this.estado = estado; }
}
