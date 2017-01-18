package Employee;

import common.MainFrame;
import common.abstractPanel;
import common.msgs;

import java.awt.TextArea;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.TextListener;
import java.awt.event.TextEvent;

public class AproveReview extends abstractPanel {

	public AproveReview(msgs reviewmessage){
		setLayout(null);
		
		TextArea textArea = new TextArea();
		textArea.setBounds(67, 35, 321, 180);
		textArea.setText(reviewmessage.getMapValue("review"));
		textArea.addTextListener(new TextListener() {
			public void textValueChanged(TextEvent arg0) {
				reviewmessage.clearMap();
				reviewmessage.addToMap("review", textArea.getSelectedText());
			}
		});
		add(textArea);
		
		JButton btnAprove = new JButton("Aprove");
		btnAprove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				msgs sendtoHandler = reviewmessage;
				sendtoHandler.setOPCode(24);
				MainFrame.page.call_handler(sendtoHandler);
			}
		});
		btnAprove.setBounds(351, 266, 89, 23);
		add(btnAprove);
		
		JButton btnDeny = new JButton("Deny");
		btnDeny.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			AproveReview.super.backFunc();
			}
		});
		btnDeny.setBounds(10, 266, 89, 23);
		add(btnDeny);
		MainFrame.localStorage.setContentPane(this);
		MainFrame.localStorage.setVisible(true);
	}
}
