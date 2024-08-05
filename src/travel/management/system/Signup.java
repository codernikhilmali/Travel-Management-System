package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Signup extends JFrame {
    JTextField tfuname, tfname, tfpass, tfans;
    Choice security;

    Signup() {
        // directly using setbound can work as setsize and setdirection together for frame 
        setBounds(350, 200, 900, 400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        // creating panel for signup form
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(133, 193, 233));
        p1.setBounds(0, 0, 500, 400);
        p1.setLayout(null);
        add(p1);

        JLabel lusername = new JLabel("Username :- ");
        lusername.setFont(new Font("TAHOMA", Font.BOLD, 17));
        lusername.setBounds(40, 20, 125, 40);
        p1.add(lusername);

        tfuname = new JTextField();
        tfuname.setFont(new Font("TAHOMA", Font.PLAIN, 17));
        tfuname.setBounds(220, 30, 220, 25);
        tfuname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfuname);

        JLabel lname = new JLabel("Name :- ");
        lname.setFont(new Font("TAHOMA", Font.BOLD, 17));
        lname.setBounds(40, 60, 125, 40);
        p1.add(lname);

        tfname = new JTextField();
        tfname.setFont(new Font("TAHOMA", Font.PLAIN, 17));
        tfname.setBounds(220, 70, 220, 25);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfname);

        JLabel Pass = new JLabel("Password :- ");
        Pass.setFont(new Font("TAHOMA", Font.BOLD, 17));
        Pass.setBounds(40, 100, 125, 40);
        p1.add(Pass);

        tfpass = new JTextField();
        tfpass.setFont(new Font("TAHOMA", Font.PLAIN, 17));
        tfpass.setBounds(220, 110, 220, 25);
        tfpass.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfpass);

        JLabel secques = new JLabel("Security Question :- ");
        secques.setFont(new Font("TAHOMA", Font.BOLD, 17));
        secques.setBounds(40, 140, 175, 40);
        p1.add(secques);

        // this is for choices question
        security = new Choice();
        security.add("What is your school name?");
        security.add("Enter your best friend's name?");
        security.add("Your lucky number?");
        security.setBounds(220, 150, 220, 40);
        p1.add(security);

        JLabel ans = new JLabel("Answer :- ");
        ans.setFont(new Font("TAHOMA", Font.BOLD, 17));
        ans.setBounds(40, 180, 125, 40);
        p1.add(ans);

        tfans = new JTextField();
        tfans.setFont(new Font("TAHOMA", Font.PLAIN, 17));
        tfans.setBounds(220, 190, 220, 25);
        tfans.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfans);

        JButton create = new JButton("Create");
        create.setBounds(80, 250, 100, 30);
        create.setForeground(new Color(133, 193, 233));
        create.setFont(new Font("TAHOMA", Font.BOLD, 20));
        create.setBackground(Color.WHITE);
        p1.add(create);

        JButton back = new JButton("Back");
        back.setBounds(250, 250, 100, 30);
        back.setForeground(new Color(133, 193, 233));
        back.setFont(new Font("TAHOMA", Font.BOLD, 16));
        back.setBackground(Color.WHITE);
        p1.add(back);

        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setVisible(true);
        p2.setBounds(500, 0, 400, 400);
        add(p2);

        ImageIcon i1 = new ImageIcon(getClass().getResource("/icons/singup.png"));
        Image i2 = i1.getImage().getScaledInstance(p2.getWidth(), p2.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, p2.getWidth(), p2.getHeight());
        p2.add(image);

        // here we add actionlister so when we click on create button this event will trigger
        create.addActionListener(new ActionListener() {
            @Override
            // this is the fuction that we have to call to perform action
            public void actionPerformed(ActionEvent ae) {
                // here we take all values as string
                String username = tfuname.getText();
                String name = tfname.getText();
                String password = tfpass.getText();
                String question = security.getSelectedItem();
                String answer = tfans.getText();

                // to add the values in table account
                try {
                    Conn c = new Conn();
                    String query = "INSERT INTO account (username, name, password, question, answer) VALUES (?, ?, ?, ?, ?)";
                    PreparedStatement pstmt = c.c.prepareStatement(query);
                    pstmt.setString(1, username);
                    pstmt.setString(2, name);
                    pstmt.setString(3, password);
                    pstmt.setString(4, question);
                    pstmt.setString(5, answer);
                    int rowsAffected = pstmt.executeUpdate();
                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(null, "Account created successfully");
                    } else {
                        JOptionPane.showMessageDialog(null, "Failed to create account");
                    }
                    c.close();
                    setVisible(false);
                    new Login();

                } catch (SQLException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
                }
            }
        });

        // actionlistener for back button
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae){
                setVisible(false);
                new Login();
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Signup::new);
    }
}
