package destiny.mover;

import destiny.inventory.Inventory;
import destiny.sorts.Degats;
import destiny.sorts.Spell;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * The type Player.
 */
public class Player extends Mover implements Serializable {

    private Inventory inventory;
    private Mover target;

    private int currentMonsterIndex;


    /**
     * Instantiates a new Player.
     *
     * @param name   son nom
     * @param HP     son nombre de points de vie
     * @param spells les spells du joueur
     */
    public Player(String name, int HP, ArrayList<Spell> spells) {
        super(name, HP, spells);
        this.inventory = new Inventory(5);
    }

    /**
     * Sets inventory.
     *
     * @param inventory the inventory
     */
    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    /**
     * Gets inventory.
     *
     * @return the inventory
     */
    public Inventory getInventory() { return this.inventory; }

    /**
     * Change target.
     *
     * @param target the target
     */
    public void changeTarget(Mover target) {
        this.target = target;
    }

    /**
     * Gets target.
     *
     * @return the target
     */
    public Mover getTarget() { return this.target; }

    @Override
    public boolean castSpell(Spell spell) {
        boolean canCast = true;
        ArrayList<Spell> lstSpells = super.getSorts();
        if(lstSpells.contains(spell)) {
            if(spell.getTarget() == null)
                canCast = spell.castOnTarget(target); // TODO
            else
                canCast = spell.castOnTarget(spell.getTarget());
        }
        return canCast;
    }

    @Override
    public String toString() {
        if(target != null)
            return "[" + getClass().getSimpleName() + "] " + super.toString() + " \nTarget : " + target.toString();
        else
            return "[" + getClass().getSimpleName() + "] " + super.toString();
    }

    /**
     * fonction qui permet de retrouver les sorts de type Degats
     * @return La liste des sorts de dégats de ce personnage
     */
    public ArrayList<Spell> getSortsDegat() {
        ArrayList<Spell> spells = new ArrayList<>();
        for(Spell s : super.getSorts()) {
            if(s.getClass().getSimpleName().equals(Degats.class.getSimpleName())) {
                spells.add(s);
            }
        }
        return spells;
    }

    /**
     * Cette fonction permet d'augmenter l'indice du monstre sur lequel on combat
     * pour passer au monstre suivant.
     */
    public void increaseMonsterIndex() {
        this.currentMonsterIndex++;
    }

    public void setCurrentMonsterIndex(int currentMonsterIndex) {
        this.currentMonsterIndex = currentMonsterIndex;
    }

    public int getCurrentMonsterIndex() {
        return this.currentMonsterIndex;
    }

}