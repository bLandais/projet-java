package destiny;

import destiny.exceptions.*;
import destiny.inventory.Inventory;
import destiny.inventory.Item;
import destiny.inventory.ItemEffect;
import destiny.mover.*;
import destiny.save.SavePlayer;
import destiny.sorts.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *  Classe qui gère la dynamique du jeu
 **/
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
        player = new Player(name, 200, new ArrayList<Spell>());
        player.setSorts(getDefaultSpellsList());
        player.setInventory(getDefaultInventory());

        try {
            SavePlayer.saveMover(player);
            Mover playerSave = SavePlayer.lireMover();
            if(playerSave == null)
                throw new ImporterException();
        }
        catch(ImporterException ex) {
            // Erreur lors de l'importation : on crée une nouvelle partie
        }

        manageGame();

    }

    /**
     * Permet de récuperer le nom du joueur
     * @return  (String) Nom du joueur
     */
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

        lstSpells.add(new Degats(100, 0));
        lstSpells.add(new Soins(player, 3));
        lstSpells.add(new Soutiens(1.10f));

        return lstSpells;
    }

    /**
     * Inventaire par défaut qui comporte 5 items avec chacun un effet différents
     * et avec des quantités différentes
     * @return  (Inventory) Inventaire par défaut
     */
    private static Inventory getDefaultInventory() {
        Inventory inventory = new Inventory(5);
        inventory.addItem(new Item(ItemEffect.FULL_HEAL, 2));
        inventory.addItem(new Item(ItemEffect.DEFENSE_INCREASE, 3));
        inventory.addItem(new Item(ItemEffect.ATTACK, 3));
        inventory.addItem(new Item(ItemEffect.RESET, 3));
        inventory.addItem(new Item(ItemEffect.SURPRISE, 1));
        return inventory;
    }

    /**
     * Affiche sur la console de l'inventaire (choix des items)
     */
    private static void showInventory() {
        System.out.printf(player.getInventory().toString());
    }

    /**
     * Affiche la liste des actions (accueil)s
     */
    private static void showActions() {
        System.out.println("** Sorts **");
        int i = 0;
        for(Spell spell : player.getSorts()) {
            System.out.println("\t" + i + ") " + spell.toString());
            i++;
        }
        System.out.println("** Sauvegarde ** -- Appuyez sur s");
    }

    /**
     * Affiche les choix du joueur (inventaire, sorts)
     */
    private static void manageGame() {
        while (!isGameFinished) {
            showInventory();
            showActions();

            // On regarde quel action il veut faire
            manageActions();
        }
    }

    /**
     * Permet de gérer l'entrée utilisateur sur le choix d'un item
     */
    private static void manageInventory() {
        // TODO
        player.getInventory().showInventory();
        boolean itemFind = false;
        while(!itemFind) {
            try {
                System.out.print("Tapez le numero de l'item à utiliser (ou \"e\" pour revenir en arrière) : ");
                String inputAction = scanner.nextLine();
                if (inputAction.equals("e")) {
                    itemFind = true;
                } else {
                    int itemInput = Integer.parseInt(inputAction);
                    Inventory inventory = player.getInventory();
                    if (itemInput >= 0 && itemInput < inventory.getItems().size()) {
                        if (inventory.getItems().get(itemInput) != null) {
                            itemFind = true;
                            Item item = inventory.getItems().get(itemInput);
                            if (item.getQuantity() == 0)
                                throw new InventoryException(InventoryException.ErrorType.EMPTY_ITEM);
                        }
                    } else
                        throw new ArgumentActionException(ArgumentActionException.CaseAction.INVENTORY);
                }
            }
            catch(InventoryException inventoryException) {
                inventoryException.displayMessage();
            }
            catch(ArgumentActionException argException) {
                argException.displayMessage();
            }
            catch(NumberFormatException numberException) {
                System.out.println("Saisie incorrecte, veuillez recommencer...");
            }
        }
    }

    /**
     * Fonction qui gère les entrées de l'utilisateur
     * Si l'entrée est incorrecte, on redemande la saisie
     * Sinon, on déclenche l'action associée
     */
    private static void manageActions() {
        String inputAction = "";
        boolean actionFind = false;
        while(inputAction.isEmpty() || !actionFind) {
            System.out.print("Tapez le numero / lettre de l'action souhaitée : ");
            try {
                inputAction = scanner.nextLine();
                if(inputAction.equals("l")) {
                    actionFind = true;
                    manageInventory();
                }
                else if(inputAction.equals("s")) {
                    actionFind = true;
                    SavePlayer.saveMover(player);
                    System.out.println("Sauvegarde effectuée");
                }
                else {
                    int actionId = Integer.parseInt(inputAction);
                    if (actionId >= 0 && actionId <= player.getSorts().size()) {
                        actionFind = true;
                        // TODO : Vérifier le cooldown
                        player.castSpell(player.getSorts().get(actionId));
                    } else {
                        throw new ArgumentActionException(ArgumentActionException.CaseAction.SPELL);
                    }
                }
            }
            catch(ArgumentActionException e) {
                e.displayMessage();
            }
            catch(NumberFormatException e) {
                System.out.println("Saisie incorrecte, veuillez recommencer...");
            }
        }
    }

    /**
     * Méthode qui permet de vérifier si le jeu est terminé
     * Soit le joueur est mort, soit il a tué le dernier monstre (boss final)
     */
    private static void watchEndGame() {
        if(player.getCurrentHP() <= 0) {
            System.out.println("------ GAME OVER ------");
            isGameFinished = true;
        }
    }

}