package Controllers;

import java.util.ArrayList;

import client.ClientConsole;
import common.MainFrame;
import common.msgs;

public class Controller_Mainpage {
	public static msgs current_user;
	static ArrayList<msgs> current_book;
	static ArrayList<msgs> current_reviews;
	msgs category_and_genre_list;
	public ClientConsole console;
	msgs thismessage;
	public employeLoginController loginmsg;
	public searchController searchmsg;
	public ListOfReviewsController reviewmsg = new ListOfReviewsController();
	public ListOfPurchasesController purchasemsg = new ListOfPurchasesController();
	public Error_Handle_Controller errormsg = new Error_Handle_Controller();
	public Controller_Mainpage(ClientConsole chat)
	{
		this.console=chat;
		category_and_genre_list = new msgs (10);
		console.accept(category_and_genre_list);
		loginmsg = new employeLoginController();
		searchmsg = new searchController();
		console.client.getgui(this);
	}
	
	
	
	public void call_handler(msgs message){
		this.thismessage=message;
		if (thismessage.getOPcode()==2)
			loginmsg.login(thismessage);
		
		if (thismessage.getOPcode()==5)
			searchmsg.search(message);
		if (thismessage.getOPcode()==6)
			searchmsg.search(message);
		
		if (thismessage.getOPcode()==15)
		{	
			MainFrame.bookP.openBookPage(thismessage);
		}
		
		if (thismessage.getOPcode()==9)
		{	
			reviewmsg.sendReviewToServer(thismessage);
		}
		
		if (thismessage.getOPcode()==11)
		{	
			reviewmsg.sendReviewToServer(thismessage);
		}
		
		if (thismessage.getOPcode()==7)
		{	
			reviewmsg.sendReviewToServer(thismessage);
		}
		
		if (thismessage.getOPcode()==8)
		{	
			reviewmsg.sendReviewToServer(thismessage);
		}
		
		if (thismessage.getOPcode()==3)
		{	
			reviewmsg.sendReviewToServer(thismessage);
		}
		
		if (thismessage.getOPcode()==4)
		{	
			reviewmsg.sendReviewToServer(thismessage);
		}
		
		if (thismessage.getOPcode()==13)
		{	
			reviewmsg.sendReviewToServer(thismessage);
		}
		
		if (thismessage.getOPcode()==20)
			reviewmsg.sendReviewToServer(thismessage);
		
		if (thismessage.getOPcode()==21)
			reviewmsg.sendReviewToServer(thismessage);
		
		if(thismessage.getOPcode()==21)
			reviewmsg.sendReviewToServer(thismessage);
		
		
		
	}	

}
