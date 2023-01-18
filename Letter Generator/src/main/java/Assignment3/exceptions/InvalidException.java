package Assignment3.exceptions;

/**
 * @author nikethaanand
 * class InvalidException exception handling class
 */
    public class InvalidException extends RuntimeException {
    /**
     *
     * @param message the message to be printed as error
     */
    public InvalidException(String message) {
            super(message);
        }
    }


