package gui_init;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BookSearch extends JPanel {
	private JTextField txtTitle;
	private JTextField txt_author;
	private JTextField txt_keyWord;
	private static String[] lang;
	private static String[] cat;
	private String selectCat;
	private String selectlang;
	/**
	 * Create the panel.
	 */
	public BookSearch() {
		lang=new String [2];
		cat=new String [2];
		cat[0]="comedy";
		cat[1]="porn";
		lang[0]="rus";
		lang[1]="eng";
		setLayout(null);
		
		JLabel lblBooksearch = new JLabel("BookSearch");
		lblBooksearch.setBounds(215, 5, 56, 14);
		add(lblBooksearch);
		
		JPanel panel = new JPanel();
		panel.setBounds(276, 7, 10, 10);
		add(panel);
		
		JLabel lblTitle = new JLabel("Title:");
		lblTitle.setBounds(10, 60, 46, 14);
		add(lblTitle);
		
		JLabel lblAuthor = new JLabel("Author:");
		lblAuthor.setBounds(10, 85, 46, 14);
		add(lblAuthor);
		
		JLabel lblLanguage = new JLabel("language:");
		lblLanguage.setBounds(10, 109, 64, 14);
		add(lblLanguage);
		
		JLabel lblCategoty = new JLabel("categoty:");
		lblCategoty.setBounds(10, 134, 60, 14);
		add(lblCategoty);
		
		JLabel lblKeyWords = new JLabel("key Words:");
		lblKeyWords.setBounds(10, 186, 77, 14);
		add(lblKeyWords);
		
		JComboBox combo_language = new JComboBox();
		combo_language.setBounds(67, 131, 90, 20);
		for(int i=0; i<2;i++)
		combo_language.addItem(lang[i]);
		add(combo_language);
		combo_language.addItemListener(new java.awt.event.ItemListener() {
			public void itemStateChanged(java.awt.event.ItemEvent e) {
				//loadStudent(std);
				String st = ((String)combo_language.getSelectedItem());
				selectlang=lang[combo_language.getSelectedIndex()];
								
			}
		});
		JComboBox combo_category = new JComboBox();
		combo_category.setBounds(67, 106, 90, 20);
		for(int i=0; i<2;i++)
		combo_category.addItem(cat);
		combo_category.addItemListener(new java.awt.event.ItemListener() {
			public void itemStateChanged(java.awt.event.ItemEvent e) {
				//loadStudent(std);
				String st = ((String)combo_category.getSelectedItem());
				selectCat=cat[combo_category.getSelectedIndex()];
								
			}
		});
		add(combo_category);
		
		txtTitle = new JTextField();
		txtTitle.setBounds(66, 57, 182, 20);
		add(txtTitle);
		txtTitle.setColumns(10);
		
		txt_author = new JTextField();
		txt_author.setBounds(66, 82, 182, 20);
		add(txt_author);
		txt_author.setColumns(10);
		
		txt_keyWord = new JTextField();
		txt_keyWord.setBounds(67, 183, 181, 20);
		add(txt_keyWord);
		txt_keyWord.setColumns(10);
		
		JLabel lblYouMayEnter = new JLabel("you may enter multipele number of words devided by \",\"");
		lblYouMayEnter.setBounds(36, 162, 288, 14);
		add(lblYouMayEnter);
		
		Button button = new Button("Search");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String keyWords[]=txt_keyWord.getText().split(",",22);
				for(int i=0;i<keyWords.length;i++)
					keyWords[i]=keyWords[i].trim();
				//searchHandler(txt_author.getText(),keyWords,txtTitle.getText(),selectLang,selectCat);
			}
		});
		button.setBounds(105, 236, 69, 19);
		add(button);
		

	}
}
