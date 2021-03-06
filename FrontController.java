// Honor Pledge:
//
// I pledge that I have neither given nor
// received any help on this assignment.
//
//mkottala

//FrontController class is responsible for entry point, user authentication
//and dispatchinig to respective view
public class FrontController {
	//instance of Dispatcher class
	private Dispatcher dispatcher;
	private Session session;
	private MarketPlaceClientController clientControllerLogin;

	//constructor for the FrontController class
	public FrontController() {
		//intializing the dispatcher object
		dispatcher = new Dispatcher();
		clientControllerLogin = new MarketPlaceClientController();
	}

	//Sample authentication check
	private boolean isAuthenticUser(String request) {
		if(request.equals("Registration Success")){
			System.out.println("user Registration Successful and displaying User View");
			return true;
		}
		else if(request.equals("User") || request.equals("Admin")){
			System.out.println("View : " + request);
			return clientControllerLogin.loginCheck(request);
		}
		return false;
	}

	//method for dispatching the request to the Dispatcher class
	public void dispatchRequest(String request) {
		//checking if the requested action is registration
		if(request == "Register"){
			request = clientControllerLogin.registerUser();
		}   

		// If the user has been authenticated - dispatch request
		if(isAuthenticUser(request) && !request.equals("Error in Registration")) {
			if(request.equals("Registration Success")){
				//if the regidtrstion is successful the request type is set to user to display user profile
				request = "User";
			}
			System.out.println(request + " authentication is successful.");
			session = clientControllerLogin.sessionLogin(request);
			dispatcher.dispatch(request,session);
		}	
		else {
			System.out.println(request + ": "+ " authentication failed.");
		}
	}

}
