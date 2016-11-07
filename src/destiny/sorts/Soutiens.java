package destiny.sorts;

import destiny.mover.Mover;

public class Soutiens extends Spell {

    private float damageIncrease = 1f;

    /**
     * Constructeur de sort de soutiens
     * @param damageIncrease    Coefficient d'augmentation de dégats
     */
    public Soutiens(float damageIncrease) {
        this.damageIncrease = damageIncrease;
    }

    /**
     * Lance le sort courant sur un autre Mover
     * @param mover     Cible sur lequel sera lancé le sort
     */
    @Override
    public void castOnMover(Mover mover) {
        super.castOnMover(mover);
        if(mover.getHP() > 0) { // is mover alive ?
            mover.setDamageIncrease(damageIncrease);
        }
    }
}
