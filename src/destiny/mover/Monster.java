package destiny.mover;

import destiny.sorts.Spell;

import java.util.ArrayList;
import java.util.Random;

public class Monster extends Mover implements Boss {
    private boolean isBoss = false;
    private Mover target;

    protected Monster(String name, int HP, ArrayList<Spell> spells, boolean isBoss) {
        super(name, HP, spells);
        this.isBoss = isBoss;
    }

    public void setTarget(Mover mover) {
        this.target = mover;
    }

    private Mover getTarget() {
        return target;
    }

    @Override
    public void castSpell(Spell spell) {
        // Only cast damage spells TODO : Sure about that ?
        ArrayList<Spell> spells = this.getSorts();
        Mover closestMover = this.getTarget();
        int nbSpells = spells.size();
        Spell randomSpellChoose = spells.get(new Random().nextInt(nbSpells));
        if(randomSpellChoose != null)
            randomSpellChoose.castOnMover(closestMover);
    }

    @Override
    public void regeneration() {
        if(this.isBoss)
            super.heal(this.getHP() / (1+new Random().nextInt(2)));
    }

    @Override
    public void defenseIncrease() {
        if(this.isBoss){
            int curDefense = this.getDefense();
            this.setDefense((int)(1.3*curDefense));
        }
    }

    @Override
    public void invulnerability() {
        if (this.isBoss) {
            this.setVulnerable(false);
        }
    }
}
