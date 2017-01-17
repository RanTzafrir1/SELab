package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

import common.msgs;

public class Add_Review {
	msgs thismessage;
	Connection localdbConnection;
	ArrayList<msgs> returnerror = new ArrayList<msgs>();
	
	@SuppressWarnings("null")
	public ArrayList<msgs> getReview(msgs loginmsgs,Connection dbConnection){
		thismessage = loginmsgs;
		localdbConnection=dbConnection;
		Statement stmt = null;
		int bookid=0;
		ResultSet rs;
		int count=0;
		
		try {			
			String insertTableSQL1 = "SELECT count(*) FROM reviews"
					+" WHERE username = '"+thismessage.getMapValue("username")+"' AND bookid="+thismessage.getBookid()+";";
					
			stmt = (Statement) localdbConnection.createStatement();
			rs=(ResultSet) stmt.executeQuery(insertTableSQL1);	
					
			while(rs.next()){
				count=rs.getInt(1);
			}

			if (count==1)
			{
				msgs returnerror1 = new msgs (0);
				returnerror1.addToMap("error","Review already exists");
				returnerror.add(returnerror1);
				return returnerror;
			}
			
			stmt=(Statement) dbConnection.createStatement(); 
			
			bookid=thismessage.getBookid();
			
			String insertTableSQL = "INSERT INTO reviews"
					+ "(bookid, username, review) VALUES"
					+ "("+bookid+",'"+thismessage.getMapValue("username")+"','"+thismessage.getMapValue("review")+"');";
			
			
			
			stmt.executeUpdate(insertTableSQL);

			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;	
		
	}
}
