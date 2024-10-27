package model;

import model.Competencia;
import model.Estadisticas;

public class Torneo implements Competencia, Estadisticas {
    private Equipo[] equipos;
    private Arbitro[] arbitros;
    private int numEquipos;
    private int numArbitros;

    public Torneo() {
        equipos = new Equipo[8];
        arbitros = new Arbitro[12];
        numEquipos = 0;
        numArbitros = 0;
    }

    public Equipo buscarEquipo(String nombre) {
        for (Equipo equipo : equipos) {
            if (equipo != null && equipo.getNombre().equalsIgnoreCase(nombre)) {
                return equipo;
            }
        }
        return null;
    }

    @Override
    public void registrarEquipo(Equipo equipo) {
        if (numEquipos < 8) {
            equipos[numEquipos++] = equipo;
        } else {
            System.out.println("Ya se han registrado 8 equipos.");
        }
    }

    @Override
    public void registrarJugador(Equipo equipo, Jugador jugador) {
        equipo.agregarJugador(jugador);
    }

    @Override
    public void registrarArbitro(Arbitro arbitro) {
        if (numArbitros < 12) {
            arbitros[numArbitros++] = arbitro;
        } else {
            System.out.println("Ya se han registrado todos los árbitros necesarios.");
        }
    }

    public void mostrarGoleador() {
        Jugador goleador = null;
        int maxGoles = 0;
        for (Equipo equipo : equipos) {
            if (equipo != null) {
                for (Jugador jugador : equipo.getJugadores()) {
                    if (jugador != null && jugador.getGoles() > maxGoles) {
                        maxGoles = jugador.getGoles();
                        goleador = jugador;
                    }
                }
            }
        }
        if (goleador != null) {
            System.out.println("Máximo goleador: " + goleador.getNombre() + " con " + maxGoles + " goles.");
        } else {
            System.out.println("No hay goles registrados.");
        }
    }

    public void mostrarEquipoFairPlay() {
        // Método para mostrar el equipo con menos tarjetas
    }
}
