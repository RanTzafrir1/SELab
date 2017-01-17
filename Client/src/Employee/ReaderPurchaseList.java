package Employee;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

import common.MainFrame;
import common.abstractPanel;
import common.msgs;

public class ReaderPurchaseList extends abstractPanel{
	
	ArrayList<msgs> localpurchases;
	
	public ReaderPurchaseList(ArrayList<msgs> purchases) {
		localpurchases=purchases;
		 
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		int counterX=0;
		int counterY=0;
		
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 164, 121, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.5, 0.5, 0.5, 0.5, 0.5, 0.5, 0.5, Double.MIN_VALUE};
		this.setLayout(gbl_contentPane);
		
		GridBagConstraints gbc_lblUsername = new GridBagConstraints();
		
		for (msgs tempmsg : localpurchases){
			
					JLabel lblUsername = new JLabel(tempmsg.getMapValue("title"));
					
					gbc_lblUsername.gridx = counterX;
					gbc_lblUsername.gridy = counterY;
					this.add(lblUsername, gbc_lblUsername);

					JLabel lblReview = new JLabel(tempmsg.getMapValue("date"));
					
					gbc_lblUsername.gridx = counterX+1;
					gbc_lblUsername.gridy = counterY;
					this.add(lblReview, gbc_lblUsername);
					
					JButton button = new JButton("addreview");
					button.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							msgs sendtoHandler = tempmsg;
							sendtoHandler.setOPCode(7);
							new WriteReview(sendtoHandler);
						}
					});
					gbc_lblUsername.gridx = counterX+2;
					gbc_lblUsername.gridy = counterY;
					this.add(button, gbc_lblUsername);					

					counterY+=1;
		}
		
	

		
		MainFrame.localStorage.setContentPane(this);
		MainFrame.localStorage.setVisible(true);


	}
}
