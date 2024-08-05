package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BookHotel extends JFrame implements ActionListener{
    JLabel jlusername,jlid, jlnum, jlphno, jltotal;
    JTextField jlnumber,jldays;
    String username;
    JButton checkprice, bookhotel, back;
    Choice hotel,ac,food;
     BookHotel(String username)
    {
        this.username = username;

        setBounds(250, 70, 1100, 750);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel text = new JLabel("Book Hotel ");
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
        hotel.add("JW Marriott Hotel");
        hotel.add("Mandarin Oriental Hotel");
        hotel.add("Four Seasons Hotel");
        hotel.add("Radisson Hotel");
        hotel.add("Classio Hotel");
        hotel.add("The Bay Club Hotel");
        hotel.add("Breeze Blows Hotel");
        hotel.add("Quick Stop Hotel");
        hotel.add("Happy Mornings Motel");
        hotel.add("Moss View Hotel");
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

        JLabel noofday = new JLabel("No. Of Days :- ");
        noofday.setBounds(60,260 , 140, 40);
        noofday.setFont(new Font("TAHOMA", Font.PLAIN,18));
        add(noofday);

        jldays = new JTextField("");
        jldays.setBounds(230,270 , 150, 30);
        jldays.setFont(new Font("TAHOMA", Font.PLAIN,18));
        add(jldays);

        JLabel jlac = new JLabel("Ac or Non Ac :- ");
        jlac.setBounds(60,320 , 140, 40);
        jlac.setFont(new Font("TAHOMA", Font.PLAIN,18));
        add(jlac);

        ac = new Choice();
        ac.add("Ac");
        ac.add("Non Ac");
        ac.setFont(new Font("TAHOMA", Font.PLAIN,16));
        ac.setBounds(230, 330, 150, 40);
        add(ac);

        JLabel jlfood = new JLabel("Food Included :- ");
        jlfood.setBounds(60,370 , 140, 40);
        jlfood.setFont(new Font("TAHOMA", Font.PLAIN,18));
        add(jlfood);

        food = new Choice();
        food.add("Yes");
        food.add("No");
        food.setFont(new Font("TAHOMA", Font.PLAIN,16));
        food.setBounds(230, 380, 150, 40);
        add(food);

        JLabel lbid = new JLabel("ID :- ");
        lbid.setBounds(60,420 , 140, 40);
        lbid.setFont(new Font("TAHOMA", Font.PLAIN,18));
        add(lbid);

        jlid = new JLabel("");
        jlid.setBounds(224,420 , 140, 40);
        jlid.setFont(new Font("TAHOMA", Font.PLAIN,18));
        add(jlid);

        JLabel lbnumber = new JLabel("Number :- ");
        lbnumber.setBounds(60,470 , 140, 40);
        lbnumber.setFont(new Font("TAHOMA", Font.PLAIN,18));
        add(lbnumber);

        jlnum = new JLabel("");
        jlnum.setBounds(224,470 , 140, 40);
        jlnum.setFont(new Font("TAHOMA", Font.PLAIN,18));
        add(jlnum);

        JLabel lbphoneno = new JLabel("Mobile No :- ");
        lbphoneno.setBounds(60,520 , 140, 40);
        lbphoneno.setFont(new Font("TAHOMA", Font.PLAIN,18));
        add(lbphoneno);

        jlphno = new JLabel("");
        jlphno.setBounds(224,520 , 140, 40);
        jlphno.setFont(new Font("TAHOMA", Font.PLAIN,18));
        add(jlphno);

        JLabel lbtotal = new JLabel("Total Price :- ");
        lbtotal.setBounds(60,570 , 140, 40);
        lbtotal.setFont(new Font("TAHOMA", Font.PLAIN,18));
        add(lbtotal);

        jltotal = new JLabel("");
        jltotal.setBounds(224,570 , 140, 40);
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
        checkprice.setBounds(60, 650, 100, 40);
        checkprice.addActionListener(this);
        add(checkprice);

        bookhotel = new JButton("Book Package");
        bookhotel.setBackground(Color.DARK_GRAY);
        bookhotel.setForeground(Color.WHITE);
        bookhotel.setBounds(180, 650, 120, 40);
        bookhotel.addActionListener(this);
        add(bookhotel);

        back = new JButton("Back");
        back.setBackground(Color.DARK_GRAY);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setBounds(320, 650, 100, 40);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/book.jpg"));
        Image i2 = i1.getImage().getScaledInstance(640, 620, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(460, 40, 640, 620);
        add(image);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == checkprice)
        {
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from hotel where name = '"+hotel.getSelectedItem()+"'");
                while(rs.next())
                {
                    int cost = Integer.parseInt(rs.getString("price_1"));
                    int intac = Integer.parseInt(rs.getString("acroom"));
                    int intfood = Integer.parseInt(rs.getString("food"));

                    int persons = Integer.parseInt(jlnumber.getText());
                    int days = Integer.parseInt(jldays.getText());

                    String acselected = ac.getSelectedItem();
                    String foodselected = food.getSelectedItem();

                    if(persons*days>0)
                    {
                        int total = 0;
                        total += acselected.equals("Ac") ? intac : 0 ;
                        total += foodselected.equals("Yes") ? intfood : 0 ;
                        total += cost;
                        total = total*persons*days;
                        jltotal.setText("Rs "+total);

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
            String jdays = jldays.getText();
            
            try {
                Conn c = new Conn();
            String query = "INSERT INTO book_hotel(username, hotel, no_persons, no_days, ac_nonac, food, id, number, phoneno, price) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = c.c.prepareStatement(query); 
            pstmt.setString(1, uname);
            pstmt.setString(2, jhotel);
            pstmt.setString(3, noperson);
            pstmt.setString(4, jdays);
            pstmt.setString(5, jac);
            pstmt.setString(6, jfood);
            pstmt.setString(7, id);
            pstmt.setString(8, number);
            pstmt.setString(9, phono);
            pstmt.setString(10, totalprize);
            
            
            pstmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Hotel Book Succesfully");
            

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
        new BookHotel("");
    }
}
