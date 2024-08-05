package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

class Login extends JFrame {

    JTextField tfusername, tfpassword;          

    Login() {
        setSize(850, 400);
        setLocation(400, 200);
        setVisible(true);
        setLayout(null); // Using null layout for absolute positioning
        
        getContentPane().setBackground(Color.WHITE); 

        JPanel p1 = new JPanel();
        p1.setBackground(new Color(131, 193, 233));
        p1.setBounds(0, 0, 360, 400);  // Adjusted width to 450 for half of the frame
        p1.setLayout(null);  // Using null layout for absolute positioning
        add(p1);

        ImageIcon i1 = new ImageIcon(getClass().getResource("/icons/Login.jpg"));
        Image i2 = i1.getImage().getScaledInstance(p1.getWidth(), p1.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, p1.getWidth(), p1.getHeight());
        p1.add(image);
        
        // Optional: Add another panel for the other half of the frame
        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setVisible(true);
        p2.setBounds(360, 0, 480, 400);  // Adjusted position and width to cover the other half
        // Background color for the other half
        add(p2);
        
        // to add font in panel 
        JLabel username = new JLabel("Username :- ");
        username.setBounds(20, 10, 150, 50);
        // to set the font type,size
        username.setFont(new Font("SAN SARIF",Font.BOLD,20));
        p2.add(username);

        // to add the textfield on frame 
        tfusername = new JTextField();
        tfusername.setBounds(20, 50, 400, 40);
        tfusername.setFont(new Font("SAN SARIF", Font.PLAIN,20));
        
        p2.add(tfusername);

        JLabel password = new JLabel("Password :- ");
        password.setBounds(20, 100, 300, 50);
        // to set the font type,size
        password.setFont(new Font("SAN SARIF",Font.BOLD,20));
        p2.add(password);

        // to add the textfield on frame 
        tfpassword = new JTextField();
        tfpassword.setBounds(20, 145, 400, 40);
        tfpassword.setFont(new Font("SAN SARIF", Font.PLAIN, 15));
        p2.add(tfpassword);

        JButton login = new JButton("login");
        login.setBounds(40, 220, 150, 40);
        login.setBackground(new Color(133, 193,233));
        login.setFont(new Font("SAN SARIF",Font.BOLD,14));
        login.setForeground(Color.BLACK);
        p2.add(login);

        JButton signup = new JButton("signup");
        signup.setBounds(240, 220, 150, 40);
        signup.setBackground(new Color(133, 193,233));
        signup.setFont(new Font("SAN SARIF",Font.BOLD,14));
        signup.setForeground(Color.BLACK);
        p2.add(signup);

        JButton fpass = new JButton("Forget Password");
        fpass.setBounds(100, 290, 200, 40);
        fpass.setBackground(new Color(133, 193,233));
        fpass.setFont(new Font("SAN SARIF",Font.BOLD,14));
        fpass.setForeground(Color.BLACK);
        p2.add(fpass);

        JLabel troublep = new JLabel("trouble in login...");
        troublep.setBounds(310, 290, 200, 40);
        troublep.setBackground(Color.RED);
        p2.add(troublep);

        fpass.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae){
                setVisible(false);
                new ForgetPassword();
            }
        });

        signup.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae){
                setVisible(false);
                new Signup();
            }
        });

        login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae){

                String uname = tfusername.getText();

                String query = "select * from account where username = '"+uname+"' and password = '"+tfpassword.getText()+"'";
                Conn c = new Conn();
                try {
                    ResultSet rs = c.s.executeQuery(query);
                    if(rs.next())
                    {
                        setVisible(false);
                        new Loading(uname);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "invalid password and username ");
                    }
                    
                } catch (Exception e) {
                    // TODO: handle exception
                }

            }
        });

    }

    public static void main(String[] args) {
        // Ensures GUI updates occur on the Event Dispatch Thread (EDT).
        SwingUtilities.invokeLater(Login::new);
    }
}
