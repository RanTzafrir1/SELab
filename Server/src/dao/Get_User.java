package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

import common.msgs;

public class Get_User {

	msgs thismessage;
	Connection localdbConnection;
	
	public msgs getUser(msgs loginmsgs,Connection dbConnection){
		thismessage = loginmsgs;
		localdbConnection=dbConnection;
		Statement ps=null;
		ResultSet rs;
		msgs loginLocalMessage=new msgs(2);
			if (thismessage.getOPcode()==2)
				loginLocalMessage.setOPCode(2);
			if (thismessage.getOPcode()==4)
				loginLocalMessage.setOPCode(4);
			
		
		String insertTableSQL = "SELECT * FROM users WHERE '"+thismessage.getMapValue("username")+"'=username;";
		
		
		try {
			ps = (Statement) dbConnection.createStatement();
			rs=(ResultSet) ps.executeQuery(insertTableSQL);
				while(rs.next()){
				
					loginLocalMessage.addToMap("username",rs.getString(1));
					loginLocalMessage.addToMap("password",rs.getString(2));
					loginLocalMessage.addToMap("firstname",rs.getString(3));
					loginLocalMessage.addToMap("lastname",rs.getString(4));
					loginLocalMessage.addToMap("ssn",rs.getString(5));
					loginLocalMessage.addToMap("type",rs.getString(6));
				}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

		return loginLocalMessage;
	}
	
}
