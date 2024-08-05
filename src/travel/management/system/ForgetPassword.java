package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ForgetPassword extends JFrame {

    JTextField tfuname , tfname, question, tfans, tfpass;
    JButton search , retrive, back;

    ForgetPassword() {
        setBounds(300, 300, 850, 400);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JPanel p1 = new JPanel();
        p1.setBounds(20, 30, 500, 300);
        p1.setLayout(null);
        add(p1);

        JPanel p2 = new JPanel();
        p2.setBounds(520, 0, 330, 400);
        p2.setLayout(null);
        p2.setBackground(Color.WHITE);
        add(p2);

        // Load the image correctly
        ImageIcon i1 = new ImageIcon(getClass().getResource("/icons/forgotpassword.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(10, 30, 300, 300);
        p2.add(image);

        JLabel lusername = new JLabel("Username :- ");
        lusername.setFont(new Font("TAHOMA", Font.BOLD, 17));
        lusername.setBounds(40, 20, 125, 40);
        p1.add(lusername);

        tfuname = new JTextField();
        tfuname.setFont(new Font("TAHOMA", Font.PLAIN, 17));
        tfuname.setBounds(160, 30, 200, 25);
        // tfuname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfuname);

        search = new JButton("Search");
        search.setBounds(380, 30, 100, 25);
        search.setForeground(Color.WHITE);
        search.setFont(new Font("TAHOMA", Font.PLAIN, 17));
        search.setBackground(Color.GRAY);
        p1.add(search);

        JLabel name = new JLabel("Name :- ");
        name.setFont(new Font("TAHOMA", Font.BOLD, 17));
        name.setBounds(40, 70, 125, 40);
        p1.add(name);

        tfname = new JTextField();
        tfname.setFont(new Font("TAHOMA", Font.PLAIN, 17));
        tfname.setBounds(160, 80, 200, 25);
        // tfname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfname);

        JLabel secques = new JLabel("Security Question :-");
        secques.setFont(new Font("TAHOMA", Font.BOLD, 15));
        secques.setBounds(40, 120, 170, 40);
        p1.add(secques);

        question = new JTextField();
        question.setFont(new Font("TAHOMA", Font.PLAIN, 17));
        question.setBounds(210, 130, 260, 25);
        // question.setBorder(BorderFactory.createEmptyBorder());
        p1.add(question);

        JLabel ans = new JLabel("Answer :-");
        ans.setFont(new Font("TAHOMA", Font.BOLD, 17));
        ans.setBounds(40, 170, 125, 40);
        p1.add(ans);

        tfans = new JTextField();
        tfans.setFont(new Font("TAHOMA", Font.PLAIN, 17));
        tfans.setBounds(160, 180, 200, 25);
        // tfans.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfans);

        JLabel pass = new JLabel("Password :-");
        pass.setFont(new Font("TAHOMA", Font.BOLD, 17));
        pass.setBounds(40, 215, 125, 40);
        p1.add(pass);

        tfpass = new JTextField();
        tfpass.setFont(new Font("TAHOMA", Font.PLAIN, 17));
        tfpass.setBounds(160, 225, 200, 25);
        // tfpass.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfpass);

        retrive = new JButton("Search");
        retrive.setBounds(380, 180, 100, 25);
        retrive.setForeground(Color.WHITE);
        retrive.setFont(new Font("TAHOMA", Font.PLAIN, 17));
        retrive.setBackground(Color.GRAY);
        p1.add(retrive);

        back = new JButton("Back");
        back.setBounds(150, 265, 100, 25);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("TAHOMA", Font.PLAIN, 17));
        back.setBackground(Color.GRAY);
        p1.add(back);

        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae)
            {
                setVisible(false);
                new Login();
            }
        });

        retrive.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae)
            {
                try {
                    String query = "select * from account where answer = '" +tfans.getText()+"'";
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery(query);
                    while(rs.next())
                    {
                       tfpass.setText(rs.getString("password"));
                    }
                    
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        });

        search.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae)
            {
                try {
                    String query = "select * from account where username  = '"+tfuname.getText()+"'";
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery(query);
                    while(rs.next())
                    {
                       tfname.setText(rs.getString("name"));
                       question.setText(rs.getString("question"));
                    }
                    
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        });


        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ForgetPassword::new);
    }
}
