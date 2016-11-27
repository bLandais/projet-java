package destiny.mover;

import destiny.GameManager;
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
     * @return  Le sort que le monstre a lancé (pour l'affichage) au format String
     */
    public String castBestSpell() {
        if(!this.getVulnerable())
            this.setVulnerable(true);
        if(getCurrentHP() == getMaximumHP()) {
            getDamageSpell().castOnTarget(target);
            return getDamageSpell().toString();
        }
        // S'il peut achever le joueur
        if(target.getCurrentHP() < getDamageSpell().getHpDamage()) {
            getDamageSpell().castOnTarget(target); // on lance sur le joueur
            return getDamageSpell().toString();
        }
        else if(this.getCurrentHP() < 100) { // le joueur pourrait le tuer directement
            if (getSoinsSpell().canCastSpell() && !this.isBoss) { // il ne peut pas et  ce n'est pas un boss
                getSoinsSpell().castOnTarget(this);
                Spell.increaseRecharge(this);
                return getSoinsSpell().toString();
            }
            else if (getSoinsSpell().canCastSpell() && this.isBoss) {
                // aléatoirement, on selectionne parmi les sorts de boss
                int randint = new Random().nextInt(3);
                switch(randint) {
                    case 0:
                        return this.regeneration();
                    case 1:
                        return this.increaseHP();
                    case 2:
                        return this.invulnerability();
                }
                return this.regeneration();
            }
            else {  // si le sort n'est malheureusement pas dispo...
                getDamageSpell().castOnTarget(target);
                return getDamageSpell().toString();
            }
        }
        else {
            getDamageSpell().castOnTarget(target);
            return getDamageSpell().toString(); // Par défaut : il lance un damage quand même !
        }
    }

    private Degats getDamageSpell() {
        for(Spell s : spells) {
            if(s instanceof Degats) {
                if(s.getTarget() != null) {
                    ((Degats) s).setHpDamage((int) (super.getDamageIncrease() * ((Degats) s).getHpDamage()));
                }
                return (Degats) s;
            }
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
    public String regeneration() {
        if(this.isBoss) {
            int hpheal = this.getCurrentHP() / (1 + new Random().nextInt(2));
            super.heal(hpheal);
            return "Le boss se régènere " + hpheal + " hp";
        }
        return null;
    }

    @Override
    public String defenseIncrease() {
        if(this.isBoss){
            int curDefense = this.getDefense();
            this.setDefense((int)(1.3*curDefense));
            return "Le boss a une défense augmenté de 30%";
        }
        return "";
    }

    @Override
    public String invulnerability() {
        if (this.isBoss) {
            this.setVulnerable(false);
            return "Le monstre est invulnérable pour ce tour";
        }
        return "";
    }

    @Override
    public String increaseHP() {
        if(this.isBoss) {
            this.setMaximumHP(this.getMaximumHP() + 150);
            this.setHP(this.getMaximumHP());
            return "Les HP du monstre sont augmentés de 150 hp";
        }
        return "";
    }

    @Override
    public String toString() {
        String boss = "";
        if(this.isBoss)
            boss = " *** BOSS *** ";
        return "[" + getClass().getSimpleName() + "] " + boss +  super.toString();
    }
}
