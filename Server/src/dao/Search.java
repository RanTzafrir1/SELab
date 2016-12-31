package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;
import com.sun.javafx.collections.MappingChange.Map;

import common.msgs;

public class Search {
	static msgs thismessage;
	static Connection localdbConnection;
	
	@SuppressWarnings("null")
	public static int getSearch(msgs loginmsgs,Connection dbConnection){
		thismessage = loginmsgs;
		localdbConnection=dbConnection;
		
		ArrayList<msgs> msgtoserver = new ArrayList<msgs>();
		Statement ps=null;
		ResultSet rs;
		msgs searchLocalMessage=new msgs(1);
		String ifAndOrStatement;
		String query=" ";
		String tempkey=null;
		String tempvalue=null;
		
		ifAndOrStatement=thismessage.getSearch();
		
			


		if (ifAndOrStatement.equals("and")){
			for (String key : thismessage.getMap().keySet()) 	
			{
				tempkey=key;
				tempvalue=thismessage.getMapValue(key);
				if (tempkey.contains("category"))
					tempkey=tempkey.substring(0, tempkey.length()-1);
				if (tempkey.contains("author"))
					tempkey=tempkey.substring(0, tempkey.length()-1);
				query=query+"'"+tempkey+"'='"+tempvalue+"' and ";
				
			}
		query=query.substring(0, query.length()-4);
		System.out.println(query);
		
		String insertTableSQL = "SELECT * FROM users WHERE"+query;
		
		try {
			ps = (Statement) dbConnection.createStatement();
			rs=(ResultSet) ps.executeQuery(insertTableSQL);
				while(rs.next()){
					
					if (thismessage.getMap().containsKey("book"))
						searchLocalMessage.addToMap("book",rs.getString(1));
					if (thismessage.getMap().containsKey("username"))
						searchLocalMessage.addToMap("password",rs.getString(2));
					
						searchLocalMessage.addToMap("firstname",rs.getString(3));
						searchLocalMessage.addToMap("lastname",rs.getString(4));
						searchLocalMessage.addToMap("ssn",rs.getString(5));
						searchLocalMessage.addToMap("type",rs.getString(6));
				}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		}
		
		return 0;
	}
}
