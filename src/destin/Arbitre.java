package destin;

import game_elements.Plateau;
import game_elements.player.Player;

import java.util.Random;
import java.util.Scanner;

/**
 * Le but de cette classe est de gérer toutes les actions des joueurs
 */
public class Arbitre {

    private final static int SIZE_PLATEAU = 50;
    private static int nbPlayers = 2; // minimum = 2
    private static Plateau plateau;
    private static Player[] players;

    private static int tourCounter = 0;

    public static void main(String[] args) {
        askNumberPlayers();
        generatePlateau();

        // TODO Création des joueurs
        players = new Player[nbPlayers];

        // TODO Choix du banquier parmi les joueurs

        System.out.printf(String.valueOf(lancerDes()));


    }

    private static void askNumberPlayers() {
        int inputNbPlayers = -1;
        while(inputNbPlayers == -1) {
            System.out.print("Veuillez indiquer le nombre de joueurs (minimum 2) : ");
            Scanner scanner = new Scanner(System.in);
            try {
                inputNbPlayers = Integer.parseInt(scanner.next());
                if(inputNbPlayers < 2) {
                    throw new Exception(); // On continue la boucle
                }
            } catch (Exception e) {
                System.out.println("Saisie incorrecte, veuillez recommencer...");
            }
        }
    }

    private static void generatePlateau() {
        plateau = new Plateau(SIZE_PLATEAU);
        plateau.generate();
    }

    private static int lancerDes() {
        Random random = new Random();
        return (random.nextInt(10) + 1); // [0; 9[ + 1 = [1; 10];
    }

}
