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
		
		//System.out.println("\nThis is the opcode: "+Integer.toString(tempmsg.getOPcode()));
		
		if (Opcheck==0)
			Error_Handle(tempmsg);
		
		if (Opcheck==2)
			Login_Handle(tempmsg);
		
		if (Opcheck==6)
			Search_Handle(newmsgfromserver);
		
		if (Opcheck==5)
			Search_Handle(newmsgfromserver);
		
		if (Opcheck==9)
			Purchases_Handle(msgfromserver);
		
		if (Opcheck==11)
			Reviews_Handle(msgfromserver);
		
		if (Opcheck==21)
			Genres_Handle(msgfromserver);
		
		//if (Opcheck==10)
		//	set_Categories(msgfromserver);

		
	}



	private void Genres_Handle(ArrayList<msgs> genresmsg) {
		
		GUI.genresmsg.openGenresList(genresmsg);
	}

	private void Error_Handle(msgs errormsg) {
		GUI.errormsg.Error_Handle(errormsg);
	}

	private void Login_Handle(msgs loginmsg) {
		GUI.loginmsg.Login_Answer(loginmsg);
	}
	
	private void Search_Handle(ArrayList<msgs> searchanswer){
		GUI.searchmsg.Search_Answer(searchanswer);
	}
	
	private void Reviews_Handle(ArrayList<msgs> reviewanswer) {
		GUI.reviewmsg.openReviewList(reviewanswer);
	}
	
	private void Purchases_Handle(ArrayList<msgs> purchasewanswer) {
		GUI.purchasemsg.openPurchaseList(purchasewanswer);
	}
	
}
