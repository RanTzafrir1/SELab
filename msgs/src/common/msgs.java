package common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;


@SuppressWarnings("serial")
public class msgs implements Serializable{
	private int opCode;
	private int bookid;
	HashMap<String, String> map;

	String search;
	
	public msgs(int op){
		this.opCode=op;
		map = new HashMap<String,String>();
	}
	
	public void addToMap(String key, String value){
		map.put(key,value) ;//adds value to list.
	}
	
	public String getMapValue(String key){
		return map.get(key);
	}
	
	public int getOPcode(){
		return this.opCode;
	}
	
	public HashMap<String, String> getMap (){
		return this.map;
	}
	
	public void setSearch(String setS)
	{
		this.search=setS;
	}
	
	public String getSearch(){
		return this.search;
	}
	
	public void setOPCode(int opcode){
		this.opCode=opcode;
	}

	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public void setMap(HashMap<String, String> newmap) {
		this.map=newmap;
		
	}
	
}



