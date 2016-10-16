package game_elements.player;

import game_elements.player.family.Sexe;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {
    private static Player player;

    @Before
    public void setUp() throws Exception {
        player = new Player("PlayerTest", Sexe.MASCULIN);
    }

    @Test
    public void getName() throws Exception {
        assertTrue("nom initial", player.getName().equals("PlayerTest"));
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
        // TODO
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
        assertTrue("joueur pas marié", player.getHusbandOrWife() == null);
        player.getPlayerMarried();
        assertTrue("joueur marié", player.getHusbandOrWife() != null);
        Player player2 = new Player("feminim", Sexe.FEMININ);
        player2.getPlayerMarried();
        assertTrue("joueuse mariée", player.getHusbandOrWife() != null);
        assertTrue("joueuse mariée", player.getFamily().size() > 0);
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
        int moneyInitiale = player.getMoney();
        player.withdrawMoney(200);
        assertTrue("on retire 200€ du compte", player.getMoney() == moneyInitiale - 200);
        player.withdrawMoney(-200);
        assertTrue("on retire avec un nombre négatif", player.getMoney() == moneyInitiale - 400);
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
        int detteInitiale = player.getDebt();
        player.refundDebt(200);
        assertTrue("rajoute une dette de 200€ donc -200", player.getDebt() == detteInitiale - 200);
        player.refundDebt(-200);
        assertTrue("avec un nombre négatif", player.getDebt() == detteInitiale - 400);
    }

}