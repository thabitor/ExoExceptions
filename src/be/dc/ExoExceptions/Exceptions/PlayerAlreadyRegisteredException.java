package be.dc.ExoExceptions.Exceptions;

public class PlayerAlreadyRegisteredException extends Exception {

    public PlayerAlreadyRegisteredException() {
        super("This player is already registered and cannot be registered again!");
    }
}

