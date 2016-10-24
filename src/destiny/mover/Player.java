package destiny.mover;

import destiny.inventory.Inventory;
import destiny.sorts.Spell;
import java.util.ArrayList;

public class Player extends Mover {

    private Inventory inventory;

    public Player(String name, int HP, ArrayList<Spell> spells) {
        super(name, HP, spells);
        this.inventory = new Inventory(5);
    }

    public Inventory getInventory() { return this.inventory; }

    public void castSpell() {

    }

}