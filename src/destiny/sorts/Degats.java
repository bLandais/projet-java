package destiny.sorts;

import destiny.GameManager;
import destiny.mover.Monster;
import destiny.mover.Mover;

import java.io.Serializable;

/**
 * The type Degats.
 */
public class Degats extends Spell implements Serializable {

    private int hpDamage;

    /**
     * Crée une instance de Degats
     *
     * @param hpDamage      le nombre de damage
     * @param rechargeRound le temps de round avant de pouvoir reutiliser
     */
    public Degats(int hpDamage, int rechargeRound) {
        super.setRechargeRound(rechargeRound);
        this.hpDamage = (int) (hpDamage * GameManager.player.getDamageIncrease());
    }

    public void setHpDamage(int damage) { this.hpDamage = damage; }
    public int getHpDamage() {
        return hpDamage;
    }

    @Override
    public boolean castOnTarget() {
        return castOnTarget(getTarget());
    }

    @Override
    public boolean castOnTarget(Mover mover) {
        boolean canCast = super.castOnTarget(mover);
        if(mover.getVulnerable() && canCast) {
            // Le monstre n'a pas de damage increase
            if(mover instanceof Monster)
                mover.damage((int) (hpDamage * GameManager.player.getDamageIncrease()));
            else
                mover.damage(hpDamage);
        }
        return false;
    }

    @Override
    public String toString() {
        return "Degats -" + (int)(hpDamage * GameManager.player.getDamageIncrease()) + "hp - " + super.toString();
    }
}