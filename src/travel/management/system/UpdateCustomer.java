package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class UpdateCustomer extends JFrame implements ActionListener{

    JLabel jluname, jlname;
    @SuppressWarnings("rawtypes")
    JComboBox idoption;
    JTextField tnumber, tcountry, taddress, temail, tmobileno, tid, tgender;
    JRadioButton male ,female;
    JButton addbtn, back;
    String username;

    UpdateCustomer(String username)
    {
        this.username = username;
        setBounds(350,100,850,650);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel text = new JLabel("Update Personal Information ");
        text.setFont(new Font("TAHOMA",Font.BOLD,30));;
        text.setForeground(Color.blue);
        text.setBounds(160,0 , 500, 40);
        add(text);

        JLabel uname = new JLabel("Username :- ");
        uname.setBounds(20,50 , 100, 40);
        add(uname);
        
        jluname = new JLabel("");
        jluname.setBounds(220,50 , 150, 40);
        add(jluname);

        JLabel jlid = new JLabel("ID :-  ");
        jlid.setBounds(20,100 , 100, 40);
        add(jlid);

        tid = new JTextField();
        tid.setBounds(220,110 , 150, 30);
        add(tid);

        JLabel jlnumber = new JLabel("Number :-  ");
        jlnumber.setBounds(20,150 , 150, 40);
        add(jlnumber);

        tnumber = new JTextField();
        tnumber.setBounds(220,160 , 150, 30);
        add(tnumber);

        JLabel name = new JLabel("Name :- ");
        name.setBounds(20,200 , 100, 40);
        add(name);
        
        jlname = new JLabel();
        jlname.setBounds(220,210 , 150, 30);
        add(jlname);

        JLabel gender = new JLabel("Gender :- ");
        gender.setBounds(20,250 , 100, 40);
        add(gender);

        tgender = new JTextField();
        tgender.setBounds(220,260 , 150, 30);
        add(tgender);

        JLabel jlcountry = new JLabel("Country :-  ");
        jlcountry.setBounds(20,300 , 150, 40);
        add(jlcountry);

        tcountry = new JTextField();
        tcountry.setBounds(220,310 , 150, 30);
        add(tcountry);

        JLabel jladdress = new JLabel("City :-  ");
        jladdress.setBounds(20,350 , 150, 40);
        add(jladdress);

        taddress = new JTextField();
        taddress.setBounds(220,360 , 150, 30);
        add(taddress);

        JLabel jlemail = new JLabel("Email Id :-  ");
        jlemail.setBounds(20,400 , 150, 40);
        add(jlemail);

        temail = new JTextField();
        temail.setBounds(220,410 , 150, 30);
        add(temail);

        JLabel jlphone = new JLabel("Mobile Number :-  ");
        jlphone.setBounds(20,450 , 150, 40);
        add(jlphone);

        tmobileno = new JTextField();
        tmobileno.setBounds(220,460 , 150, 30);
        add(tmobileno);

        addbtn = new JButton("Update");
        addbtn.setBounds(80, 530, 100, 40);
        addbtn.setBackground(Color.DARK_GRAY);
        addbtn.setForeground(Color.WHITE);
        addbtn.addActionListener(this);
        add(addbtn);

        back = new JButton("Back");
        back.setBounds(200, 530, 100,40);
        back.setBackground(Color.DARK_GRAY);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/update.png"));
        Image i2 = i1.getImage().getScaledInstance(400, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(450, 114, 350, 500);
        add(image);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("Select * from customer where username = '"+username+"'");
            while(rs.next())
            {
                jluname.setText(rs.getString("username"));
                jlname.setText(rs.getString("name"));
                tnumber.setText(rs.getString("number"));
                tcountry.setText(rs.getString("country"));
                taddress.setText(rs.getString("address"));
                temail.setText(rs.getString("email"));
                tmobileno.setText(rs.getString("phoneno"));
                tid.setText(rs.getString("id"));
                tgender.setText(rs.getString("gender"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }



        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
{
    if(ae.getSource() == addbtn)
    {
        String username = jluname.getText();
        String id = tid.getText();
        String number = tnumber.getText();
        String name = jlname.getText();
        String gender = tgender.getText();
        String country = tcountry.getText();
        String address = taddress.getText();
        String email = temail.getText();
        String phoneno = tmobileno.getText();

        try {
            Conn c = new Conn();
            String query = "UPDATE customer SET username = ?, id = ?, number = ?, name = ?, gender = ?, country = ?, address = ?, email = ?, phoneno = ? ";
            PreparedStatement pstmt = c.c.prepareStatement(query); 
            pstmt.setString(1, username);
            pstmt.setString(2, id);
            pstmt.setString(3, number);
            pstmt.setString(4, name);
            pstmt.setString(5, gender);
            pstmt.setString(6, country);
            pstmt.setString(7, address);
            pstmt.setString(8, email);
            pstmt.setString(9, phoneno);
            pstmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Customer details updated successfully");
            new Dashboard(name);

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    else {
        setVisible(false);
    }
}

    public static void main(String[] args) {
        new UpdateCustomer("");
    }
}
