package admin;
import codes.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class Choix {
	public static void window() {
        JFrame f = new JFrame();
        f.setTitle("ONCF");
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        JButton b1 = new JButton("Les reduction");
        JButton b2 = new JButton("Les trains");
        JButton b3 = new JButton("Les utilisateurs");
        
        
        GoTo.reduction(b1);
        GoTo.trains(b2);
        GoTo.utilisateur(b3);
        
        Styles.bgColor(mainPanel);
        Styles.buttonStyle(b1);
        Styles.buttonStyle(b2);
        Styles.buttonSize(500, 100, b1);
        Styles.buttonSize(500, 100,b2);
        Styles.centerButtons(mainPanel, b1,b2);
        
        
        f.setContentPane(mainPanel);
        f.setVisible(true);
    }
}
