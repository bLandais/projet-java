package destiny.exceptions;

public class ArgumentActionException extends Exception {

    public enum CaseAction {
        SPELL,
        INVENTORY
    }

    private CaseAction code_error;

    public ArgumentActionException(CaseAction action) {
        this.code_error = action;
    }

    public void displayMessage() {
        switch (this.code_error) {
            case SPELL:
                System.out.println("Identifiant de sort inconnu, veuillez recommencer...");
                break;
            case INVENTORY:
                System.out.println("Identifiant de l'item inconnu,  veuillez recommencer...");
                break;
        }
    }

    public ArgumentActionException(Throwable exception) {
        super(exception);
    }

    public ArgumentActionException(String message, Throwable exception) {
        super(message, exception);
    }

}