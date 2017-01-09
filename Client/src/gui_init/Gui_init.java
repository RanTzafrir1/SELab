package gui_init;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import common.msgs;


public class Gui_init {
	
	ClientConsole thischat;
	BufferedReader fromConsole;
	String message=null;
	msgs thisloginanswer;
	
	
	public Gui_init(ClientConsole chat){
		thischat = chat;
		fromConsole =
	              new BufferedReader(new InputStreamReader(System.in));
		thisloginanswer = new msgs(2);
		
		
		
		/*chat.client.getgui(this);*/
		GUI_Display();
		
	}
	
	public void GUI_Display(){
		String message=null;
		
		
		try {
			
			
			System.out.printf("Please choose one of the following options:\n");
			System.out.printf("To search, press 1\n");
			System.out.printf("To login, press 2\n");
			System.out.printf("To add a book, press 3\n");
			System.out.printf("To add a user, press 4\n");
			message = fromConsole.readLine();
			}
		catch (Exception ex)
		    {
				System.out.println
					("Unexpected error while reading from console!");
		    }
		
		
		if (message.equals("1"))
			Search_Page();
			
		if (message.equals("2"))
			Login();
		
		if (message.equals("3"))
			Add_Book();
		
		if (message.equals("4"))
			Add_User();
		
			
	}
	
	public void Search_Page(){
		msgs mapmessage = new msgs(1);
		
		
		try {
			System.out.printf("Please enter a book name:\n");
			message = fromConsole.readLine();
			mapmessage.addToMap("book", message);

			
			System.out.printf("Please enter a category:\n");
			message = fromConsole.readLine();
			mapmessage.addToMap("category", message);
			
			System.out.printf("Please enter a keyword:\n");
			message = fromConsole.readLine();
			mapmessage.addToMap("keyword", message);
		} catch(IOException exception)
	    {
			System.out.println
            ("Unexpected error while reading from console!");
		    }
		
		
		
		thischat.accept(mapmessage);
	}
	
	public void Login(){
		msgs mapmessage = new msgs(2);
		
		try {
			System.out.printf("Please enter a username:\n");
			message = fromConsole.readLine();
			mapmessage.addToMap("username", message);
			System.out.printf("Please enter a password:\n");
			message = fromConsole.readLine();
			mapmessage.addToMap("password", message);
		} catch(IOException exception)
	    {
			System.out.println
            ("Unexpected error while reading from console!");
		    }
		thisloginanswer=mapmessage;
		thischat.accept(mapmessage);
		
		
	}
	
	public void Login_Answer(msgs answer){
		//System.out.printf("This is the password:"+answer.getMapValue("password")+"\n\n");
		//System.out.printf("This is the old password:"+thisloginanswer.getMapValue("password")+"\n\n");
		
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
		int authornum,i;

		try {
			System.out.printf("Please enter a book name:\n");
			message = fromConsole.readLine();
			mapmessage.addToMap("book", message);
			

			System.out.printf("Please enter an author:\n");
			message = fromConsole.readLine();
			mapmessage.addToMap("author", message);
			
			System.out.printf("Please enter a category:\n");
			message = fromConsole.readLine();
			mapmessage.addToMap("category", message);
			
			System.out.printf("How many genres?:\n");
			message = fromConsole.readLine();
			authornum=Integer.parseInt(message);
			mapmessage.addToMap("numberofauthors", message);

			for (i=0;i<authornum;i++)
			{
				System.out.printf("Please enter an author:\n");
				message = fromConsole.readLine();
				mapmessage.addToMap("author"+i, message);
			}
			
			System.out.printf("Please enter a keyword:\n");
			message = fromConsole.readLine();
			mapmessage.addToMap("keyword", message);
		} catch(IOException exception)
	    {
			System.out.println
            ("Unexpected error while reading from console!");
		    }
		
		
		
		thischat.accept(mapmessage);
	}
	
	public void Add_User(){
		msgs mapmessage = new msgs(4);

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
			
			System.out.printf("Please enter a type:\n");
			message = fromConsole.readLine();
			mapmessage.addToMap("type", message);
			
		} catch(IOException exception)
	    {
			System.out.println
            ("Unexpected error while reading from console!");
		    }
			
		thischat.accept(mapmessage);
	}
		
	
}
