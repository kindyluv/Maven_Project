package africa.semicolon.beansAppProject.exception;

public class InvalidEmailAddressException extends RuntimeException{

    public InvalidEmailAddressException(String message) {
        super(message);
    }
}
