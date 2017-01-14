package Controllers;

import java.util.ArrayList;

import Employee.ReaderReviewList;
import common.MainFrame;
import common.msgs;

public class ListOfReviewsController {

	public void openReviewList(ArrayList<msgs> reviews){
		new ReaderReviewList(reviews);
		
		
	}
	
	public void sendReviewToServer(msgs sendtoserver){
		MainFrame.localStorage.client.accept(sendtoserver);
	}
}
