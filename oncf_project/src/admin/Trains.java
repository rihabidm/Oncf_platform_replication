package admin;

import codes.*;
import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class Trains {
    public static JPanel window() {

        try {
            Statement st = Connexion.connectONCF();
            ResultSet res = st.executeQuery("select * from train");

            String[][] data = new String[100][6];

            int rowCount = 0;
            while (res.next()) {
                String depart = res.getString(1);
                String arivee = res.getString(2);
                String time = res.getString(3);
                String price = res.getString(4);
                JButton modifier = new JButton("Modifier");
                JButton supprimer = new JButton("Supprimer");

                // Stocker les données dans le tableau
                data[rowCount][0] = depart;
                data[rowCount][1] = arivee;
                data[rowCount][2] = time;
                data[rowCount][3] = price;

                rowCount++;
            }

            // Créer un tableau avec les données
            String[] columnNames = {"Gare Depart", "Gare Arrivee", "Date","Prix"};
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
