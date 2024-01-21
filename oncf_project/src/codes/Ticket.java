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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


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
            
            public void actionPerformed(ActionEvent e) {
                downloadTicket(); // Call your download ticket logic here
            }
        });

        f.setContentPane(mainPanel);
        f.setVisible(true);
    }

    private static void downloadTicket(String username) {
        Connection connection = null;
        try {
            // Establish a database connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/oncf", "root", "");

            // Query to retrieve user information
            String query = "SELECT * FROM users WHERE username = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, username);
                ResultSet resultSet = preparedStatement.executeQuery();

                // Create a temporary file to store the ticket information
                File ticketFile = File.createTempFile("train_ticket", ".txt");

                // Write ticket information to the file
                try (FileWriter writer = new FileWriter(ticketFile)) {
                    if (resultSet.next()) {
                        writer.write("Passenger Name: " + resultSet.getString("username") + "\n");
                        // Add other user-specific data here
                    } else {
                        // User not found
                        JOptionPane.showMessageDialog(null, "User not found.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }

                // Display a message or perform any other actions related to ticket download
                JOptionPane.showMessageDialog(null, "Ticket downloaded successfully: " + ticketFile.getAbsolutePath());
            }
        } catch (SQLException | IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error downloading the ticket.", "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            // Close the database connection in the finally block
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
<<<<<<< HEAD
}
=======

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
>>>>>>> 4c1293e50c06c15cad6d7def0d577300912e5f3e
