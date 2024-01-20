package codes;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Ticket {
    private JFrame frame;
    private JPanel mainPanel;
    private JButton downloadButton;
    private JTextArea ticketInfoArea;

    public Ticket() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setTitle("Train Ticket");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new JPanel();
        Styles.bgColor(mainPanel);

        downloadButton = new JButton("Download Ticket");
        Styles.buttonStyle(downloadButton);
        Styles.buttonSize(200, 50, downloadButton);
        Styles.centerButtons(mainPanel, downloadButton);

        // Add ActionListener to handle the button click event
        downloadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                downloadTicket();
            }
        });

        JLabel headerLabel = new JLabel("Welcome to ONCF");
        Styles.headerLabelStyle(headerLabel);

        ticketInfoArea = new JTextArea(10, 30);
        Styles.ticketInfoAreaStyle(ticketInfoArea);
        ticketInfoArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(ticketInfoArea);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(headerLabel, BorderLayout.NORTH);
        mainPanel.add(downloadButton, BorderLayout.CENTER);
        mainPanel.add(scrollPane, BorderLayout.SOUTH);

        frame.setContentPane(mainPanel);
        frame.setVisible(true);
    }

    private void downloadTicket() {
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
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Ticket();
            }
        });
    }
}

class Styles {
    public static void bgColor(JPanel panel) {
        // Add your background color styling logic here
        panel.setBackground(new Color(255, 255, 204));
    }

    public static void buttonStyle(JButton button) {
        // Add your button styling logic here
        button.setFont(new Font("Arial", Font.BOLD, 16));
    }

    public static void buttonSize(int width, int height, JButton button) {
        // Add your button size logic here
        button.setPreferredSize(new Dimension(width, height));
    }

    public static void centerButtons(JPanel panel, JButton button) {
        // Add your centering logic for buttons here
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel.add(button);
    }

    public static void headerLabelStyle(JLabel label) {
        // Add your header label styling logic here
        label.setFont(new Font("Arial", Font.BOLD, 20));
    }

    public static void ticketInfoAreaStyle(JTextArea area) {
        // Add your ticket info area styling logic here
        area.setFont(new Font("Arial", Font.PLAIN, 14));
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
    }
}
