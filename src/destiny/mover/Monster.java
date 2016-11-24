package destiny.mover;

import destiny.sorts.Degats;
import destiny.sorts.Soins;
import destiny.sorts.Spell;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

/**
 * The type Monster.
 */
public class Monster extends Mover implements Boss, Serializable {
    private boolean isBoss = false;
    private Mover target;

    /**
     * Instantiates a new Monster.
     *
     * @param name   son nom
     * @param HP     nombre de points de vie
     * @param spells les sorts
     * @param isBoss est-ce un boss ?
     */
    public Monster(String name, int HP, ArrayList<Spell> spells, boolean isBoss) {
        super(name, HP, spells);
        this.isBoss = isBoss;
        getSoinsSpell();
    }

    /**
     * Quand le joueur change de cible, le monstre change aussi de cible pour que ce soit le joueur
     * @param mover Cible
     */
    public void setTarget(Mover mover) {
        this.target = mover;
    }

    /**
     * Mini intelligence artificielle
     * @return  Le sort que le monstre a lancé (pour l'affichage)
     */
    public Spell castBestSpell() {
        if(getCurrentHP() == getMaximumHP()) {
            getDamageSpell().castOnTarget(target);
            return getDamageSpell();
        }
        // S'il peut achever le joueur
        if(target.getCurrentHP() < getDamageSpell().getHpDamage()) {
            getDamageSpell().castOnTarget(target); // on lance sur le joueur
            return getDamageSpell();
        }
        else if(this.getCurrentHP() < 100) { // le joueur pourrait le tuer directement
            if(getSoinsSpell().canCastSpell()) {
                getSoinsSpell().castOnTarget(this);
                Spell.increaseRecharge(this);
                return getSoinsSpell();
            }
            else {  // si le sort n'est malheureusement pas dispo...
                getDamageSpell().castOnTarget(target);
                return getDamageSpell();
            }
        }
        else {
            getDamageSpell().castOnTarget(target);
            return getDamageSpell(); // Par défaut : il lance un damage quand même !
        }
    }

    private Degats getDamageSpell() {
        for(Spell s : spells) {
            if(s instanceof Degats)
                return (Degats)s;
        }
        return null;
    }

    private Soins getSoinsSpell() {
        for(Spell s : spells) {
            if(s.getClass().getName().equals(Soins.class.getName()))
                return (Soins)s;
        }
        return null;
    }

    @Override
    public boolean castSpell(Spell spell) {
        boolean canCast = true;
        ArrayList<Spell> spells = this.getSorts();
        Mover closestMover = spell.getTarget();
        int nbSpells = spells.size();
        Spell randomSpellChoose = spells.get(new Random().nextInt(nbSpells));
        if(randomSpellChoose != null)
            canCast = randomSpellChoose.castOnTarget();
        return canCast;
    }

    @Override
    public void regeneration() {
        if(this.isBoss)
            super.heal(this.getCurrentHP() / (1+new Random().nextInt(2)));
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

    @Override
    public void increaseHP() {
        if(this.isBoss) {
            this.setMaximumHP(300);
            this.setHP(300);
        }
    }

    @Override
    public String toString() {
        return "[" + getClass().getSimpleName() + "] " + super.toString();
    }
}
