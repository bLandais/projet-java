package destiny.sorts;

import destiny.mover.Mover;

public class Soins extends Spell {

    private int hpHeal = 0;

    public Soins(int hpHeal) {
        this.hpHeal = hpHeal;
    }

    @Override
    public void castOnMover(Mover mover) {
        mover.heal(hpHeal);
    }
}
