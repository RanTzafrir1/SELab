package Employee;

import javax.swing.JPanel;

import common.BookSearch;
import common.MainFrame;
import common.abstractPanel;

import javax.swing.JButton;
import javax.swing.JLabel;

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
		btnCreatereader.setBounds(306, 62, 106, 23);
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
		btnUpdateuser.setBounds(306, 96, 106, 23);
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
		MainFrame.localStorage.setVisible(true);
	}

}
