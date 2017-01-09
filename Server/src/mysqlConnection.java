import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class mysqlConnection {

	Connection conn;
	public mysqlConnection()
	{
		try 
		{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception ex) {/* handle the error*/}
        
        try 
        {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/Assignment3","root","silverdragon");
            System.out.println("SQL connection succeed");
     	} catch (SQLException ex) 
     	    {/* handle any errors*/

            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            }
   	}

	public Connection getConnection(){
		return this.conn;
	}
}