package client;

import gui_init.Gui_init;
import gui_init.Gui_init1;
import gui_init.employeeLoginController;

import java.util.ArrayList;

import Controllers.Controller_Mainpage;
import common.msgs;

public class HandleMessagesFromServer {
	  ArrayList <msgs> msgfromserver;
	  public msgs tempmsg;
	  Controller_Mainpage GUI;
	  int Opcheck;
	  
	  HandleMessagesFromServer(Controller_Mainpage gUI2){
		  this.GUI=gUI2;
	  }

	public void startmessagehandler(ArrayList<msgs> newmsgfromserver) {
		msgfromserver=newmsgfromserver;
		tempmsg=msgfromserver.get(0);
		Opcheck=tempmsg.getOPcode();
		

		
		if (Opcheck==2)
			Login_Handle(tempmsg);
		
		if (Opcheck==6)
			Search_Handle(msgfromserver);
		
		if (Opcheck==5)
			Search_Handle(msgfromserver);
		
		//if (Opcheck==10)
		//	set_Categories(msgfromserver);

		
	}

/*	private void set_Categories(ArrayList<msgs> categorymsg) {
		GUI.set_category_and_genre(categorymsg);
	}*/

	private void Login_Handle(msgs loginmsg) {
		GUI.loginmsg.Login_Answer(loginmsg);
	}
	
	private void Search_Handle(ArrayList<msgs> searchanswer){
		GUI.searchmsg.Search_Answer(searchanswer);
	}
	
	
}
