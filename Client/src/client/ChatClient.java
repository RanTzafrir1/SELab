// This file contains material supporting section 3.7 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com 

package client;
import ocsf.client.*;
import common.*;

import java.io.*;
import java.util.ArrayList;

import gui_init.*;

/**
 * This class overrides some of the methods defined in the abstract
 * superclass in order to give more functionality to the client.
 *
 * @author Dr Timothy C. Lethbridge
 * @author Dr Robert Lagani&egrave;
 * @author Fran&ccedil;ois B&eacute;langer
 * @version July 2000
 */
@SuppressWarnings("serial")
public class ChatClient extends AbstractClient implements Serializable
{
  //Instance variables **********************************************
  
  /**
   * The interface type variable.  It allows the implementation of 
   * the display method in the client.
   */
  ChatIF clientUI; 
  
  
  //public ArrayList<msgs> msgslistfromserver;
  //public Object msgslistfromserver;
  ArrayList <msgs> msgfromserver;
  public msgs tempmsg;
  employeeLoginController GUI;
  HandleMessagesFromServer messagehandler;
  
  //Constructors ****************************************************
  
  /**
   * Constructs an instance of the chat client.
   *
   * @param host The server to connect to.
   * @param port The port number to connect on.
   * @param clientUI The interface type variable.
   */
  public ChatClient(String host, int port, ChatIF clientUI) 
   
   
		  throws IOException 
  {
    super(host, port); //Call the superclass constructor
    this.clientUI = clientUI;
    openConnection();
  }

  //Instance methods ************************************************
    
  @SuppressWarnings("unchecked")
public void handleMessageFromServer(Object msg) 
  {
    //this.msgslistfromserver=(ArrayList<msgs>) msg;
    //this.msgslistfromserver=msg;
	  msgfromserver = (ArrayList<msgs>) msg;
	  messagehandler.startmessagehandler(msgfromserver);
	  //GUI.Login_Answer(msgfromserver);
	  
	  
	  
	  //System.out.printf("\nThe new username is: "+tempmsg.getMapValue("username"));
	  //System.out.printf("\nThe new password is: "+tempmsg.getMapValue("password"));
	//sh = new ServerHandler(msg);
	
	//sh.letsgo();
	  
  }
  
  public void getgui(employeeLoginController gui_init1){
	  this.GUI=gui_init1;
	  messagehandler = new HandleMessagesFromServer(GUI);
  }

  /**
   * This method handles all data coming from the UI            
   *
   * @param msgs The message from the UI.    
   */
  public void handleMessageFromClientUI(Object msgs)
  {
    try
    {
    	sendToServer(msgs);
    }
    catch(IOException e)
    {
      clientUI.display
        ("Could not send message to server.  Terminating client.");
      quit();
    }
  }
  
  /**
   * This method terminates the client.
   */
  public void quit()
  {
    try
    {
      closeConnection();
    }
    catch(IOException e) {}
    System.exit(0);
  }
}
//End of ChatClient class
