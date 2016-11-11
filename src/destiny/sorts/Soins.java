package destiny.sorts;

import destiny.mover.Mover;

public class Soins extends Spell {

    private int hpHeal;

    /**
     * Constructeur du sort de Soin
     * @param hpHeal    Nombre de points de vie qui seront rajoutés lors du lancement du sort
     */
    public Soins(int hpHeal, int rechargeRound) {
        super.setRechargeRound(rechargeRound);
        this.hpHeal = hpHeal;
    }

    /**
     * Lance le sort courant sur un
     * @param mover     Mover (monstre, player) sur lequel sera lancé le sort
     **/
    @Override
    public void castOnMover(Mover mover) {
        super.castOnMover(mover);
        mover.heal(hpHeal);
    }

    @Override
    public String toString() {
        return "Soins +" + hpHeal + "hp - " + super.toString();
    }
}
