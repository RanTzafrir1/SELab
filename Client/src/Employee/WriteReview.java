package Employee;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.TextArea;

import javax.swing.JCheckBox;
import javax.swing.JButton;

import common.MainFrame;
import common.abstractPanel;
import common.msgs;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WriteReview extends abstractPanel {

	/**
	 * Create the panel.
	 */
	public WriteReview(msgs reviewmessage) {
		setLayout(null);
		
		TextArea textArea = new TextArea();
		textArea.setBounds(67, 35, 321, 180);
		add(textArea);
		
		JCheckBox chckbxSignature = new JCheckBox("Signature");
		chckbxSignature.setBounds(275, 248, 113, 25);
		add(chckbxSignature);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				msgs sendtoHandler = reviewmessage;
				sendtoHandler.setOPCode(7);
				sendtoHandler.addToMap("review", textArea.getText());
				MainFrame.page.call_handler(sendtoHandler);	
			}
		});
		btnSubmit.setBounds(113, 248, 97, 25);
		add(btnSubmit);
		
		MainFrame.localStorage.setContentPane(this);
		MainFrame.localStorage.setVisible(true);
		


	}
}
