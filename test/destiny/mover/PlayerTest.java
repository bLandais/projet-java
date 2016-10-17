package destiny.mover;

import destiny.sorts.Degats;
import destiny.sorts.Soutiens;
import destiny.sorts.Spell;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class PlayerTest {

    Player player;

    @Before
    public void setUp() throws Exception {
        ArrayList<Spell> spells = new ArrayList<Spell>();
        spells.add(new Soutiens(1.2f));
        spells.add(new Degats(15)); // We do not care the spells for now
        player = new Player("First", 150, spells);
    }

    @Test
    public void castSpell() throws Exception {
        player.castSpell();
        // TODO
    }

}