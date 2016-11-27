package destiny.exceptions;

/**
 * The type Argument action exception.
 */
public class ArgumentActionException extends Exception {

    /**
     * Les cas possibles d'erreur
     */
    public enum CaseAction {
        SPELL,
        INVENTORY
    }

    private CaseAction code_error;

    /**
     * Instantiates a new Argument action exception.
     *
     * @param action the action
     */
    public ArgumentActionException(CaseAction action) {
        this.code_error = action;
    }

    /**
     * Affiche le message d'erreur
     */
    public void displayMessage() {
        switch (this.code_error) {
            case SPELL:
                System.out.println("Identifiant de sort inconnu, veuillez recommencer...");
                break;
            case INVENTORY:
                System.out.println("Identifiant de l'item inconnu,  veuillez recommencer...");
                break;
            default:
                System.out.println("Erreur, veuillez recommencer...");
                break;
        }
    }

    /**
     * Instantiates a new Argument action exception.
     *
     * @param exception the exception
     */
    public ArgumentActionException(Throwable exception) {
        super(exception);
    }

    /**
     * Instantiates a new Argument action exception.
     *
     * @param message   the message
     * @param exception the exception
     */
    public ArgumentActionException(String message, Throwable exception) {
        super(message, exception);
    }

}