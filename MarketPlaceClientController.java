// Honor Pledge:
//
// I pledge that I have neither given nor 
// received any help on this assignment.
//
//mkottala


// FIXED: This is how I fixed what was wrong.
// I have separated the framework functionality by including an additional controller 
// which implements the RMI client functionality


import java.rmi.Naming;
import java.util.Scanner;


public class MarketPlaceClientController {
	static private MarketPlace marketPlace;
	
	//Main Method for RMI Client
		public static void main(String args[]){
			// RMI Security Manager
			System.setSecurityManager(new SecurityManager());
			try{
				String name = "//tesla.cs.iupui.edu:2525/MarketPlaceServer";
				// Attempt to locate the MarketPlace Server
				marketPlace = (MarketPlace) Naming.lookup(name);
				
				
				//Creating an instance of Entry View
				ClientEntryView entryPoint = new ClientEntryView();
				// Create new instance of a Front Controller
				FrontController frontController = new FrontController();
				
				// Dispatch request for respective views
				
				frontController.dispatchRequest(entryPoint.performAction());					
			} catch(Exception e){
				System.out.println("MarketPlace Client Exception: " +
				e.getMessage());
				e.printStackTrace();
			}
			
			System.exit(0);
		}
		
		public boolean loginCheck(String request) {
			ClientEntryView loginView = new ClientEntryView();
			loginView.checkLogin();
			String id = loginView.getId();
			String password = loginView.getPassword();
			System.out.println("Login Checking");
			try {
				return marketPlace.login(id, password, request);
			}
			catch(Exception e){
				System.out.println("MarketPlace Client login Exception: " +
				e.getMessage());
				e.printStackTrace();
			}
			return true;
		}
		
}