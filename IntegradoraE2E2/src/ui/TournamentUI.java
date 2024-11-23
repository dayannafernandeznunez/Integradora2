package ui;

import model.Tournament;
import model.CardType;
import java.util.Scanner;

public class TournamentUI {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tournament tournament = new Tournament();

        while (true) {
            // Mostrar menú de opciones
            System.out.println("\nBienvenido al sistema de gestión del torneo");
            System.out.println("1. Agregar equipo");
            System.out.println("2. Agregar jugador a un equipo");
            System.out.println("3. Agregar árbitro");
            System.out.println("4. Generar Fixture");
            System.out.println("5. Mostrar Fixture");
            System.out.println("6. Asignar árbitros");
            System.out.println("7. Registrar resultado de partido");
            System.out.println("8. Registrar gol");
            System.out.println("9. Registrar tarjeta");
            System.out.println("10. Ver clasificación por grupo");
            System.out.println("11. Ver máximo goleador");
            System.out.println("12. Ver equipo con Fair Play");
            System.out.println("13. Ver eficiencia de equipos");
            System.out.println("14. Ver eficiencia de jugadores");
            System.out.println("15. Ver índice de tarjetas de árbitros");
            System.out.println("0. Salir");
            System.out.print("Elija una opción: ");

            int option = scanner.nextInt();
            scanner.nextLine();  // Consumir salto de línea

            switch (option) {
                case 1:
                    // Agregar equipo
                    System.out.print("Ingrese nombre del equipo: ");
                    String teamName = scanner.nextLine();
                    System.out.print("Ingrese país del equipo: ");
                    String teamCountry = scanner.nextLine();
                    System.out.print("Ingrese nombre del entrenador: ");
                    String coach = scanner.nextLine();
                    tournament.addTeam(teamName, teamCountry, coach);
                    System.out.println("Equipo agregado con éxito.");
                    break;

                case 2:
                    // Agregar jugador a un equipo
                    System.out.print("Ingrese nombre del equipo: ");
                    teamName = scanner.nextLine();
                    System.out.print("Ingrese nombre del jugador: ");
                    String playerName = scanner.nextLine();
                    System.out.print("Ingrese número del jugador: ");
                    int number = scanner.nextInt();
                    tournament.addPlayerToTeam(teamName, playerName, number);
                    System.out.println("Jugador agregado con éxito.");
                    break;

                case 3:
                    // Agregar árbitro
                    System.out.print("Ingrese nombre del árbitro: ");
                    String refereeName = scanner.nextLine();
                    System.out.print("Ingrese tipo de árbitro (Principal, Asistente): ");
                    String refereeType = scanner.nextLine();
                    tournament.addReferee(refereeName, refereeType);
                    System.out.println("Árbitro agregado con éxito.");
                    break;

                case 4:
                    // Generar Fixture
                    tournament.generateFixture();
                    System.out.println("Fixture generado.");
                    break;

                case 5:
                    // Mostrar Fixture con matriz
                    tournament.showFixture();
                    break;

                case 6:
                    // Asignar árbitros a los partidos
                    tournament.assignReferees();
                    System.out.println("Árbitros asignados.");
                    break;

                case 7:
                    // Registrar resultado de partido
                    System.out.print("Ingrese número del partido (0 para el primer partido, 1 para el segundo...): ");
                    int matchIndex = scanner.nextInt();
                    System.out.print("Ingrese goles del primer equipo: ");
                    int score1 = scanner.nextInt();
                    System.out.print("Ingrese goles del segundo equipo: ");
                    int score2 = scanner.nextInt();
                    tournament.registerMatchResult(matchIndex, score1, score2);
                    System.out.println("Resultado registrado.");
                    break;

                case 8:
                    // Registrar gol
                    System.out.print("Ingrese número del partido: ");
                    matchIndex = scanner.nextInt();
                    scanner.nextLine();  // Consumir salto de línea
                    System.out.print("Ingrese nombre del jugador que anotó el gol: ");
                    playerName = scanner.nextLine();
                    System.out.print("Ingrese nombre del jugador asistente: ");
                    String assistantName = scanner.nextLine();
                    tournament.registerGoal(matchIndex, playerName, assistantName);
                    System.out.println("Gol registrado.");
                    break;

                case 9:
                    // Registrar tarjeta
                    System.out.print("Ingrese número del partido: ");
                    matchIndex = scanner.nextInt();
                    scanner.nextLine();  // Consumir salto de línea
                    System.out.print("Ingrese nombre del jugador: ");
                    playerName = scanner.nextLine();
                    System.out.print("Ingrese tipo de tarjeta (YELLOW, RED): ");
                    String cardTypeStr = scanner.nextLine();
                    CardType cardType = CardType.valueOf(cardTypeStr.toUpperCase());
                    tournament.registerCard(matchIndex, playerName, cardType);
                    System.out.println("Tarjeta registrada.");
                    break;

                case 10:
                    // Ver clasificación por grupo (matriz de clasificación)
                    tournament.showGroupStandings();
                    break;

                case 11:
                    // Ver máximo goleador
                    tournament.showTopScorer();
                    break;

                case 12:
                    // Ver equipo con Fair Play
                    tournament.showFairPlayTeam();
                    break;

                case 13:
                    // Ver eficiencia de equipos
                    tournament.calculateTeamEfficiency();
                    break;

                case 14:
                    // Ver eficiencia de jugadores
                    tournament.calculatePlayerEfficiency();
                    break;

                case 15:
                    // Ver índice de tarjetas de árbitros
                    tournament.calculateRefereeCardIndex();
                    break;

                case 0:
                    // Salir
                    System.out.println("Saliendo del programa...");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opción inválida. Por favor, intente de nuevo.");
                    break;
            }
        }
    }
}
