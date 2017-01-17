package common;

import javax.swing.JPanel;
import javax.swing.JCheckBox;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BookSearch extends abstractPanel {
	private JTextField title;
	private JTextField author;
	private JTextField language;
	private JTextField genre;
	private JTextField keyword;
	private JTextField textField;
	int counter=0;
	msgs searchmsg = new msgs (5);
	
	/**
	 * Create the panel.
	 */
	public BookSearch() {
		setLayout(null);
		
		searchmsg.clearMap();
		if (MainFrame.page.current_user.getMapValue("type").equals("0"))
			super.backbutton.setVisible(false);
		
		
			
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTitle.setBounds(12, 44, 50, 25);
		add(lblTitle);
		
		JCheckBox chckbxSearchByOr = new JCheckBox("search by or");
		chckbxSearchByOr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (chckbxSearchByOr.isSelected())
					searchmsg.setOPCode(6);
			}
		});
		chckbxSearchByOr.setBounds(190, 5, 99, 25);
		add(chckbxSearchByOr);
		
		JLabel lblAuthor = new JLabel("Author");
		lblAuthor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAuthor.setBounds(12, 82, 50, 25);
		add(lblAuthor);
		
		JLabel lblLanguage = new JLabel("Language");
		lblLanguage.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLanguage.setBounds(12, 120, 82, 25);
		add(lblLanguage);
		
		JLabel lblGenre = new JLabel("Genre");
		lblGenre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGenre.setBounds(12, 158, 50, 25);
		add(lblGenre);
		
		JLabel lblKeyword = new JLabel("Keyword");
		lblKeyword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblKeyword.setBounds(12, 196, 82, 25);
		add(lblKeyword);
		
		title = new JTextField();
		title.setText("");
		title.setBounds(156, 46, 116, 22);
		title.setText(null);
		add(title);
		title.setColumns(10);
		
		author = new JTextField();
		author.setBounds(156, 84, 116, 22);
		author.setText(null);
		add(author);
		author.setColumns(10);
		
		language = new JTextField();
		language.setBounds(156, 122, 116, 22);
		language.setText(null);
		add(language);
		language.setColumns(10);
		
		genre = new JTextField();
		genre.setBounds(156, 160, 116, 22);
		genre.setText(null);
		add(genre);
		genre.setColumns(10);
		
		keyword = new JTextField();
		keyword.setBounds(156, 198, 116, 22);
		keyword.setText(null);
		add(keyword);
		keyword.setColumns(10);
		
		JButton button = new JButton("+");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				counter++;
				searchmsg.addToMap("keyword"+counter, keyword.getText());	
				keyword.setText(null);
			}
		});
		button.setBounds(284, 197, 41, 25);
		add(button);
		
		JButton btnList = new JButton("list");
		btnList.setBounds(284, 159, 97, 25);
		add(btnList);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				counter++;
				if (title.getText().length()>0) 
					searchmsg.addToMap("title", title.getText());
				if (author.getText().length()>0) 
					searchmsg.addToMap("author", author.getText());
				if (language.getText().length()>0) 
					searchmsg.addToMap("language", language.getText());
				if (genre.getText().length()>0) 
					searchmsg.addToMap("genre", genre.getText());
				if (keyword.getText().length()>0) 
					searchmsg.addToMap("keyword"+counter, keyword.getText());
				
				
				/*msgs sendtoserver = new msgs(0);
				
				sendtoserver.setOPCode(searchmsg.getOPcode());
				for (String key : searchmsg.getMap().keySet()) 	
				{
					sendtoserver.addToMap(key, searchmsg.getMapValue(key));
				}
				
				searchmsg.clearMap();*/
				
			
				
				MainFrame.page.call_handler(searchmsg);
				
				//searchmsg = new msgs(5);
				//searchmsg.clearMap();
				//searchmsg.setOPCode(5);
				//new BookSearch();
				
			}
		});
		btnSearch.setBounds(175, 249, 97, 25);
		add(btnSearch);
		
		MainFrame.localStorage.setContentPane(this);
		
		textField = new JTextField();
		textField.setBounds(156, 160, 116, 22);
		add(textField);
		textField.setColumns(10);
		
		JButton btnPurchases = new JButton("Purchases");
		btnPurchases.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				msgs purchasesmsg = new msgs (9);
				purchasesmsg.addToMap("username", MainFrame.page.current_user.getMapValue("username"));
				MainFrame.page.call_handler(purchasesmsg);
			}
		});
		btnPurchases.setBounds(341, 83, 97, 25);
		add(btnPurchases);
		
		if (MainFrame.page.current_user.getMapValue("type").equals("1"))
			btnPurchases.setVisible(false);
			
		MainFrame.localStorage.setVisible(true);

	}

}
