package game_elements.actions;

public abstract class Action {

    private ActionType actionType;
    private String description;

    public abstract void doCaseAction();
    public abstract void doCarteAction();

}
