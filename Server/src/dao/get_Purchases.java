package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

import common.msgs;

public class get_Purchases {
	static msgs thismessage;
	static Connection localdbConnection;
	static ArrayList<msgs> msgtoserver;
	
	public get_Purchases(){
		msgtoserver = new ArrayList<msgs>();
	}
	
	public static ArrayList<msgs> getListOfPurchases(msgs loginmsgs,Connection dbConnection){
		thismessage = loginmsgs;
		localdbConnection=dbConnection;
		Statement ps=null;
		ResultSet rs;
		int counter=0;
		
		
		
		String insertTableSQL = "SELECT bookid FROM purchases WHERE '"+thismessage.getMapValue("username")+"'=username;";
		
		try {
			ps = (Statement) localdbConnection.createStatement();
			rs=(ResultSet) ps.executeQuery(insertTableSQL);
				while(rs.next()){
					counter++;
					
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		return null;
		
	}
}