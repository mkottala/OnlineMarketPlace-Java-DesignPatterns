
// Honor Pledge:
//
// I pledge that I have neither given nor
// received any help on this assignment.
//
//mkottala

import java.io.Serializable;

//Session class implements from Serializable and this is created based on the user role
//A new session object is created and passed over the application
public class Session implements Serializable{

	String roleType;
	
	//constrcutor to intialize roleType
	public Session(String roleType){
		this.roleType=roleType;
	}

	//return new role type
	public String getRoleType(){
		return roleType;
	}
}
