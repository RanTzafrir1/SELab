package gui_init;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import client.ClientConsole;
import common.msgs;


public class employeeLoginController {

	static ClientConsole thischat;
	msgs thisloginanswer;
	BufferedReader fromConsole;
	msgs forReview;
	msgs currentUser;
	ArrayList <msgs> currentBookSearch;
	

	public employeeLoginController(ClientConsole chat){
		employeeLoginController.thischat=chat;
		thischat.client.getgui(this);
		fromConsole =
	              new BufferedReader(new InputStreamReader(System.in));
		this.thisloginanswer = new msgs(2);
		this.forReview = new msgs(7);
		this.currentUser = new msgs (0);
		this.currentBookSearch = new ArrayList<msgs>();
	}
	public void login(String userName, String password) {
		
		//System.out.printf("Press 1 if you want to add a book\n\n");
		if (userName.equals("2"))
			Add_Book();
		else if (userName.equals("5"))
			Search();
		else if (userName.equals("7"))
			Add_Review();
		else if (userName.equals("4"))
			Add_User();
		else if (userName.equals("8"))
			Purchase_Book();
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
				{
					System.out.printf("You can login\n");
					forReview.addToMap("username", answer.getMapValue("username"));
					currentUser=answer;
				}
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
			mapmessage.addToMap("title", message);
			

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
			
			counter=1;
			check="y";	

			System.out.printf("Please enter a category:\n");
			message = fromConsole.readLine();
			mapmessage.addToMap("category"+counter, message);
			
			System.out.printf("Please enter a genre:\n");
			message = fromConsole.readLine();
			mapmessage.addToMap("genre"+counter, message);
			
			System.out.printf("Would you like to enter another category? (y/n):\n");
			check = fromConsole.readLine();
			while (check.equals("y")){
				counter++;
				System.out.printf("Please enter an category:\n");
				message = fromConsole.readLine();
				mapmessage.addToMap("category"+counter, message);
				
				System.out.printf("Please enter a genre:\n");
				message = fromConsole.readLine();
				mapmessage.addToMap("genre"+counter, message);
				
				System.out.printf("Would you like to enter another category? (y/n):\n");
				check = fromConsole.readLine();
			}
			
			counter=1;
			check="y";
			
			System.out.printf("Please enter a keyword:\n");
			message = fromConsole.readLine();
			mapmessage.addToMap("keyword"+counter, message);
			
			System.out.printf("Would you like to enter another keyword? (y/n):\n");
			check = fromConsole.readLine();
			while (check.equals("y")){
				counter++;
				System.out.printf("Please enter an keyword:\n");
				message = fromConsole.readLine();
				mapmessage.addToMap("keyword"+counter, message);
				System.out.printf("Would you like to enter another keyword? (y/n):\n");
				check = fromConsole.readLine();
			}
			
			counter=1;
			check="y";
			
			
			System.out.printf("Please enter a summary:\n");
			message = fromConsole.readLine();
			mapmessage.addToMap("summary", message);
			
			System.out.printf("Please enter a language:\n");
			message = fromConsole.readLine();
			mapmessage.addToMap("language", message);
			
			System.out.printf("Please enter a tableofcontents:\n");
			message = fromConsole.readLine();
			mapmessage.addToMap("tableofcontents", message);
			
			System.out.printf("Please enter a price:\n");
			message = fromConsole.readLine();
			mapmessage.addToMap("price", message);
			
		} catch(IOException exception)
	    {
			System.out.println
            ("Unexpected error while reading from console!");
		    }
		
		
		
		thischat.accept(mapmessage);
	}
	
	public void Search(){
	msgs mapmessage = new msgs(0);
	String message;
	String check="y";
	int counter=1;
	try {
		System.out.printf("Please please choose and-or:\n");
		message = fromConsole.readLine();

		if (message.equals("and"))
			mapmessage.setOPCode(5);
		
		if (message.equals("or"))
			mapmessage.setOPCode(6);
		
		System.out.printf("Would you like to search by book (y/n)?:\n");
		message = fromConsole.readLine();
		
		if (message.equals("y"))		
		{
			System.out.printf("Please enter a book name:\n");
			message = fromConsole.readLine();
			mapmessage.addToMap("title", message);
		}
		
		System.out.printf("Would you like to search by author (y/n)?:\n");
		message = fromConsole.readLine();
		if (message.equals("y"))		
		{
			System.out.printf("Please enter an author:\n");
			message = fromConsole.readLine();
			mapmessage.addToMap("author", message);
		}
		
		counter=1;
		check="y";
		
		System.out.printf("Would you like to search by genre (y/n)?:\n");
		message = fromConsole.readLine();
		if (message.equals("y"))		
		{
			System.out.printf("Please enter a genre:\n");
			message = fromConsole.readLine();
			mapmessage.addToMap("genre", message);
		}
		
		System.out.printf("Would you like to search by language (y/n)?:\n");
		message = fromConsole.readLine();
		if (message.equals("y"))		
		{
			System.out.printf("Please enter a language:\n");
			message = fromConsole.readLine();
			mapmessage.addToMap("language", message);
		}
		
		System.out.printf("Would you like to search by keyword (y/n)?:\n");
		message = fromConsole.readLine();
		if (message.equals("y"))		
		{
			System.out.printf("Please enter a keyword:\n");
			message = fromConsole.readLine();
			mapmessage.addToMap("keyword"+counter, message);
		
			System.out.printf("Would you like to enter another keyword? (y/n):\n");
			check = fromConsole.readLine();
			while (check.equals("y")){
				counter++;
				System.out.printf("Please enter an keyword:\n");
				message = fromConsole.readLine();
				mapmessage.addToMap("keyword"+counter, message);
				System.out.printf("Would you like to enter another keyword? (y/n):\n");
				check = fromConsole.readLine();
			}
		}
		
		
		counter=1;
		check="y";
		
	} catch(IOException exception)
    {
		System.out.println
        ("Unexpected error while reading from console!");
	    }
	
	
	
	thischat.accept(mapmessage);
}
	
	public void Add_User(){
		msgs mapmessage = new msgs(4);
		String message=null;
		try {
			System.out.printf("Please enter a username:\n");
			message = fromConsole.readLine();
			mapmessage.addToMap("username", message);
			
			System.out.printf("Please enter a password:\n");
			message = fromConsole.readLine();
			mapmessage.addToMap("password", message);

			
			System.out.printf("Please enter a firstname:\n");
			message = fromConsole.readLine();
			mapmessage.addToMap("firstname", message);
			
			System.out.printf("Please enter a lastname:\n");
			message = fromConsole.readLine();
			mapmessage.addToMap("lastname", message);

			
			System.out.printf("Please enter a SSN:\n");
			message = fromConsole.readLine();
			mapmessage.addToMap("ssn", message);
			
			
		} catch(IOException exception)
	    {
			System.out.println
            ("Unexpected error while reading from console!");
		    }
			
		thischat.accept(mapmessage);
	}

	public void Or_Search_Answer(ArrayList<msgs> searchanswer) {
		
		for (msgs printmsg : searchanswer)
		{
			for (String key : printmsg.getMap().keySet()) 	
			{
				System.out.println("The "+key+" is: "+printmsg.getMapValue(key)+"\n");
			}
		}
		
		currentBookSearch=searchanswer;
		forReview.setBookid(searchanswer.get(0).getBookid());
		
	
	}
	
	public void Add_Review(){
		String message=null;
		try {
			System.out.printf("Please enter a review:\n");
			message = fromConsole.readLine();
			forReview.addToMap("review", message);
			
			
		} catch(IOException exception)
	    {
			System.out.println
            ("Unexpected error while reading from console!");
		    }
			
		thischat.accept(forReview);
	}
	
	public void Purchase_Book(){
		String message=null;
		msgs sendPurchase = new msgs(8);
		try {
			
			System.out.printf("This is the list of books:\n");
			
			for (msgs printmsg : currentBookSearch)
			{
				System.out.printf("The book ID is :"+printmsg.getBookid());
				System.out.printf("The book name is :"+printmsg.getMapValue("title")+"\n");
			}
			
			System.out.printf("Please enter the title of the book you wish to purchase:\n");
			message = fromConsole.readLine();
			
			for (msgs printmsg : currentBookSearch)
			{
				if (printmsg.getMapValue("title").equals(message))
					sendPurchase.setBookid(printmsg.getBookid());
			}
			
			sendPurchase.addToMap("username", currentUser.getMapValue("username"));
			
			
		} catch(IOException exception)
	    {
			System.out.println
            ("Unexpected error while reading from console!");
		    }
			
		System.out.println ("\n The current user is: "+currentUser.getMapValue("username"));
		System.out.println ("\n The username is: "+sendPurchase.getMapValue("username")+" and the bookid is: "+sendPurchase.getBookid());
		
		thischat.accept(sendPurchase);
	}

}
