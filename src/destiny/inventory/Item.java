package destiny.inventory;

import destiny.mover.Mover;

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

    public void useItemOnMover(Mover mover, ItemEffect effect) {
        switch(itemEffect) {
            case FULL_HEAL:
                this.quantity--;
                mover.heal(mover.getMaximumHP() - mover.getCurrentHP());
                break;
            case DEFENSE_INCREASE: // TODO
                this.quantity--;
                mover.setDefense(mover.getDefense() + 50);
                break;
            case ATTACK:
                break;
            case RESET:
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