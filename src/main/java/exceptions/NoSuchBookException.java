package exceptions;

public class NoSuchBookException extends RuntimeException {
    public NoSuchBookException() {
        super("No such book exception");
    }

    public NoSuchBookException(String message) {
        super(message);
    }
}
