package game_elements.cases;

import game_elements.actions.Action;
import game_elements.cases.Case;

public class CaseRouge implements Case {

    private Action action;

    @Override
    public void doAction() {

    }

    @Override
    public String toString() {
        return action.toString();
    }

    @Override
    public boolean equals(Object obj) {
        return false; // TODO
    }
}
