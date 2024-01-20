package codes;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Tarifnormal {
    public static void window() {
        JFrame f = new JFrame();
        f.setTitle("ONCF");
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        JPanel mainPanel = new JPanel();
        
        Statement st = Connexion.connectONCF();
        
        ArrayList<String> gares = new ArrayList<String>();
        Set<String> dates = new HashSet<String>();
        try {
            ResultSet res = st.executeQuery("select * from gares");
            while (res.next()) {
                gares.add(res.getString(2));
            }
            ResultSet restrain = st.executeQuery("select * from train");
            while (restrain.next()) {
            	String datePart = Todate.convertTimestampToDate(restrain.getString(3));
                dates.add(datePart);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String[] gare = gares.toArray(new String[0]);
        String[] date = dates.toArray(new String[0]);

        
        final JComboBox<String> departComboBox = new JComboBox<String>(gare);
        final JComboBox<String> arriveeComboBox = new JComboBox<String>(gare);
        final JComboBox<String> listdate = new JComboBox<String>(date);
        final Poucent poucentInstance = new Poucent();
        poucentInstance.setValue(0);
        
        JButton submitButton = new JButton("Suivant");
        JButton returnButton = new JButton("Retour");
        GoTo.train(submitButton,departComboBox,arriveeComboBox,listdate,poucentInstance);
        GoTo.page(returnButton);
       
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(submitButton);
        buttonPanel.add(returnButton);
        Styles.organiserNormal(mainPanel,buttonPanel,departComboBox,arriveeComboBox,listdate);
        Styles.bgColor(mainPanel);
        Styles.buttonStyle(returnButton);
        Styles.buttonStyle(submitButton);
        f.setContentPane(mainPanel);
        f.setVisible(true);
    }
    
}