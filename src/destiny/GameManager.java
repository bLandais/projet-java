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

    private static Player player;

    public static void main(String[] args) {
        System.out.println("Bienvenue dans Destiny");
        String name = askPlayerName();
        ArrayList<Spell> lstSpells = getDefaultSpellsList();
        player = new Player(name, 200, lstSpells);

        try {

            throw new ImporterException();
        }
        catch(ImporterException ex) {
            // Erreur lors de l'importation : on crée une nouvelle partie

        }

    }

    private static String askPlayerName() {
        String name = "";
        Scanner scanner = new Scanner(System.in);
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

    public static void manageInventory() {

    }

    public static void manageActions() {

    }

    public static void generateLevel() {

    }

}