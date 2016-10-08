package game_elements.player;

public class Player {

    private int money = 0;
    private int debt = 0;
    private int salary = 0;
    private int profession = 0; // TODO : Pas un entier !

    private int position = 0; // position sur le plateau

    /**
     * Ajoute de l'argent dans le compte du joueur
     * @param amount    Montant à ajouter
     */
    public void giveMoney(int amount) {
        money += Math.abs(amount); // pas possible de lui enlever de l'argent directement
    }

    /**
     * Retire l'argent dans le compte en banque du joueur
     * @param amount    Montant à retirer
     */
    public void withdrawMoney(int amount) {
        money -= Math.abs(amount); // pas de pb avec le signe !
    }

    /**
     * Le joueur prend un crédit auprès de la banque
     * Attention : la fonction n'ajoute pas l'argent dans le compte en banque !
     * @param amountDebt
     */
    public void addDebt(int amountDebt) {
        debt += Math.abs(amountDebt);
    }

    /**
     * Remboursement d'un certain montant de la dette
     * @param amountDebt    Montant qui va être remboursé
     */
    public void refundDebt(int amountDebt) {
        debt -= Math.abs(amountDebt);
    }

}
