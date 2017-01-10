package msgs;
import java.io.Serializable;
import java.util.HashMap;


@SuppressWarnings("serial")
public class msgs implements Serializable{
	private int opCode;
	HashMap<String, String> map;
	private int bookid;
	
	public msgs(int op){
		map = new HashMap<String, String>();
		this.opCode=op;
	}
	
	public void addToMap(String key, String value){
		key.toLowerCase();
		value.toLowerCase();
		map.put(key, value);
	}
	
	public String getMapValue(String key){
		return map.get(key);
	}
	
	public void setMap(HashMap<String, String> newmap){
		map=newmap;
	}

	
	public int getOPcode(){
		return this.opCode;
	}
	
	public void setOPCode(code){
		this.opCode=id;
	}
	
	public int getBookID(){
		return this.bookid;
	}
	
	public void setBookID(int id){
		this.bookid=id;
	}
	
}



