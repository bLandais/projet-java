package main.destin;

public class InputTypeException extends Exception {

    public InputTypeException() {
        System.err.println("Type de saisie incorrecte");
    }

    public InputTypeException(String message) {
        super(message);
    }

}
