package Controllers;

import java.util.ArrayList;

import common.MainFrame;
import common.msgs;
import Employee.*;

public class searchController {

	public void search(msgs msgtoserver){
		msgs mapmessage = msgtoserver;
		MainFrame.localStorage.client.accept(mapmessage);
	}


public void Search_Answer(ArrayList<msgs> searchanswer) {
	

	Controller_Mainpage.current_book=searchanswer;

	new searchAnswer(searchanswer);
	}
}
