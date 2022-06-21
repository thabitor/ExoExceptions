package be.dc.ExoExceptions;

import be.dc.ExoExceptions.Exceptions.CompetitionEndedException;
import be.dc.ExoExceptions.Exceptions.PlayerAlreadyRegisteredException;
import be.dc.ExoExceptions.Exceptions.RegistrationLimitException;

public class Main {
    public static void main(String[] args) throws Exception {

        Sportif player1 = new Sportif("Roger", "Federer", 1985);
        Sportif player2 = new Sportif("Simona", "Halep", 1988);
        Sportif player3 = new Sportif("Paula", "Badosa", 1995);
        Sportif player4 = new Sportif("Serena", "Williams", 1997);
        Sportif player5 = new Sportif("Andy", "Murray", 1988);

        Competition firstRound = new Competition(3);
        Competition secondRound = new Competition(4);
        Competition thirdRound = new Competition(5);

        try {
            firstRound.inscrire(player1);
            firstRound.inscrire(player2);
            firstRound.inscrire(player4);
            firstRound.lancer();
            System.out.println(firstRound.getPlayersPerformance());
        } catch (PlayerAlreadyRegisteredException | RegistrationLimitException | CompetitionEndedException ex) {
            System.out.println(ex.getMessage());
        }
    }


}
