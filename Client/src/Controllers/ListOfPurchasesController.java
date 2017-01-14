package Controllers;

import java.util.ArrayList;

import Employee.ReaderPurchaseList;
import common.msgs;

public class ListOfPurchasesController {

	public void openPurchaseList(ArrayList<msgs> purchasewanswer) {
		new ReaderPurchaseList(purchasewanswer);
		
	}

}
