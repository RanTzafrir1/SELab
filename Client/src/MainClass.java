import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import common.MainFrame;

import client.ClientConsole;
import gui_init.*;

@SuppressWarnings("serial")
public class MainClass extends JFrame{
	
	
	final public static int DEFAULT_PORT = 5552;

	//static Gui_init1 GUI;
	static MainFrame frame;
	
	 public static void main(String[] args)
	 {
		 String host = "";
		/* String IP = new String();
		 
	     JTextField field1 = new JTextField();
	     JPanel panel = new JPanel(new GridLayout(0, 1));
	     panel.add(new JLabel("Please enter server IP"));
	     panel.add(field1);
	     JOptionPane.showConfirmDialog(null, panel, "Test",
	            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
	     IP=field1.getText();
	     System.out.println(IP);*/
		
		
		
		
		 try
		    {
		    	
		      host = args[0];
		    }
		    catch(ArrayIndexOutOfBoundsException e)
		    {
		      host = "localhost";
		    }
		 	
		    ClientConsole chat= new ClientConsole(host, DEFAULT_PORT);
		    frame = new MainFrame(chat);
		    //GUI = new Gui_init1(chat);
		    //GUI.setVisible(true);  
		    //chat.display("Welcome!1");
	 }
}


