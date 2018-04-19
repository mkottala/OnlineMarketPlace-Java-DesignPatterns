// Honor Pledge:
//
// I pledge that I have neither given nor
// received any help on this assignment.
//
//mkottala

// importing Scanner for input operation
import java.util.ArrayList;
import java.util.Scanner;



// View class of the MVC pattern and it acts as the client for the Java RMI
public class MarketPlaceUserView implements User{
	private String userName;
	private String userId;
	private String password;
	private Session session;

	//method for entering user login information

	//Get methods for userId, UserName and Password
	public String getUserId() {
		return this.userId;
	}

	//get methods
	public String getUserName() {
		return this.userName;
	}

	public String getPassword() {
		return this.password;
	}


	// Method to be implemented for Browsing items
	public void browseItems() {
		System.out.println("Browsing Items displayed here");
	}


	// Method o be implemented for Displaying User or Admin Profile
	@Override
	public int displayUser(Session session) {
		Scanner userInput = new Scanner(System.in);
		MarketPlaceClientController clientControllerObj = new MarketPlaceClientController();
		System.out.println("Displaying User Profile");
		System.out.println(clientControllerObj.displayUser(session));
		System.out.println("Enter Action");
		System.out.println("1.Browse Items");
		System.out.println("2.Purchase Items");
		System.out.println("3.Add Item to Cart");
		System.out.println("4.Display cart");
		userInput = new Scanner(System.in);
		int option = userInput.nextInt();
		return option;
	}


	//method for user registration
	public void registration() {
		Scanner userInput = new Scanner(System.in);
		System.out.println(" Enter User Registration Details:  ");
		System.out.println("User Name: ");
		userName = userInput.nextLine();
		System.out.println("User Id: ");
		userId = userInput.nextLine();
		System.out.println("Enter Password: ");
		password = userInput.nextLine();
		userInput.close();
	}

	// Method to be implemented for Browsing items
	@Override
	public void browse(Session session) {
		MarketPlaceClientController clientControllerObj = new MarketPlaceClientController();
		System.out.println("Items displayed here :");
		System.out.println("Item Id  Item Name \t\t Description  \t\t\tQuantity  \tPrice");
		ArrayList<String> items = clientControllerObj.browseUserItems(session);
		for(int i = 0; i< items.size(); i++){
			System.out.println(items.get(i));
		}
	}

	@Override
	public void purchase(Session session) {
		MarketPlaceClientController clientControllerObj = new MarketPlaceClientController();
		//User input of item id 
		Scanner userInput = new Scanner(System.in);
		System.out.println("Enter the Item Number:");
		int itemId = userInput.nextInt();
		System.out.println("Enter the Quantity:");
		int quantity =userInput.nextInt();
		String result = clientControllerObj.purchase(session,itemId,quantity);
		System.out.println(result);
	}

	//implementing view output of add items to cart
	@Override
	public void addItemsToCart(Session session) {
		MarketPlaceClientController clientControllerObj = new MarketPlaceClientController();
		browse(session);
		System.out.println("Enter the item Id to add item to cart: ");
		Scanner userInput = new Scanner(System.in);
		int itemId =userInput.nextInt();
		System.out.println("Enter item Quantity: ");
		int quantity = userInput.nextInt();
		System.out.println(clientControllerObj.addItemsToCart(session,itemId,quantity));
	}


	//implementing view output of display cart
	@Override
	public void displayCart(Session session) {
		MarketPlaceClientController clientControllerObj = new MarketPlaceClientController();
	}
}
