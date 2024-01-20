package codes;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ticket {
    private JFrame frame;
    private JPanel mainPanel;

    public Ticket() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        Styles.window(frame, "ONCF");

        mainPanel = new JPanel();
        Styles.bgColor(mainPanel);

        frame.setContentPane(mainPanel);
        frame.setVisible(true);
    }

    public static void window() {
        JFrame ticketFrame = new JFrame();
        Styles.window(ticketFrame, "Train Ticket");

        JPanel ticketPanel = new JPanel();
        Styles.bgColor(ticketPanel);

        JLabel ticketLabel = new JLabel("This is your train ticket");
        Styles.headerLabelStyle(ticketLabel);

        ticketPanel.add(ticketLabel);

        ticketFrame.setContentPane(ticketPanel);
        ticketFrame.setVisible(true);
    }

    public static void downloadWindow(String ticketContent) {
        JFrame ticketFrame = new JFrame();
        Styles.window(ticketFrame, "Train Ticket");

        JPanel ticketPanel = new JPanel();
        Styles.bgColor(ticketPanel);

        JTextArea ticketTextArea = new JTextArea(ticketContent);
        Styles.ticketInfoAreaStyle(ticketTextArea);
        ticketTextArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(ticketTextArea);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        ticketPanel.setLayout(new BorderLayout());
        ticketPanel.add(scrollPane, BorderLayout.CENTER);

        ticketFrame.setContentPane(ticketPanel);
        ticketFrame.setVisible(true);
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
    public static void window(JFrame frame, String title) {
        frame.setTitle(title);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void bgColor(JPanel panel) {
        panel.setBackground(new Color(255, 255, 204));
    }

    public static void headerLabelStyle(JLabel label) {
        label.setFont(new Font("Arial", Font.BOLD, 20));
    }

    public static void ticketInfoAreaStyle(JTextArea area) {
        area.setFont(new Font("Arial", Font.PLAIN, 14));
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
    }
}
