package Controllers;

import java.util.ArrayList;


import common.MainFrame;
import common.msgs;
import Employee.*;

public class searchController {

	public void search(msgs msgtoserver){
		MainFrame.localStorage.client.accept(msgtoserver);
	}


public void Search_Answer(ArrayList<msgs> searchanswer) {
	

	Controller_Mainpage.current_book=searchanswer;
	
	new searchAnswer(searchanswer);
	}
}
