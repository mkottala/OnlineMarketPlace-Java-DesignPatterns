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
	private Session session;
	private MarketPlaceClientController clientControllerObj;

	public MarketPlaceUserView(){
		clientControllerObj = new MarketPlaceClientController();		
	}

	// Method o be implemented for Displaying User or Admin Profile
	@Override
	public int displayUser(Session session) {
		Scanner userInput = new Scanner(System.in);
		System.out.println("Displaying User Profile");
		System.out.println(clientControllerObj.displayUser(session));
		System.out.println("Enter Action");
		System.out.println("1.Browse Items");
		System.out.println("2.Checkout (Purchase cart Items)");
		System.out.println("3.Add Item to Cart");
		System.out.println("4.Display cart");
		userInput = new Scanner(System.in);
		int option = userInput.nextInt();
		return option;
	}


	// Method to be implemented for Browsing items
	@Override
	public void browse(Session session) {
		System.out.println("************************************** ITEMS DISPLAYED HERE ********************************************");
		System.out.println("");
		System.out.println("Item Id  Item Name \t\t Description  \t\t\tQuantity  \tPrice");
		ArrayList<String> items = clientControllerObj.browseUserItems(session);
		for(int i = 0; i< items.size(); i++){
			System.out.println(items.get(i));
		}
		System.out.println("*******************************************************************************************************");
	}

	@Override
	public void purchase(Session session) {
		System.out.println("*************************************** CHECK OUT ******************************************************");
		ArrayList<String> result = clientControllerObj.purchase(session);
		for(int i = 0; i< result.size(); i++){
			System.out.println(result.get(i));
		}
		System.out.println("*******************************************************************************************************");
	}

	//implementing view output of add items to cart
	@Override
	public void addItemsToCart(Session session) {
		browse(session);
		System.out.println("************************************* ADD ITEMS TO CART *************************************************");
		System.out.println("Enter the item Id to add item to cart: ");
		Scanner userInput = new Scanner(System.in);
		int itemId =userInput.nextInt();
		System.out.println("Enter item Quantity: ");
		int quantity = userInput.nextInt();
		System.out.println(clientControllerObj.addItemsToCart(session,itemId,quantity));
		System.out.println("*******************************************************************************************************");
	}


	//implementing view output of display cart
	@Override
	public void displayCart(Session session) {
		System.out.println("******************************************** DISPLAYING CART ********************************************");
		ArrayList<String> cartItems = clientControllerObj.displayCart(session);
		if(cartItems.isEmpty()){
			System.out.println("Cart is Empty");
		}
		else{
			System.out.println("Cart Items displayed here :");
			System.out.println("CartId   ItemId   Quantity");
			for(int i = 0; i< cartItems.size(); i++){
				System.out.println(cartItems.get(i));
			}
		}
		System.out.println("*******************************************************************************************************");
	}
}
