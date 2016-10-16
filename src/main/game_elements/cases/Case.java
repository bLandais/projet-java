package main.game_elements.cases;

import main.game_elements.actions.Action;
import main.game_elements.player.Player;

public abstract class Case {

    protected Action action;

    abstract void doAction(Player player);

}
