package travel.management.system;

import java.awt.*;
import java.io.IOException;
import javax.swing.*;

public class Paytm extends JFrame {

    Paytm() {
        setTitle("Paytm Rent Payment");
        setBounds(300,120,800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a JEditorPane to display web content
        JEditorPane pane = new JEditorPane();
        pane.setEditable(false);

        try {
            // Set the URL to display
            pane.setPage("https://www.paytm.com");
        } catch (IOException e) {
            // Handle exceptions properly
            System.err.println("Error loading page: " + e.getMessage());
            JOptionPane.showMessageDialog(this, "Error loading page: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }

        // Create a JScrollPane and add the JEditorPane to it
        JScrollPane scrollPane = new JScrollPane(pane);

        // Add the JScrollPane to the JFrame
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        // Set JFrame visibility
        setVisible(true);
    }

    public static void main(String[] args) {
        // Create an instance of Paytm JFrame
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Paytm();
            }
        });
    }
}
