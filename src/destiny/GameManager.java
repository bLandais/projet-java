package destiny;

import destiny.exceptions.ImporterException;
import destiny.mover.Player;
import destiny.sorts.Degats;
import destiny.sorts.Soins;
import destiny.sorts.Soutiens;
import destiny.sorts.Spell;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe qui gère la dynamique du jeu
 */
public class GameManager {

    private static boolean isGameFinished = false;

    private static Scanner scanner;
    private static final int CODE_INVENTORY = 1;
    private static final int CODE_SPELLS = 2;
    private static Player player;

    public static void main(String[] args) {
        System.out.println("Bienvenue dans Destiny");
        scanner = new Scanner(System.in);
        String name = askPlayerName();
        ArrayList<Spell> lstSpells = getDefaultSpellsList();
        player = new Player(name, 200, lstSpells);

        try {

            throw new ImporterException();
        }
        catch(ImporterException ex) {
            // Erreur lors de l'importation : on crée une nouvelle partie

        }

        manageGame();

    }

    private static String askPlayerName() {
        String name = "";
        System.out.print("Quel est votre nom ? ");
        name = scanner.nextLine();
        while(name.isEmpty()) {
            System.out.println("Le nom saisi est invalide. Quel est votre nom ?");
            name = scanner.nextLine();
        }
        return name;
    }

    /**
     * Fonction appellée lorsque nous créeons le joueur
     * @return  Une liste par défaut de sorts avec 1 sort de chaque catégorie
     *      Degats   -> 100 de damage
     *      Soins    -> 50 de soins
     *      Soutiens -> 10% d'augmentation
     */
    private static ArrayList<Spell> getDefaultSpellsList() {
        ArrayList<Spell> lstSpells = new ArrayList<>();

        lstSpells.add(new Degats(100));
        lstSpells.add(new Soins(50));
        lstSpells.add(new Soutiens(1.10f));

        return lstSpells;
    }

    private static void showInventory() {
        System.out.printf(player.getInventory().toString());
    }

    private static void showActions() {
        System.out.println("** Sorts **");
        int i = 0;
        for(Spell spell : player.getSorts()) {
            System.out.println("\t" + i + ") " + spell.toString());
            i++;
        }
    }

    private static void manageGame() {
        while (!isGameFinished) {
            showInventory();
            showActions();

            // On regarde quel action il veut faire
            manageActions();
        }
    }

    private static void manageActions() {
        System.out.print("Tapez le numero / lettre de l'action souhaitée : ");
        String inputAction = "";
        boolean actionFind = false;
        while(inputAction.isEmpty() || !actionFind) {
            inputAction = scanner.nextLine();
            if(inputAction.equals("l")) {
                actionFind = true;
                player.getInventory().showInventory(); // TODO : A corriger
            }
        }


    }

    private static void watchEndGame() {
        if(player.getHP() <= 0) {
            System.out.println("------ GAME OVER ------");
            isGameFinished = true;
        }
    }

}