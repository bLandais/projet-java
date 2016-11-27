package destiny.inventory;

import destiny.GameManager;
import destiny.mover.Mover;
import destiny.mover.Player;
import destiny.sorts.Degats;
import destiny.sorts.Spell;

import java.io.Serializable;

/**
 * The type Item.
 */
public class Item implements Serializable {
    private final ItemEffect itemEffect;
    private int quantity;

    /**
     * Instantiates a new Item.
     *
     * @param effect   the effect
     * @param quantity the quantity
     */
    public Item(ItemEffect effect, int quantity) {
        this.itemEffect = effect;
        this.quantity = quantity;
    }

    /**
     * La quantité est décrémentée de 1.
     */
    private void decreaseQuantity() {
        if(quantity >= 1) {
            this.quantity--;
        }
        else
            this.quantity =0;
    }

    /**
     * Use item on mover.
     *
     * @param mover le mover sur lequel l'item sera utilisé
     */
    public void useItemOnMover(Mover mover) {
        useItemOnMover(mover, this.itemEffect);
    }

    /**
     * Use item on mover.
     *
     * @param mover  Mover qui va subir l'effet de l'item
     * @param effect the effect
     */
    public void useItemOnMover(Mover mover, ItemEffect effect) {
        decreaseQuantity();
        switch(effect) {
            case FULL_HEAL:
                mover.heal(mover.getMaximumHP() - mover.getCurrentHP());
                System.out.println("Utilisation de l'objet de soins : HP max");
                break;
            case DEFENSE_INCREASE: // TODO
                mover.setDefense(mover.getDefense() + 50);
                System.out.println("Utilisation de l'objet de défense");
                break;
            case ATTACK:
                GameManager.player.setDamageIncrease(mover.getDamageIncrease() * 1.5f);
                System.out.println("Utilisation de l'objet des dégats * 1.5");
                break;
            case RESET:
                for(Spell spell : mover.getSorts()) {
                    spell.setCurrentRound(spell.getRechargeRound()); // le sort est prêt a être lancé !
                }
                System.out.println("Utilisation de l'objet de remise à zéro");
                break;
            case SURPRISE:
                useItemOnMover(mover, ItemEffect.values()[(int) (Math.random() * ItemEffect.values().length)]);
                break;
            default:
                break;
        }
    }

    @Override
    public String toString() {
        return "Item : " + itemEffect + " - Reste : " + quantity;
    }

    /**
     * Gets quantity.
     *
     * @return the quantity
     */
    public int getQuantity() { return this.quantity;}

    /**
     * Add quantity.
     *
     * @param quantity the quantity
     */
    public void addQuantity(int quantity) { this.quantity += quantity; }
}