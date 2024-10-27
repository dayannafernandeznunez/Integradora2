package model;

import model.*;
import model.Posicion;
import model.TipoArbitro;

public class TorneoController {
    private Torneo torneo;

    public TorneoController() {
        torneo = new Torneo();
    }


    public void precargarDatos() {
        // Precarga de equipos y jugadores
        registrarEquipo("Argentina", "Argentina", "Lionel Scaloni");
        registrarJugador("Argentina", 10, "Lionel Messi", "Argentina", Posicion.DELANTERO);
        registrarJugador("Argentina", 1, "Emiliano Martínez", "Argentina", Posicion.ARQUERO);
        
        registrarEquipo("Brasil", "Brasil", "Tite");
        registrarJugador("Brasil", 10, "Neymar Jr", "Brasil", Posicion.DELANTERO);
        registrarJugador("Brasil", 1, "Alisson Becker", "Brasil", Posicion.ARQUERO);
        
        registrarEquipo("Uruguay", "Uruguay", "Diego Alonso");
        registrarJugador("Uruguay", 9, "Luis Suárez", "Uruguay", Posicion.DELANTERO);
        registrarJugador("Uruguay", 1, "Fernando Muslera", "Uruguay", Posicion.ARQUERO);
        
        registrarEquipo("Colombia", "Colombia", "Reinaldo Rueda");
        registrarJugador("Colombia", 10, "James Rodríguez", "Colombia", Posicion.VOLANTE);
        registrarJugador("Colombia", 1, "David Ospina", "Colombia", Posicion.ARQUERO);

        // Precarga de árbitros
        registrarArbitro(1, "Árbitro Central 1", "Chile", TipoArbitro.CENTRAL);
        registrarArbitro(2, "Árbitro Central 2", "Perú", TipoArbitro.CENTRAL);
        registrarArbitro(3, "Árbitro Asistente 1", "Ecuador", TipoArbitro.ASISTENTE);
        registrarArbitro(4, "Árbitro Asistente 2", "Paraguay", TipoArbitro.ASISTENTE);
        
        System.out.println("Datos precargados.");
    }
    
    public void registrarEquipo(String nombre, String pais, String directorTecnico) {
        Equipo equipo = new Equipo(nombre, pais, directorTecnico);
        torneo.registrarEquipo(equipo);
    }

    public void registrarJugador(String nombreEquipo, int numero, String nombreJugador, String paisJugador, Posicion posicion) {
        Equipo equipo = torneo.buscarEquipo(nombreEquipo);
        if (equipo != null) {
            Jugador jugador = new Jugador(numero, nombreJugador, paisJugador, posicion);
            torneo.registrarJugador(equipo, jugador);
        } else {
            System.out.println("Equipo no encontrado.");
        }
    }

    public void registrarArbitro(int id, String nombre, String pais, TipoArbitro tipo) {
        Arbitro arbitro = new Arbitro(id, nombre, pais, tipo);
        torneo.registrarArbitro(arbitro);
    }

    public void simularPartido(String nombreEquipo1, String nombreEquipo2, int goles1, int goles2) {
        Equipo equipo1 = torneo.buscarEquipo(nombreEquipo1);
        Equipo equipo2 = torneo.buscarEquipo(nombreEquipo2);

        if (equipo1 != null && equipo2 != null) {
            Partido partido = new Partido(equipo1, equipo2);
            partido.registrarMarcador(goles1, goles2);
            torneo.registrarPartido(partido);
            System.out.println("Partido simulado y registrado.");
        } else {
            System.out.println("Uno o ambos equipos no existen.");
        }
    }

    public void mostrarEstadisticas() {
        torneo.mostrarGoleador();
        torneo.mostrarEquipoFairPlay();
    }

    public Torneo getTorneo() {
        return torneo;
    }
}
