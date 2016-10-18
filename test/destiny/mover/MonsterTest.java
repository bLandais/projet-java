package destiny.mover;

import destiny.sorts.Degats;
import destiny.sorts.Soutiens;
import destiny.sorts.Spell;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class MonsterTest {

    Monster monster;

    @Before
    public void setUp() throws Exception {
        ArrayList<Spell> spells = new ArrayList<Spell>();
        spells.add(new Soutiens(1.2f));
        spells.add(new Degats(15)); // We do not care the spells for now
        monster = new Monster("Big monster", 150, spells);
    }

    @Test
    public void castSpell() throws Exception {

    }

    @Test
    public void regeneration() throws Exception {
        int hpInitial = monster.getHP();
        monster.regeneration();
        assertTrue("hp cohérant", hpInitial <= monster.getHP());
    }

    @Test
    public void defenseIncrease() throws Exception {

    }

    @Test
    public void invulnerability() throws Exception {
        monster.invulnerability();
        assertTrue("variable modifiée", monster.getVulnerable() == false);
        int hpInitial = monster.getHP();
        monster.getSorts().get(1).castOnMover(monster);
        assertTrue("pas de changement HP", monster.getHP() == hpInitial);
        // TODO : passer des tours et voir si l'invulnerabilité s'enleve
    }

}