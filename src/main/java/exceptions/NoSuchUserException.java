package exceptions;

public class NoSuchUserException extends RuntimeException {
    public NoSuchUserException() {
        super("No such user exception");
    }

    public NoSuchUserException(String message) {
        super(message);
    }
}
