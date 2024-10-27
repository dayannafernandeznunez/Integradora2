package model;

public class Partido {
    private Equipo equipo1;
    private Equipo equipo2;
    private Arbitro arbitroCentral;
    private Arbitro[] asistentes;
    private int golesEquipo1;
    private int golesEquipo2;

    public Partido(Equipo equipo1, Equipo equipo2) {
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.asistentes = new Arbitro[2];
    }
    
    public void asignarArbitros(Arbitro central, Arbitro asistente1, Arbitro asistente2) {
        this.arbitroCentral = central;
        this.asistentes[0] = asistente1;
        this.asistentes[1] = asistente2;
    }
    
    public void registrarMarcador(int goles1, int goles2) {
        this.golesEquipo1 = goles1;
        this.golesEquipo2 = goles2;
        equipo1.actualizarEstadisticas(goles1, goles2);
        equipo2.actualizarEstadisticas(goles2, goles1);
    }
}
