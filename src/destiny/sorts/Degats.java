package destiny.sorts;

import destiny.mover.Mover;

public class Degats extends Spell {

    private int hpDamage;

    public Degats(int hpDamage, int rechargeRound) {
        super.setRechargeRound(rechargeRound);
        this.hpDamage = hpDamage;
    }

    @Override
    public void castOnMover(Mover mover) {
        super.castOnMover(mover);
        if(mover.getVulnerable()) {
            mover.damage(hpDamage);
        }
    }

    @Override
    public String toString() {
        return "Degats -" + hpDamage + "hp - " + super.toString();
    }
}