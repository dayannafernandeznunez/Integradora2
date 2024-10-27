package ui;

import model.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TorneoController torneoController = new TorneoController();

        torneoController.precargarDatos();

        int opcion;

        do {
            System.out.println("\n--- Menú de Opciones ---");
            System.out.println("1. Registrar un equipo");
            System.out.println("2. Registrar un jugador");
            System.out.println("3. Registrar un árbitro");
            System.out.println("4. Simular un partido");
            System.out.println("5. Mostrar estadísticas");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    registrarEquipo(torneoController, scanner);
                    break;
                case 2:
                    registrarJugador(torneoController, scanner);
                    break;
                case 3:
                    registrarArbitro(torneoController, scanner);
                    break;
                case 4:
                    simularPartido(torneoController, scanner);
                    break;
                case 5:
                    mostrarEstadisticas(torneoController);
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 0);

        scanner.close();
    }

    private static void registrarEquipo(TorneoController torneoController, Scanner scanner) {
        System.out.print("Ingrese el nombre del equipo: ");
        String nombre = scanner.next();
        System.out.print("Ingrese el país del equipo: ");
        String pais = scanner.next();
        System.out.print("Ingrese el nombre del director técnico: ");
        String directorTecnico = scanner.next();

        torneoController.registrarEquipo(nombre, pais, directorTecnico);
        System.out.println("Equipo registrado.");
    }

    private static void registrarJugador(TorneoController torneoController, Scanner scanner) {
        System.out.print("Ingrese el nombre del equipo al que pertenece el jugador: ");
        String nombreEquipo = scanner.next();

        System.out.print("Ingrese el número del jugador: ");
        int numero = scanner.nextInt();
        System.out.print("Ingrese el nombre del jugador: ");
        String nombreJugador = scanner.next();
        System.out.print("Ingrese el país de origen del jugador: ");
        String paisJugador = scanner.next();
        System.out.println("Seleccione la posición del jugador:");
        System.out.println("1. Arquero");
        System.out.println("2. Defensa");
        System.out.println("3. Volante");
        System.out.println("4. Delantero");
        int posicion = scanner.nextInt();
        Posicion pos = Posicion.values()[posicion - 1];

        torneoController.registrarJugador(nombreEquipo, numero, nombreJugador, paisJugador, pos);
        System.out.println("Jugador registrado.");
    }

    private static void registrarArbitro(TorneoController torneoController, Scanner scanner) {
        System.out.print("Ingrese el id del árbitro: ");
        int id = scanner.nextInt();
        System.out.print("Ingrese el nombre del árbitro: ");
        String nombre = scanner.next();
        System.out.print("Ingrese el país del árbitro: ");
        String pais = scanner.next();
        System.out.println("Seleccione el tipo de árbitro:");
        System.out.println("1. Central");
        System.out.println("2. Asistente");
        int tipo = scanner.nextInt();
        TipoArbitro tipoArbitro = (tipo == 1) ? TipoArbitro.CENTRAL : TipoArbitro.ASISTENTE;

        torneoController.registrarArbitro(id, nombre, pais, tipoArbitro);
        System.out.println("Árbitro registrado.");
    }

    private static void simularPartido(TorneoController torneoController, Scanner scanner) {
        System.out.print("Ingrese el nombre del primer equipo: ");
        String nombreEquipo1 = scanner.next();

        System.out.print("Ingrese el nombre del segundo equipo: ");
        String nombreEquipo2 = scanner.next();

        System.out.print("Ingrese los goles del primer equipo: ");
        int goles1 = scanner.nextInt();
        System.out.print("Ingrese los goles del segundo equipo: ");
        int goles2 = scanner.nextInt();

        torneoController.simularPartido(nombreEquipo1, nombreEquipo2, goles1, goles2);
    }

    private static void mostrarEstadisticas(TorneoController torneoController) {
        torneoController.mostrarEstadisticas();
    }
}
