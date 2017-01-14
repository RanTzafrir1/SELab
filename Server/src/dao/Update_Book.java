package dao;

import java.sql.SQLException;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

import common.msgs;

public class Update_Book {

	msgs thismessage;
	Connection localdbConnection;
	ResultSet rs;
	Statement stmt=null;
	
	public void getUpdate_Book(msgs loginmsgs,Connection dbConnection){
		thismessage = loginmsgs;
		localdbConnection=dbConnection;
		Statement stmt1=null;
		
		
		try {			
			
			stmt1=(Statement) dbConnection.createStatement();
					
			String insertTableSQL = "UPDATE books"
					+ " SET title='"+thismessage.getMapValue("title")+"',language='"+thismessage.getMapValue("language")
					+ "',summary='"+thismessage.getMapValue("summary")+"',tableofcontents='"
					+ thismessage.getMapValue("tableofcontents")+"',price='"+thismessage.getMapValue("price")+"'"
					+ " WHERE bookid="+Integer.toString(thismessage.getBookid())+";";
			
			System.out.println("\n"+insertTableSQL+"\n");
			
			stmt1.executeUpdate(insertTableSQL);
			
			for (String key : thismessage.getMap().keySet()) 	
			{
				if (key.contains("oldauthor"))
				{
					insertTableSQL="UPDATE booksauthor SET author='"+thismessage.getMapValue(key.substring(3))+"' WHERE author='"
					+ thismessage.getMapValue(key)+"' AND bookid="+Integer.toString(thismessage.getBookid())+";";
					System.out.println("\n"+insertTableSQL+"\n");
					stmt1.executeUpdate(insertTableSQL);
				}
			}
			
			for (String key : thismessage.getMap().keySet()) 	
			{
				if (key.contains("oldgenre"))
				{
					insertTableSQL="UPDATE bookgenre SET genre='"+thismessage.getMapValue(key.substring(3))+"' WHERE genre='"
					+ thismessage.getMapValue(key)+"' AND bookid="+Integer.toString(thismessage.getBookid())+";";
					System.out.println("\n"+insertTableSQL+"\n");
					stmt1.executeUpdate(insertTableSQL);
				}
			}
			
			for (String key : thismessage.getMap().keySet()) 	
			{
				if (key.contains("oldkeyword"))
				{
					insertTableSQL="UPDATE keywords SET keyword='"+thismessage.getMapValue(key.substring(3))+"' WHERE keyword='"
					+ thismessage.getMapValue(key)+"' AND bookid="+Integer.toString(thismessage.getBookid())+";";
					System.out.println("\n"+insertTableSQL+"\n");
					stmt1.executeUpdate(insertTableSQL);
				}
			}
			
			
			

			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}	
}
