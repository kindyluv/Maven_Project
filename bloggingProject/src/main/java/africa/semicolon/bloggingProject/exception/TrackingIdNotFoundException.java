package africa.semicolon.bloggingProject.exception;

public class TrackingIdNotFoundException extends RuntimeException{

    public TrackingIdNotFoundException(String message){
        super(message);
    }
}
