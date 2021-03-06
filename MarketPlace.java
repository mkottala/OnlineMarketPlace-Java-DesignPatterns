// Honor Pledge:
//
// I pledge that I have neither given nor 
// received any help on this assignment.
//
//mkottala

/**
 * This interface serves as the proxy between the View and the
 * Controller,Model . The MarketPlaceController implements this method.
 *
 */

import java.rmi.Remote;
// Ryan: Do you really need everything in this package?
// Fixed: I have used only the Arraylist from this package, So I have modified the import statement accordingly
import java.util.ArrayList;

public interface MarketPlace extends Remote {
	//interfaces that MarketPlaceView uses remotely

	//interface methods used for user or customer login
	boolean userLogin(String userId, String password, String type) throws java.rmi.RemoteException;
	boolean adminLogin(String userId, String password, String type) throws java.rmi.RemoteException;

	//admin related functions with role based access
	//add items method for admin
	@RoleAnnotations("Admin")
	public String addItems( Session session, String[] itemRow) throws java.rmi.RemoteException;

	//method for adding customers
	@RoleAnnotations("Admin")
	public String addUser( Session session, String[] UserRow) throws java.rmi.RemoteException;

	//method for adding admin to admin table
	@RoleAnnotations("Admin")
	public String addAdmin( Session session, String[] AdminRow) throws java.rmi.RemoteException;

	//method for deleting the items in the items table 
	@RoleAnnotations("Admin")
	public String deleteItems(Session session, int itemId) throws java.rmi.RemoteException;

	//method for removing customers used by admin
	@RoleAnnotations("Admin")
	public String removeUser(Session session, int customerId) throws java.rmi.RemoteException;

	//method for updating items description, quantity or price
	@RoleAnnotations("Admin")
	public String updateItems(Session session,int itemId, int itemField, String itemUpdate) throws java.rmi.RemoteException;

	//method for displaying items to admin
	@RoleAnnotations("Admin")
	public ArrayList<String> browseAdminItems(Session session) throws java.rmi.RemoteException;

	//method for displaying users list to admin
	@RoleAnnotations("Admin")
	public ArrayList<String> displayUsersList(Session session) throws java.rmi.RemoteException;

	//user related function with role based access
	@RoleAnnotations("User")
	public String displayUser(Session session) throws java.rmi.RemoteException;

	// user browse items function role based access
	@RoleAnnotations("User")
	public ArrayList<String> browseUserItems(Session session) throws java.rmi.RemoteException;

	//user purchase items function with user role
	@RoleAnnotations("User")
	public ArrayList<String> purchase(Session session) throws java.rmi.RemoteException;

	//user add items to cart function with user role
	@RoleAnnotations("User")
	public String addItemsToCart(Session session, int itemId, int quantity) throws java.rmi.RemoteException;

	//function for displaying cart to customer
	@RoleAnnotations("User")
	public ArrayList<String> displayCart(Session session) throws java.rmi.RemoteException;

	//session creation method
	public Session sessionLogin(String request) throws java.rmi.RemoteException;

	//registers a user
	public String register(String firstName,String lastName,String userName, String password) throws java.rmi.RemoteException;
}
