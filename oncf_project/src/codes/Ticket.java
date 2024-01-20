package codes;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Ticket {
    public static void window() {
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
            @Override
            public void actionPerformed(ActionEvent e) {
                downloadTicket(); // Call your download ticket logic here
            }
        });

        f.setContentPane(mainPanel);
        f.setVisible(true);
    }

    private static void downloadTicket() {
        try {
            // Create a temporary file to simulate the ticket
            File ticketFile = File.createTempFile("train_ticket", ".txt");

            // Write ticket information to the file
            FileWriter writer = new FileWriter(ticketFile);
            writer.write("Passenger Name: John Doe\n");
            writer.write("Train Number: 1234\n");
            writer.write("Departure Time: 12:00 PM\n");
            writer.write("Arrival Time: 03:00 PM\n");
            writer.write("Seat Number: A-12\n");
            writer.close();

            // Display a message or perform any other actions related to ticket download
            JOptionPane.showMessageDialog(null, "Ticket downloaded successfully: " + ticketFile.getAbsolutePath());
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error downloading the ticket.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                window();
            }
        });
    }
}

class Styles {
    public static void bgColor(JPanel panel) {
        panel.setBackground(new Color(255, 255, 204));
    }

    public static void buttonStyle(JButton button) {
        button.setFont(new Font("Arial", Font.BOLD, 16));
    }

    public static void buttonSize(int width, int height, JButton button) {
        button.setPreferredSize(new Dimension(width, height));
    }

    public static void centerButtons(JPanel panel, JButton button) {
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel.add(button);
    }
}