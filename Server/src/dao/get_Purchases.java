package dao;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

import common.msgs;

public class get_Purchases {
	static msgs thismessage = new msgs(0);
	static Connection localdbConnection;
	static ArrayList<msgs> msgtoserver = new ArrayList<msgs>();
	
	public static ArrayList<msgs> getListOfPurchases(msgs loginmsgs,Connection dbConnection){
		thismessage = loginmsgs;
		localdbConnection=dbConnection;
		Statement ps=null;
		ResultSet rs;

		int counter=0;
		 
		
		String insertTableSQL = "SELECT * FROM purchases WHERE '"+(thismessage.getMapValue("username"))+"'=username;";
		
		
		try {
			ps = (Statement) localdbConnection.createStatement();
			rs=(ResultSet) ps.executeQuery(insertTableSQL);
			
				while(rs.next()){
					msgs localReviewMessage = new msgs(9);
					localReviewMessage.setBookid(rs.getInt(1));
					localReviewMessage.addToMap("username", rs.getString(2));
					localReviewMessage.addToMap("date", rs.getString(3));
					msgtoserver.add(localReviewMessage);
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
			
		for (msgs temp : msgtoserver){
			insertTableSQL = "SELECT title FROM books WHERE bookid="+Integer.toString(temp.getBookid())+";";


		
			try {
				ps = (Statement) localdbConnection.createStatement();
				rs=(ResultSet) ps.executeQuery(insertTableSQL);
				
				while(rs.next()){
					msgtoserver.get(counter).addToMap("title",rs.getString(1));
				}
				
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			
			
			counter++;
		}
		return msgtoserver;
	}
}
