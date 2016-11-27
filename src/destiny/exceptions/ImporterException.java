package destiny.exceptions;

/**
 * The type Importer exception.
 */
public class ImporterException extends Exception {

    /**
     * Instantiates a new Importer exception.
     */
    public ImporterException() {}

    /**
     * Instantiates a new Importer exception.
     *
     * @param message the message
     */
    public ImporterException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Importer exception.
     *
     * @param exception the exception
     */
    public ImporterException(Throwable exception) {
        super(exception);
    }

    /**
     * Instantiates a new Importer exception.
     *
     * @param message   the message
     * @param exception the exception
     */
    public ImporterException(String message, Throwable exception) {
        super(message, exception);
    }

}