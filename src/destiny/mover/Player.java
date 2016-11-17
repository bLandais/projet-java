package destiny.mover;

import destiny.inventory.Inventory;
import destiny.sorts.Spell;

import java.io.Serializable;
import java.util.ArrayList;

public class Player extends Mover implements Serializable {

    private Inventory inventory;
    private Mover target;

    public Player(String name, int HP, ArrayList<Spell> spells) {
        super(name, HP, spells);
        this.inventory = new Inventory(5);
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
    public Inventory getInventory() { return this.inventory; }

    public void changeTarget(Mover target) {
        this.target = target;
    }
    public Mover getTarget() { return this.target; }

    @Override
    public void castSpell(Spell spell) {
        ArrayList<Spell> lstSpells = super.getSorts();
        if(lstSpells.contains(spell)) {
            spell.castOnTarget(target); // TODO
        }
    }

    @Override
    public String toString() {
        if(target != null)
            return "[" + getClass().getSimpleName() + "] " + super.toString() + " \nTarget : " + target.toString();
        else
            return "[" + getClass().getSimpleName() + "] " + super.toString();
    }
}