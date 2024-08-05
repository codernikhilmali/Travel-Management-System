package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BookPackage extends JFrame implements ActionListener{
    JLabel jlusername,jlid, jlname, jlnum, jlphno, jltotal;
    JTextField jlnumber;
    String username;
    JButton checkprice, bookpackage, back;
    Choice packaged;
    BookPackage(String username)
    {
        this.username = username;

        setBounds(250, 150, 1100, 650);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel text = new JLabel("Book Package ");
        text.setFont(new Font("TAHOMA",Font.BOLD,30));;
        text.setForeground(Color.blue);
        text.setBounds(60,30 , 500, 40);
        add(text);

        JLabel uname1 = new JLabel("Username :- ");
        uname1.setBounds(60,100 , 130, 40);
        uname1.setFont(new Font("TAHOMA", Font.PLAIN,18));
        add(uname1);

        jlusername = new JLabel("");
        jlusername.setFont(new Font("TAHOMA", Font.PLAIN,18));
        jlusername.setBounds(230,100 , 100, 40);
        add(jlusername);

        JLabel lbpackage = new JLabel("Select Package :- ");
        lbpackage.setBounds(60,160 , 150, 40);
        lbpackage.setFont(new Font("TAHOMA", Font.PLAIN,18));
        add(lbpackage);

         packaged = new Choice();
        packaged.add("Gold Package");
        packaged.add("Silver Package");
        packaged.add("Bronze Package");
        packaged.setFont(new Font("TAHOMA", Font.PLAIN,16));
        packaged.setBounds(230, 170, 150, 40);
        add(packaged);

        JLabel number = new JLabel("Total Persons :- ");
        number.setBounds(60,220 , 140, 40);
        number.setFont(new Font("TAHOMA", Font.PLAIN,18));
        add(number);

        jlnumber = new JTextField("");
        jlnumber.setBounds(230,230 , 150, 30);
        jlnumber.setFont(new Font("TAHOMA", Font.PLAIN,18));
        add(jlnumber);

        JLabel lbid = new JLabel("ID :- ");
        lbid.setBounds(60,280 , 140, 40);
        lbid.setFont(new Font("TAHOMA", Font.PLAIN,18));
        add(lbid);

        jlid = new JLabel("");
        jlid.setBounds(220,280 , 140, 40);
        jlid.setFont(new Font("TAHOMA", Font.PLAIN,18));
        add(jlid);

        JLabel lbnumber = new JLabel("Number :- ");
        lbnumber.setBounds(60,340 , 140, 40);
        lbnumber.setFont(new Font("TAHOMA", Font.PLAIN,18));
        add(lbnumber);

        jlnum = new JLabel("");
        jlnum.setBounds(220,340 , 140, 40);
        jlnum.setFont(new Font("TAHOMA", Font.PLAIN,18));
        add(jlnum);

        JLabel lbphoneno = new JLabel("Mobile No :- ");
        lbphoneno.setBounds(60,400 , 140, 40);
        lbphoneno.setFont(new Font("TAHOMA", Font.PLAIN,18));
        add(lbphoneno);

        jlphno = new JLabel("");
        jlphno.setBounds(220,400 , 140, 40);
        jlphno.setFont(new Font("TAHOMA", Font.PLAIN,18));
        add(jlphno);

        JLabel lbtotal = new JLabel("Total Price :- ");
        lbtotal.setBounds(60,460 , 140, 40);
        lbtotal.setFont(new Font("TAHOMA", Font.PLAIN,18));
        add(lbtotal);

        jltotal = new JLabel("");
        jltotal.setBounds(220,460 , 140, 40);
        jltotal.setFont(new Font("TAHOMA", Font.PLAIN,18));
        add(jltotal);

         try {
            Conn c = new Conn();
            String query = "Select * from customer where username = '"+username+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next())
            {
                jlusername.setText(rs.getString("username"));
                jlnum.setText(rs.getString("number"));
                jlphno.setText(rs.getString("phoneno"));
                jlid.setText(rs.getString("id"));

            }
        } catch (Exception e) {
            System.out.println(e);
        }

        checkprice = new JButton("Checkprice");
        checkprice.setBackground(Color.DARK_GRAY);
        checkprice.setForeground(Color.WHITE);
        checkprice.setBounds(60, 520, 100, 40);
        checkprice.addActionListener(this);
        add(checkprice);

        bookpackage = new JButton("Book Package");
        bookpackage.setBackground(Color.DARK_GRAY);
        bookpackage.setForeground(Color.WHITE);
        bookpackage.setBounds(180, 520, 120, 40);
        bookpackage.addActionListener(this);
        add(bookpackage);

        back = new JButton("Back");
        back.setBackground(Color.DARK_GRAY);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setBounds(320, 520, 100, 40);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookpackage.jpg"));
        Image i2 = i1.getImage().getScaledInstance(640, 620, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(460, 0, 640, 620);
        add(image);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == checkprice)
        {
            String pack = packaged.getSelectedItem();
            int cost = 0;
            if(pack.equals("Gold Package"))
            {
                cost += 32000;
            }else if(pack.equals("Silver Package"))
            {
                cost += 24000;
            }else
            {
                cost += 12000;
            }

            int person = Integer.parseInt(jlnumber.getText());
            cost *= person;
            jltotal.setText("Rs "+cost);

        }

        if(ae.getSource() == bookpackage)
        {
            String uname = jlusername.getText();
            String id = jlid.getText();
            String number = jlnum.getText();
            String paackage = (String)packaged.getSelectedItem();
            String phono = jlphno.getText();
            String noperson = jlnumber.getText();
            String totalprize = jltotal.getText();
            
            try {
                Conn c = new Conn();
            String query = "INSERT INTO tourpackage(username, id, id_no, pack_name, persons, total_price, phoneno) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = c.c.prepareStatement(query); 
            pstmt.setString(1, uname);
            pstmt.setString(2, id);
            pstmt.setString(3, number);
            pstmt.setString(4, paackage);
            pstmt.setString(5, noperson);
            pstmt.setString(6, totalprize);
            pstmt.setString(7, phono);
            
            pstmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Package Book Succesfully");
            

            } catch (Exception e) {
                System.out.println(e);
            }
        }

        if(ae.getSource() == back)
        {
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new BookPackage("");
    }
}
