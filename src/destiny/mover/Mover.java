package destiny.mover;

import destiny.sorts.Spell;
import java.util.ArrayList;

public abstract class Mover {
    private int curHP;
    private int maxHP;
    private final String name;
    private ArrayList<Spell> spells;
    private boolean isVulnerable;
    private int defense;
    private float damageIncrease;

    public float getDamageIncrease() {
        return damageIncrease;
    }

    public void setDamageIncrease(float damageIncrease) {
        this.damageIncrease = damageIncrease;
    }

    protected Mover(String name, int HP, ArrayList<Spell> spells) {
        this.name = name;
        this.maxHP = HP;
        this.curHP = HP;
        this.spells = spells;
        this.isVulnerable = true;
        this.defense = 200; // TODO : Default ?
        this.damageIncrease = 1.0f;
    }

    /**
     * Fonction qui permet de définir si un monstre est vulnerable (tours limité)
     * @param isVulnerable  True : vulnerable, par défaut
     */
    public void setVulnerable(boolean isVulnerable) {
        this.isVulnerable = isVulnerable;
    }

    public boolean getVulnerable()  {
        return this.isVulnerable;
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

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public String getName() { return this.name; }

    public ArrayList<Spell> getSorts() { return this.spells; }
    public void setSorts(ArrayList<Spell> sorts) { this.spells = sorts; }

    public abstract void castSpell();

    public Mover getClosestMover() {
        // TODO
        return null;
    }
}