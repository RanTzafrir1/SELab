package Employee;


	import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Rectangle;

	import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import common.MainFrame;
import common.abstractPanel;
import common.msgs;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;

	import java.awt.Font;
import java.awt.GridLayout;

	import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.DropMode;
import javax.swing.SwingConstants;

	/**
	 * Add a book gui.
	 * @author G_16
	 */
	public class AddBook extends abstractPanel
	{
		private JTextField textField;
		private JTextField textField_1;
		private JTextField textField_2;
		private JTextField textField_3;
		private JTextField textField_4;
		private JTextField textField_5;
		private JTextField textField_6;
		int authorcounter=0;
		int counter=0;
		String getCategory=null;
		msgs addbook = new msgs(3);
		ArrayList<msgs> genrelist = new ArrayList<msgs>();
		
		public AddBook() {
			
			
			setLayout(null);
			
			genrelist=MainFrame.genreslist;
			
			JLabel lblTitle = new JLabel("title");
			lblTitle.setBounds(45, 28, 56, 16);
			add(lblTitle);
			
			textField = new JTextField();
			textField.setBounds(159, 25, 116, 22);
			add(textField);
			textField.setColumns(10);
			
			JLabel lblAuthor = new JLabel("author");
			lblAuthor.setBounds(45, 63, 56, 16);
			add(lblAuthor);
			
			textField_1 = new JTextField();
			textField_1.setBounds(159, 60, 116, 22);
			add(textField_1);
			textField_1.setColumns(10);
			
			JButton btnNewButton = new JButton("+");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					authorcounter++;
					addbook.addToMap("author"+authorcounter, textField_1.getText());
					textField_1.setText("");
				}
			});
			btnNewButton.setBounds(287, 59, 40, 25);
			add(btnNewButton);
			
			JLabel lblNewLabel = new JLabel("language");
			lblNewLabel.setBounds(45, 98, 56, 16);
			add(lblNewLabel);
			
			textField_2 = new JTextField();
			textField_2.setBounds(159, 95, 116, 22);
			add(textField_2);
			textField_2.setColumns(10);
			
			JLabel lblNewLabel_1 = new JLabel("summary");
			lblNewLabel_1.setBounds(45, 133, 56, 16);
			add(lblNewLabel_1);
			
			textField_3 = new JTextField();
			textField_3.setBounds(159, 130, 116, 22);
			add(textField_3);
			textField_3.setColumns(10);
			
			JLabel lblTableOfContents = new JLabel("table of contents");
			lblTableOfContents.setBounds(33, 173, 95, 16);
			add(lblTableOfContents);
			
			textField_4 = new JTextField();
			textField_4.setBounds(159, 170, 116, 22);
			add(textField_4);
			textField_4.setColumns(10);
			
			JLabel lblPrice = new JLabel("price");
			lblPrice.setBounds(45, 218, 56, 16);
			add(lblPrice);
			
			textField_5 = new JTextField();
			textField_5.setBounds(159, 215, 116, 22);
			add(textField_5);
			textField_5.setColumns(10);
			
			JLabel lblNewLabel_2 = new JLabel("genre");
			lblNewLabel_2.setBounds(45, 265, 56, 16);
			add(lblNewLabel_2);
			
			/*textField_6 = new JTextField();
			textField_6.setBounds(159, 262, 116, 22);
			add(textField_6);
			textField_6.setColumns(10);*/
			
			//JComboBox<String> categories1 = new JComboBox<String>();
			//categories1.setBounds(new Rectangle(280, 262, 116, 22));
			
			JComboBox<String> genres = new JComboBox<String>();
			for (msgs temp : genrelist)
				genres.addItem(temp.getMapValue("category"));
			add(genres);
			genres.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					getCategory=(String) genres.getSelectedItem();
					
						//remove(categories1);
						JComboBox<String> categories = new JComboBox<String>();
						categories.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								counter++;
								addbook.addToMap("genre"+counter, (String) genres.getSelectedItem());
								remove(categories);
							
							}
						});
						categories.setBounds(new Rectangle(280, 262, 116, 22));
					
						for (msgs temp : genrelist)
						{
							if (temp.getMapValue("category").equals(getCategory))
							{	for (String key : temp.getMap().keySet()) 	
								{
									if (key.contains("genre"))
										categories.addItem(temp.getMapValue(key));
								}
							}
						}
					
						add(categories);
					
				}
			
			});
			
			genres.setBounds(new Rectangle(159, 262, 116, 22));
			

			
			JButton btnSubmit = new JButton("submit");
			btnSubmit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					addbook.addToMap("title",textField.getText());
					addbook.addToMap("language",textField_2.getText());
					addbook.addToMap("summary",textField_3.getText());
					addbook.addToMap("tableofcontents",textField_4.getText());
					addbook.addToMap("price",textField_5.getText());
					addbook.addToMap("genre",textField_6.getText());
					MainFrame.page.call_handler(addbook);	
					
					new AddBook();
					
				}
			});
			btnSubmit.setBounds(135, 311, 97, 25);
			add(btnSubmit);
			
			MainFrame.localStorage.setContentPane(this);
			MainFrame.localStorage.setVisible(true);
		}
		
		
	}
	