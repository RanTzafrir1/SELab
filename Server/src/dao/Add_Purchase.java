package dao;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;
import common.msgs;

public class Add_Purchase {
	msgs thismessage;
	Connection localdbConnection;

	
	public void getPurchase(msgs loginmsgs,Connection dbConnection){
		thismessage = loginmsgs;
		localdbConnection=dbConnection;
		ResultSet rs;//
		Statement stmt = null;
		int bookid = 0;
		String username = null;
		
		/*AVRORA CHANGES*/
		int isfrozen = 0;
		try {
			
			username = thismessage.getMapValue("username");
			String insertTableSQL1 = "SELECT isfrozen FROM readers"
					+" WHERE username = '"+username+"';";
					
			stmt = (Statement) localdbConnection.createStatement();
			rs=(ResultSet) stmt.executeQuery(insertTableSQL1);	
					
			while(rs.next())
				isfrozen = rs.getInt(1);
			
			if (isfrozen == 1){
				
				rs.beforeFirst();
				try {				
						stmt=(Statement) dbConnection.createStatement(); 
						
						bookid=thismessage.getBookid();
						
						DateFormat dateFormat = new SimpleDateFormat("MMMM dd yyyy");
						  java.util.Date date = new java.util.Date();
						
						String insertTableSQL = "INSERT INTO purchases"
								+ "(bookid, username, date) VALUES"
								+ "("+bookid+",'"+thismessage.getMapValue("username")+"','"+dateFormat.format(date)+"');";
						
						stmt.executeUpdate(insertTableSQL);
			
						} catch (SQLException e) {
						e.printStackTrace();
					
						}
			}
			else System.out.println("\nTASHLUM LO TAKIN\n");
			} catch (SQLException e) {
				e.printStackTrace();
			}	
					
	}			
			
}
