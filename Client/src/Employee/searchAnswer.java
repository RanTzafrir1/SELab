package Employee;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javafx.geometry.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;
import common.BookSearch;
import common.MainFrame;
import common.abstractPanel;
import common.msgs;

public class searchAnswer extends abstractPanel {

	/**
	 * Create the panel.
	 */
	public searchAnswer(ArrayList<msgs> purchases) {
		
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		int counterX=0;
		int counterY=0;
		
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 164, 121, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.5, 0.5, 0.5, 0.5, 0.5, 0.5, 0.5, Double.MIN_VALUE};
		this.setLayout(gbl_contentPane);
		
		super.backbutton.setVisible(false);
		
		for (msgs tempmsg : purchases){
			counterX=0;
			String authors="";
			for (String key : tempmsg.getMap().keySet()) 	
			{
				
				if(key.contains("title"))
				{
					JLabel lblUsername = new JLabel(tempmsg.getMapValue(key));
					GridBagConstraints gbc_lblUsername = new GridBagConstraints();
					gbc_lblUsername.gridx = counterX;
					gbc_lblUsername.gridy = counterY;
					this.add(lblUsername, gbc_lblUsername);
				}
				if(key.contains("author"))
					authors+=tempmsg.getMapValue(key)+" ";
			}
			JLabel lblUsername = new JLabel(authors);
			GridBagConstraints gbc_lblUsername = new GridBagConstraints();
			gbc_lblUsername.gridx = counterX+1;
			gbc_lblUsername.gridy = counterY;
			this.add(lblUsername, gbc_lblUsername);
			
			JButton bookpage = new JButton("bookpage");
			bookpage.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {	
					msgs sendtoHandler = tempmsg;
					sendtoHandler.setOPCode(15);
					MainFrame.page.call_handler(sendtoHandler);	
					//sendtoHandler.clearMap();
				}	
			});
			
			gbc_lblUsername.gridx = counterX+2;
			gbc_lblUsername.gridy = counterY;
			this.add(bookpage, gbc_lblUsername);

			counterY+=1;
		}
		
		JButton backbutton = new JButton("back");
		backbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				new BookSearch();
			}	
		});
		
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.gridx = counterX+4;
		
		this.add(backbutton, gbc_button);
		
		MainFrame.localStorage.setContentPane(this);
		MainFrame.localStorage.setVisible(true);

		
		
	}
	      
	      

}

