
package student.management.system;
import java.sql.*;


public class conn {
    
    Connection c;
    Statement s;
    
  
    public conn()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
             c = DriverManager.getConnection("jdbc:mysql:///studentmanagementsystem","root","komal@10");
            s=c.createStatement();
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
