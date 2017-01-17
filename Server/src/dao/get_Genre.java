package dao;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

import common.msgs;

public class get_Genre {
	static msgs thismessage = new msgs(0);
	static Connection localdbConnection;
	static ArrayList<msgs> msgtoserver = new ArrayList<msgs>();
	static ArrayList<String> categoryarray = new ArrayList<String>();
	static ArrayList<String> genrearray = new ArrayList<String>();

	
	public static ArrayList<msgs> getListOfGenres(msgs loginmsgs,Connection dbConnection){
		thismessage = loginmsgs;
		localdbConnection=dbConnection;
		Statement ps=null;
		ResultSet rs;
		String category=null;;
		int check=0;
		 
		
		String insertTableSQL = "SELECT * FROM categories;";
		
		
		
		try {
			ps = (Statement) localdbConnection.createStatement();
			rs=(ResultSet) ps.executeQuery(insertTableSQL);
			

			
			while(rs.next()){
				categoryarray.add(rs.getString(1));
				genrearray.add(rs.getString(2));
				}	
			
			for (String temp : categoryarray)
			{}
			
				
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		for (msgs temp : msgtoserver)
			for (String key : temp.getMap().keySet()) 	
			{
				System.out.println("\n This is the key: "+key+" and this is the value: "+temp.getMapValue(key));
			}
			

		return msgtoserver;
	}
}
