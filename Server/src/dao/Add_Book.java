package dao;

import java.sql.SQLException;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import common.msgs;

public class Add_Book {

	msgs thismessage;
	Connection localdbConnection;
	
	public void getAdd_Book(msgs loginmsgs,Connection dbConnection){
		thismessage = loginmsgs;
		localdbConnection=dbConnection;
		PreparedStatement ps=null;
		
		int i,j;
		
		try {			
			
			String insertTableSQL = "INSERT INTO books"
					+ "(bookname, category, summary) VALUES"
					+ "(?,?,?)";
			
			ps = (PreparedStatement) localdbConnection.prepareStatement(insertTableSQL);
			ps.setString(1,thismessage.getMapValue("book"));
			ps.setString(2,thismessage.getMapValue("category"));
			ps.setString(3,thismessage.getMapValue("summary"));
			
			ps.executeUpdate();
			
			String insertTableSQL1 = "INSERT INTO bookauthors"
					+ "(bookname, author) VALUES"
					+ "(?,?)";
			ps.clearParameters();
				
				
			ps = (PreparedStatement) localdbConnection.prepareStatement(insertTableSQL1);
			
			for (i=0;i<Integer.parseInt(thismessage.getMapValue("numberofauthors"));i++)
			{
				
				j=i+1;
				ps.setString(1,thismessage.getMapValue("book"));
				ps.setString(2,thismessage.getMapValue("author"+j));
				ps.executeUpdate();
				
			}
			
			String insertTableSQL2 = "INSERT INTO bookcategory"
					+ "(bookname, category) VALUES"
					+ "(?,?)";
			ps.clearParameters();
				
				
			ps = (PreparedStatement) localdbConnection.prepareStatement(insertTableSQL2);
			
			for (i=0;i<Integer.parseInt(thismessage.getMapValue("numberofcategory"));i++)
			{
				
				j=i+1;
				ps.setString(1,thismessage.getMapValue("book"));
				ps.setString(2,thismessage.getMapValue("category"+j));
				ps.executeUpdate();
				
			}
			
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}	
}
