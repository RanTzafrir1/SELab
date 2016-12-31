package dao;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import common.msgs;

public class Add_User {
	msgs thismessage;
	Connection localdbConnection;
	
	public void getAdd_User(msgs loginmsgs,Connection dbConnection){
		thismessage = loginmsgs;
		localdbConnection=dbConnection;
		PreparedStatement ps=null;
		try {			
			
			String insertTableSQL = "INSERT INTO users"
					+ "(username, password, firstname, lastname,ssn,type) VALUES"
					+ "(?,?,?,?,?,?)";
			
			ps = (PreparedStatement) localdbConnection.prepareStatement(insertTableSQL);
			
			ps.setString(1,thismessage.getMapValue("username"));
			ps.setString(2,thismessage.getMapValue("password"));
			ps.setString(3,thismessage.getMapValue("firstname"));
			ps.setString(4,thismessage.getMapValue("lastname"));
			ps.setString(5,thismessage.getMapValue("ssn"));
			ps.setString(6,thismessage.getMapValue("type"));
			
			ps.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
