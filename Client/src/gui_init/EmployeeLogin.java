package gui_init;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.swing.colorchooser.*;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import common.MainClass;
import common.msgs;

public class EmployeeLogin extends JPanel{
	Image img;
	
	private static final long serialVersionUID = 00424;
		private JTextField TxtUserName;
		private JButton    btnLogin;
		private JTextField TxtPassword;
		ClientConsole thischat;
		
		public EmployeeLogin() {
			super();
			this.setLayout(null);
			this.setBackground(new Color(91, 91, 91));
			//employeeLoginController Controllers = new employeeLoginController();
			
			Font myFont = new Font("Serif", Font.BOLD, 20);
			
			JLabel lblTitle = new JLabel("Employee Only Login:");
			lblTitle.setFont(new Font("Serif", Font.BOLD, 40));
			lblTitle.setForeground(Color.green);
			lblTitle.setBounds(150, 52, 400, 40);
			add(lblTitle);
			
			
			this.setLayout(null);
			JLabel lblUsername = new JLabel("UserName:");
			lblUsername.setBounds(104, 106, 126, 40);
			lblUsername.setForeground(Color.white);
			lblUsername.setFont(myFont);
			add( lblUsername);

			TxtUserName = new JTextField();
			TxtUserName.setFont(myFont);
			TxtUserName.setBounds(204, 106, 206, 40);
			add(TxtUserName);

			
			JLabel lblPassword = new JLabel("Password:");
			lblPassword.setFont(myFont);
			lblPassword.setForeground(Color.white);
			lblPassword.setBounds(104, 206, 126, 40);
			add(lblPassword);

			TxtPassword = new JTextField();
			TxtPassword.setFont(myFont);
			TxtPassword.setBounds(204, 206, 206,40);
			add(TxtPassword);
			
			btnLogin = new JButton("Log In");
			btnLogin.setBounds(204, 306, 126, 40);
			btnLogin.setFont(myFont);
			add(btnLogin);
			btnLogin.addActionListener(new java.awt.event.ActionListener()
			{
				public void actionPerformed(java.awt.event.ActionEvent e) 
				{
					System.out.println("actionPerformed()"); 
					//Controllers.login(TxtUserName.getText(),TxtPassword.getText());
					/*switch(ans)
					{
					case 0:
						JOptionPane.showMessageDialog(null, "wrong","Inane error", JOptionPane.ERROR_MESSAGE);
						break;
					case 1:
						JOptionPane.showMessageDialog(null,"Good JOB");
						break;
					default:
						JOptionPane.showMessageDialog(null, "Eggs are not supposed to be green.","Inane error", JOptionPane.ERROR_MESSAGE);
					}*/
					
				}
			});
			
			
			 
			try {
				URL url = new URL( "https://newevolutiondesigns.com/images/freebies/cool-wallpaper-3.jpg");
				BufferedImage myPicture = ImageIO.read(url);
				JLabel wIcon = new JLabel(new ImageIcon(myPicture.getScaledInstance(900, 600, myPicture.SCALE_SMOOTH)));
				wIcon.setBounds(400, 100, 1200, 800);
				add(wIcon);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

		
		
		
}	


