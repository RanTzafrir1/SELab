package dao;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import common.msgs;

public class Add_Review {
	msgs thismessage;
	Connection localdbConnection;
	
	public void getReview(msgs loginmsgs,Connection dbConnection){
		thismessage = loginmsgs;
		localdbConnection=dbConnection;
		PreparedStatement ps=null;
		
		try {			
			
			String insertTableSQL = "INSERT INTO reviews"
					+ "(book, username, review) VALUES"
					+ "(?,?,?)";
			
			ps = (PreparedStatement) localdbConnection.prepareStatement(insertTableSQL);
			
			ps.setString(1,thismessage.getMapValue("book"));
			ps.setString(2,thismessage.getMapValue("username"));
			ps.setString(3,thismessage.getMapValue("review"));
			ps.setString(4,"0");
			
			ps.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
