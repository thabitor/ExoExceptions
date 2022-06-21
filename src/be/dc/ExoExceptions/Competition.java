package be.dc.ExoExceptions;

import be.dc.ExoExceptions.Exceptions.CompetitionEndedException;
import be.dc.ExoExceptions.Exceptions.PlayerAlreadyRegisteredException;
import be.dc.ExoExceptions.Exceptions.PlayerNotRegisteredException;
import be.dc.ExoExceptions.Exceptions.RegistrationLimitException;
import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class Competition {

    private int limiteParticipant;
    private ArrayList<Sportif> listPlayers = new ArrayList<>();
    private ArrayList<Integer> performanceArray = new ArrayList<>();

    private boolean estTermine;
    private Sportif winner;

    private HashMap<Sportif, Integer> playersPerformance;


    public Competition(int limiteParticipant) {
        this.limiteParticipant = limiteParticipant;
    }

    public ArrayList<Sportif> inscrire(Sportif x) throws Exception {

//        try {
            if (listPlayers.size() == 0) {
                listPlayers.add(x);
            } else if (listPlayers.size() < limiteParticipant) {
                for (Sportif s : listPlayers) {
                    if (s == x) {
                        throw new PlayerAlreadyRegisteredException(); // Exception for the player is already registered;
                    }
                }
                listPlayers.add(x);
            } else {
                throw new RegistrationLimitException(); // Exception for exceeding registration limit
            }
//        } catch (PlayerAlreadyRegisteredException | RegistrationLimitException ex) {
//            ex.getMessage();
        return listPlayers;
    }

    public void deInscrire(Sportif x) throws Exception {
        try {
            for (Sportif s : listPlayers) {
                if (s == x) {
                    listPlayers.remove(x);
                } else {
                    throw new Exception();  // Exception for player not being already registered
                }
            }
        } catch (PlayerNotRegisteredException ex) {
            ex.getMessage();
        }
    }

        public HashMap<Sportif, Integer> lancer () throws Exception {

            int playersSize = listPlayers.size();
            int performanceSize = performanceArray.size();
//            try {
            if (!estTermine) {
                for (Sportif player : listPlayers) {
                    this.performanceArray.add(player.perform());
                }
                if (playersSize == performanceSize) {
                    estTermine = true;
                    for (int i = 0; i < playersSize; i++) {
                        playersPerformance.put(listPlayers.get(i), performanceArray.get(i));
                    }
                }
            } else {
                throw new CompetitionEndedException(); // Exception that the competition is finished
            }
//            } catch (CompetitionEndedException ex) {
//                ex.getMessage();
//            }
            return playersPerformance;
        }

        public Sportif getWinner () {
            if (estTermine) {
                int maxPerformance = (Collections.max(playersPerformance.values()));
                for (Map.Entry<Sportif, Integer> entry : playersPerformance.entrySet()) {
                    if (entry.getValue() == maxPerformance) {
                        winner = entry.getKey();
                    }
                }
            }
            return winner;
        }

        public boolean estTermine () {
            return estTermine;
        }

        public int getLimiteParticipant () {
            return limiteParticipant;
        }

        public ArrayList<Sportif> getListPlayers () {
            return listPlayers;
        }

        public void setLimiteParticipant ( int limiteParticipant){
            this.limiteParticipant = limiteParticipant;
        }

    public HashMap<Sportif, Integer> getPlayersPerformance() {
        return playersPerformance;
    }
}
