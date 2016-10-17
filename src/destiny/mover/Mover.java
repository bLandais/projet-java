package destiny.mover;

import destiny.sorts.Spell;
import java.util.ArrayList;

public abstract class Mover {
    private int curHP;
    private int maxHP;
    private final String name;
    private ArrayList<Spell> spells;

    protected Mover(String name, int HP, ArrayList<Spell> spells) {
        this.name = name;
        this.maxHP = HP;
        this.curHP = HP;
        this.spells = spells;
    }

    public void heal(int hpAmount) {
        if(this.curHP <= 0)
            return; // pas de zombies !
        if(this.curHP + Math.abs(hpAmount) > this.maxHP)
            this.curHP = this.maxHP;
        else
            this.curHP += Math.abs(hpAmount);
    }

    public void damage(int hpDamage) {
        if(this.curHP <= 0)
            return; // Dead
        this.curHP -= Math.abs(hpDamage);
        if(this.curHP < 0)
            this.curHP = 0; // affichage
    }

    public int getHP() { return this.curHP; }
    protected void setHP(int HP) { this.curHP = HP; }

    public String getName() { return this.name; }

    public ArrayList<Spell> getSorts() { return this.spells; }
    public void setSorts(ArrayList<Spell> sorts) { this.spells = sorts; }

    public abstract void castSpell();

}