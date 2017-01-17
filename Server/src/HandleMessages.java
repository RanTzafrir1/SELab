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
		
		
		if ((thismessage.getOPcode())==6)
			Search();
		if ((thismessage.getOPcode())==5)
			Search();
		if ((thismessage.getOPcode())==2)
			Login();
		if ((thismessage.getOPcode())==3)
			Add_Book();
		if ((thismessage.getOPcode())==4)
			Add_User();
		if ((thismessage.getOPcode())==7)
			Add_A_Review();
		if ((thismessage.getOPcode())==8)
			Add_Purchase();
		if ((thismessage.getOPcode())==9)
			Get_Purchases();
		if ((thismessage.getOPcode())==11)
			Get_ListOfReviews();
		if ((thismessage.getOPcode())==13)
			UpdateBook();
		if ((thismessage.getOPcode())==20)
			getLanguage();
		if ((thismessage.getOPcode())==21)
			getGenres();
		
	}
	
	private void getGenres() {
		localMsg=new msgs(21);
		localMsg=this.thismessage;
		Connection conn=(Connection) connect.getConnection();
		ArrayList <msgs> genreArrayMsg = new ArrayList <msgs>();
		genreArrayMsg=get_Genre.getListOfGenres(localMsg,conn);
		sendMessageToServer(genreArrayMsg);			
	}
	
	
	private void getLanguage() {
		localMsg=new msgs(20);
		localMsg=this.thismessage;
		Connection conn=(Connection) connect.getConnection();
		ArrayList <msgs> lanaugeArrayMsg = new ArrayList <msgs>();
		lanaugeArrayMsg=get_Language.getListOfLanguages(localMsg,conn);
		sendMessageToServer(lanaugeArrayMsg);	
	}
	
	
	private void UpdateBook() {
		Update_Book localUpdate_Book = new Update_Book();
		Connection conn=(Connection) connect.getConnection();
		localUpdate_Book.getUpdate_Book(thismessage,conn);
	}
	private void Get_ListOfReviews() {
		
		localMsg=new msgs(11);
		localMsg=this.thismessage;
		Connection conn=(Connection) connect.getConnection();
		ArrayList <msgs> reviewsArrayMsg = new ArrayList <msgs>();
		reviewsArrayMsg=get_Reviews.getListOfReviews(localMsg,conn);
		sendMessageToServer(reviewsArrayMsg);	
	}
	private void Get_Purchases() {
		localMsg=new msgs(1);
		localMsg=this.thismessage;
		Connection conn=(Connection) connect.getConnection();
		ArrayList <msgs> purchasesArrayMsg = new ArrayList <msgs>();
		purchasesArrayMsg=get_Purchases.getListOfPurchases(localMsg,conn);
		sendMessageToServer(purchasesArrayMsg);	
		
	}
	private void Add_Purchase() {
		Add_Purchase localAdd_Purchase = new Add_Purchase();
		Connection conn=(Connection) connect.getConnection();
		localAdd_Purchase.getPurchase(thismessage,conn);
				
	}
	
	public Runnable Add_A_Review(){
		Add_Review localAdd_Review = new Add_Review();
		Connection conn=(Connection) connect.getConnection();
		localAdd_Review.getReview(thismessage,conn);
		
		return null;
	}
	
	public Runnable Search(){
		localMsg=new msgs(1);
		localMsg=this.thismessage;
		msgs errormsg = new msgs(0);
		
		Connection conn=(Connection) connect.getConnection();
		ArrayList <msgs> loginArrayMsg = new ArrayList <msgs>();
		loginArrayMsg.clear();
	
		loginArrayMsg=Search.getOrSearch(localMsg,conn);
		
		if (loginArrayMsg.size()==0)
		{
			errormsg.addToMap("error","No book was found");
			loginArrayMsg.add(errormsg);
		}
		
		sendMessageToServer(loginArrayMsg);	
		
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
		thisEchoServer.sendToAllClients(msgtoserver);
	}
	
}
