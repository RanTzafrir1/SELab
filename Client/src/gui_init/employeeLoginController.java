package gui_init;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import common.msgs;


public class employeeLoginController {

	static ClientConsole thischat;
	msgs thisloginanswer;
	BufferedReader fromConsole;
	
	

	public employeeLoginController(ClientConsole chat){
		employeeLoginController.thischat=chat;
		thischat.client.getgui(this);
		fromConsole =
	              new BufferedReader(new InputStreamReader(System.in));
		this.thisloginanswer = new msgs(2);
	}
	public void login(String userName, String password) {
		
		//System.out.printf("Press 1 if you want to add a book\n\n");
		if (userName.equals("2"))
			Add_Book();
		else if (userName.equals("3"))
			Search();
		else{
			msgs mapmessage = new msgs(2);

			mapmessage.addToMap("username", userName);
			mapmessage.addToMap("password", password);
			thisloginanswer=mapmessage;

			thischat.accept(mapmessage);
		}
		
	}
	
	public void Login_Answer(msgs answer){

		
		if (answer.getMapValue("username")==null)
			System.out.printf("User does not exist");
		else
		{
			if (thisloginanswer.getMapValue("password").equals(answer.getMapValue("password")))
				System.out.printf("You can login\n");
			else System.out.printf("Incorrect password\n");
		}
	}
	
	public void Add_Book(){
		msgs mapmessage = new msgs(3);
		String message;
		String check="y";
		int counter=1;
		try {
			System.out.printf("Please enter a book name:\n");
			message = fromConsole.readLine();
			mapmessage.addToMap("book", message);
			
			mapmessage.addToMap("numberofauthors", "1");

			System.out.printf("Please enter an author:\n");
			message = fromConsole.readLine();
			mapmessage.addToMap("author"+counter, message);
			
			System.out.printf("Would you like to enter another author? (y/n):\n");
			check = fromConsole.readLine();
			while (check.equals("y")){
				counter++;
				System.out.printf("Please enter an author:\n");
				message = fromConsole.readLine();
				mapmessage.addToMap("author"+counter, message);
				System.out.printf("Would you like to enter another author? (y/n):\n");
				check = fromConsole.readLine();
			}
			mapmessage.addToMap("numberofauthors", ""+counter);
			
			counter=1;
			check="y";
			
			System.out.printf("Please enter a genre:\n");
			message = fromConsole.readLine();
			mapmessage.addToMap("category", message);
			
			
			mapmessage.addToMap("numberofcategory", "1");

			System.out.printf("Please enter a category:\n");
			message = fromConsole.readLine();
			mapmessage.addToMap("category"+counter, message);
			
			System.out.printf("Would you like to enter another category? (y/n):\n");
			check = fromConsole.readLine();
			while (check.equals("y")){
				counter++;
				System.out.printf("Please enter an category:\n");
				message = fromConsole.readLine();
				mapmessage.addToMap("category"+counter, message);
				System.out.printf("Would you like to enter another category? (y/n):\n");
				check = fromConsole.readLine();
			}
			mapmessage.addToMap("numberofcategory", ""+counter);
			
			counter=1;
			check="y";
			
			
			System.out.printf("Please enter a summary:\n");
			message = fromConsole.readLine();
			mapmessage.addToMap("summary", message);
		} catch(IOException exception)
	    {
			System.out.println
            ("Unexpected error while reading from console!");
		    }
		
		
		
		thischat.accept(mapmessage);
	}
	
	public void Search(){
	msgs mapmessage = new msgs(1);
	String message;
	String check="y";
	int counter=1;
	try {
		System.out.printf("Please please choose and-or:\n");
		message = fromConsole.readLine();
		mapmessage.setSearch(message);
		
		System.out.printf("Please enter a book name:\n");
		message = fromConsole.readLine();
		mapmessage.addToMap("book", message);
		
		//mapmessage.addToMap("numberofauthors", "1");

		System.out.printf("Please enter an author:\n");
		message = fromConsole.readLine();
		mapmessage.addToMap("author"+counter, message);
		
		System.out.printf("Would you like to enter another author? (y/n):\n");
		check = fromConsole.readLine();
		while (check.equals("y")){
			counter++;
			System.out.printf("Please enter an author:\n");
			message = fromConsole.readLine();
			mapmessage.addToMap("author"+counter, message);
			System.out.printf("Would you like to enter another author? (y/n):\n");
			check = fromConsole.readLine();
		}
		//mapmessage.addToMap("numberofauthors", ""+counter);
		
		counter=1;
		check="y";
		
		System.out.printf("Please enter a genre:\n");
		message = fromConsole.readLine();
		mapmessage.addToMap("genre", message);
		
		
		//mapmessage.addToMap("numberofcategory", "1");

		System.out.printf("Please enter a category:\n");
		message = fromConsole.readLine();
		mapmessage.addToMap("category"+counter, message);
		
		System.out.printf("Would you like to enter another category? (y/n):\n");
		check = fromConsole.readLine();
		while (check.equals("y")){
			counter++;
			System.out.printf("Please enter an category:\n");
			message = fromConsole.readLine();
			mapmessage.addToMap("category"+counter, message);
			System.out.printf("Would you like to enter another category? (y/n):\n");
			check = fromConsole.readLine();
		}
		//mapmessage.addToMap("numberofcategory", ""+counter);
		
		counter=1;
		check="y";
		
		
		System.out.printf("Please enter a summary:\n");
		message = fromConsole.readLine();
		mapmessage.addToMap("summary", message);
	} catch(IOException exception)
    {
		System.out.println
        ("Unexpected error while reading from console!");
	    }
	
	
	
	thischat.accept(mapmessage);
}
	
	
}
