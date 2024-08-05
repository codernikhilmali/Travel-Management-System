package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BookDestinations extends JFrame implements ActionListener{
    JLabel jlusername,jlid, jlnum, jlphno, jltotal;
    JTextField jlnumber;
    String username;
    JButton checkprice, bookhotel, back;
    Choice hotel,ac,food;
     BookDestinations(String username)
    {
        this.username = username;

        setBounds(250, 70, 1100, 750);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel text = new JLabel("Book Your Destination");
        text.setFont(new Font("TAHOMA",Font.BOLD,30));;
        text.setForeground(Color.blue);
        text.setBounds(60,30 , 500, 40);
        add(text);

        JLabel uname1 = new JLabel("Username :- ");
        uname1.setBounds(60,110 , 130, 40);
        uname1.setFont(new Font("TAHOMA", Font.PLAIN,18));
        add(uname1);

        jlusername = new JLabel("");
        jlusername.setFont(new Font("TAHOMA", Font.PLAIN,18));
        jlusername.setBounds(230,120 , 100, 40);
        add(jlusername);

        JLabel lbpackage = new JLabel("Select Hotel :- ");
        lbpackage.setBounds(60,160 , 150, 40);
        lbpackage.setFont(new Font("TAHOMA", Font.PLAIN,18));
        add(lbpackage);

         hotel = new Choice();
        hotel.add("Shimla, Himachal Pradesh");
        hotel.add("Triund Mcleodganj");
        hotel.add("Leh Ladakh");
        hotel.add("Kashi Temple, Varanasi");
        hotel.add("Ooty Hill Station");
        hotel.add("Mysore Palace");
        hotel.add("Humayun Tomb");
        hotel.add("India Gate");
        hotel.add("Dal Lake");
        hotel.add("Stone Chariot, Hampi");
        hotel.setFont(new Font("TAHOMA", Font.PLAIN,16));
        hotel.setBounds(230, 170, 200, 40);
        add(hotel);

        JLabel number = new JLabel("Total Persons :- ");
        number.setBounds(60,210 , 140, 40);
        number.setFont(new Font("TAHOMA", Font.PLAIN,18));
        add(number);

        jlnumber = new JTextField("");
        jlnumber.setBounds(230,220 , 150, 30);
        jlnumber.setFont(new Font("TAHOMA", Font.PLAIN,18));
        add(jlnumber);

        JLabel jlac = new JLabel("Ac or Non Ac :- ");
        jlac.setBounds(60,260 , 140, 40);
        jlac.setFont(new Font("TAHOMA", Font.PLAIN,18));
        add(jlac);

        ac = new Choice();
        ac.add("Ac");
        ac.add("Non Ac");
        ac.setFont(new Font("TAHOMA", Font.PLAIN,16));
        ac.setBounds(230, 270, 150, 40);
        add(ac);

        JLabel jlfood = new JLabel("Food Included :- ");
        jlfood.setBounds(60,310 , 140, 40);
        jlfood.setFont(new Font("TAHOMA", Font.PLAIN,18));
        add(jlfood);

        food = new Choice();
        food.add("Yes");
        food.add("No");
        food.setFont(new Font("TAHOMA", Font.PLAIN,16));
        food.setBounds(230, 320, 150, 40);
        add(food);

        JLabel lbid = new JLabel("ID :- ");
        lbid.setBounds(60,360 , 140, 40);
        lbid.setFont(new Font("TAHOMA", Font.PLAIN,18));
        add(lbid);

        jlid = new JLabel("");
        jlid.setBounds(224,360 , 140, 40);
        jlid.setFont(new Font("TAHOMA", Font.PLAIN,18));
        add(jlid);

        JLabel lbnumber = new JLabel("Number :- ");
        lbnumber.setBounds(60,410 , 140, 40);
        lbnumber.setFont(new Font("TAHOMA", Font.PLAIN,18));
        add(lbnumber);

        jlnum = new JLabel("");
        jlnum.setBounds(224,410 , 140, 40);
        jlnum.setFont(new Font("TAHOMA", Font.PLAIN,18));
        add(jlnum);

        JLabel lbphoneno = new JLabel("Mobile No :- ");
        lbphoneno.setBounds(60,460 , 140, 40);
        lbphoneno.setFont(new Font("TAHOMA", Font.PLAIN,18));
        add(lbphoneno);

        jlphno = new JLabel("");
        jlphno.setBounds(224,460 , 140, 40);
        jlphno.setFont(new Font("TAHOMA", Font.PLAIN,18));
        add(jlphno);

        JLabel lbtotal = new JLabel("Total Price :- ");
        lbtotal.setBounds(60,510 , 140, 40);
        lbtotal.setFont(new Font("TAHOMA", Font.PLAIN,18));
        add(lbtotal);

        jltotal = new JLabel("");
        jltotal.setBounds(224,510 , 140, 40);
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
        checkprice.setBounds(60, 600, 100, 40);
        checkprice.addActionListener(this);
        add(checkprice);

        bookhotel = new JButton("Book Package");
        bookhotel.setBackground(Color.DARK_GRAY);
        bookhotel.setForeground(Color.WHITE);
        bookhotel.setBounds(180, 600, 120, 40);
        bookhotel.addActionListener(this);
        add(bookhotel);

        back = new JButton("Back");
        back.setBackground(Color.DARK_GRAY);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setBounds(320, 600, 100, 40);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookpackage.jpg"));
        Image i2 = i1.getImage().getScaledInstance(640, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(460, 40, 640, 600);
        add(image);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == checkprice)
        {
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from destinations where name = '"+hotel.getSelectedItem()+"'");
                while(rs.next())
                {
                    int cost = Integer.parseInt(rs.getString("price_1"));
                    int intac = Integer.parseInt(rs.getString("ac"));
                    int intfood = Integer.parseInt(rs.getString("food"));

                    int persons = Integer.parseInt(jlnumber.getText());

                    String acselected = ac.getSelectedItem();
                    String foodselected = food.getSelectedItem();

                    if(persons != 0)
                    {
                        try {
                            int total = 0;
                            total += acselected.equals("Ac") ? intac : 0 ;
                            total += foodselected.equals("Yes") ? intfood : 0 ;
                            total += cost;
                            total = total*persons;
                            jltotal.setText("Rs "+total);
                            
                        } catch (Exception e) {
                            System.out.println(e);
                        }

                    }
                    else{
                        JOptionPane.showMessageDialog(null, "please fill all the fields");
                    }
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        if(ae.getSource() == bookhotel)
        {
            String uname = jlusername.getText();
            String id = jlid.getText();
            String number = jlnum.getText();
            String jhotel = (String)hotel.getSelectedItem();
            String jac = (String)ac.getSelectedItem();
            String jfood = (String)food.getSelectedItem();
            String phono = jlphno.getText();
            String noperson = jlnumber.getText();
            String totalprize = jltotal.getText();
            
            
            try {
                Conn c = new Conn();
            String query = "INSERT INTO bookdestination(username, dest_name, no_persons, ac_nonac, food, id, number, phoneno, price) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = c.c.prepareStatement(query); 
            pstmt.setString(1, uname);
            pstmt.setString(2, jhotel);
            pstmt.setString(3, noperson);
            pstmt.setString(4, jac);
            pstmt.setString(5, jfood);
            pstmt.setString(6, id);
            pstmt.setString(7, number);
            pstmt.setString(8, phono);
            pstmt.setString(9, totalprize);
            
            
            pstmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Destination Book Succesfully");
            

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
        new BookDestinations("");
    }
}

