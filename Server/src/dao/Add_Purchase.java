package dao;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

import common.msgs;

public class Add_Purchase {
	msgs thismessage;
	Connection localdbConnection;
	ArrayList<msgs> returnerror = new ArrayList<msgs>();

	
	public ArrayList<msgs> getPurchase(msgs loginmsgs,Connection dbConnection){
		thismessage = loginmsgs;
		localdbConnection=dbConnection;
		ResultSet rs;//
		Statement stmt = null;
		int bookid = 0;
		String username = null;
		/*AVRORA CHANGES*/
		int isfrozen = 0;
		int count=0;
		
		try {
			
			username = thismessage.getMapValue("username");
			String insertTableSQL1 = "SELECT isfrozen FROM readers"
					+" WHERE username = '"+username+"';";
					
			stmt = (Statement) localdbConnection.createStatement();
			rs=(ResultSet) stmt.executeQuery(insertTableSQL1);	
					
			while(rs.next())
				isfrozen = rs.getInt(1);
			
			if (isfrozen == 0){
				msgs returnerror1 = new msgs (0);
				returnerror1.addToMap("error","User is frozen");
				returnerror.add(returnerror1);
				return returnerror;
				
			}
			
			insertTableSQL1 = "SELECT count(*) FROM purchases"
					+" WHERE username = '"+username+"' AND bookid="+thismessage.getBookid()+";";
					
			stmt = (Statement) localdbConnection.createStatement();
			rs=(ResultSet) stmt.executeQuery(insertTableSQL1);	
					
			while(rs.next()){
				count=rs.getInt(1);
			}

			if (count==1)
			{
				msgs returnerror1 = new msgs (0);
				returnerror1.addToMap("error","Book already purchased");
				returnerror.add(returnerror1);
				return returnerror;
			}

				try {				
						stmt=(Statement) dbConnection.createStatement(); 
						
						bookid=thismessage.getBookid();
						
						DateFormat dateFormat = new SimpleDateFormat("MMMM dd yyyy");
						  java.util.Date date = new java.util.Date();
						
						String insertTableSQL = "INSERT INTO purchases"
								+ "(bookid, username, date) VALUES"
								+ "("+bookid+",'"+thismessage.getMapValue("username")+"','"+dateFormat.format(date)+"');";
						
						stmt.executeUpdate(insertTableSQL);
			
						} catch (SQLException e) {
						e.printStackTrace();
					
						}
				
			
			
			} catch (SQLException e) {
				e.printStackTrace();
			}

		return null;
					
	}			
			
}
