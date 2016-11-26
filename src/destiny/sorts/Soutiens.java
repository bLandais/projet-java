package destiny.sorts;

import destiny.mover.Mover;

import java.io.Serializable;

/**
 * The type Soutiens.
 */
public class Soutiens extends Spell implements Serializable {

    private float damageIncrease;

    /**
     * Constructeur de sort de soutiens
     *
     * @param damageIncrease Coefficient d'augmentation de dégats
     */
    public Soutiens(float damageIncrease) {
        this.damageIncrease = damageIncrease;
    }

    /**
     * Lance le sort courant sur la cible courante
     */
    @Override
    public boolean castOnTarget() {
        castOnTarget(target);
        return false;
    }

    @Override
    public boolean castOnTarget(Mover mover) {
        boolean canCast = super.castOnTarget(mover);
        if(mover != null && canCast) {
            if (mover.getCurrentHP() > 0) { // is mover alive ?
                mover.setDamageIncrease(damageIncrease);
            }
        }
        return canCast;
    }

    @Override
    public String toString() {
        return "Soutiens : " + damageIncrease * 100 + "% des dégats normaux - " + super.toString();
    }
}