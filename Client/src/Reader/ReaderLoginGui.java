package Reader;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JMenuBar;
import javax.swing.JComboBox;

public class ReaderLoginGui {

	private JFrame frmIbookLogin;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReaderLoginGui window = new ReaderLoginGui();
					window.frmIbookLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ReaderLoginGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmIbookLogin = new JFrame();
		frmIbookLogin.setTitle("iBook - login");
		frmIbookLogin.setBounds(100, 100, 450, 300);
		frmIbookLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmIbookLogin.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(232, 98, 86, 20);
		frmIbookLogin.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(74, 98, 86, 20);
		frmIbookLogin.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(154, 129, 89, 23);
		frmIbookLogin.getContentPane().add(btnLogin);
		
		JButton btnEmployee = new JButton("Employee");
		btnEmployee.setBounds(335, 227, 89, 23);
		frmIbookLogin.getContentPane().add(btnEmployee);
		
		JLabel lblUsername = new JLabel("username");
		lblUsername.setBounds(74, 69, 86, 14);
		frmIbookLogin.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("password");
		lblPassword.setBounds(232, 73, 86, 14);
		frmIbookLogin.getContentPane().add(lblPassword);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(10, 227, 89, 23);
		frmIbookLogin.getContentPane().add(btnExit);
	}
}
