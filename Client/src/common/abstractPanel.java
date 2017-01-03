package common;
import javax.swing.JPanel;
public class abstractPanel extends JPanel {
	
	public abstractPanel(){
		super();
		MainClass.panelPassedList.add(this);
		
	}
	
	protected void backFunc()
	{
		MainClass.localStorage.setContentPane(MainClass.panelPassedList.get(MainClass.panelPassedList.size()-2));
		MainClass.panelPassedList.remove(this);
	}
	
	protected void logout()
	{
		while(MainClass.localStorage.panelPassedList.size()>1)
		  MainClass.localStorage.panelPassedList.remove(MainClass.localStorage.panelPassedList.size()-1);
	}
	
}
