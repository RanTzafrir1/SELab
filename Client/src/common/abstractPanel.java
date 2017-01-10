package common;
import javax.swing.JPanel;

public class abstractPanel extends JPanel {
	
	public abstractPanel(){
		super();
		MainFrame.localStorage.panelPassedList.add(this);		
	}
	
	protected void backFunc()
	{
		MainFrame.localStorage.setContentPane(MainFrame.localStorage.panelPassedList.get(MainFrame.localStorage.panelPassedList.size()-1));
		MainFrame.localStorage.panelPassedList.remove(this);
	}
	
	protected void logout()
	{
		MainFrame.localStorage.panelPassedList.clear();
		//new ReaderLogin();//when implemented
	}
	
}
