package be.dc.ExoExceptions;

import java.util.Random;

public class Sportif {

    private String prenom;
    private String Nom;
    private int anneeNaissance;



    public Sportif(String prenom, String nom, int dateNaissance) {
        this.prenom = prenom;
        Nom = nom;
        this.anneeNaissance = dateNaissance;
    }

    public int perform() {
        Random rand = new Random();
        int performance = rand.nextInt(100);
        return performance;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNom() {
        return Nom;
    }

    public int getAnneeNaissance() {
        return anneeNaissance;
    }

}
