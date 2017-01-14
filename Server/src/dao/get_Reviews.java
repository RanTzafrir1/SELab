package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

import common.msgs;

public class get_Reviews {
	static msgs thismessage = new msgs(0);
	static Connection localdbConnection;
	static ArrayList<msgs> msgtoserver = new ArrayList<msgs>();
	
	public static ArrayList<msgs> getListOfReviews(msgs loginmsgs,Connection dbConnection){
		thismessage = loginmsgs;
		localdbConnection=dbConnection;
		Statement ps=null;
		ResultSet rs;
		int i=0;
		
		
		
		String insertTableSQL = "SELECT * FROM reviews WHERE '"+(thismessage.getMapValue("bookid"))+"'=bookid;";
		
		
		try {
			ps = (Statement) localdbConnection.createStatement();
			rs=(ResultSet) ps.executeQuery(insertTableSQL);
			
				while(rs.next()){
					msgs localReviewMessage = new msgs(11);
					localReviewMessage.setBookid(rs.getInt(1));
					localReviewMessage.addToMap("username", rs.getString(2));
					localReviewMessage.addToMap("review", rs.getString(3));

					if (rs.getString(4).equals("0"))
						msgtoserver.add(localReviewMessage);
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
			
		return msgtoserver;
	}
}
