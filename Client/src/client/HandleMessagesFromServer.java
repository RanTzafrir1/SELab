package client;

import java.util.ArrayList;

import common.msgs;
import gui_init.employeeLoginController;

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
