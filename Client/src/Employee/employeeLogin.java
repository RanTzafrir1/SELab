package Employee;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import common.MainFrame;
import common.msgs;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

@SuppressWarnings("serial")
public class employeeLogin extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	
	/**
	 * Create the panel.
	 */
	public employeeLogin(int notexists) {
		setLayout(null);
		msgs loginmsg = new msgs (2);
		
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(37, 56, 84, 16);
		add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(37, 111, 84, 16);
		add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(142, 53, 116, 22);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(142, 108, 116, 22);
		add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnSubmit = new JButton("Login");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				loginmsg.addToMap("username", textField.getText());
				loginmsg.addToMap("password", textField_1.getText());
				MainFrame.page.call_handler(loginmsg);
			}
		});
		btnSubmit.setBounds(157, 187, 97, 25);
		btnSubmit.setEnabled(true);
		add(btnSubmit);
		
		JLabel lblUserDoesNot = new JLabel("User does not exist");
		lblUserDoesNot.setForeground(Color.RED);
		lblUserDoesNot.setBounds(118, 155, 278, 16);
		add(lblUserDoesNot);
		
		lblUserDoesNot.setVisible(false);
		if (notexists==1)
			lblUserDoesNot.setVisible(true);
		
		MainFrame.localStorage.setContentPane(this);
		MainFrame.localStorage.setVisible(true);

	}
}
