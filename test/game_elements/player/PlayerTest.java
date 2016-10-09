package game_elements.player;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {

    private static Player player;

    @Before
    public void setUp() throws Exception {
        player = new Player();
    }

    @Test
    public void getMoney() throws Exception {
        assertTrue("getMoney quand il vient d'être créé", player.getMoney() == 0);
        player.giveMoney(500);
        assertTrue("getMoney en donnant un nombre entier positif", player.getMoney() == 500);
        player.giveMoney(-500);
        assertTrue("getMoney en donnant un nombre entier négatif", player.getMoney() == 1000);
        player.giveMoney(0);
        assertTrue("getMoney en donnant un nombre nul", player.getMoney() == 1000);
    }

    @Test
    public void getDebt() throws Exception {
        assertTrue("getDebt initial", player.getDebt() == 0);
        player.addDebt(-500);
        assertTrue("getDebt nb négatif", player.getDebt() == 500);
        player.addDebt(500);
        assertTrue("getDebt nb positif", player.getDebt() == 1000);
    }

    @Test
    public void getSalary() throws Exception {

    }

    @Test
    public void getProfession() throws Exception {

    }

    @Test
    public void getPosition() throws Exception {

    }

    @Test
    public void getFamily() throws Exception {

    }

    @Test
    public void getPlayerMarried() throws Exception {

    }

    @Test
    public void giveMoney() throws Exception {
        // Même test que pour getMoney
        assertTrue("getMoney quand il vient d'être créé", player.getMoney() == 0);
        player.giveMoney(500);
        assertTrue("getMoney en donnant un nombre entier positif", player.getMoney() == 500);
        player.giveMoney(-500);
        assertTrue("getMoney en donnant un nombre entier négatif", player.getMoney() == 1000);
        player.giveMoney(0);
        assertTrue("getMoney en donnant un nombre nul", player.getMoney() == 1000);
    }

    @Test
    public void withdrawMoney() throws Exception {

    }

    @Test
    public void addDebt() throws Exception {
        assertTrue("getDebt initial", player.getDebt() == 0);
        player.addDebt(-500);
        assertTrue("getDebt nb négatif", player.getDebt() == 500);
        player.addDebt(500);
        assertTrue("getDebt nb positif", player.getDebt() == 1000);
    }

    @Test
    public void refundDebt() throws Exception {

    }

}