 
package emart.dbutil;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DBConnection {
    
    private static Connection conn;
    
    static 
    {
        try
        {
            //Class.forName("oracle.jdbc.OracleDriver");
            Class.forName("oracle.jdbc.OracleDriver");
            //conn = DriverManager.getConnection("jdbc:oracle:thin:@//LAPTOP-VUKQUDRE:1521/XE", "student", "project");
            conn = DriverManager.getConnection("Jdbc:oracle:thin:@//LAPTOP-6AJ8BQKH:1521/XE","groceries","groceries");
            JOptionPane.showMessageDialog(null, "Connection Opened  Successfully ! ", "Success",JOptionPane.INFORMATION_MESSAGE);
        }
        catch(ClassNotFoundException ex)
        {
            JOptionPane.showMessageDialog(null, "Error in loading the driver ", "Driver Error !",JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
            System.exit(1);
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Error in opening Connection ", "DB Error !",JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
            System.exit(1);
        }
    }
    
    public static Connection getConnection() 
    {
        return conn;
    }
    
    public static void closeConnection()
    {
        try
        {
            conn.close();
            JOptionPane.showMessageDialog(null, "Connection Closed Successfully ! ", "Success",JOptionPane.INFORMATION_MESSAGE);
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Error in Closing connection", "DB Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
                
    }

     
}
