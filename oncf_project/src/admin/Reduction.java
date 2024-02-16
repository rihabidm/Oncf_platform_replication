package admin;

import codes.*;
import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class Reduction {
    public static JPanel window() {

        try {
            Statement st = Connexion.connectONCF();
            ResultSet res = st.executeQuery("select * from reduction");

            // Créer un tableau de données pour stocker les résultats de la requête
            String[][] data = new String[25][5]; // Vous devrez peut-être ajuster la taille du tableau

            int rowCount = 0;
            while (res.next()) {
                String carte = res.getString(1);
                String code = res.getString(2);
                String pourcentage = res.getString(3);
                JButton modifier = new JButton("Modifier");
                JButton supprimer = new JButton("Supprimer");

                // Stocker les données dans le tableau
                data[rowCount][0] = carte;
                data[rowCount][1] = code;
                data[rowCount][2] = pourcentage;

                rowCount++;
            }

            // Créer un tableau avec les données
            String[] columnNames = {"Carte", "Code", "Pourcentage"};
            JTable table = new JTable(data, columnNames);

            // Ajouter le tableau à un JScrollPane
            JScrollPane scrollPane = new JScrollPane(table);
            mainPanel.add(scrollPane);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Styles.bgColor(mainPanel);
        return mainPanel;
    }
   
}
