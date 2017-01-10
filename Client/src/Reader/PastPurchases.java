package Reader;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;

import common.abstractPanel;
import common.abstractTablePanel;
import common.msgs;

import java.awt.Dimension;
import java.util.ArrayList;
import java.awt.Component;

public class PastPurchases extends abstractPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public PastPurchases(ArrayList<msgs>[] Purchases) {
		setLayout(null);
		
		abstractTablePanel panel = new abstractTablePanel(Purchases);
		panel.setBorder(new TitledBorder(null, "JPanel title", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(379, 247, -321, -153);
		add(panel);
	}
}
