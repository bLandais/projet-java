package destiny.sorts;

import destiny.mover.Mover;

public class Degats extends Spell {

    private int hpDamage;

    public Degats(int hpDamage) {
        this.hpDamage = hpDamage;
    }

    @Override
    public void castOnMover(Mover mover) {
        mover.damage(hpDamage);
    }
}
