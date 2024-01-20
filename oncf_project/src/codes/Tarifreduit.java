package codes;
import java.sql.*;

import javax.swing.*;




import java.awt.*;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;


public class Tarifreduit {
	
    public static void window() {
        JFrame f = new JFrame();
        f.setTitle("ONCF");
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel mainPanel = new JPanel(new GridBagLayout());
        final Poucent poucentInstance = new Poucent();
        
        
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20,20, 20));

        
        ArrayList<String> gares = new ArrayList<String>();
        Set<String> cartes = new HashSet<String>();
        Set<String> dates = new HashSet<String>();
        final ArrayList<RedData> data = new ArrayList<RedData>();
        try {
        	Statement st = Connexion.connectONCF();
            ResultSet resGare = st.executeQuery("select * from gares");
            while (resGare.next()) {
                gares.add(resGare.getString(2));
            }
            ResultSet restrain = st.executeQuery("select * from train");
            while (restrain.next()) {
            	String datePart = Todate.convertTimestampToDate(restrain.getString(3));
                dates.add(datePart);
            }

            
            resGare.close();

            st = Connexion.connectONCF(); 
            ResultSet resRed = st.executeQuery("select * from reduction");
            while (resRed.next()) {
                cartes.add(resRed.getString(1));
                String card = resRed.getString(1);  
                String code = resRed.getString(2);  
                int pourcentage = resRed.getInt(3);  
                Poucent poucentage=new Poucent();
                poucentage.setValue(pourcentage);
                RedData user = new RedData(card, code, pourcentage);
                data.add(user);
            }
            
            resRed.close();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String[] gare = gares.toArray(new String[0]);
        String[] carte = cartes.toArray(new String[0]);
        String[] date = dates.toArray(new String[0]);

        
        final JComboBox<String> departComboBox = new JComboBox<String>(gare);
        final JComboBox<String> arriveeComboBox = new JComboBox<String>(gare);
        final JComboBox<String> listdate = new JComboBox<String>(date);
        final JComboBox<String> maCarte = new JComboBox<String>(carte);
        JTextField dateTextField = new JTextField();
        dateTextField.setColumns(10);
        final JTextField monCode = new JTextField();
        monCode.setColumns(10);
        
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton submitButton = new JButton("Suivant");
        JButton returnButton = new JButton("Retour");
        GoTo.page(returnButton);
        GoTo.trainreduit(submitButton,data,departComboBox,arriveeComboBox,listdate,monCode,maCarte,poucentInstance);
        buttonPanel.add(submitButton);
        buttonPanel.add(returnButton);
        Styles.organiserReduit(mainPanel,buttonPanel,maCarte,monCode,departComboBox,arriveeComboBox,listdate);
        Styles.bgColor(mainPanel);
        Styles.buttonStyle(returnButton);
        Styles.buttonStyle(submitButton);
        f.setContentPane(mainPanel);
        f.setVisible(true);
    }
    
    
    
}
