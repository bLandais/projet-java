package destiny.inventory;

import destiny.mover.Mover;
import destiny.mover.Player;
import destiny.sorts.Degats;
import destiny.sorts.Spell;

import java.io.Serializable;

public class Item implements Serializable {
    private final ItemEffect itemEffect;
    private int quantity;

    public Item(ItemEffect effect, int quantity) {
        this.itemEffect = effect;
        this.quantity = quantity;
    }

    public void useItemOnMover(Mover mover) {
        useItemOnMover(mover, this.itemEffect);
    }

    /**
     *
     * @param mover Mover qui va subir l'effet de l'item
     * @param effect
     */
    public void useItemOnMover(Mover mover, ItemEffect effect) {
        switch(effect) {
            case FULL_HEAL:
                this.quantity--;
                mover.heal(mover.getMaximumHP() - mover.getCurrentHP());
                break;
            case DEFENSE_INCREASE: // TODO
                this.quantity--;
                mover.setDefense(mover.getDefense() + 50);
                break;
            case ATTACK:
                this.quantity--;
                // TODO : Corriger car l'effet de l'item d'attaque ne change pas les damage
                for(Spell spell : (((Player)mover).getSortsDegat())) {
                    mover.setDamageIncrease(mover.getDamageIncrease() * 1.5f);
                    ((Degats) spell).setHpDamage(((Degats)spell).getHpDamage() * (int)mover.getDamageIncrease());
                }
                break;
            case RESET:
                for(Spell spell : mover.getSorts()) {
                    spell.setCurrentRound(spell.getRechargeRound()); // le sort est prêt a être lancé !
                }
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

    public int getQuantity() { return this.quantity;}
    public void addQuantity(int quantity) { this.quantity += quantity; }
}