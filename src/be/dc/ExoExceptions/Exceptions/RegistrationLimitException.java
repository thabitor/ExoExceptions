package be.dc.ExoExceptions.Exceptions;

public class RegistrationLimitException extends Exception {

    public RegistrationLimitException() {
        super("Registration limit reached");
    }
}
