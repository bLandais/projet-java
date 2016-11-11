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
        spell_soin = new Soins(40, 3);
        ArrayList<Spell> spells = new ArrayList<Spell>();
        spells.add(new Soutiens(1.4f));
        player = new Player("spell caster", 120, spells);
    }

    @Test
    public void castOnMover() throws Exception {
        assertTrue("intial no heal", player.getCurrentHP() == 120);
        spell_soin.castOnMover(player);
        assertTrue("heal de 40, vie max", player.getCurrentHP() == 120); // il est au max de sa vie
        player.damage(20);
        spell_soin.castOnMover(player);
        assertTrue("heal de 40, mais vie pas au max", player.getCurrentHP() == 120);
        player.damage(60);
        spell_soin.castOnMover(player);
        assertTrue("heal de 40, mais vie pas au max", player.getCurrentHP() == 100);
        player.damage(130); // DEAD
        spell_soin.castOnMover(player);
        assertTrue("heal mais il est mort donc incastable", player.getCurrentHP() == 0); // Dead
    }

}