package destiny.sorts;

import destiny.mover.Player;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class SoinsTest {

    Player player;
    Soins spell_soin;

    @Before
    public void setUp() throws Exception {
        spell_soin = new Soins(40);
        ArrayList<Spell> spells = new ArrayList<Spell>();
        spells.add(new Soutiens(1.4f));
        player = new Player("spell caster", 120, spells);
    }

    @Test
    public void castOnMover() throws Exception {
        assertTrue("intial no heal", player.getHP() == 120);
        spell_soin.castOnMover(player);
        assertTrue("heal de 40", player.getHP() == 160);
    }

}