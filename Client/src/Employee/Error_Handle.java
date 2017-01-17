package Employee;

import javax.swing.JPanel;
import javax.swing.JLabel;

import common.MainFrame;
import common.abstractPanel;
import common.msgs;

public class Error_Handle extends abstractPanel {

	/**
	 * Create the panel.
	 */
	public Error_Handle(msgs Error_msg) {
		setLayout(null);
		
		JLabel lblError = new JLabel("Error");
		lblError.setBounds(60, 42, 149, 70);
		lblError.setText(Error_msg.getMapValue("error"));
		add(lblError);
		
		MainFrame.localStorage.setContentPane(this);
		MainFrame.localStorage.setVisible(true);

	}
}
