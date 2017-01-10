package Controllers;

import java.util.ArrayList;

import common.msgs;

public class setCategory {
	ArrayList<msgs> categoryandgenres;
	
	public void set_category_list(ArrayList<msgs> msgfromserver){
		this.categoryandgenres=msgfromserver;
	}
	
	public ArrayList<msgs> get_category_list(){
		return categoryandgenres;
	}
}
