// This file contains material supporting section 3.7 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com 
package gui_init;

import java.io.*;

import client.*;
import common.ChatIF;
import common.msgs;

import java.util.ArrayList;




/**
 * This class constructs the UI for a chat client.  It implements the
 * chat interface in order to activate the display() method.
 * Warning: Some of the code here is cloned in ServerConsole
 *
 * @author Fran&ccedil;ois B&eacute;langer
 * @author Dr Timothy C. Lethbridge
 * @author Dr Robert Lagani&egrave;re
 * @version July 2000
 */
public class ClientConsole implements ChatIF 
{
  //Class variables *************************************************

  /**
   * The default port to connect on.
   */
	protected boolean m_waitForServer;

  //Instance variables **********************************************

  /**
   * The instance of the client that created this ConsoleChat.
   */
  ChatClient client;
  msgs temp;
  

  //Constructors ****************************************************

  /**
   * Constructs an instance of the ClientConsole UI.
   *
   * @param host The host to connect to.
   * @param port The port to connect on.
   */
  
  
  ArrayList<msgs> msgslistfromserver;
  int check=0;

  public ClientConsole(String host, int port)
  {
    try
    {
      client= new ChatClient(host, port, this);
    }
    catch(IOException exception)
    {
      System.out.println("Error: Can't setup connection!"
                + " Terminating client.");
      System.exit(1);
    }
  }


  //Instance methods ************************************************

  /**
   * This method waits for input from the console.  Once it is
   * received, it sends it to the client's message handler.
   */
  public void accept(Object message)
  {
	  client.handleMessageFromClientUI(message);		
  }
  
  
  
/*  @SuppressWarnings("unchecked")
public ArrayList<msgs> accept2(Object message){
	  
	  client.handleMessageFromClientUI(message);
	  ArrayList<msgs> msgsfromserver;
	  
		msgsfromserver=(ArrayList<msgs>) client.msgslistfromserver;
		return msgsfromserver;
 
  }*/
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	
	  
	  
	  
	  
	  
	  
  public void display(String message)
  {
    System.out.println("> " + message);
    System.out.printf("\n\nPlease select one of the following options.\n");     
    System.out.printf("To print the tuple, please enter 1.\n");     
    System.out.printf("To update the tuple, please enter 2.\n");   

  }

}

