package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

import common.msgs;

public class Get_Book {

	static msgs thismessage;
	static Connection localdbConnection;
	
	public static msgs getBook(int loginmsgs,Connection dbConnection){
		//thismessage = loginmsgs;
		localdbConnection=dbConnection;
		Statement ps=null;
		ResultSet rs;
		msgs loginLocalMessage=new msgs(0);
			
		
		msgs searchLocalMessage=new msgs(6);
		String insertTableSQL=null;
		
		
		
		int counter=0;
		
		try {
			searchLocalMessage.setBookid(loginmsgs);
			
			insertTableSQL = "SELECT * FROM books WHERE bookid='"+Integer.toString(loginmsgs)+"';";
			
			ps = (Statement) localdbConnection.createStatement();
			rs=(ResultSet) ps.executeQuery(insertTableSQL);
		
			while(rs.next()){
				
				searchLocalMessage.addToMap("bookid",rs.getString(1));
				searchLocalMessage.addToMap("title",rs.getString(2));
				searchLocalMessage.addToMap("language",rs.getString(3));
				searchLocalMessage.addToMap("summary",rs.getString(4));
				searchLocalMessage.addToMap("tableofcontents",rs.getString(5));
				searchLocalMessage.addToMap("price",rs.getString(6));
				searchLocalMessage.addToMap("visibility",rs.getString(7));
			}
			
			insertTableSQL = "SELECT * FROM booksauthor WHERE bookid='"+Integer.toString(loginmsgs)+"';";	
			ps = (Statement) localdbConnection.createStatement();
			rs=(ResultSet) ps.executeQuery(insertTableSQL);
			
				while(rs.next()){
				
					counter++;
					searchLocalMessage.addToMap("author"+counter,rs.getString(2));
				
				}
			
			counter=0;
			insertTableSQL = "SELECT * FROM bookgenre WHERE bookid='"+Integer.toString(loginmsgs)+"';";	
			ps = (Statement) localdbConnection.createStatement();
			rs=(ResultSet) ps.executeQuery(insertTableSQL);
			
			while(rs.next()){
				
				counter++;
				searchLocalMessage.addToMap("genre"+counter,rs.getString(2));
				
			}
			
			counter=0;
			insertTableSQL = "SELECT * FROM keywords WHERE bookid='"+Integer.toString(loginmsgs)+"';";	
			ps = (Statement) localdbConnection.createStatement();
			rs=(ResultSet) ps.executeQuery(insertTableSQL);
			
			while(rs.next()){
				
				counter++;
				searchLocalMessage.addToMap("keyword"+counter,rs.getString(2));
				
			}
			if (thismessage.getOPcode()==6)
				searchLocalMessage.setOPCode(6);
			else searchLocalMessage.setOPCode(5);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

		return loginLocalMessage;
	}
	
}
