package Employee;

import javax.swing.JPanel;

import common.BookSearch;
import common.MainFrame;
import common.abstractPanel;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EmployeeHomePage extends abstractPanel {
	/**
	 * Create the panel.
	 */
	public EmployeeHomePage() {
		setLayout(null);
		super.backbutton.setVisible(false);
		
		JButton btnAddbook = new JButton("AddBook");
		btnAddbook.setBounds(169, 62, 97, 23);
		add(btnAddbook);
		btnAddbook.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(java.awt.event.ActionEvent e) 
			{
				new AddBook();
				
			}
		});
		
		JButton btnCreatereader = new JButton("CreateReader");
		btnCreatereader.setBounds(296, 62, 151, 23);
		add(btnCreatereader);
		btnCreatereader.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(java.awt.event.ActionEvent e) 
			{
				new CreateReader();
			}
		});
		
		
		JButton btnSearchbook = new JButton("SearchBook");
		btnSearchbook.setBounds(169, 96, 97, 23);
		add(btnSearchbook);
		btnSearchbook.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(java.awt.event.ActionEvent e) 
			{
				new BookSearch();
			}
		});
		
		JLabel lblEmployeeHomePage = new JLabel("Employee Home Page");
		lblEmployeeHomePage.setBounds(205, 11, 127, 14);
		add(lblEmployeeHomePage);
		
		JButton btnWatchreviews = new JButton("WatchReviews");
		btnWatchreviews.setBounds(268, 208, 118, 23);
		add(btnWatchreviews);
		btnWatchreviews.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(java.awt.event.ActionEvent e) 
			{
				System.out.println("actionPerformed()"); 
				//Controller.OpenReviewsApproval();
			}
		});
		
		
		JLabel lblReviews = new JLabel("reviews?");
		lblReviews.setBounds(285, 182, 73, 14);
		add(lblReviews);
		
		JButton btnUpdateuser = new JButton("UpdateUser");
		btnUpdateuser.setBounds(296, 96, 151, 23);
		add(btnUpdateuser);
		btnUpdateuser.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(java.awt.event.ActionEvent e) 
			{
				System.out.println("actionPerformed()"); 
				//Controller.OpenUpdateUsers();
			}
		});
		
		MainFrame.localStorage.setContentPane(this);
		
		JButton btnUpdatePaymentMethod = new JButton("Update Payment Method");
		btnUpdatePaymentMethod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnUpdatePaymentMethod.setBounds(296, 130, 151, 23);
		add(btnUpdatePaymentMethod);
		MainFrame.localStorage.setVisible(true);
	}
}
