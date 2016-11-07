package destiny;

import destiny.mover.Player;

import java.io.IOException;
import java.util.Scanner;

/**
 * Classe qui gère la dynamique du jeu
 */
public class GameManager {

    private static Player player;

    public static void main(String[] args) {
        System.out.println("Bienvenue dans Destiny");
        askPlayerName();
        //  player = new Player(askPlayerName(), 100, );
    }

    private static String askPlayerName() {
        String name = "";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quel est votre nom ?");
        name = scanner.nextLine();
        while(name.isEmpty()) {
            System.out.println("Le nom saisi est invalide. Quel est votre nom ?");
            name = scanner.nextLine();
        }
        return name;
    }

    public static void manageInventory() {

    }

    public static void manageActions() {

    }

    public static void generateLevel() {

    }

}