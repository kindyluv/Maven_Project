package africa.semicolon.bloggingProject.exception;

public class DuplicatePostTrackingIdException extends RuntimeException{

    public DuplicatePostTrackingIdException(String message) {
        super(message);
    }
}
