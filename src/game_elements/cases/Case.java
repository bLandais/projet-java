package game_elements.cases;

import game_elements.actions.Action;
import game_elements.player.Player;

public abstract class Case {

    protected Action action;

    abstract void doAction(Player player);

}
