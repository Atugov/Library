package exceptions;

public class NoSuchAuthorException extends RuntimeException {
    public NoSuchAuthorException() {
        super("No such author exception");
    }

    public NoSuchAuthorException(String message) {
        super(message);
    }
}
