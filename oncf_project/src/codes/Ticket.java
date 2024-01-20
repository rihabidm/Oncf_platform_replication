package codes;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class Ticket {
	public static void window() {
        JFrame f = new JFrame();
        f.setTitle("ONCF");
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel mainPanel = new JPanel();
        Styles.bgColor(mainPanel);
        JButton b1 = new JButton("Télécharger ticket");
        Styles.buttonStyle(b1);
        Styles.buttonSize(500, 100, b1);
        Styles.centerButtons(mainPanel, b1);
        f.setContentPane(mainPanel);
        f.setVisible(true);
    }
}
