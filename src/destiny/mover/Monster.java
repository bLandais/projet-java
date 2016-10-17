package destiny.mover;

import destiny.sorts.Spell;

import java.util.ArrayList;

public class Monster extends Mover implements Boss {

    protected Monster(String name, int HP, ArrayList<Spell> spells) {
        super(name, HP, spells);
    }

    @Override
    public void castSpell() {
        // Only cast damage spells

    }


    @Override
    public void regeneration() {

    }

    @Override
    public void defenseIncrease() {

    }

    @Override
    public void invulnerability() {

    }
}
