package Employee;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import common.MainFrame;
import common.abstractPanel;
import common.msgs;

public class UpdateBook extends abstractPanel {

	/**
	 * Create the panel.
	 * @param bookMessage 
	 */

	private JTextField textField;
	int authorcounter=0;
	msgs addbook = new msgs(13);
	msgs localmsg = new msgs(13);
	HashMap<String,JTextField> map = new HashMap<String,JTextField>();

	public UpdateBook(msgs bookMessage) {

		int titleY=0,authorY=40,languageY=80,summaryY=120,table_of_ontentsY=160,priceY=200,genreY=240,categoryY=280;
		int counterX=0,axisY=0;
		String tempString=null;
		String lastString=null;
		localmsg=bookMessage;


		setLayout(null);


		for (String key : bookMessage.getMap().keySet()) 	
		{		
			lastString=tempString;
			tempString=bookMessage.getMapValue(key).replaceAll("[^A-Za-z]", "");
			if(!(lastString.equals(tempString))){
				counterX=0;
				switch (tempString) {
				case "title":
					axisY=titleY;
					break;
				case "author":
					axisY=authorY;
					break;
				case "language":
					axisY=languageY;
					break;
				case "summary":
					axisY=summaryY;
					break;
				case "table_of_ontents":
					axisY=table_of_ontentsY;
					break;
				case "price":
					axisY=priceY;
					break;
				case "genre":
					axisY=genreY;
					break;
				case "category":
					axisY=categoryY;
					break;
				default:
					break;
				}
			}
			JLabel lblTitle = new JLabel(key);
			lblTitle.setBounds(45+counterX, 28+axisY, 56, 16);
			add(lblTitle);

			textField = new JTextField();
			textField.setBounds(159+counterX, 25+axisY, 116, 22);
			textField.setText(tempString);
			add(textField);
			textField.setColumns(10);


			map.put(key, textField);

			counterX+=60;
		}



		JButton btnSubmit = new JButton("submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				for (String key : localmsg.getMap().keySet()) 	
				{	
					addbook.addToMap(key,map.get(key).getText());	
					if (!localmsg.getMapValue(key).equals(map.get(key).getText()))
						addbook.addToMap("old"+key,localmsg.getMapValue(key));
				}



				addbook.setBookid(localmsg.getBookid());
				MainFrame.page.call_handler(addbook);	

				new UpdateBook(localmsg);

			}
		});
		btnSubmit.setBounds(250, 311, 97, 25);
		add(btnSubmit);

		MainFrame.localStorage.setContentPane(this);
		MainFrame.localStorage.setVisible(true);

	}

}
