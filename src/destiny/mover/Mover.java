package destiny.mover;

import destiny.sorts.Spell;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * The type Mover.
 */
public abstract class Mover implements Serializable {
    private int curHP;
    private int maxHP;
    /**
     * The Name.
     */
    protected final String name;
    /**
     * The Spells.
     */
    protected ArrayList<Spell> spells;
    private boolean isVulnerable;
    private int defense;
    private float damageIncrease;

    /**
     * Gets current hp.
     *
     * @return the current hp
     */
    public int getCurrentHP() { return this.curHP; }

    /**
     * Gets maximum hp.
     *
     * @return the maximum hp
     */
    public int getMaximumHP() { return this.maxHP; }

    /**
     * Sets maximum hp.
     *
     * @param maxHP the max hp
     */
    public void setMaximumHP(int maxHP) { this.maxHP = maxHP; }

    /**
     * Gets damage increase.
     *
     * @return the damage increase
     */
    public float getDamageIncrease() {
        return damageIncrease;
    }

    /**
     * Sets damage increase.
     *
     * @param damageIncrease the damage increase
     */
    public void setDamageIncrease(float damageIncrease) {
        this.damageIncrease = damageIncrease;
    }

    /**
     * Instantiates a new Mover.
     *
     * @param name   the name
     * @param HP     the hp
     * @param spells the spells
     */
    protected Mover(String name, int HP, ArrayList<Spell> spells) {
        this.name = name;
        this.maxHP = HP;
        this.curHP = HP;
        this.spells = spells;
        this.isVulnerable = true;
        this.defense = 200; // Default
        this.damageIncrease = 1.0f;
    }

    /**
     * Fonction qui permet de définir si un monstre est vulnerable (tours limité)
     *
     * @param isVulnerable True : vulnerable, par défaut
     */
    public void setVulnerable(boolean isVulnerable) {
        this.isVulnerable = isVulnerable;
    }

    /**
     * Gets vulnerable.
     *
     * @return the vulnerable
     */
    public boolean getVulnerable()  {
        return this.isVulnerable;
    }

    /**
     * Heal.
     *
     * @param hpAmount le nombre de hp heal
     */
    public void heal(int hpAmount) {
        if(this.curHP <= 0)
            return; // pas de zombies !
        if(this.curHP + Math.abs(hpAmount) > this.maxHP)
            this.curHP = this.maxHP;
        else
            this.curHP += Math.abs(hpAmount);
    }

    /**
     * Damage.
     *
     * @param hpDamage the hp damage
     */
    public void damage(int hpDamage) {
        if(this.curHP <= 0)
            return; // Dead
        this.curHP -= Math.abs(hpDamage);
        if(this.curHP < 0) {
            this.curHP = 0; // affichage
            System.out.println(this.getName() + " a été tué");
        }
    }

    /**
     * Sets hp.
     *
     * @param HP the hp
     */
    protected void setHP(int HP) {
        if (HP > this.maxHP) {
            this.curHP = maxHP;
        }
        else
            this.curHP = HP;
    }

    /**
     * Gets defense.
     *
     * @return the defense
     */
    public int getDefense() {
        return defense;
    }

    /**
     * Sets defense.
     *
     * @param defense the defense
     */
    public void setDefense(int defense) {
        this.defense = defense;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() { return this.name; }

    /**
     * Obtenir les sorts.
     *
     * @return les sorts
     */
    public ArrayList<Spell> getSorts() { return this.spells; }

    /**
     * Sets sorts.
     *
     * @param sorts définir les sorts qu'il pourra lancer
     */
    public void setSorts(ArrayList<Spell> sorts) { this.spells = sorts; }

    /**
     * Cast spell.
     *
     * @param spell le sort qui va être lancé
     */
    public abstract boolean castSpell(Spell spell);

    @Override
    public String toString() {
        return getName() + "--> HP: " + this.getCurrentHP() + "/" + this.getMaximumHP() + "\t\t Defense: " + this.getDefense() + "\t\t Degats : "
                + this.getDamageIncrease() * 100 + "%";
    }
}