package model;

import model.Posicion;

public class Jugador {
    private int numero;
    private String nombre;
    private String pais;
    private Posicion posicion;
    private int goles;
    private int partidosJugados;
    
    public Jugador(int numero, String nombre, String pais, Posicion posicion) {
        this.numero = numero;
        this.nombre = nombre;
        this.pais = pais;
        this.posicion = posicion;
        this.goles = 0;
        this.partidosJugados = 0;
    }
    
    public void registrarGol() {
        this.goles++;
    }
    
    public void incrementarPartidosJugados() {
        this.partidosJugados++;
    }

    public String getNombre() {
        return nombre;
    }

    public int getGoles() {
        return goles;
    }
}

