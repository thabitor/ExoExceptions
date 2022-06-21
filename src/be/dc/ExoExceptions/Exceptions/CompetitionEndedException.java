package be.dc.ExoExceptions.Exceptions;

public class CompetitionEndedException extends Exception {
    public CompetitionEndedException() {
        super("This competition has already ended!");
    }
}
