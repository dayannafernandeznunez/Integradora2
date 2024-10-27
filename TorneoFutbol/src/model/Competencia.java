package model;

import model.Equipo;
import model.Jugador;
import model.Arbitro;

public interface Competencia {
    void registrarEquipo(Equipo equipo);
    void registrarJugador(Equipo equipo, Jugador jugador);
    void registrarArbitro(Arbitro arbitro);
}
