package travel.management.system;

import javax.swing.*;
import java.awt.*;


public class TravelManagementSystem extends JFrame implements Runnable
{    
    Thread threads;
    
    TravelManagementSystem() {
//      class to get images in application
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/splash.jpg"));
//      to crop image according our screeen size and make it fit in frame
        Image i2 = i1.getImage().getScaledInstance(1000,480, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
//      get image on frame
        JLabel image = new JLabel(i3);
        add(image);
        threads = new Thread(this);
        threads.start();
        setVisible(true);
    }
    public void run()
    {
        try {
            Thread.sleep(3000);
            setVisible(false);
            SwingUtilities.invokeLater(Login::new);

        } catch (Exception e) {
            
        }
    }
    public static void  main(String[] args)
    {
      TravelManagementSystem frame = new TravelManagementSystem();
//    to set size dynamically and keep image moving and animation  
      int x=1;
      for(int i=1; i<=500; x+=6, i+=6)
      {
          frame.setLocation(500-(x-i/2),400-(i/2));
          frame.setSize(i*2,i);
          try{
              Thread.sleep(10);
          }catch(Exception e){}
      }
        
    }
}
