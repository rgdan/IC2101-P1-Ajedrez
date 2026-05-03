package com.tec.ajedrez;

import com.tec.ajedrez.enums.Color;
import com.tec.ajedrez.enums.EstadoPartida;
import com.tec.ajedrez.piezas.Caballo;
import com.tec.ajedrez.piezas.Pieza;
import java.util.ArrayList;
import java.util.List;

public class Partida {

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

        // 1. Debe haber una pieza en el origen
        if (!origen.estaOcupada()) {
            return false;
        }

        Pieza pieza = origen.getPieza();

        // 2. El jugador solo puede mover sus propias piezas
        if (pieza.getColor() != turnoActual.getColor()) {
            return false;
        }

        // 3. La pieza debe considerar válido el movimiento
        if (!pieza.validarMovimiento(destino)) {
            return false;
        }

        // 4. Si no es caballo, el camino debe estar libre
        if (!(pieza instanceof Caballo) && !tablero.caminoLibre(origen, destino)) {
            return false;
        }

        // 5. Ejecutar el movimiento
        historial.add(new Movimiento(origen, destino, pieza));
        origen.quitarPieza();
        destino.setPieza(pieza);
        pieza.setPosicionActual(destino);

        // 6. Cambiar turno
        turnoActual = (turnoActual == jugadorBlanco) ? jugadorNegro : jugadorBlanco;

        return true;
    }

    /**
     * Revisa si el jugador está en jaque
     * @return true si el jugador está en jaque, false si no
     */
    public boolean esJaque(Color color);

    /**
     * Revisa si el jugador está en jaque mate
     * @return true si el jugador está en jaque mate, false si no
     */
    public boolean esJaqueMate(Color color);

    // Método para promocionar un peón
    public void promocionPeon(Pieza peon, String tipoPieza);

    /* GETTERS */
    public Jugador getTurnoActual()      { return turnoActual; }
    public List<Movimiento> getHistorial() { return historial;  }
    public Tablero getTablero()          { return tablero;     }

    /* SETTERS */
    public void setEstado(EstadoPartida estado) { this.estado = estado; }
}
