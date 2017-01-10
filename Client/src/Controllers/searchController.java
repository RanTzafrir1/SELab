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
	
	/*for (msgs printmsg : searchanswer)
	{
		for (String key : printmsg.getMap().keySet()) 	
		{
			System.out.println("The "+key+" is: "+printmsg.getMapValue(key)+"\n");
		}
	}*/
	
	
	
	Controller_Mainpage.current_book=searchanswer;
	//forReview.setBookid(searchanswer.get(0).getBookid());
	
	searchAnswer answer = new searchAnswer(searchanswer);
	}
}
