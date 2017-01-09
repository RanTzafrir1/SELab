package gui_init;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

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
import common.msgs;


public class Gui_init1 extends JFrame{
		/**
	 * 
	 */
	private static final long serialVersionUID = 00424;
		private JPanel     contentPane;
		private JTextField TxtUserName;
		private JButton    btnLogin;
		private JTextField TxtPassword;
		ClientConsole thischat;
		
		public Gui_init1(ClientConsole chat) {
			super();	
			this.thischat=chat;
			employeeLoginController Controllers = new employeeLoginController(chat);
			
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 610, 435);
			contentPane = new JPanel();
			
			
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);

			this.setLocationRelativeTo(null);
			GridBagLayout gbl_contentPane = new GridBagLayout();
			gbl_contentPane.columnWidths = new int[]{0, 164, 121, 0, 0};
			gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
			gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
			gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			contentPane.setLayout(gbl_contentPane);

			JLabel lblUsername = new JLabel("UserName:");
			GridBagConstraints gbc_lblUsername = new GridBagConstraints();
			gbc_lblUsername.insets = new Insets(0, 0, 5, 5);
			gbc_lblUsername.gridx = 1;
			gbc_lblUsername.gridy = 1;
			contentPane.add(lblUsername, gbc_lblUsername);

			TxtUserName = new JTextField();
			GridBagConstraints gbc_TxtUserName = new GridBagConstraints();
			gbc_TxtUserName.insets = new Insets(0, 0, 5, 0);
			gbc_TxtUserName.fill = GridBagConstraints.HORIZONTAL;
			gbc_TxtUserName.gridx = 3;
			gbc_TxtUserName.gridy = 1;
			contentPane.add(TxtUserName, gbc_TxtUserName);
			TxtUserName.setColumns(10);

			
			JLabel lblPassword = new JLabel("Password:");
			GridBagConstraints gbc_lblPassword = new GridBagConstraints();
			gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
			gbc_lblPassword.gridx = 1;
			gbc_lblPassword.gridy = 3;
			contentPane.add(lblPassword, gbc_lblPassword);

			TxtPassword = new JTextField();
			GridBagConstraints gbc_TxtPassword = new GridBagConstraints();
			gbc_TxtPassword.insets = new Insets(0, 0, 5, 0);
			gbc_TxtPassword.fill = GridBagConstraints.HORIZONTAL;
			gbc_TxtPassword.gridx = 3;
			gbc_TxtPassword.gridy = 3;
			contentPane.add(TxtPassword, gbc_TxtPassword);
			TxtUserName.setColumns(10);

			btnLogin = new JButton("Log In");

			GridBagConstraints gbc_btnLogin = new GridBagConstraints();
			gbc_btnLogin.fill = GridBagConstraints.HORIZONTAL;
			gbc_btnLogin.insets = new Insets(0, 0, 0, 5);
			gbc_btnLogin.gridx = 2;
			gbc_btnLogin.gridy = 6;
			contentPane.add(btnLogin, gbc_btnLogin);
			btnLogin.addActionListener(new java.awt.event.ActionListener()
			{
				public void actionPerformed(java.awt.event.ActionEvent e) 
				{
					System.out.println("actionPerformed()"); 
					Controllers.login(TxtUserName.getText(),TxtPassword.getText());
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
				URL url = new URL( "http://cdn.modernfarmer.com/wp-content/uploads/2014/09/cowhero2.jpg");
				BufferedImage myPicture = ImageIO.read(url);
				JLabel wIcon = new JLabel(new ImageIcon(myPicture.getScaledInstance(240, 200, myPicture.SCALE_SMOOTH)));
				GridBagConstraints gbc_Pic = new GridBagConstraints();
				gbc_Pic.insets = new Insets(0, 0, 15, 5);
				gbc_Pic.fill = GridBagConstraints.HORIZONTAL;
				gbc_Pic.gridx = 2;
				gbc_Pic.gridy = 12;
				contentPane.add(wIcon, gbc_Pic);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

		
		
		
		
}	


