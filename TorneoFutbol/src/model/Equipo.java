package model;

import model.Posicion;

public class Equipo {
    private String nombre;
    private String pais;
    private String directorTecnico;
    private Jugador[] jugadores;
    private int numJugadores;
    private int pj, pg, pe, pp, gf, gc, dg, pts;

    public Equipo(String nombre, String pais, String directorTecnico) {
        this.nombre = nombre;
        this.pais = pais;
        this.directorTecnico = directorTecnico;
        this.jugadores = new Jugador[20];
        this.numJugadores = 0;
    }
    
    public void agregarJugador(Jugador jugador) {
        if (numJugadores < 20) {
            jugadores[numJugadores++] = jugador;
        } else {
            System.out.println("El equipo ya tiene 20 jugadores.");
        }
    }

    public void actualizarEstadisticas(int golesAFavor, int golesEnContra) {
        this.pj++;
        if (golesAFavor > golesEnContra) {
            this.pg++;
            this.pts += 3;
        } else if (golesAFavor == golesEnContra) {
            this.pe++;
            this.pts += 1;
        } else {
            this.pp++;
        }
        this.gf += golesAFavor;
        this.gc += golesEnContra;
        this.dg = gf - gc;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPts() {
        return pts;
    }

    public int getPj() {
        return pj;
    }
}

