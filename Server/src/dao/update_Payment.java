package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

import common.msgs;

public class update_Payment {

	static msgs thismessage;
	static Connection localdbConnection;
	static Statement stmt=null;
	static ArrayList<msgs> returnerror = new ArrayList<msgs>();
	
	public static ArrayList<msgs> update_pay(msgs loginmsgs,Connection dbConnection){
		thismessage = loginmsgs;
		localdbConnection=dbConnection;
		Statement ps=null;
		ResultSet rs;
		int i=0;
		int count=0;
		
		
		String insertTableSQL = "SELECT count(*) FROM readers WHERE username='"+thismessage.getMapValue("username")+"';";
		
		try {
			
			stmt = (Statement) localdbConnection.createStatement();
			rs=(ResultSet) stmt.executeQuery(insertTableSQL);	
					
			while(rs.next()){
				count=rs.getInt(1);
			}

			if (count==0)
			{
				msgs returnerror1 = new msgs (0);
				returnerror1.addToMap("error","User does not exist");
				returnerror.add(returnerror1);
				return returnerror;
			}
			
			insertTableSQL = "UPDATE readers SET paymentmathod='"+thismessage.getMapValue("paymentmathod")+
							 "',subscription='"+thismessage.getMapValue("subscription")+"',date=curdate() WHERE "+
							 "username='"+thismessage.getMapValue("username")+"';";
			
			stmt.executeUpdate(insertTableSQL);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
			
		return null;
	}
}
