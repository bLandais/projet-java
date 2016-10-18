package destiny.mover;

import destiny.sorts.Spell;

import java.util.ArrayList;
import java.util.Random;

public class Monster extends Mover implements Boss {

    protected Monster(String name, int HP, ArrayList<Spell> spells) {
        super(name, HP, spells);
    }

    @Override
    public void castSpell() {
        // Only cast damage spells TODO : Sure about that ?
        ArrayList<Spell> spells = this.getSorts();
        Mover closestMover = this.getClosestMover();
        int nbSpells = spells.size();
        Spell randomSpellChoose = spells.get(new Random().nextInt(nbSpells));
        if(randomSpellChoose != null) {
            randomSpellChoose.castOnMover(closestMover);
        }
    }


    @Override
    public void regeneration() {
        super.heal(this.getHP() / (1+new Random().nextInt(2)));
    }

    @Override
    public void defenseIncrease() {
    }

    @Override
    public void invulnerability() {
        this.setVulnerable(false);
    }
}
