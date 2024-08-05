package travel.management.system;
import javax.swing.*;
import java.awt.*;

public class Loading extends JFrame implements Runnable{

     String uname;
     Thread threads;
     JProgressBar progress;

     public void run()
     {
        try {
            
            for(int i = 0; i<=100; i++)
            {
                int max = progress.getMaximum();
                int value = progress.getValue();

            if (value < max) {
                progress.setValue(progress.getValue()+1);    
            }
            else{

                setVisible(false);
                new Dashboard(uname);

            }
            Thread.sleep(30);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
     }
    Loading (String uname){
        this.uname = uname;
        setBounds(500, 200, 650, 400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel name = new JLabel("Travel And Tourism Application");
        name.setBounds(70,20, 480, 30);
        name.setForeground(Color.BLUE);
        name.setFont(new Font("TAHOMA",Font.BOLD,30));
        add(name);

        progress = new JProgressBar();
        progress.setBounds(120, 90, 350, 40);
        progress.setStringPainted(true);
        add(progress); 

        JLabel loading = new JLabel("Loading, Please Wait... ");
        loading.setBounds(180,130, 480, 30);
        loading.setForeground(Color.RED);
        loading.setFont(new Font("TAHOMA",Font.BOLD,16));
        add(loading);

        JLabel text = new JLabel("Welcome "+uname);
        text.setBounds(50,300, 300, 30);
        text.setForeground(Color.RED);
        text.setFont(new Font("TAHOMA",Font.BOLD,20));
        add(text);

        threads = new Thread(this);
        threads.start();
        setVisible(true);

       
    }
    public static void main(String[] args) {
        new Loading("");
    }
}
