package dao;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import common.msgs;

public class Add_User {
	msgs thismessage;
	Connection localdbConnection;
	
	public void getAdd_User(msgs loginmsgs,Connection dbConnection){
		thismessage = loginmsgs;
		localdbConnection=dbConnection;
		PreparedStatement ps=null;
		Statement stmt=null;
		try {			
			
			String insertTableSQL = "INSERT INTO users"
					+ "(username, password, firstname, lastname,ssn) VALUES"
					+ "(?,?,?,?,?)";
			
			ps = (PreparedStatement) localdbConnection.prepareStatement(insertTableSQL);
			
			ps.setString(1,thismessage.getMapValue("username"));
			ps.setString(2,thismessage.getMapValue("password"));
			ps.setString(3,thismessage.getMapValue("firstname"));
			ps.setString(4,thismessage.getMapValue("lastname"));
			ps.setString(5,thismessage.getMapValue("ssn"));
			
			ps.executeUpdate();
			
			stmt=(Statement) dbConnection.createStatement();
			
			insertTableSQL = "INSERT INTO readers"
					+ "(username) VALUES('"+thismessage.getMapValue("username")+"');";
					
			stmt.executeUpdate(insertTableSQL);
					
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
