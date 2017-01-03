package gui_init;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Scrollbar;
import javax.swing.JTable;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Panel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import net.miginfocom.swing.MigLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.FlowLayout;

public class ReaderSearchResult extends JPanel {
	private JTable table;
	private JTable table_1;

	/**
	 * Create the panel.
	 */
	public ReaderSearchResult() {
		setLayout(null);
		
		JLabel lblSearchResult = new JLabel("search result");
		lblSearchResult.setBounds(112, 11, 73, 14);
		add(lblSearchResult);
		
		JLabel lblCategory = new JLabel("category");
		lblCategory.setBounds(57, 84, 46, 14);
		add(lblCategory);
		
		JLabel lblSubject = new JLabel("subject");
		lblSubject.setBounds(136, 84, 46, 14);
		add(lblSubject);
		
		JLabel lblTitleAndAuthor = new JLabel("Title and Author");
		lblTitleAndAuthor.setBounds(216, 84, 88, 14);
		add(lblTitleAndAuthor);
		
		JLabel lblLink = new JLabel("link");
		lblLink.setBounds(343, 84, 46, 14);
		add(lblLink);
		
		Button button = new Button("past purchases");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setBounds(303, 31, 88, 19);
		add(button);
		
		table = new JTable();
		table.setBounds(10, 169, 105, -71);
		add(table);
		
		table_1 = new JTable();
		table_1.setBounds(20, 109, 404, 180);
		table_1.se
		add(table_1);

	}
}
