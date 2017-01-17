package Employee;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextPane;

import common.BookSearch;
import common.MainFrame;
import common.msgs;

import javax.swing.JTextField;

import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JComboBox;

public class UpdatePaymentMethod extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	String[] PaymentMethods = { "ByMonth", "ByWeek", "Separately" };
	/**
	 * Create the panel.
	 */
	public UpdatePaymentMethod() {
		setLayout(null);
		
		JLabel lblUpdatePaymentMethod = new JLabel("Update Payment method");
		lblUpdatePaymentMethod.setBounds(184, 22, 135, 14);
		add(lblUpdatePaymentMethod);
		
		JLabel lblUsername = new JLabel("UserName:");
		lblUsername.setBounds(35, 57, 63, 14);
		add(lblUsername);
		
		JLabel lblSubscription = new JLabel("subscription");
		lblSubscription.setBounds(33, 106, 87, 14);
		add(lblSubscription);
		
		JLabel lblCreditCardNumber = new JLabel("credit card number");
		lblCreditCardNumber.setBounds(33, 164, 100, 14);
		add(lblCreditCardNumber);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(143, 51, 6, 20);
		add(textPane);
		
		textField = new JTextField();
		textField.setBounds(142, 54, 135, 20);
		add(textField);
		textField.setColumns(10);
		
		JComboBox<String> PaymentType = new JComboBox<String>();
		PaymentType.setBounds(new Rectangle(143, 106, 132, 20));
		for(String name:PaymentMethods)
			PaymentType.addItem(name);
		add(PaymentType);
		
		textField_2 = new JTextField();
		textField_2.setBounds(143, 164, 134, 20);
		add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(302, 220, 89, 23);
		add(btnSubmit);
		btnSubmit.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(java.awt.event.ActionEvent e) 
			{
				msgs updateDetails = new msgs(23);
				updateDetails.addToMap("username",textField.getText());
				updateDetails.addToMap("subscription",PaymentType.getItemAt(PaymentType.getSelectedIndex()));
				updateDetails.addToMap("paymentmathod",textField_2.getText());
				MainFrame.page.call_handler(updateDetails);	
				//super.back();
			}
		});
		MainFrame.localStorage.setContentPane(this);
		MainFrame.localStorage.setVisible(true);
	}
}
