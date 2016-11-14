package destiny.sorts;

import destiny.mover.Mover;

public class Soins extends Spell {

    private int hpHeal;

    /**
     * Constructeur du sort de Soin
     * @param player    La cible du sort (le joueur pour le sort de soin)
     * @param rechargeRound  Temps avant de pouvoir reutiliser le sort
     */
    public Soins(Mover player, int rechargeRound) {
        super.setRechargeRound(rechargeRound);
        super.setTarget(player);
        this.hpHeal = (int)(player.getMaximumHP() * 0.3);
    }

    /**
     * Lance le sort courant sur la cible en cours
     **/
    @Override
    public void castOnTarget() {
        castOnTarget(getTarget());
    }

    /**
     * Lance le sort courant sur un mover
     * @param mover     Mover (monstre, player) sur lequel sera lancé le sort
     **/
    @Override
    public void castOnTarget(Mover mover) {
        super.castOnTarget(mover);
        mover.heal(hpHeal);
    }

    @Override
    public String toString() {
        return "Soins +" + hpHeal + "hp - " + super.toString();
    }
}
