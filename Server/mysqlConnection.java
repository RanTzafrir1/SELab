import javax.xml.transform.Result;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//Ran Tzafrir 034750752
public class mysqlConnection {

	public mysqlConnection(Object msg)
	{
		try 
		{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception ex) {/* handle the error*/}
        
        try 
        {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/test","root","silverdragon");
            //Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.3.68/test","root","Root");
            System.out.println("SQL connection succeed");
            
            System.out.println("This is "+msg);
            //createTableCourses(conn);
			changeFlight(conn);
           // printCourses(conn);
     	} catch (SQLException ex) 
     	    {/* handle any errors*/

            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            }
   	}

   	public static void changeFlight(Connection con)
	{
		float [] price=new float[18];
		int[] nums=new int [18];
		int[] tempnum=new int [18];
		int j;
		float[] tempp=new float [18];
		int k=0;
		int i=0;
		Statement stmt;
		PreparedStatement ps = null;
		try{
			stmt = con.createStatement();

			stmt.executeUpdate("update flights SET price = 5000 where num = 387 ");
			ps = con.prepareStatement("select num,price,distance from flights");
			ResultSet rs = ps.executeQuery();
			System.out.print("flight 387 updated to 5000$\n\n");
			////

			while (rs.next())
			{
				nums[i] = Integer.parseInt(rs.getString("num"));
				price[i++]=Float.parseFloat(rs.getString("price"));
			}

			for (j=0;j<i;j++)
			{
				price[j]=price[j]+200;
				System.out.println("flight number " + nums[j] + " price - " + price[j]);
			}

			ps =  con.prepareStatement("UPDATE flights SET price = ? WHERE num = ?");
			for (j=0;j<i;j++)
			{
				ps.setFloat(1, price[j]);
				ps.setInt(2, nums[j]);
				ps.executeUpdate();
			}


			ps = con.prepareStatement("select num,distance,price from flights where distance > 1000");
			rs = ps.executeQuery();
			j=0;
			while (rs.next())
			{
				tempnum[j] = Integer.parseInt(rs.getString("num"));
				tempp[j]=Float.parseFloat(rs.getString("price")) + 50;
				Statement stmt2 = con.createStatement();
				stmt2.executeUpdate("UPDATE flights SET price = " +tempp[j] + " WHERE num = " +tempnum[j]);

				j++;
			}
			System.out.println("\nhere are flights more than 1000 km up which updated:");
			for (k=0;k<j;k++)
				System.out.println("flight number " + tempnum[k] + " price - " + tempp[k]);


			rs.close();
			ps.close();


		} catch (SQLException e) {	e.printStackTrace();}


	}
	/*public static void printCourses(Connection con)
	{
		Statement stmt;
		try 
		{
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM courses;");
	 		while(rs.next())
	 		{
				 // Print out the values
				 System.out.println(rs.getString(1)+"  " +rs.getString(2));
			} 
			rs.close();
			//stmt.executeUpdate("UPDATE course SET semestr=\"W08\" WHERE num=61309");
		} catch (SQLException e) {e.printStackTrace();}
	}

	
	public static void createTableCourses(Connection con1){
		Statement stmt;
		try {
			stmt = con1.createStatement();
			stmt.executeUpdate("create table courses(num int, name VARCHAR(40), semestr VARCHAR(10));");
			stmt.executeUpdate("load data local infile \"courses.txt\" into table courses");
	 		
		} catch (SQLException e) {	e.printStackTrace();}
		 		
	}*/
	
	
	
}


