package be.dc.ExoExceptions.Exceptions;

public class PlayerNotRegisteredException extends Exception {

    public PlayerNotRegisteredException() {
        super("This player is not registered!");
    }
}
