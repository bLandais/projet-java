package destiny.mover;

import destiny.sorts.Spell;
import java.util.ArrayList;

public abstract class Mover {
    private int HP;
    private final String name;
    private ArrayList<Spell> spells;

    protected Mover(String name, int HP, ArrayList<Spell> spells) {
        this.name = name;
        this.HP = HP;
        this.spells = spells;
    }

    public void heal(int hpAmount) {
        this.HP += Math.abs(hpAmount);
    }

    public void damage(int hpDamage) {
        this.HP -= Math.abs(hpDamage);
    }

    public int getHP() { return this.HP; }
    protected void setHP(int HP) { this.HP = HP; }

    public String getName() { return this.name; }

    public ArrayList<Spell> getSorts() { return this.spells; }
    public void setSorts(ArrayList<Spell> sorts) { this.spells = sorts; }

    public abstract void castSpell();

}