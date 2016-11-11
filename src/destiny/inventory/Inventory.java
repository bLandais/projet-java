package destiny.inventory;

import java.util.ArrayList;

public class Inventory {

    private final int nbSlots;
    private ArrayList<Item> items;

    public Inventory(int nbSlots) {
        this.nbSlots = nbSlots;
        this.items = new ArrayList<Item>(nbSlots);
    }

    @Override
    public String toString() {
        String str = "** Inventaire ** - Espace disponible : " + items.size() + "/" + nbSlots + " -- Appuyez sur l\n";
        return str;
    }

    public void addItem(Item item) {
        // On regarde s'il y a déjà cet item dans l'inventaire
        if (!items.contains(item)) {
            items.add(item);
        } else {
            items.get(items.indexOf(item)).addQuantity(item.getQuantity());
        }
    }

    public int getNbSlots() { return this.nbSlots; }
    public ArrayList<Item> getItems() { return this.items; }

    public void showInventory() {
        String str = "Liste des items dans l'inventaire :\n";
        int i = 0;
        for(Item item : items) {
            str += i + ") " + item.toString() + "\n";
            i++;
        }
        System.out.println(str);
    }
}