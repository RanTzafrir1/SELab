package dao;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import common.msgs;

public class Add_Review {
	msgs thismessage;
	Connection localdbConnection;
	
	@SuppressWarnings("null")
	public void getReview(msgs loginmsgs,Connection dbConnection){
		thismessage = loginmsgs;
		localdbConnection=dbConnection;
		Statement stmt = null;
		int bookid=0;
		
		try {			
			
			stmt=(Statement) dbConnection.createStatement(); 
			
			bookid=thismessage.getBookid();
			
			String insertTableSQL = "INSERT INTO reviews"
					+ "(bookid, username, review) VALUES"
					+ "("+bookid+",'"+thismessage.getMapValue("username")+"','"+thismessage.getMapValue("review")+"');";
			
			
			
			stmt.executeUpdate(insertTableSQL);

			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		
	}
}
