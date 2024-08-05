package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;;


public class Dashboard extends JFrame implements ActionListener{

    JButton adddetails,updatedetails,viewdetails,deletedetails,checkpackage,bookpackage,vbdestination,bookdestination,payment,destination,vbhotels,bookhotels,viewhotels,viewpackage,exit;
    String uname ;
    Dashboard(String uname)
    {
        this.uname = uname ;
        // setBounds(0, 0, 1600, 1000);
        // this we can use to get full screen width
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);

        JPanel p1 = new JPanel();
        p1.setBackground(new Color(0,0 ,102));
        p1.setBounds(0, 0, 1600, 65);
        p1.setLayout(null);
        add(p1);

        ImageIcon i1 = new ImageIcon(getClass().getResource("/icons/dashboard.png"));
        Image i2 = i1.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel icon = new JLabel(i3);
        icon.setBounds(5, 0, 70,70);
        p1.add(icon);

        JLabel heading = new JLabel("Dashboard");
        heading.setBounds(80, 10, 340, 50);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("TAHOMA", Font.BOLD, 30));
        p1.add(heading);

        JPanel p2 = new JPanel();
        p2.setBackground(new Color(0,0 ,102));
        p2.setBounds(0, 65, 300, 1000);
        p2.setLayout(null);
        add(p2);

         adddetails = new JButton("Add Personal Details");
        adddetails.setBounds(0, 0, 300, 60);
        adddetails.setBackground(new Color(0,0 ,102));
        adddetails.setFont(new Font("TAHOMA", Font.PLAIN, 20));
        adddetails.setForeground(Color.WHITE);
        adddetails.setMargin(new Insets(0, 0, 0, 65));
        adddetails.addActionListener(this);
        p2.add(adddetails);

         updatedetails = new JButton("Update Personal Details");
        updatedetails.setBounds(0, 50, 300, 60);
        updatedetails.setBackground(new Color(0,0 ,102));
        updatedetails.setFont(new Font("TAHOMA", Font.PLAIN, 20));
        updatedetails.setForeground(Color.WHITE);
        updatedetails.addActionListener(this);
        updatedetails.setMargin(new Insets(0, 0, 0, 40));
        p2.add(updatedetails);

         viewdetails = new JButton("View Personal Details");
        viewdetails.setBounds(0, 100, 300, 60);
        viewdetails.setBackground(new Color(0,0 ,102));
        viewdetails.setFont(new Font("TAHOMA", Font.PLAIN, 20));
        viewdetails.setForeground(Color.WHITE);
        viewdetails.addActionListener(this);
        viewdetails.setMargin(new Insets(0, 0, 0, 65));
        p2.add(viewdetails);

         deletedetails = new JButton("Delete Personal Details");
        deletedetails.setBounds(0, 150, 300, 60);
        deletedetails.setBackground(new Color(0,0 ,102));
        deletedetails.setFont(new Font("TAHOMA", Font.PLAIN, 20));
        deletedetails.setForeground(Color.WHITE);
        deletedetails.addActionListener(this);
        deletedetails.setMargin(new Insets(0, 0, 0, 50));
        p2.add(deletedetails);

         checkpackage = new JButton("Check Packages");
        checkpackage.setBounds(0, 200, 300, 60);
        checkpackage.setBackground(new Color(0,0 ,102));
        checkpackage.setFont(new Font("TAHOMA", Font.PLAIN, 20));
        checkpackage.setForeground(Color.WHITE);
        checkpackage.addActionListener(this);
        checkpackage.setMargin(new Insets(0, 0, 0, 110));
        p2.add(checkpackage);

         bookpackage = new JButton("Book Package");
        bookpackage.setBounds(0, 250, 300, 60);
        bookpackage.setBackground(new Color(0,0 ,102));
        bookpackage.setFont(new Font("TAHOMA", Font.PLAIN, 20));
        bookpackage.setForeground(Color.WHITE);
        bookpackage.addActionListener(this);
        bookpackage.setMargin(new Insets(0, 0, 0, 125));
        p2.add(bookpackage);

         viewpackage = new JButton("View Package");
        viewpackage.setBounds(0, 300, 300, 60);
        viewpackage.setBackground(new Color(0,0 ,102));
        viewpackage.setFont(new Font("TAHOMA", Font.PLAIN, 20));
        viewpackage.setForeground(Color.WHITE);
        viewpackage.addActionListener(this);
        viewpackage.setMargin(new Insets(0, 0, 0, 125));
        p2.add(viewpackage);

         viewhotels = new JButton("View Hotels");
        viewhotels.setBounds(0, 350, 300, 60);
        viewhotels.setBackground(new Color(0,0 ,102));
        viewhotels.setFont(new Font("TAHOMA", Font.PLAIN, 20));
        viewhotels.setForeground(Color.WHITE);
        viewhotels.addActionListener(this);
        viewhotels.setMargin(new Insets(0, 0, 0, 140));
        p2.add(viewhotels);

         bookhotels = new JButton("Book Hotels");
        bookhotels.setBounds(0, 400, 300, 60);
        bookhotels.setBackground(new Color(0,0 ,102));
        bookhotels.setFont(new Font("TAHOMA", Font.PLAIN, 20));
        bookhotels.setForeground(Color.WHITE);
        bookhotels.addActionListener(this);
        bookhotels.setMargin(new Insets(0, 0, 0, 140));
        p2.add(bookhotels);

         vbhotels = new JButton("View Booked Hotel");
        vbhotels.setBounds(0, 450, 300, 60);
        vbhotels.setBackground(new Color(0,0 ,102));
        vbhotels.setFont(new Font("TAHOMA", Font.PLAIN, 20));
        vbhotels.setForeground(Color.WHITE);
        vbhotels.addActionListener(this);
        vbhotels.setMargin(new Insets(0, 0, 0, 80));
        p2.add(vbhotels);

         destination = new JButton("View Destinations");
        destination.setBounds(0, 500, 300, 60);
        destination.setBackground(new Color(0,0 ,102));
        destination.setFont(new Font("TAHOMA", Font.PLAIN, 20));
        destination.setForeground(Color.WHITE);
        destination.addActionListener(this);
        destination.setMargin(new Insets(0, 0, 0, 80));
        p2.add(destination);

        bookdestination = new JButton("Book Destination");
       bookdestination.setBounds(0, 550, 300, 60);
       bookdestination.setBackground(new Color(0,0 ,102));
       bookdestination.setFont(new Font("TAHOMA", Font.PLAIN, 20));
       bookdestination.setMargin(new Insets(0, 0, 0, 90));
       bookdestination.addActionListener(this);
       bookdestination.setForeground(Color.WHITE);
       p2.add(bookdestination);
       
       vbdestination = new JButton("View Booked Destination");
      vbdestination.setBounds(0, 600, 300, 60);
      vbdestination.setBackground(new Color(0,0 ,102));
      vbdestination.setFont(new Font("TAHOMA", Font.PLAIN, 20));
      vbdestination.setMargin(new Insets(0, 0, 0, 25));
      vbdestination.addActionListener(this);
      vbdestination.setForeground(Color.WHITE);
      p2.add(vbdestination);

         payment = new JButton("Payments");
        payment.setBounds(0, 650, 300, 60);
        payment.setBackground(new Color(0,0 ,102));
        payment.setFont(new Font("TAHOMA", Font.PLAIN, 20));
        payment.setForeground(Color.WHITE);
        payment.addActionListener(this);
        payment.setMargin(new Insets(0, 0, 0, 150));
        p2.add(payment);

         exit = new JButton("Exit");
        exit.setBounds(0, 700, 300, 60);
        exit.setBackground(new Color(0,0 ,102));
        exit.setFont(new Font("TAHOMA", Font.PLAIN, 20));
        exit.setMargin(new Insets(0, 0, 0, 200));
        exit.addActionListener(this);
        exit.setForeground(Color.WHITE);
        p2.add(exit);

        JPanel p3 = new JPanel();
        p3.setBounds(300, 60, 1300, 940);
        p3.setLayout(null);
        p3.setBackground(Color.BLUE);
        add(p3);

        // Load the image correctly
        ImageIcon ii1 = new ImageIcon(getClass().getResource("/icons/home.jpg"));
        Image ii2 = ii1.getImage().getScaledInstance(1300, 940, Image.SCALE_DEFAULT);
        ImageIcon ii3 = new ImageIcon(ii2);
        JLabel image = new JLabel(ii3);
        image.setBounds(0, 0, 1300, 940);
        p3.add(image);

        JLabel text = new JLabel("Travel And Tourism Management System");
        text.setBounds(50, 50, 1500, 70);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("TAHOMA", Font.BOLD, 50));
        image.add(text);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == adddetails)
        {
            new AddCustomer(uname);
        }

        if(ae.getSource() == viewdetails)
        {
            new ViewCustomer(uname);
        }

        if(ae.getSource() == updatedetails)
        {
            new UpdateCustomer(uname);
        }
        if(ae.getSource() == deletedetails)
        {
             try {
                new DeleteCustomer();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(ae.getSource() == bookpackage)
        {
            new BookPackage(uname);
        }
        if(ae.getSource() == checkpackage)
        {
            new CheckPackage();
        }
        if(ae.getSource() == viewpackage)
        {
            new ViewPackage(uname);
        }
        if(ae.getSource() == destination)
        {
            new Destination();
        }
        if(ae.getSource() == viewhotels)
        {
            new CheckHotels();
        }
        if(ae.getSource() == bookhotels)
        {
            new BookHotel(uname);
        }
        if(ae.getSource() == vbhotels)
        {
            new ViewBookedHotel(uname);
        }
        if(ae.getSource() == bookdestination)
        {
            new BookDestinations(uname);
        }
        if(ae.getSource() == vbdestination)
        {
            new ViewBookDestination(uname);
        }
        if(ae.getSource() == payment)
        {
            new Payment();
        }
    }

    
    public static void main(String[] args) {
        new Dashboard("");
    }
    
}
