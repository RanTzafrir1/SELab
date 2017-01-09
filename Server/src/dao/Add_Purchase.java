package dao;

import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import common.msgs;

public class Add_Purchase {
	msgs thismessage;
	Connection localdbConnection;
	
	@SuppressWarnings("null")
	public void getPurchase(msgs loginmsgs,Connection dbConnection){
		thismessage = loginmsgs;
		localdbConnection=dbConnection;
		Statement stmt = null;
		int bookid=0;
		
		try {			
			System.out.println ("\n We got to Add_Purchase After\n");
			
			stmt=(Statement) dbConnection.createStatement(); 
			
			bookid=thismessage.getBookid();
			
			DateFormat dateFormat = new SimpleDateFormat("MMMM dd yyyy");
			  java.util.Date date = new java.util.Date();
			  System.out.println("Current Date : " + dateFormat.format(date));
			
			System.out.println ("\n The date is: "+dateFormat.format(date)+"\n");
			
			String insertTableSQL = "INSERT INTO purchases"
					+ "(bookid, username, date) VALUES"
					+ "("+bookid+",'"+thismessage.getMapValue("username")+"','"+dateFormat.format(date)+"');";
			

			System.out.println("\n"+insertTableSQL+"\n");
			
			stmt.executeUpdate(insertTableSQL);

			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		
	}
}
