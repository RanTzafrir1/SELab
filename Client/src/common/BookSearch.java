package common;

import javax.swing.JPanel;
import javax.swing.JCheckBox;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BookSearch extends JPanel {
	private JTextField title;
	private JTextField author;
	private JTextField language;
	private JTextField genre;
	private JTextField keyword;
	private JTextField textField;
	int counter=0;
	
	/**
	 * Create the panel.
	 */
	public BookSearch() {
		setLayout(null);
		msgs searchmsg = new msgs (5);
		
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
		
		keyword = new JTextField();
		keyword.setBounds(156, 160, 116, 22);
		keyword.setText(null);
		add(keyword);
		keyword.setColumns(10);
		
		genre = new JTextField();
		genre.setBounds(156, 198, 116, 22);
		genre.setText(null);
		add(genre);
		genre.setColumns(10);
		
		JButton button = new JButton("+");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				counter++;
				keyword.setText(null);
				searchmsg.addToMap("keyword"+counter, title.getText());	
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
				
				if (title.getText().length()>0) 
					searchmsg.addToMap("title", title.getText());
				if (author.getText().length()>0) 
					searchmsg.addToMap("author", author.getText());
				if (language.getText().length()>0) 
					searchmsg.addToMap("language", language.getText());
				if (genre.getText().length()>0) 
					searchmsg.addToMap("genre", language.getText());
				MainFrame.page.call_handler(searchmsg);
			}
		});
		btnSearch.setBounds(175, 249, 97, 25);
		add(btnSearch);
		
		MainFrame.localStorage.setContentPane(this);
		
		textField = new JTextField();
		textField.setBounds(156, 160, 116, 22);
		add(textField);
		textField.setColumns(10);
		MainFrame.localStorage.setVisible(true);

	}

}
