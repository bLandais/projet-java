package destiny.sorts;

import destiny.mover.Mover;
import sun.awt.shell.ShellFolder;

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
        this.hpDamage = hpDamage;
    }

    public void setHpDamage(int damage) { this.hpDamage = damage; }
    public int getHpDamage() {
        return hpDamage;
    }

    @Override
    public void castOnTarget() {
        castOnTarget(getTarget());
    }

    @Override
    public void castOnTarget(Mover mover) {
        super.castOnTarget(mover);
        if(mover.getVulnerable()) {
            mover.damage(hpDamage);
        }
    }

    @Override
    public String toString() {
        return "Degats -" + (int)(hpDamage) + "hp - " + super.toString();
    }
}