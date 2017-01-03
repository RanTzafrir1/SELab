// This file contains material supporting section 3.7 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com 
package gui_init;

import java.io.*;

import client.*;
import common.ChatIF;
import common.msgs;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.TextArea;



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
public class ClientConsole extends JFrame implements ChatIF 
{
  //Class variables *************************************************
	private static final long serialVersionUID = 1L;
	private JTextField txtHost;
	private JTextField textPort;
//	private JTextField txtRoot;
//	private JTextField txtPassword;
	private TextArea txtArea;


	protected boolean m_waitForServer;

  //Instance variables **********************************************

	ChatClient client;
	JFrame clientTempFrame;
	msgs temp;
	ArrayList<msgs> msgslistfromserver;
	int check=0;

  //Constructors ****************************************************

  /**
   * Constructs an instance of the ClientConsole UI.
   *
   * @param host The host to connect to.
   * @param port The port to connect on.
   */
  
  
  

  public ClientConsole()
  {
	  super();  
	  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  clientTempFrame=this;
	  clientTempFrame.setSize(500, 400);
	  clientTempFrame.setLayout(null);
	  clientTempFrame.getContentPane().setBackground(Color.orange);
	  
		JLabel lblClientConsol = new JLabel("Client Consol");
		lblClientConsol.setBounds(187, 23, 77, 14);
		add(lblClientConsol);
		
		JLabel lblHost_1 = new JLabel("host:");
		lblHost_1.setBounds(60, 63, 46, 14);
		add(lblHost_1);
		
		JLabel lblPort = new JLabel("port:");
		lblPort.setBounds(60, 102, 46, 28);
		lblPort.setFont(getFont());
		add(lblPort);
		/*
		JLabel lblUsername = new JLabel("userName");
		lblUsername.setBounds(248, 63, 68, 14);
		add(lblUsername);
		
		JLabel lblPassword = new JLabel("password:");
		lblPassword.setBounds(248, 109, 56, 14);
		add(lblPassword);
		*/
		txtHost = new JTextField();
		txtHost.setText("localhost");
		txtHost.setBounds(104, 60, 86, 20);
		add(txtHost);
		txtHost.setColumns(10);
		
		textPort = new JTextField();
		textPort.setText("5553");
		textPort.setBounds(104, 106, 86, 20);
		add(textPort);
		textPort.setColumns(10);
		
		
		/*
		txtRoot = new JTextField();
		txtRoot.setText("root");
		txtRoot.setBounds(338, 60, 86, 20);
		add(txtRoot);
		txtRoot.setColumns(10);
		
		
		
		txtPassword = new JTextField();
		txtPassword.setBounds(338, 106, 86, 20);
		add(txtPassword);
		txtPassword.setColumns(10);
		*/
		
		txtArea = new TextArea();
		txtArea.setBounds(80, 166, 320, 130);
		txtArea.setEditable(false);
		txtArea.setText("plz fill up the filleds abobe and then press on connect button");
		add(txtArea);
		
		JButton btnConnect = new JButton("Connect");
		btnConnect.setBounds(190,130, 100, 20);
		
		btnConnect.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				/*try
			    {
			      client=  new ChatClient(txtHost.getText(),Integer.parseInt(textPort.getText()), (ChatIF)client);*/
				
			      clientTempFrame.setVisible(false);
			      common.MainClass.localStorage.setContentPane(new EmployeeLogin());
			      common.MainClass.localStorage.setVisible(true);
			      
			      //now open first window
			      
			    /*}
			    catch(IOException exception)
			    {
			    	txtArea.setText(txtArea.getText()+"\nError: Can't setup connection! check your input");
			    }*/
			}
		});
		add(btnConnect);
  }
		
   
	
	


  //Instance methods ************************************************

  /**
   * This method waits for input from the console.  Once it is
   * received, it sends it to the client's message handler.
   */
  public void accept(Object message)
  {
	  this.client.handleMessageFromClientUI(message);		
  }



@Override
public void display(String message) {
	txtArea.setText(txtArea.getText()+"\n"+message);

}
  

  
  
/*  @SuppressWarnings("unchecked")
public ArrayList<msgs> accept2(Object message){
	  
	  client.handleMessageFromClientUI(message);
	  ArrayList<msgs> msgsfromserver;
	  
		msgsfromserver=(ArrayList<msgs>) client.msgslistfromserver;
		return msgsfromserver;
 
  }*/
	  


}

