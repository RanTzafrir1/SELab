import java.io.BufferedReader;

import dao.*;

import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;
import com.sun.javafx.collections.MappingChange.Map;

import common.msgs;

public class HandleMessages {

	msgs thismessage;
	HashMap<Integer, Runnable> funclist;
	private mysqlConnection connect;
	public ArrayList <msgs> msgtoserver;
	BufferedReader fromConsole;
	EchoServer thisEchoServer;
	msgs localMsg;

	
	
	public HandleMessages(msgs message,EchoServer sv){
		
		thismessage = message;
		fromConsole =
	              new BufferedReader(new InputStreamReader(System.in));
		msgtoserver = new ArrayList<msgs>();
		
		this.thisEchoServer=sv;
		connect = new mysqlConnection();
		System.out.println("Connection to JDBC established");		
		
	}
	public void letsgo(){

		if ((thismessage.getOPcode())==1)
			Search();
		if ((thismessage.getOPcode())==2)
			Login();
		if ((thismessage.getOPcode())==3)
			Add_Book();
		if ((thismessage.getOPcode())==4)
			Add_User();
		
	}
	public Runnable Search(){
		localMsg=new msgs(1);
		localMsg=this.thismessage;
		int i;
		Connection conn=(Connection) connect.getConnection();
		Search localSearch = new Search();	
		i=Search.getSearch(localMsg,conn);
		
		//loginArrayMsg=localLogin.getLogin(localMsg, conn);
		
		return null;
	}
	
	public Runnable Login(){
		localMsg=new msgs(2);
		localMsg=this.thismessage;
		Connection conn=(Connection) connect.getConnection();
		ArrayList <msgs> loginArrayMsg = new ArrayList <msgs>();
		Login localLogin = new Login();	
		
		loginArrayMsg=localLogin.getLogin(localMsg, conn);
		
		sendMessageToServer(loginArrayMsg);		
		
		return null;
	}
	
	public Runnable Add_Book(){
		Add_Book localAdd_Book = new Add_Book();
		Connection conn=(Connection) connect.getConnection();
		localAdd_Book.getAdd_Book(thismessage,conn);
		return null;
	}
	
		public Runnable Add_User(){
			Connection conn=(Connection) connect.getConnection();
			Add_User localAdd_User = new Add_User();	
			localAdd_User.getAdd_User(thismessage,conn);
			return null;
	}
		
	private void sendMessageToServer(ArrayList <msgs> msgtoserver){
		this.thisEchoServer.sendToAllClients(msgtoserver);
	}
	
}
