package Controllers;

import Employee.EmployeeHomePage;
import Employee.employeeLogin;
import common.BookSearch;
import common.MainFrame;
import common.msgs;

public class employeLoginController {
	msgs currentUser;
	msgs thisloginanswer;

	public void login(msgs loginMsg) {

		msgs mapmessage = loginMsg;
		
		thisloginanswer=mapmessage;

		System.out.println("\nWe are here\n");
		MainFrame.localStorage.client.accept(mapmessage);
		
	}
public void Login_Answer(msgs answer){

		
		if (answer.getMapValue("username")==null)
			new employeeLogin (1);
		else
		{
			if (thisloginanswer.getMapValue("password").equals(answer.getMapValue("password")))
				{
					Controller_Mainpage.current_user=answer;
					if (Controller_Mainpage.current_user.getMapValue("type").equals("0")) //0 is Reader, 1 is Librarian
							new BookSearch();
					if (Controller_Mainpage.current_user.getMapValue("type").equals("1")) //0 is Reader, 1 is Librarian
						new EmployeeHomePage();
				}
			else System.out.printf("Incorrect password\n");
		}
		
	}
}
