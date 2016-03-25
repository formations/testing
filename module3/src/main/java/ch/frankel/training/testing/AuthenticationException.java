package ch.frankel.training.testing;

@SuppressWarnings("serial")
public class AuthenticationException extends RuntimeException {
    public AuthenticationException() {
        // NOTHING TO DO HERE
    }

    public AuthenticationException(Exception e) {
        super(e);
    }
}
