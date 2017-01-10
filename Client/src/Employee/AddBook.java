package Employee;


	import java.awt.BorderLayout;
	import java.awt.EventQueue;

	import javax.swing.JFrame;
	import javax.swing.JPanel;
	import javax.swing.border.EmptyBorder;

import common.abstractPanel;

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
	import javax.swing.DropMode;
	import javax.swing.SwingConstants;

	/**
	 * Add a book gui.
	 * @author G_16
	 */
	public class AddBook extends abstractPanel
	{
		private JTextField BookTitle_textField;
		private JTextField[] Authors_textField;
		private JTextField[] Categs_textField;
		private JTextField lang_textField;
		private JTextField sum_textField;
		private JTextField toc_textField;
		private JTextField keyWords_textField;
		private JButton Add_btn = new JButton("Add");
		private JButton AddAuthor_btn = new JButton("+");
		private JButton AddCateg_btn = new JButton("+");
		private JLabel windowTitle_lbl = new JLabel("Add a Book To iBook");
		private JLabel lbl_BookTitle = new JLabel("Book Title");
		private JLabel Author1_lbl = new JLabel("Author (1)");
		private JLabel categ1_lbl = new JLabel("Category (1)");
		private JLabel lang_lbl = new JLabel("Language");
		private JLabel sum_lbl = new JLabel("Summary");
		private JLabel toc_lbl = new JLabel("Table Of Contents");
		private JLabel keyWords_lbl = new JLabel("Key Words");
		private String CategsString = new String();
		private String AuthorsString = new String();
		private Integer CategCounter = new Integer (1);
		private Integer AuthorCounter = new Integer (1);

		/**
		 * Launch the application.
		 */
		
			
		
		

		/**
		 * Create the frame.
		 */
		public AddBook() 
		{
			
			
		
			//////////////////////////////////
			//Window Creation
			/////////////////////////////////
			setBounds(100, 100, 1200, 800);
			this.setBorder(new EmptyBorder(5, 5, 5, 5));
			
			windowTitle_lbl.setVerticalAlignment(SwingConstants.TOP);
			
			//////////////////////////////////
			//Design of add book window
			/////////////////////////////////
			windowTitle_lbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
			
			this.setLayout(new GridLayout(0, 1, 5, 15));
			//
			this.add(windowTitle_lbl);
			//
			lbl_BookTitle.setFont(new Font("Tahoma", Font.PLAIN, 14));
			this.add(lbl_BookTitle);
			//
			BookTitle_textField = new JTextField();
			BookTitle_textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
			BookTitle_textField.setColumns(10);
			this.add(BookTitle_textField);
			//
			Author1_lbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
			this.add(Author1_lbl);
			//
			Authors_textField = new JTextField[10];
			Authors_textField[0] = new JTextField();
			Authors_textField[0].setFont(new Font("Tahoma", Font.PLAIN, 14));
			Authors_textField[0].setColumns(10);
			this.add(Authors_textField[0]);
			//
			this.add(AddAuthor_btn);
			//
			lang_lbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
			this.add(lang_lbl);
			//
			lang_textField = new JTextField();
			lang_textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lang_textField.setColumns(10);
			this.add(lang_textField);
			//
			sum_lbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
			this.add(sum_lbl);
			//
			sum_textField = new JTextField();
			sum_textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
			sum_textField.setColumns(10);
			this.add(sum_textField);
			//
			toc_lbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
			this.add(toc_lbl);
			//
			toc_textField = new JTextField();
			toc_textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
			toc_textField.setColumns(10);
			this.add(toc_textField);
			//
			categ1_lbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
			this.add(categ1_lbl);
			//
			Categs_textField = new JTextField[10];
			Categs_textField[0] = new JTextField();
			Categs_textField[0].setFont(new Font("Tahoma", Font.PLAIN, 14));
			Categs_textField[0].setColumns(10);
			this.add(Categs_textField[0]);
			//
			this.add(AddCateg_btn);
			//
			keyWords_lbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
			this.add(keyWords_lbl);
			//
			keyWords_textField = new JTextField();
			keyWords_textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
			keyWords_textField.setColumns(10);
			this.add(keyWords_textField);
			//
			this.add(Add_btn);
			///////////////////////////////////
			//End of gruop layout.
			///////////////////////////////////
			initActions();

		}
		/**
		 * Handling the action events on the screen.
		 * 
		 */
		private void initActions() 
		{
			/**
			 * Add Book Action Listener - Handles click on Add button.
			 */
			Add_btn.addActionListener(new ActionListener() 
			{
				int AuthorEmptyFlag;
				int CategEmptyFlag;
				public void actionPerformed(ActionEvent e) 
				{
					AuthorsString=null;
					CategsString=null;
					/**
					 * Building The Category String.
					 */
					if(CategCounter>1)
					{
						for(CategEmptyFlag=CategCounter-1;CategEmptyFlag>=0;CategEmptyFlag--)
						{
							if(Categs_textField[CategEmptyFlag].getText().equals(""))
							{
								System.out.print(1);
								CategEmptyFlag = 1;
								break;
							}
							if(CategsString != null)
							CategsString=CategsString + ", " + Categs_textField[CategEmptyFlag].getText(); 
							else
								CategsString=Categs_textField[CategEmptyFlag].getText();
						}
					}
					else
						CategsString = Categs_textField[CategEmptyFlag].getText();
					/**
					 * Building The Authors String.
					 */
					if(AuthorCounter>1)
					{
						for(AuthorEmptyFlag=AuthorCounter-1;AuthorEmptyFlag>=0;AuthorEmptyFlag--)
						{
							if(Authors_textField[AuthorEmptyFlag].getText().equals(""))
							{
								System.out.print(1);
								AuthorEmptyFlag = 1;
								break;
							}
							if(AuthorsString != null)
							AuthorsString=AuthorsString + ", " + Authors_textField[AuthorEmptyFlag].getText(); 
							else
								AuthorsString=Authors_textField[AuthorEmptyFlag].getText();
						}
					}
					else
						AuthorsString = Authors_textField[AuthorEmptyFlag].getText();
					
					/**
					 * Check If there are empty fields and prints message accordingly.
					 */
					if(BookTitle_textField.getText().equals("") || Authors_textField[0].getText().equals("") || AuthorEmptyFlag == 1 
							|| lang_textField.getText().equals("") || sum_textField.getText().equals("") || toc_textField.getText().equals("") ||
							CategEmptyFlag == 1 || Categs_textField[0].getText().equals("") || keyWords_textField.getText().equals(""))
					{
						JOptionPane.showMessageDialog(Add_btn, "Empty Fields Detected, Fill All Fields.", " Empty Field", 0, null);
					}
					else
					{
						//Selection = 0 - YES, Selection = 1 - NO, Selection = 2 - CANCEL, Selection = -1 - Pressed x,   
						Integer selection = JOptionPane.showConfirmDialog(Add_btn, "Are You sure you want to add book with this details: \n" +
					lbl_BookTitle.getText() + ": " + BookTitle_textField.getText() + "\n" + "Authors: " + AuthorsString + "\n" + lang_lbl.getText() + 
					 ": " + lang_textField.getText() + "\n" + sum_lbl.getText() + ": " + sum_textField.getText() + "\n" + toc_lbl.getText() + ": " + 
					 toc_textField.getText() + "\n" + "Categories: " + CategsString + "\n" + keyWords_lbl.getText() + ": " +
					  keyWords_textField.getText());
					}
				}
			});
			/**
			 * Add Author Action Listener - Handles click on Add author button.
			 */
			AddAuthor_btn.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent e) 
				{
					fun2();
				}
			});
			
			/**
			 * Add Category Action Listener - Handles click on Add category button.
			 */
			AddCateg_btn.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent e) 
				{
					fun();
				}
			});
			
		}
		void fun2()
		{
			this.removeAll();
			AuthorCounter++;
			this.setLayout(new GridLayout(0,1,5,10));
			this.add(windowTitle_lbl);
			this.add(lbl_BookTitle);
			this.add(BookTitle_textField);
			this.add(Author1_lbl);
			this.add(Authors_textField[0]);
			for(int i=1;i<AuthorCounter-1;i++)
			{
				this.add(new JLabel("Author("+ (i+1) + ")"));
				this.add(Authors_textField[i]);
			}
			this.add(new JLabel("Author("+ AuthorCounter + ")"));
			Authors_textField[AuthorCounter-1] = new JTextField();
			this.add(Authors_textField[AuthorCounter-1]);
			this.add(AddAuthor_btn);
			this.add(lang_lbl);
			this.add(lang_textField);
			this.add(sum_lbl);
			this.add(sum_textField);
			this.add(toc_lbl);
			this.add(toc_textField);
			for(int i=0;i<CategCounter;i++)
			{
				this.add(new JLabel("Category("+ (i+1) + ")"));
				this.add(Categs_textField[i]);
			}
			this.add(AddCateg_btn);
			this.add(keyWords_lbl);
			this.add(keyWords_textField);
			this.add(Add_btn);
			this.revalidate();
			this.repaint();
		}
		
		void fun()
		{
			this.remove(Add_btn);
			this.remove(AddCateg_btn);
			this.remove(keyWords_lbl);
			this.remove(keyWords_textField);
			CategCounter++;
			this.setLayout(new GridLayout(0,1,5,10));
			this.add(new JLabel("Category("+ CategCounter + ")"));
			Categs_textField[CategCounter-1]=new JTextField();
			this.add(Categs_textField[CategCounter-1]);
			this.add(AddCateg_btn);
			this.add(keyWords_lbl);
			this.add(keyWords_textField);
			this.add(Add_btn);
			this.revalidate();
			this.repaint();
		}
	}




