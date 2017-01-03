package common;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.TextArea;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;

public class Main extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtHost;
	private JTextField textField;
	private JTextField txtRoot;
	private JTextField textField_1;
	private TextArea textArea;

	/**
	 * Create the panel.
	 */
	public Main() {
		setLayout(null);
		this.setBackground(Color.ORANGE);	
		
		JLabel lblHost_1 = new JLabel("host:");
		lblHost_1.setBounds(60, 63, 46, 14);
		add(lblHost_1);
		
		JLabel lblPort = new JLabel("port:");
		lblPort.setBounds(60, 102, 46, 28);
		add(lblPort);
		
		JLabel lblUsername = new JLabel("userName");
		lblUsername.setBounds(248, 63, 68, 14);
		add(lblUsername);
		
		JLabel lblPassword = new JLabel("password:");
		lblPassword.setBounds(248, 109, 56, 14);
		add(lblPassword);
		
		txtHost = new JTextField();
		txtHost.setText("localhost");
		txtHost.setBounds(104, 60, 86, 20);
		add(txtHost);
		txtHost.setColumns(10);
		
		textField = new JTextField();
		textField.setText("5553");
		textField.setBounds(104, 106, 86, 20);
		add(textField);
		textField.setColumns(10);
		
		
		
		txtRoot = new JTextField();
		txtRoot.setText("root");
		txtRoot.setBounds(338, 60, 86, 20);
		add(txtRoot);
		txtRoot.setColumns(10);
		
		
		
		textField_1 = new JTextField();
		textField_1.setBounds(338, 106, 86, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblClientConsol = new JLabel("Client Consol");
		lblClientConsol.setBounds(187, 23, 77, 14);
		add(lblClientConsol);
		
		TextArea textArea = new TextArea();
		textArea.setBounds(80, 166, 320, 130);
		textArea.setEditable(false);
		textArea.setText("plz fill up the filleds abobe and then press on connect button");
		add(textArea);
		
		JButton btnConnect = new JButton("Connect");
		btnConnect.setBounds(175, 137, 89, 23);
		add(btnConnect);
		btnConnect.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				
			}
		});
		

	}
	
}
