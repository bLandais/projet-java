package destiny.mover;

import destiny.sorts.Degats;
import destiny.sorts.Soutiens;
import destiny.sorts.Spell;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class MonsterTest {

    Monster monster_boss;
    Monster monster;

    @Before
    public void setUp() throws Exception {
        ArrayList<Spell> spells = new ArrayList<Spell>();
        spells.add(new Soutiens(1.2f));
        spells.add(new Degats(15)); // We do not care the spells for now
        monster_boss = new Monster("Boss monster", 150, spells, true);
        monster = new Monster("Big Monster", 100, spells, false);
    }

    @Test
    public void castSpell() throws Exception {

    }

    @Test
    public void regeneration() throws Exception {
        int hpInitial = monster_boss.getHP();
        monster_boss.regeneration();
        assertTrue("hp cohérant", hpInitial <= monster_boss.getHP());
    }

    @Test
    public void defenseIncrease() throws Exception {
        int curDefense = monster.getDefense();
        int curDefenseBoss = monster_boss.getDefense();
        monster.defenseIncrease();
        monster_boss.defenseIncrease();
        assertFalse("defense increase monstre normal", monster.getDefense() > curDefense);
        assertTrue("defense increase boss", monster_boss.getDefense() >= curDefenseBoss);
    }

    @Test
    public void invulnerability() throws Exception {
        monster.invulnerability();
        assertTrue("monster pas invulnerable", monster.getVulnerable());
        int hpInitial = monster_boss.getHP();
        monster_boss.getSorts().get(1).castOnMover(monster_boss);
        assertTrue("degats sur vulnerable", monster_boss.getHP() == hpInitial - 15);
        monster_boss.invulnerability();
        assertFalse("variable modifiée", monster_boss.getVulnerable());
        hpInitial = monster_boss.getHP();
        monster_boss.getSorts().get(1).castOnMover(monster_boss);
        assertTrue("pas de changement HP", monster_boss.getHP() == hpInitial);
        // TODO : passer des tours et voir si l'invulnerabilité s'enleve
    }

}