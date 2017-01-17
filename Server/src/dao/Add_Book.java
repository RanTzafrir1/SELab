package dao;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

import common.msgs;

public class Add_Book {

	msgs thismessage;
	Connection localdbConnection;
	ResultSet rs;
	Statement stmt=null;
	
	public void getAdd_Book(msgs loginmsgs,Connection dbConnection){
		thismessage = loginmsgs;
		localdbConnection=dbConnection;
		Statement stmt1=null;
		int bookid=0;
		String insertTableSQL1=null;
		
		try {			
			
			stmt1=(Statement) dbConnection.createStatement();
					
			String insertTableSQL = "INSERT INTO books"
					+ "(title, language, summary,tableofcontents,price) VALUES"
					+ "('"+thismessage.getMapValue("title")+"','"+thismessage.getMapValue("language")
					+ "','"+thismessage.getMapValue("summary")+"','"+thismessage.getMapValue("tableofcontents")+"','"+thismessage.getMapValue("price")+"');";
			

			stmt1.executeUpdate(insertTableSQL);
			
			insertTableSQL = "SELECT max(bookid) FROM books";
			
			try {
				stmt = (Statement) dbConnection.createStatement();
				rs=(ResultSet) stmt.executeQuery(insertTableSQL);
					while(rs.next()){
						bookid=rs.getInt(1);
					}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			for (String key : thismessage.getMap().keySet()) 	
			{
				if(key.contains("author"))
				{
					insertTableSQL1 = "INSERT INTO booksauthor"
							+ "(bookid, author) VALUES("
							+ bookid+",'"+thismessage.getMapValue(key)+"');";
					stmt1.executeUpdate(insertTableSQL1);
				}
			}
			
			for (String key : thismessage.getMap().keySet()) 	
			{
				if(key.contains("genre"))
				{
					//genreSubString=key.substring(key.length()-1);
					
					insertTableSQL1 = "INSERT INTO bookgenre"
							+ "(bookid,genre) VALUES("
							+ bookid+",'"+thismessage.getMapValue(key)+"');";
					stmt1.executeUpdate(insertTableSQL1);
				}
			}
			
			for (String key : thismessage.getMap().keySet()) 	
			{
				if(key.contains("keyword"))
				{			
					insertTableSQL1 = "INSERT INTO keywords"
							+ "(bookid, keyword) VALUES("
							+ bookid+",'"+thismessage.getMapValue(key)+"');";
					stmt1.executeUpdate(insertTableSQL1);
				}
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}	
}
