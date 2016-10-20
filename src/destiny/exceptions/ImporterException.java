package destiny.exceptions;

public class ImporterException extends Exception {

    public ImporterException() {}

    public ImporterException(String message) {
        super(message);
    }

    public ImporterException(Throwable exception) {
        super(exception);
    }

    public ImporterException(String message, Throwable exception) {
        super(message, exception);
    }

}
