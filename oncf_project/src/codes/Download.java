package codes;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Download {
    private String gareDepart;
    private String gareArrivee;
    private String date;
    private int prix;

    public Download(String gareDepart, String gareArrivee, String date, int prix) {
        this.gareDepart = gareDepart;
        this.gareArrivee = gareArrivee;
        this.date = date;
        this.prix = prix;
    }

    public void ticket() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Ticket.txt"))) {
            writer.write("Gare de départ: " + gareDepart);
            writer.newLine();
            writer.write("Gare d'arrivée: " + gareArrivee);
            writer.newLine();
            writer.write("date: " + date);
            writer.newLine();
            writer.write("Prix: " + prix);
            System.out.println("Ticket généré avec succès!");
        } catch (IOException e) {
            System.err.println("Erreur lors de la création du ticket : " + e.getMessage());
        }
    }
}


