package travel.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conn {
    Connection c;
    Statement s;

    public Conn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/travel_management_system", "root", "123456789");
            s = c.createStatement();  // Assigning the created statement to the `s` variable
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Optionally, add methods to close the connection and statement
    public void close() {
        try {
            if (s != null) s.close();
            if (c != null) c.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
