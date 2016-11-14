package destiny.sorts;

import destiny.mover.Mover;

import java.io.Serializable;

public class Degats extends Spell implements Serializable {

    private int hpDamage;

    public Degats(int hpDamage, int rechargeRound) {
        super.setRechargeRound(rechargeRound);
        this.hpDamage = hpDamage;
    }

    @Override
    public void castOnTarget() {
        castOnTarget(getTarget());
    }

    @Override
    public void castOnTarget(Mover mover) {
        super.castOnTarget(mover);
        if(mover.getVulnerable()){
            mover.damage(hpDamage);
        }
    }

    @Override
    public String toString() {
        return "Degats -" + hpDamage + "hp - " + super.toString();
    }
}