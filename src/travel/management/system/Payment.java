package travel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;

public class Payment extends JFrame {

    public Payment() {

        setLayout(null);
        setBounds(400, 150, 800, 600);

        JLabel label = new JLabel("Pay using Paytm");
        label.setFont(new Font("Raleway", Font.BOLD, 40));
        label.setBounds(50, 20, 350, 45);
        add(label);

        // Image loading
        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("icons/paytm.jpeg"));
        Image i8 = i7.getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel l4 = new JLabel(i9);
        l4.setBounds(0, 150, 800, 600); // Fixed typo here (0600 -> 600)
        add(l4);

        // Pay button
        JButton pay = new JButton("Pay");
        pay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    // Open Paytm website in the default browser
                    java.awt.Desktop.getDesktop().browse(new java.net.URI("https://paytm.com/online-payments"));
                } catch (IOException | java.net.URISyntaxException ex) {
                    JOptionPane.showMessageDialog(Payment.this, "Error opening Paytm: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }
            }
        });
        pay.setBounds(420, 20, 80, 40);
        add(pay);

        // Back button
        JButton back = new JButton("Back");
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        back.setBounds(510, 20, 80, 40);
        add(back);

        getContentPane().setBackground(Color.WHITE);
        setVisible(true);

    }

    public static void main(String[] args) {
        new Payment();
    }

}
