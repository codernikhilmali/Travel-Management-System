package travel.management.system;
import javax.swing.*;
import java.awt.*;

public class CheckPackage extends JFrame {

    CheckPackage() {
        setBounds(350, 150, 900, 600);
        setLayout(null);

        JTabbedPane tab = new JTabbedPane();
        tab.setBounds(0, 0, 900, 600);
        add(tab);

        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(Color.WHITE);
        tab.addTab("Package 1", null, p1);

        JLabel l1 = new JLabel("GOLD PACKAGE");
        l1.setBounds(50, 20, 300, 40);
        l1.setFont(new Font("TAHOMA", Font.BOLD, 30));
        l1.setForeground(Color.BLUE);
        p1.add(l1);

        JLabel l2 = new JLabel("6 DAYS AND 7 NIGHTS");
        l2.setBounds(50, 80, 300, 40);
        l2.setFont(new Font("TAHOMA", Font.BOLD, 20));
        l2.setForeground(Color.red);
        p1.add(l2);

        JLabel l3 = new JLabel("AIRPORT ASSISTANCE");
        l3.setBounds(50, 130, 300, 40);
        l3.setFont(new Font("TAHOMA", Font.BOLD, 20));
        l3.setForeground(Color.red);
        p1.add(l3);

        JLabel l4 = new JLabel("CITY TOUR");
        l4.setBounds(50, 180, 300, 40);
        l4.setFont(new Font("TAHOMA", Font.BOLD, 20));
        l4.setForeground(Color.red);
        p1.add(l4);

        JLabel l5 = new JLabel("DAILY BUFFET");
        l5.setBounds(50, 230, 300, 40);
        l5.setFont(new Font("TAHOMA", Font.BOLD, 20));
        l5.setForeground(Color.red);
        p1.add(l5);

        JLabel l6 = new JLabel("WELCOME DRINKS");
        l6.setBounds(50, 280, 300, 40);
        l6.setFont(new Font("TAHOMA", Font.BOLD, 20));
        l6.setForeground(Color.red);
        p1.add(l6);

        JLabel l7 = new JLabel("3 ISLAND CRUISE");
        l7.setBounds(50, 330, 300, 40);
        l7.setFont(new Font("TAHOMA", Font.BOLD, 20));
        l7.setForeground(Color.red);
        p1.add(l7);

        JLabel l8 = new JLabel("RS 32000 ONWARS");
        l8.setBounds(50, 380, 300, 40);
        l8.setFont(new Font("TAHOMA", Font.BOLD, 20));
        l8.setForeground(Color.magenta);
        p1.add(l8);

        JLabel l9 = new JLabel("BOOK NOW");
        l9.setBounds(50, 450, 300, 40);
        l9.setFont(new Font("TAHOMA", Font.BOLD, 30));
        l9.setForeground(Color.BLUE);
        p1.add(l9);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/package1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 20, 400, 500);
        p1.add(image);

        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBackground(Color.WHITE);
        tab.addTab("Package 2", null, p2);

        JLabel l11 = new JLabel("SILVER PACKAGE");
        l11.setBounds(50, 20, 300, 40);
        l11.setFont(new Font("TAHOMA", Font.BOLD, 30));
        l11.setForeground(Color.BLUE);
        p2.add(l11);

        JLabel l12 = new JLabel("4 DAYS AND 5 NIGHTS");
        l12.setBounds(50, 80, 300, 40);
        l12.setFont(new Font("TAHOMA", Font.BOLD, 20));
        l12.setForeground(Color.red);
        p2.add(l12);

        JLabel l13 = new JLabel("AIRPORT ASSISTANCE");
        l13.setBounds(50, 130, 300, 40);
        l13.setFont(new Font("TAHOMA", Font.BOLD, 20));
        l13.setForeground(Color.red);
        p2.add(l13);

        JLabel l14 = new JLabel("CITY TOUR");
        l14.setBounds(50, 180, 300, 40);
        l14.setFont(new Font("TAHOMA", Font.BOLD, 20));
        l14.setForeground(Color.red);
        p2.add(l14);

        JLabel l15 = new JLabel("DAILY BUFFET");
        l15.setBounds(50, 230, 300, 40);
        l15.setFont(new Font("TAHOMA", Font.BOLD, 20));
        l15.setForeground(Color.red);
        p2.add(l15);

        JLabel l16 = new JLabel("WELCOME DRINKS");
        l16.setBounds(50, 280, 300, 40);
        l16.setFont(new Font("TAHOMA", Font.BOLD, 20));
        l16.setForeground(Color.red);
        p2.add(l16);

        JLabel l17 = new JLabel("1 ISLAND CRUISE");
        l17.setBounds(50, 330, 300, 40);
        l17.setFont(new Font("TAHOMA", Font.BOLD, 20));
        l17.setForeground(Color.red);
        p2.add(l17);

        JLabel l18 = new JLabel("RS 24000 ONWARDS");
        l18.setBounds(50, 380, 300, 40);
        l18.setFont(new Font("TAHOMA", Font.BOLD, 20));
        l18.setForeground(Color.MAGENTA);
        p2.add(l18);

        JLabel l19 = new JLabel("BOOK NOW");
        l19.setBounds(50, 450, 300, 40);
        l19.setFont(new Font("TAHOMA", Font.BOLD, 30));
        l19.setForeground(Color.BLUE);
        p2.add(l19);

        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icons/package2.jpg"));
        Image i12 = i11.getImage().getScaledInstance(400, 500, Image.SCALE_DEFAULT);
        ImageIcon i13 = new ImageIcon(i12);
        JLabel image1 = new JLabel(i13);
        image1.setBounds(400, 20, 400, 500);
        p2.add(image1);

        JPanel p3 = new JPanel();
        p3.setLayout(null);
        p3.setBackground(Color.WHITE);
        tab.addTab("Package 3", null, p3);

        JLabel l21 = new JLabel("BRONZE PACKAGE");
        l21.setBounds(50, 20, 300, 40);
        l21.setFont(new Font("TAHOMA", Font.BOLD, 30));
        l21.setForeground(Color.BLUE);
        p3.add(l21);

        JLabel l22 = new JLabel("2 DAYS AND 3 NIGHTS");
        l22.setBounds(50, 80, 300, 40);
        l22.setFont(new Font("TAHOMA", Font.BOLD, 20));
        l22.setForeground(Color.red);
        p3.add(l22);

        JLabel l23 = new JLabel("AIRPORT ASSISTANCE");
        l23.setBounds(50, 130, 300, 40);
        l23.setFont(new Font("TAHOMA", Font.BOLD, 20));
        l23.setForeground(Color.red);
        p3.add(l23);

        JLabel l24 = new JLabel("CITY TOUR");
        l24.setBounds(50, 180, 300, 40);
        l24.setFont(new Font("TAHOMA", Font.BOLD, 20));
        l24.setForeground(Color.red);
        p3.add(l24);

        JLabel l25 = new JLabel("DAILY BUFFET");
        l25.setBounds(50, 230, 300, 40);
        l25.setFont(new Font("TAHOMA", Font.BOLD, 20));
        l25.setForeground(Color.red);
        p3.add(l25);

        JLabel l26 = new JLabel("WELCOME DRINKS");
        l26.setBounds(50, 280, 300, 40);
        l26.setFont(new Font("TAHOMA", Font.BOLD, 20));
        l26.setForeground(Color.red);
        p3.add(l26);

        JLabel l27 = new JLabel("BONE FIRE");
        l27.setBounds(50, 330, 300, 40);
        l27.setFont(new Font("TAHOMA", Font.BOLD, 20));
        l27.setForeground(Color.red);
        p3.add(l27);

        JLabel l28 = new JLabel("RS 15000 ONWARDS");
        l28.setBounds(50, 380, 300, 40);
        l28.setFont(new Font("TAHOMA", Font.BOLD, 20));
        l28.setForeground(Color.MAGENTA);
        p3.add(l28);

        JLabel l29 = new JLabel("BOOK NOW");
        l29.setBounds(50, 450, 300, 40);
        l29.setFont(new Font("TAHOMA", Font.BOLD, 30));
        l29.setForeground(Color.BLUE);
        p3.add(l29);

        ImageIcon i21 = new ImageIcon(ClassLoader.getSystemResource("icons/package3.jpg"));
        Image i22 = i21.getImage().getScaledInstance(400, 500, Image.SCALE_DEFAULT);
        ImageIcon i23 = new ImageIcon(i22);
        JLabel image2 = new JLabel(i23);
        image2.setBounds(400, 20, 400, 500);
        p3.add(image2);


        setVisible(true);
    }

    public static void main(String[] args) {
        new CheckPackage();
    }
}
