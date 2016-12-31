package client;

import gui_init.Gui_init;
import gui_init.Gui_init1;
import gui_init.employeeLoginController;

import java.util.ArrayList;

import common.msgs;

public class HandleMessagesFromServer {
	  ArrayList <msgs> msgfromserver;
	  public msgs tempmsg;
	  employeeLoginController GUI;
	  int Opcheck;
	  
	  HandleMessagesFromServer(employeeLoginController gUI2){
		  this.GUI=gUI2;
	  }

	public void startmessagehandler(ArrayList<msgs> newmsgfromserver) {
		msgfromserver=newmsgfromserver;
		tempmsg=msgfromserver.get(0);
		Opcheck=tempmsg.getOPcode();
		
		if (Opcheck==2)
			Login_Handle(tempmsg);

		
	}

	private void Login_Handle(msgs loginmsg) {
		GUI.Login_Answer(loginmsg);
	}
	
	
}
