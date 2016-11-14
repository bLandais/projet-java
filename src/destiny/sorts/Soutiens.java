package destiny.sorts;

import destiny.mover.Mover;

public class Soutiens extends Spell {

    private float damageIncrease;

    /**
     * Constructeur de sort de soutiens
     * @param damageIncrease    Coefficient d'augmentation de dégats
     */
    public Soutiens(float damageIncrease) {
        this.damageIncrease = damageIncrease;
    }

    /**
     * Lance le sort courant sur la cible courante
     */
    @Override
    public void castOnTarget() {
        castOnTarget(target);
    }

    @Override
    public void castOnTarget(Mover mover) {
        super.castOnTarget(mover);
        if(mover != null) {
            if (mover.getCurrentHP() > 0) { // is mover alive ?
                mover.setDamageIncrease(damageIncrease);
            }
        }
    }

    @Override
    public String toString() {
        return "Soutiens : " + damageIncrease * 100 + "% des dégats normaux - " + super.toString();
    }
}
