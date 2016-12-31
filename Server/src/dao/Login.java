package dao;

import java.util.ArrayList;

import com.mysql.jdbc.Connection;

import common.msgs;

public class Login {
	
	msgs thismessage,loginmsg;
	Connection localdbConnection;
	ArrayList<msgs> loginmsgsArray;
	Get_User loginUser;
	
	public ArrayList<msgs> getLogin(msgs loginmsgs,Connection dbConnection){
		thismessage = loginmsgs;
		localdbConnection=dbConnection;
		loginmsgsArray = new ArrayList<msgs>();
		loginUser=new Get_User();
		
		loginmsg = loginUser.getUser(thismessage,localdbConnection);
		loginmsg.setOPCode(2);
		
		loginmsgsArray.add(loginmsg);
		
		return loginmsgsArray;
		
	}
}
