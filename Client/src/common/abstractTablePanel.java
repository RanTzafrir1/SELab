package common;

import javax.swing.JButton;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;

import common.msgs;

import java.awt.LayoutManager;
import java.awt.Rectangle;
import java.awt.Scrollbar;

@SuppressWarnings("serial")
public class abstractTablePanel extends abstractPanel {
	JButton bttn;
	public abstractTablePanel(ArrayList<msgs> reviews) {
		String str="";
		this.setBounds(new Rectangle(700,700));
		int row=reviews.length;
		for(int i=0;i<row;i++)
		{
			str+="[20px:20px:20px]";
		}
		setLayout(new MigLayout("", "[100px:100px:100px][100px:100px:100px][100px:100px:100px][100px:100px:100px][]", "[][][][][][][][][][]"));
		
		JScrollBar scrollBar = new JScrollBar();
		this.add(scrollBar);
		prints(reviews);
	}
	
		public void prints(ArrayList<msgs> items[])
		{
			ArrayList<JButton> bttns=new ArrayList<JButton>();
			for(int i=0;i<items.length;i++)
			{
				this.add(null, new String("TITLE"));
				this.add(null, new String("AUTHOR"));
				this.add(null, new String("DATE"));
				bttns.add(new JButton("write review"));
				this.add("write review", bttns.get(bttns.size()-1) );
				bttns.get(bttns.size()-1).addActionListener(new java.awt.event.ActionListener()
				{
					public void actionPerformed(java.awt.event.ActionEvent e) 
					{
						System.out.println("actionPerformed()"); 
						bttns.indexOf(e.getSource());
					}
				});
			}
		}
	}


