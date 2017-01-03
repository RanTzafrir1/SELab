package common;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;

import client.ChatClient;
import common.msgs;
import gui_init.ClientConsole;
import gui_init.EmployeeLogin;


@SuppressWarnings("serial")
public class MainClass extends JFrame{
	
	//global parameters
	 static ArrayList<JPanel> panelPassedList;//list of all the panels we passed
	 static msgs userinfo;
	public static MainClass localStorage;
	 static ChatClient client;
	
	 public static void main(String[] args)
	 {
		 	localStorage=new MainClass();
		 	ClientConsole GUI = new ClientConsole();
		    GUI.setVisible(true);   
	 }
	 MainClass()
	 {
		  super();  
		  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  setSize(this.getMaximumSize());
		  getContentPane().setBackground(Color.orange);
		  EmployeeLogin login=new EmployeeLogin();
		  setContentPane(login);
		  this.setVisible(false);
	 }
}


