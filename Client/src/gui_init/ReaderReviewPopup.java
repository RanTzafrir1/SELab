package gui_init;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.TextArea;
import javax.swing.JLabel;

public class ReaderReviewPopup extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public ReaderReviewPopup(String review,String ReaderName , String bookName,String authorName)
	{
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			TextArea textArea = new TextArea();
			textArea.setEditable(false);
			textArea.setText(review);
			textArea.setBounds(10, 62, 424, 166);
			contentPanel.add(textArea);
		}
		
		JLabel lblBooknameAndAuthor = new JLabel(bookName+" "+authorName);
		lblBooknameAndAuthor.setBounds(29, 11, 153, 39);
		contentPanel.add(lblBooknameAndAuthor);
		
		JLabel lblReviewedBy = new JLabel("reviewed by");
		lblReviewedBy.setBounds(314, 23, 75, 14);
		contentPanel.add(lblReviewedBy);
		
		JLabel lblMoshe = new JLabel(ReaderName);
		lblMoshe.setBounds(298, 36, 91, 14);
		contentPanel.add(lblMoshe);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			
		}
	}
}
