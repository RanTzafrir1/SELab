package Reader;

import javax.swing.JPanel;

import common.MainFrame;
import common.abstractPanel;

import javax.swing.JLabel;
import java.awt.TextArea;
import javax.swing.JButton;

public class ReaderBookPage extends abstractPanel {
	String BookID;
	BookPageController controller;
	/**
	 * Create the panel.
	 */
	public ReaderBookPage(String Summary,String AuthorName,String BookID,String BookTitle) {
		setLayout(null);
		this.BookID=BookID;
		controller=new BookPageController();
		
		
		JLabel lblBooktitle = new JLabel(BookTitle);
		lblBooktitle.setBounds(48, 32, 43, 14);
		add(lblBooktitle);
		
		JLabel lblReaderBookPage = new JLabel("Reader Book Page");
		lblReaderBookPage.setBounds(181, 11, 88, 14);
		add(lblReaderBookPage);
		
		JLabel lblAuthor = new JLabel(AuthorName);
		lblAuthor.setBounds(124, 32, 46, 14);
		add(lblAuthor);
		
		TextArea textArea = new TextArea();
		textArea.setText(Summary);
		textArea.setEditable(false);
		textArea.setBounds(20, 52, 408, 208);
		add(textArea);
		
		JButton btnPurchase = new JButton("purchase");
		btnPurchase.setBounds(307, 266, 89, 23);
		add(btnPurchase);
		btnPurchase.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(java.awt.event.ActionEvent e) 
			{
				System.out.println("actionPerformed()"); 
				controller.purchase(BookID,MainFrame.localStorage.userinfo.getMapValue("userName"));
			
			}
		});

	}
}
