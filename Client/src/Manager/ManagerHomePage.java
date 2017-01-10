package Manager;

import Employee.EmployeeHomePage;
import javax.swing.JButton;
import javax.swing.JCheckBox;


public class ManagerHomePage extends EmployeeHomePage {
	ManagerHomePageController ControllerRating;
	public ManagerHomePage() {
		setLayout(null);
		

		JCheckBox chckbxBookInAll = new JCheckBox("book In all categries");
		chckbxBookInAll.setBounds(10, 143, 134, 23);
		add(chckbxBookInAll);
		
		JButton btnRatingonebook = new JButton("Purchase Rating");
		btnRatingonebook.setBounds(10, 72, 115, 23);
		add(btnRatingonebook);
		btnRatingonebook.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(java.awt.event.ActionEvent e) 
			{
				System.out.println("actionPerformed()"); 
				ControllerRating.OpenPurchaseRating();
			}
		});
		
		
		JButton btnRatingallbooks = new JButton("RatingAllBooks ");
		btnRatingallbooks.setBounds(10, 108, 115, 23);
		add(btnRatingallbooks);
		btnRatingallbooks.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(java.awt.event.ActionEvent e) 
			{
				System.out.println("actionPerformed()"); 
				if(chckbxBookInAll.getAutoscrolls()==true)
					ControllerRating.OpenRatingAllBooks();
				else
					ControllerRating.OpenRatingOneCategory();
			}
		});
		
		
		JButton btnUsersStatistics = new JButton("Users Statistics");
		btnUsersStatistics.setBounds(10, 38, 115, 23);
		add(btnUsersStatistics);
		btnRatingallbooks.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(java.awt.event.ActionEvent e) 
			{
				System.out.println("actionPerformed()"); 
				ControllerRating.OpenUsersStatistics();
			}
		});
		
		
	}
}
