package Controllers;

import common.BookSearch;
import common.MainFrame;
import common.msgs;

public class employeLoginController {
	msgs currentUser;
	msgs thisloginanswer;

	public void login(msgs loginMsg) {

		msgs mapmessage = loginMsg;
		
		thisloginanswer=mapmessage;

		MainFrame.localStorage.client.accept(mapmessage);
		
	}
public void Login_Answer(msgs answer){

		
		if (answer.getMapValue("username")==null)
			System.out.printf("User does not exist");
		else
		{
			if (thisloginanswer.getMapValue("password").equals(answer.getMapValue("password")))
				{
					System.out.printf("You can login\n");
					Controller_Mainpage.current_user=answer;
					new BookSearch();
				}
			else System.out.printf("Incorrect password\n");
		}
		
	}
}
