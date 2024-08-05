package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class ViewCustomer extends JFrame {

    JLabel jlusername,jlid,jlnumber, jlname, jlgender,jlphoneno,jlcountry,jladdress,jlemail ;

    String username;
    ViewCustomer(String username)
    {
        this.username = username;

        setBounds(350, 150, 870, 625);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("VIEW DETAILS ");
        text.setBounds(300,20 , 300, 40);
        text.setFont(new Font("TAHOMA", Font.BOLD,35));
        text.setForeground(Color.BLUE);
        add(text);

        JLabel uname = new JLabel("Username :- ");
        uname.setBounds(50,90 , 130, 40);
        uname.setFont(new Font("TAHOMA", Font.PLAIN,18));
        add(uname);

        jlusername = new JLabel("");
        jlusername.setFont(new Font("TAHOMA", Font.PLAIN,18));
        jlusername.setBounds(220,90 , 100, 40);
        add(jlusername);

        JLabel id = new JLabel("Id :- ");
        id.setBounds(50,150 , 180, 40);
        id.setFont(new Font("TAHOMA", Font.PLAIN,18));
        add(id);

        jlid = new JLabel("");
        jlid.setBounds(220,150 , 180, 40);
        jlid.setFont(new Font("TAHOMA", Font.PLAIN,18));
        add(jlid);

        JLabel number = new JLabel("Id Number :- ");
        number.setBounds(50,210 , 140, 40);
        number.setFont(new Font("TAHOMA", Font.PLAIN,18));
        add(number);

        jlnumber = new JLabel("");
        jlnumber.setBounds(220,210 , 180, 40);
        jlnumber.setFont(new Font("TAHOMA", Font.PLAIN,18));
        add(jlnumber);

        JLabel name = new JLabel("Name :- ");
        name.setBounds(50,270 , 140, 40);
        name.setFont(new Font("TAHOMA", Font.PLAIN,18));
        add(name);

        jlname = new JLabel("");
        jlname.setBounds(220,270 , 140, 40);
        jlname.setFont(new Font("TAHOMA", Font.PLAIN,18));
        add(jlname);

        JLabel gender = new JLabel("Gender :- ");
        gender.setBounds(50,330 , 140, 40);
        gender.setFont(new Font("TAHOMA", Font.PLAIN,18));
        add(gender);

        jlgender = new JLabel("");
        jlgender.setBounds(220,330 , 140, 40);
        jlgender.setFont(new Font("TAHOMA", Font.PLAIN,18));
        add(jlgender);

        JLabel country = new JLabel("Country :- ");
        country.setBounds(500,90 , 130, 40);
        country.setFont(new Font("TAHOMA", Font.PLAIN,18));
        add(country);

        jlcountry = new JLabel("");
        jlcountry.setFont(new Font("TAHOMA", Font.PLAIN,18));
        jlcountry.setBounds(650,90 , 150, 40);
        add(jlcountry);

        JLabel address = new JLabel("City  :- ");
        address.setBounds(500,150 , 100, 40);
        address.setFont(new Font("TAHOMA", Font.PLAIN,18));
        add(address);

        jladdress = new JLabel("");
        jladdress.setBounds(650,150 , 200, 40);
        jladdress.setFont(new Font("TAHOMA", Font.PLAIN,18));
        add(jladdress);

        JLabel email = new JLabel("Email ID :- ");
        email.setBounds(500,210 , 140, 40);
        email.setFont(new Font("TAHOMA", Font.PLAIN,18));
        add(email);

        jlemail = new JLabel("");
        jlemail.setBounds(650,210 , 180, 40);
        jlemail.setFont(new Font("TAHOMA", Font.PLAIN,18));
        add(jlemail);

        JLabel phoneno = new JLabel("Mobile NO :- ");
        phoneno.setBounds(500,270 , 180, 40);
        phoneno.setFont(new Font("TAHOMA", Font.PLAIN,18));
        add(phoneno);

        jlphoneno = new JLabel("");
        jlphoneno.setBounds(650,270 , 180, 40);
        jlphoneno.setFont(new Font("TAHOMA", Font.PLAIN,18));
        add(jlphoneno);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
        Image i2 = i1.getImage().getScaledInstance(870, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 330, 870, 350);
        add(image);

        try {
            
            String query = "select * from customer where username = 'nikhilmali'";
            Conn c = new Conn();
            ResultSet rs=c.s.executeQuery(query);

            while (rs.next()) {
                jlname.setText(rs.getString("name"));
                jlusername.setText(rs.getString("username"));
                jlid.setText(rs.getString("id"));
                jlnumber.setText(rs.getString("number"));
                jlgender.setText(rs.getString("gender"));
                jlcountry.setText(rs.getString("country"));
                jladdress.setText(rs.getString("address"));
                jlemail.setText(rs.getString("email"));
                jlphoneno.setText(rs.getString("phoneno"));
            }

        } catch (Exception e) {
            System.out.println(e);    
        }

        setVisible(true);
    }
    public static void main(String[] args) {
        new ViewCustomer("");
    }
    
}
