package destiny.sorts;

import destiny.mover.PlayerTest;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SpellTest {
    Spell spell;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void getPercentCritic() throws Exception {

    }

    @Test
    public void getRechargeRound() throws Exception {

    }

    @Test
    public void setPercentCritic() throws Exception {

    }

    @Test
    public void setRechargeRound() throws Exception {
        spell = new Soins(PlayerTest.player, 3);
        assertTrue(spell.getRechargeRound() == 3);
        spell.setRechargeRound(-4);
        assertTrue(spell.getRechargeRound() == 0);
    }

}