package common;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

import Controllers.Controller_Mainpage;
import Employee.UpdateBook;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class bookPage extends abstractPanel {

	/**
	 * Create the panel.
	 */
	JLabel lblNewLabel = new JLabel("Title");
	JLabel lblAuthor = new JLabel("Author");
	JLabel lblSummary = new JLabel("Summary");
	JButton btnPurchase = new JButton("Purchase");
	JButton btnReviews = new JButton("Reviews");
	JButton btnUpdateBook = new JButton("UpdateBook");

	
	public bookPage() {
		setLayout(null);
		
		
		lblNewLabel.setBounds(63, 13, 117, 32);
		add(lblNewLabel);
		
		
		lblAuthor.setBounds(63, 77, 223, 32);
		add(lblAuthor);
		
		
		lblSummary.setBounds(63, 122, 251, 65);
		add(lblSummary);

	}
	
	public void openBookPage(msgs bookMessage){
		lblNewLabel.setText(bookMessage.getMapValue("title"));
		String authors="";
		for (String key : bookMessage.getMap().keySet()) 	
		{
			
			if(key.contains("author"))
			{
				authors+=bookMessage.getMapValue(key)+" ";
			}
		}
		
		lblAuthor.setText(authors);
		lblSummary.setText(bookMessage.getMapValue("summary"));
		
		btnPurchase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				msgs sendtoHandler = bookMessage;
				sendtoHandler.setOPCode(8);
				sendtoHandler.addToMap("username", MainFrame.page.current_user.getMapValue("username"));
				MainFrame.page.call_handler(sendtoHandler);	
			}
		});
		
		btnPurchase.setBounds(300, 235, 97, 25);
		add(btnPurchase);
		
		if (MainFrame.page.current_user.getMapValue("type").equals("1"))
			btnPurchase.setVisible(false);
		
		btnReviews.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookMessage.setOPCode(11);
				MainFrame.page.call_handler(bookMessage);
			}
		});
		
		btnReviews.setBounds(179, 235, 97, 25);
		add(btnReviews);
		
		
		
		btnUpdateBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookMessage.setOPCode(13);
				new UpdateBook(bookMessage);
			}
		});
		
		btnUpdateBook.setBounds(60, 235, 97, 25);
		add(btnUpdateBook);
		

		
		
		
		

		MainFrame.localStorage.setContentPane(this);
		MainFrame.localStorage.setVisible(true);
	}

}
