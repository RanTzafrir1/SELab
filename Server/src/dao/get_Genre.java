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
	static msgs tempmsg = new msgs (21);
	
	public static ArrayList<msgs> getListOfGenres(msgs loginmsgs,Connection dbConnection){
		thismessage = loginmsgs;
		localdbConnection=dbConnection;
		Statement ps=null;
		ResultSet rs;
		String category=null;;
		int check=0;
		int counter=1;
		 
		
		String insertTableSQL = "SELECT * FROM categories ORDER BY category;";
		
		
		try {
			ps = (Statement) localdbConnection.createStatement();
			rs=(ResultSet) ps.executeQuery(insertTableSQL);
			

			
			while(rs.next()){
				categoryarray.add(rs.getString(1));
				genrearray.add(rs.getString(2));
				}	
			
			category=categoryarray.get(0);

			for (String temp : categoryarray)
			{
				if (temp.equals(category))
				{
					tempmsg.addToMap("genre"+counter, genrearray.get(check));
					counter++;

				}
				else {
					tempmsg.addToMap("category",category);
					category=temp;
					msgtoserver.add(tempmsg);
					tempmsg = new msgs(21);
					counter=1;
					tempmsg.addToMap("genre"+counter, genrearray.get(check));
					counter++;
					
				}
				check++;
			}
			tempmsg.addToMap("category",category);
			msgtoserver.add(tempmsg);
			
				
		} catch (SQLException e) {
			e.printStackTrace();
		}	

		return msgtoserver;
	}
}
