package destin;

import game_elements.Plateau;
import game_elements.player.Player;
import game_elements.player.family.Sexe;

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
        for(int i = 0; i < nbPlayers; i++) {
            String nom = askName(i + 1);
            players[i] = new Player(nom, askSexe(nom));
            players[i].giveMoney(10000);
        }

        // TODO Choix du banquier parmi les joueurs

    }

    /**
     * Demande le nom d'un joueur
     * @param idPlayer  Le numéro du joueur (à défaut de connaître son nom)
     * @return  Retourne le nom du joueur
     */
    private static String askName(int idPlayer) {
        String name = "";
        while(name.equals("")) {
            System.out.print("Joueur numéro " + idPlayer + ", nom : ");
            Scanner scanner = new Scanner(System.in);
            try {
                String name_input = scanner.next();
                for(Player p : players) {
                    if (p != null) {
                        if (p.getName().equals(name_input)) // Nom déjà choisi
                            throw new InputTypeException("Nom déjà utilisé");
                    }
                }
                name = name_input;
            }
            catch(InputTypeException e) {
                System.out.println(e.getMessage());
            }
            catch (Exception e) {
                System.out.println("Saisie incorrecte, veuillez recommencer...");
            }
        }
        return name;
    }

    private static Sexe askSexe(String nomPlayer) {
        Sexe sexe = Sexe.UNKNOWN;
        while(sexe.equals(Sexe.UNKNOWN)) {
            System.out.print("Joueur " + nomPlayer + " - Tapez M pour Masculin, F pour Féminim : ");
            Scanner scanner = new Scanner(System.in);
            try {
                String sexe_input = scanner.next();
                if(sexe_input.toUpperCase().equals("M") || sexe_input.toUpperCase().equals("F")) {
                    sexe = (sexe_input.equals("M") ? Sexe.MASCULIN : Sexe.FEMININ);
                }
                else {
                    throw new Exception(); // continue la boucle
                }
            } catch (Exception e) {
                System.out.println("Saisie incorrecte, veuillez recommencer...");
            }
        }
        return sexe;
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

    /**
     * Generation du plateau
     */
    private static void generatePlateau() {
        plateau = new Plateau(SIZE_PLATEAU);
        plateau.generate();
    }

    /**
     * Lancer aléatoire du dès
     * @return  Un entier entre [1; 10]
     */
    private static int lancerDes() {
        Random random = new Random();
        return (random.nextInt(10) + 1); // [0; 10[ + 1 = [1; 10];
    }

}
