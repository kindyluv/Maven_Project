package africa.semicolon.beansAppProject.exception;

public class DuplicateCustomerException extends RuntimeException{

    public DuplicateCustomerException(String message) {
        super(message);
    }
}
