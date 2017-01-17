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
	static ArrayList<Integer> bookidList = new ArrayList<Integer>();
	static Statement ps=null;
	static ResultSet rs;
	static ArrayList<msgs> msgtoserver = new ArrayList<msgs>();
	static int intcheck=0;
	
	public Search(){
	}
	
	@SuppressWarnings("unused")
	public static ArrayList<msgs> getOrSearch(msgs loginmsgs,Connection dbConnection){
		msgtoserver.clear();
		thismessage = loginmsgs;
		localdbConnection=dbConnection;
		bookidList.clear();
		
		msgs searchLocalMessage=new msgs(6);
		String query1=null,query2=null,query3=null,query4=null,query5=null,query6=null;
		String tempquery=null;
		
		

		
		
		for (String key : thismessage.getMap().keySet()) 	
		{
			
			if(key.contains("title"))
			{
				query6=""+key+"='"+thismessage.getMapValue(key)+"'";
			}
			if(key.contains("author"))
			{
					query2=""+key+"='"+thismessage.getMapValue(key)+"'";
				
			}
			if(key.contains("language"))
			{
					query5=""+key+"='"+thismessage.getMapValue(key)+"'";
			}
			if(key.contains("keyword"))
			{
				if (query3==null)
					query3="";
				tempquery=key;
				tempquery=tempquery.substring(0, tempquery.length()-1);
				if (thismessage.getOPcode()==6)
					query3+=""+tempquery+"='"+thismessage.getMapValue(key)+"' or ";
				if (thismessage.getOPcode()==5)
					query3+=""+tempquery+"='"+thismessage.getMapValue(key)+"' and ";
			}
			if(key.contains("genre"))
			{
				query4=""+key+"='"+thismessage.getMapValue(key)+"'";
			}
			
		}
		
		if (query3!=null)
		{
			if (thismessage.getOPcode()==6) query3=query3.substring(0, query3.length()-4);
			else query3=query3.substring(0, query3.length()-5);
		}

		
		
		if(query6!=null)
			query1=query6;
		if(query5!=null)
			query1=query5;
		if (query6!=null)
				if(query5!=null)
					if (thismessage.getOPcode()==6)
						query1=query6+" or "+query5;
					else query1=query6+" and "+query5;
		
		
		if (thismessage.getOPcode()==6)
		{
			if (query1!=null) insertBookID(query1,"books");
			if (query2!=null) insertBookID(query2,"booksauthor");
			if (query3!=null) insertBookID(query3,"keywords");
			if (query4!=null) insertBookID(query4,"bookgenre");
		}
		
		
		else
		{
			
			if (query1!=null) insertAndBookID(query1,"books");
			if (query2!=null) insertAndBookID(query2,"booksauthor");
			if (query3!=null) insertAndBookID(query3,"keywords");
			if (query4!=null) insertAndBookID(query4,"bookgenre");
		}
		
		
		
		
		msgtoserver=buildMsgs();
		
		
		
		return msgtoserver;
	}
	
	
		private static void insertBookID(String query,String list){
		String insertTableSQL=null;
		
		
		
		if (query!=null)
		{
			insertTableSQL = "SELECT bookid FROM "+list+" WHERE "+query+";";
			try {
				ps = (Statement) localdbConnection.createStatement();
				rs=(ResultSet) ps.executeQuery(insertTableSQL);
					while(rs.next()){
						if (!bookidList.contains(rs.getInt(1)))
							bookidList.add(rs.getInt(1));
						
					}
					
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	private static void insertAndBookID(String query,String list){
		String insertTableSQL=null;
		ArrayList<Integer> bookidList1= new ArrayList<Integer>();;
		
		
		if (query!=null)
		{
			insertTableSQL = "SELECT bookid FROM "+list+" WHERE "+query+";";
			try {
				ps = (Statement) localdbConnection.createStatement();
				rs=(ResultSet) ps.executeQuery(insertTableSQL);
					while(rs.next()){
						bookidList1.add(rs.getInt(1));
					}
					
	
			
			
			if (intcheck==0){
				if (bookidList.isEmpty())
					bookidList=bookidList1;
				else bookidList.retainAll(bookidList1);
			
				if (bookidList.isEmpty())
					if (!bookidList1.isEmpty())
						intcheck=1;
			}
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private static ArrayList<msgs> buildMsgs(){
		
			
		for (Integer elem : bookidList)
			setMsgToServer(elem);


		return msgtoserver;
	
	}
	
	
	
	public static void setMsgToServer(int elem){
		
		
		msgs searchLocalMessage=new msgs(6);
		String insertTableSQL=null;
				
		int visibility=0;//avrora
		
		int counter=0;
		
	
		try {
			searchLocalMessage.setBookid(elem);
			insertTableSQL = "SELECT * FROM books WHERE bookid='"+Integer.toString(elem)+"';";
			
			ps = (Statement) localdbConnection.createStatement();
			rs=(ResultSet) ps.executeQuery(insertTableSQL);
			
			while(rs.next())//avrora
				visibility = rs.getInt(7);//avrora
			
			System.out.println("\n"+ insertTableSQL+"\n");
			if(visibility == 1){//avrora
				
				rs.beforeFirst();//avrora
				while(rs.next()){
					
					searchLocalMessage.addToMap("bookid",rs.getString(1));
					searchLocalMessage.addToMap("title",rs.getString(2));
					searchLocalMessage.addToMap("language",rs.getString(3));
					searchLocalMessage.addToMap("summary",rs.getString(4));
					searchLocalMessage.addToMap("tableofcontents",rs.getString(5));
					searchLocalMessage.addToMap("price",rs.getString(6));
					//searchLocalMessage.addToMap("visibility",rs.getString(7));//avrora
				}
				
				insertTableSQL = "SELECT * FROM booksauthor WHERE bookid='"+Integer.toString(elem)+"';";	
				ps = (Statement) localdbConnection.createStatement();
				rs=(ResultSet) ps.executeQuery(insertTableSQL);
				
					while(rs.next()){
					
						counter++;
						searchLocalMessage.addToMap("author"+counter,rs.getString(2));
					
					}
				
				counter=0;
				insertTableSQL = "SELECT * FROM bookgenre WHERE bookid='"+Integer.toString(elem)+"';";	
				ps = (Statement) localdbConnection.createStatement();
				rs=(ResultSet) ps.executeQuery(insertTableSQL);
				
				while(rs.next()){
					
					counter++;
					searchLocalMessage.addToMap("genre"+counter,rs.getString(2));
					
				}
				
				counter=0;
				insertTableSQL = "SELECT * FROM keywords WHERE bookid='"+Integer.toString(elem)+"';";	
				ps = (Statement) localdbConnection.createStatement();
				rs=(ResultSet) ps.executeQuery(insertTableSQL);
				
				while(rs.next()){
					
					counter++;
					searchLocalMessage.addToMap("keyword"+counter,rs.getString(2));
					
				}
				if (thismessage.getOPcode()==6)
					searchLocalMessage.setOPCode(6);
				else searchLocalMessage.setOPCode(5);
				
				
				
				msgtoserver.add(searchLocalMessage);
				
			}//if
			} catch (SQLException e) {
			e.printStackTrace();
			}
		
		
	}	
		

}
