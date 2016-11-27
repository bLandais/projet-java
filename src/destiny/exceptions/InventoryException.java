package destiny.exceptions;

/**
 * The type Inventory exception.
 */
public class InventoryException extends Exception {
    /**
     * Le type d'erreur dans l'inventaire
     */
    public enum ErrorType {
        EMPTY_ITEM
    }

    private ErrorType code_error;

    /**
     * Instantiates a new Inventory exception.
     *
     * @param action the action
     */
    public InventoryException(ErrorType action) {
        this.code_error = action;
    }

    /**
     * Affiche l'erreur
     */
    public void displayMessage() {
        switch (this.code_error) {
            case EMPTY_ITEM:
                System.out.println("Quantité insuffisante...");
                break;
            default:
                System.out.println("Erreur avec cet objet...");
                break;
        }
    }
}
