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
			
		int counterY=0;
			
			localmsg=bookMessage;
			
			
			setLayout(null);
			
			
			for (String key : bookMessage.getMap().keySet()) 	
			{			
				
				JLabel lblTitle = new JLabel(key);
				lblTitle.setBounds(45, 28+counterY, 56, 16);
				add(lblTitle);
				
				textField = new JTextField();
				textField.setBounds(159, 25+counterY, 116, 22);
				textField.setText(bookMessage.getMapValue(key));
				add(textField);
				textField.setColumns(10);
					
				
				map.put(key, textField);
				
				counterY+=40;
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
