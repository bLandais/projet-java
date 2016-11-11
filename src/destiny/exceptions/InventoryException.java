package destiny.exceptions;

public class InventoryException extends Exception {
    public enum ErrorType {
        EMPTY_ITEM
    }

    private ErrorType code_error;

    public InventoryException(ErrorType action) {
        this.code_error = action;
    }

    public void displayMessage() {
        switch (this.code_error) {
            case EMPTY_ITEM:
                System.out.println("Quantité insuffisante...");
                break;
        }
    }
}
