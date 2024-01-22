package codes;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Ticket {
    public static void window(final String gd,final String ga,final String d ,final int p) {
        JFrame f = new JFrame();
        f.setTitle("ONCF");
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel mainPanel = new JPanel();
        Styles.bgColor(mainPanel);
        

        JButton downloadButton = new JButton("Télécharger ticket");
        Styles.buttonStyle(downloadButton);
        Styles.buttonSize(200, 50, downloadButton);
        Styles.centerButtons(mainPanel, downloadButton);

        // Add ActionListener to handle the button click event
        downloadButton.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                 Download telecharger= new Download(gd,ga,d,p);
                 telecharger.ticket();
            }
        });

        f.setContentPane(mainPanel);
        f.setVisible(true);
    }

    
}