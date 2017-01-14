package Employee;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import common.MainFrame;
import common.abstractPanel;
import common.msgs;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreateReader extends abstractPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Create the panel.
	 */
	public CreateReader() {
		setLayout(null);
		
		JLabel lblUsername = new JLabel("username");
		lblUsername.setBounds(49, 30, 78, 16);
		add(lblUsername);
		
		textField = new JTextField();
		textField.setBounds(158, 27, 116, 22);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("password");
		lblPassword.setBounds(49, 65, 56, 16);
		add(lblPassword);
		
		textField_1 = new JTextField();
		textField_1.setBounds(158, 62, 116, 22);
		add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(158, 103, 116, 22);
		add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblFirstname = new JLabel("firstname");
		lblFirstname.setBounds(49, 106, 56, 16);
		add(lblFirstname);
		
		JLabel lblLastname = new JLabel("lastname");
		lblLastname.setBounds(49, 147, 56, 16);
		add(lblLastname);
		
		textField_3 = new JTextField();
		textField_3.setBounds(158, 144, 116, 22);
		add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblSsn = new JLabel("ssn");
		lblSsn.setBounds(49, 188, 56, 16);
		add(lblSsn);
		
		textField_4 = new JTextField();
		textField_4.setBounds(158, 185, 116, 22);
		add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnSubmit = new JButton("submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				msgs sendtoserver = new msgs(4);
				sendtoserver.addToMap("username", textField.getText());
				sendtoserver.addToMap("password", textField_1.getText());
				sendtoserver.addToMap("firstname", textField_2.getText());
				sendtoserver.addToMap("lastname", textField_3.getText());
				sendtoserver.addToMap("ssn", textField_4.getText());
				MainFrame.page.call_handler(sendtoserver);	
				
				new CreateReader();
			}
		});
		btnSubmit.setBounds(132, 238, 97, 25);
		add(btnSubmit);
		
		MainFrame.localStorage.setContentPane(this);
		MainFrame.localStorage.setVisible(true);

	}

}
