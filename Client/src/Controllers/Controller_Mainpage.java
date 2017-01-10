package Controllers;

import java.util.ArrayList;

import client.ClientConsole;
import common.msgs;

public class Controller_Mainpage {
	static msgs current_user;
	static ArrayList<msgs> current_book;
	msgs category_and_genre_list;
	public ClientConsole console;
	msgs thismessage;
	public employeLoginController loginmsg;
	public searchController searchmsg;
	
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
			searchmsg.search(thismessage);
		if (thismessage.getOPcode()==6)
			searchmsg.search(thismessage);
		
	}	

}
