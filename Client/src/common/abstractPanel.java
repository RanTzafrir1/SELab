package common;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class abstractPanel extends JPanel {
	protected JButton backbutton;
	JButton Logoutbutton;
	JButton Homepagebutton;
	
	public abstractPanel(){
		super();
		MainFrame.localStorage.panelPassedList.add(this);
		setLayout(null);

		backbutton = new JButton("Back");
		if(Logoutbutton==null)
		{
			backbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				backFunc();
			}
		});
		}
		this.add(backbutton);
		backbutton.setBounds(350, 350, 97, 25);
		
	/*	Logoutbutton = new JButton("Logout");
		if(Logoutbutton!=null)
		{
			Logoutbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				backFunc();
			}
		});
		}*/
		
		
	/*	if(Homepagebutton!=null)
		{
			Homepagebutton = new JButton("backToHomepage");
			Homepagebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainPagefunc();
			}
		});
		Homepagebutton.se.setBounds(350, 350, 350, 350);
		add(Homepagebutton);
		}*/
		
	}
	
	protected void backFunc()
	{
		MainFrame.panelPassedList.remove(this);
		MainFrame.localStorage.setContentPane(MainFrame.localStorage.panelPassedList.get(MainFrame.panelPassedList.size()-1));
		MainFrame.localStorage.setVisible(true);
	}
	
	protected void logoutFunc()
	{
		MainFrame.localStorage.panelPassedList.clear();
		//new ReaderLogin();//when implemented
	}
	protected void MainPageFunc()
	{
		if(MainFrame.panelPassedList.remove(this))
			;
		MainFrame.localStorage.setContentPane(MainFrame.localStorage.panelPassedList.get(MainFrame.panelPassedList.size()-1));
		MainFrame.localStorage.setVisible(true);
	}
}
