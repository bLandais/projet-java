package destiny;

import destiny.sorts.Spell;

import java.util.ArrayList;

public abstract class Mover {
    private int HP;
    private String name;
    private ArrayList<Spell> spells;

    public int getHP() { return this.HP; }
    public void setHP(int HP) { this.HP = HP; }

    public String getName() { return this.name; }
    public void setName(String name) { this.name = name; }

    public ArrayList<Spell> getSorts() { return this.spells; }
    public void setSorts(ArrayList<Spell> sorts) { this.spells = sorts; }

}