package dao;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import common.msgs;

public class Add_Purchase {
	msgs thismessage;
	Connection localdbConnection;
	
	public void getPurchase(msgs loginmsgs,Connection dbConnection){
		thismessage = loginmsgs;
		localdbConnection=dbConnection;
		Statement stmt = null;
		int bookid=0;
		
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
}
