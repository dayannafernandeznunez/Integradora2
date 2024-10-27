package model;

import model.TipoArbitro;

public class Arbitro {
    private int id;
    private String nombre;
    private String pais;
    private TipoArbitro tipo;
    
    public Arbitro(int id, String nombre, String pais, TipoArbitro tipo) {
        this.id = id;
        this.nombre = nombre;
        this.pais = pais;
        this.tipo = tipo;
    }
    
    public TipoArbitro getTipo() {
        return tipo;
    }

    public String getNombre() {
        return nombre;
    }
}
