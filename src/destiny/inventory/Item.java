package destiny.inventory;

import destiny.mover.Mover;

public class Item {
    private final ItemEffect itemEffect;
    private int quantity;

    public Item(ItemEffect effect, int quantity) {
        this.itemEffect = effect;
        this.quantity = quantity;
    }

    public void useItemOnMover(Mover mover) {
        switch(itemEffect) {
            case HEAL:
                this.quantity--;
                mover.heal(50); // TODO
                break;
            case DEFENSE_INCREASE: // TODO
                this.quantity--;
                mover.setDefense(mover.getDefense() + 50);
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