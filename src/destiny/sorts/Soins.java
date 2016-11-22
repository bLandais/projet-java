package destiny.sorts;

import destiny.mover.Mover;

import java.io.Serializable;

public class Soins extends Spell implements Serializable {

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
    public boolean castOnTarget() {
        castOnTarget(getTarget());
        return false;
    }

    /**
     * Lance le sort courant sur un mover
     * @param mover     Mover (monstre, player) sur lequel sera lancé le sort
     **/
    @Override
    public boolean castOnTarget(Mover mover) {
        boolean canCast = super.castOnTarget(mover);
        if (canCast)
            mover.heal(hpHeal);
        return canCast;
    }

    /**
     * Permet d'obtenir la description de l'effet de ce sort
     * @return  Soins + #nbHP hp + Attente (x/x)
     */
    @Override
    public String toString() {
        return "Soins +" + hpHeal + "hp - " + super.toString();
    }
}
