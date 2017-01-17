package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

import common.msgs;

public class Add_User {
	msgs thismessage;
	Connection localdbConnection;
	ArrayList<msgs> returnerror = new ArrayList<msgs>();
	
	public ArrayList<msgs> getAdd_User(msgs loginmsgs,Connection dbConnection){
		thismessage = loginmsgs;
		localdbConnection=dbConnection;
		PreparedStatement ps=null;
		Statement stmt=null;
		ResultSet rs;
		int count=0;
		
		try {		
					
				String insertTableSQL1 = "SELECT count(*) FROM users"
						+" WHERE username = '"+thismessage.getMapValue("username")+"';";
						
				stmt = (Statement) localdbConnection.createStatement();
				rs=(ResultSet) stmt.executeQuery(insertTableSQL1);	
						
				while(rs.next()){
					count=rs.getInt(1);
				}

				if (count==1)
				{
					msgs returnerror1 = new msgs (0);
					returnerror1.addToMap("error","User already exists");
					returnerror.add(returnerror1);
					return returnerror;
				}
				
			
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
		return null;
	}
}
