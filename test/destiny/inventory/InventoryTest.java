package destiny.inventory;

import destiny.mover.Player;
import destiny.sorts.Degats;
import destiny.sorts.Soutiens;
import destiny.sorts.Spell;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class InventoryTest {
    Player player;

    @Before
    public void setUp() throws Exception {
        ArrayList<Spell> spells = new ArrayList<Spell>();
        spells.add(new Soutiens(1.2f));
        spells.add(new Degats(15, 0)); // We do not care the spells for now
        player = new Player("name", 100, spells);
        player.getInventory().addItem(new Item(ItemEffect.FULL_HEAL, 1));
        player.getInventory().addItem(new Item(ItemEffect.DEFENSE_INCREASE, 3));
    }

    @Test
    public void testToString() throws Exception {

    }

    @Test
    public void getNbSlots() throws Exception {
        assertTrue("nb slots", player.getInventory().getNbSlots() == 5);
    }

    @Test
    public void getItems() throws Exception {

    }

}