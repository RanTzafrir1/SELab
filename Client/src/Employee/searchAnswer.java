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
import common.MainFrame;
import common.msgs;

public class searchAnswer extends JPanel {
	int msgcounter=0;

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
					MainFrame.page.call_handler(purchases.get(msgcounter));	
				}	
			});
			
			gbc_lblUsername.gridx = counterX+2;
			gbc_lblUsername.gridy = counterY;
			this.add(bookpage, gbc_lblUsername);

			
			msgcounter++;
			counterY+=1;
		}
		
	
		
		MainFrame.localStorage.setContentPane(this);
		MainFrame.localStorage.setVisible(true);
/*
		JLabel lblUsername = new JLabel("UserName:");
		GridBagConstraints gbc_lblUsername = new GridBagConstraints();
		gbc_lblUsername.gridx = 1;
		gbc_lblUsername.gridy = 1;
		this.add(lblUsername, gbc_lblUsername);*/

	/*	TxtUserName = new JTextField();
		GridBagConstraints gbc_TxtUserName = new GridBagConstraints();
		gbc_TxtUserName.insets = new Insets(0, 0, 5, 0);
		gbc_TxtUserName.fill = GridBagConstraints.HORIZONTAL;
		gbc_TxtUserName.gridx = 3;
		gbc_TxtUserName.gridy = 1;
		this.add(TxtUserName, gbc_TxtUserName);
		TxtUserName.setColumns(10);*/

		
		/*JLabel lblPassword = new JLabel("Password:");
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 1;
		gbc_lblPassword.gridy = 3;
		this.add(lblPassword, gbc_lblPassword);

		TxtPassword = new JPasswordField();
		GridBagConstraints gbc_TxtPassword = new GridBagConstraints();
		gbc_TxtPassword.insets = new Insets(0, 0, 5, 0);
		gbc_TxtPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_TxtPassword.gridx = 3;
		gbc_TxtPassword.gridy = 3;
		this.add(TxtPassword, gbc_TxtPassword);

		btnLogin = new JButton("Log In");

		GridBagConstraints gbc_btnLogin = new GridBagConstraints();
		gbc_btnLogin.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnLogin.insets = new Insets(0, 0, 0, 5);
		gbc_btnLogin.gridx = 2;
		gbc_btnLogin.gridy = 6;
		this.add(btnLogin, gbc_btnLogin);
		btnLogin.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(java.awt.event.ActionEvent e) 
			{
				System.out.println("actionPerformed()"); 
				int ans=employeeLoginController.login(TxtUserName.getText(),TxtPassword.getPassword());
				switch(ans)
				{
				case 0:
					JOptionPane.showMessageDialog(null, "wrong","Inane error", JOptionPane.ERROR_MESSAGE);
					break;
				case 1:
					JOptionPane.showMessageDialog(null,"Good JOB");
					break;
				default:
					JOptionPane.showMessageDialog(null, "Eggs are not supposed to be green.","Inane error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		
		 
		try {
			URL url = new URL( "http://cdn.modernfarmer.com/wp-content/uploads/2014/09/cowhero2.jpg");
			BufferedImage myPicture = ImageIO.read(url);
			JLabel wIcon = new JLabel(new ImageIcon(myPicture.getScaledInstance(240, 200, myPicture.SCALE_SMOOTH)));
			GridBagConstraints gbc_Pic = new GridBagConstraints();
			gbc_Pic.insets = new Insets(0, 0, 15, 5);
			gbc_Pic.fill = GridBagConstraints.HORIZONTAL;
			gbc_Pic.gridx = 2;
			gbc_Pic.gridy = 12;
			this.add(wIcon, gbc_Pic);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
		
	}
	      
	      

}

