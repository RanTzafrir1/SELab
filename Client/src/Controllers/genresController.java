package Controllers;

import java.util.ArrayList;

import Employee.ReaderPurchaseList;
import common.MainFrame;
import common.msgs;

public class genresController {
	
	public void openGenresList(ArrayList<msgs> purchasewanswer) {
		MainFrame.genreslist = purchasewanswer;
	}
}
