package common;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Controllers.Controller_Mainpage;
import Employee.employeeLogin;
import client.ClientConsole;
import common.msgs;
//import Employee.employeeLogin;


@SuppressWarnings("serial")
public class MainFrame extends JFrame{
	
	//global parameters
	 public static ArrayList<JPanel> panelPassedList = new ArrayList<JPanel>();;//list of all the panels we passed
	 public msgs userinfo;
	 public static MainFrame localStorage;
	 public ClientConsole client;
	 public static Controller_Mainpage page;
	 public static bookPage bookP = new bookPage();
	 ArrayList<String> languagelist = new ArrayList<String>();
	 public static ArrayList<msgs> genreslist = new ArrayList<msgs>();
	
	 
	 public MainFrame(ClientConsole chat)
	 {
		  super();  
		  this.client=chat;
		  localStorage=this;
		  page = new Controller_Mainpage(client);
		  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  setSize(this.getMaximumSize());
		  getContentPane().setBackground(Color.orange);
		  createLists create = new createLists();
		  employeeLogin login=new employeeLogin(0);

	 }
}


