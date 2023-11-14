import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * @author MHJ
 *
 */
public class Main {
	 static User currentuser;
	 static String currentRole;
	 


	public static void main(String[] args) throws IOException, ParseException  {
		User u1 = SelectUser();
		
		
		if (u1.getRole().equalsIgnoreCase("customer")) {
			currentuser = new Customer(u1.getUserID(),u1.getUsername(),u1.getSurname(),u1.getAddress(),u1.getRole(),u1.getBalance());
			//System.out.println(currentuser.getAddress().formatted());
			String oldLine =  currentuser.getUserID()+", "+ currentuser.getUsername()+", "+currentuser.getSurname()+", "+ 
		    		  currentuser.getAddress().formatted()+", "+currentuser.getBalance()+", "+currentuser.getRole();
			System.out.println(oldLine);
			CustomerMainMenu();
		}
		else{
			currentuser = new Admin(u1.getUserID(),u1.getUsername(),u1.getSurname(),u1.getAddress(),u1.getRole(),u1.getBalance());
			String oldLine =  currentuser.getUserID()+", "+ currentuser.getUsername()+", "+currentuser.getSurname()+", "+ 
		    		  currentuser.getAddress().formatted()+", "+currentuser.getBalance()+", "+currentuser.getRole();
			System.out.println(oldLine);
			AdminMainMenu();
			
		
		}
	}
	
	private static User SelectUser() throws IOException, ParseException {
		User[] userArr =User.CreateUsers();
		System.out.println("choose a user:");
		System.out.println(User.GetUsernames(User.CreateUsers()).toString());
		
		BufferedReader reader = new BufferedReader(
        new InputStreamReader(System.in));
 
        String username = reader.readLine();
        	
        User currentuser = null;
        for (User i : userArr) {
			if (username.equalsIgnoreCase(i.getUsername())) {
				currentuser = i;
			}
       }
        if( currentuser == null) {
        	System.out.println("error: choose a valid user");
        	main(null);
        }
		return currentuser;
	}

	
	public static void CustomerMainMenu() throws IOException, ParseException {
		System.out.println("---------------");
		System.out.println("Would you like to view books in catalogue (v), search for books (s), go to your basket(b) or logout(l)?" );
		Scanner r1 = new Scanner(System.in);
		//BufferedReader reader = new BufferedReader(
	      //      new InputStreamReader(System.in));
			 String Choice = r1.nextLine();
		System.out.println(Choice.trim());
		if(Choice.trim().equalsIgnoreCase("b")) {
			CustomerBasketMenu();
		}
		if(Choice.trim().equalsIgnoreCase("v")) {
			Books.viewBooks("customer");
		}
		
		if(Choice.trim().equalsIgnoreCase("s")) {
			Customer.SearchBooks();
		}
		if(Choice.trim().equalsIgnoreCase("l")) {
			main(null);
		}
		else {
			CustomerMainMenu();
		}
	}
	

	private static void CustomerBasketMenu() throws IOException, ParseException {
		System.out.println("---------------");
		System.out.println("Would you like to add books to the basket (a), go to view your basket(v), buy books in basket(b), logout(l) or empty your basket(e) ?" );
		Scanner r1 = new Scanner(System.in);
		//BufferedReader reader = new BufferedReader(
	      //      new InputStreamReader(System.in));
			 String Choice = r1.nextLine();
		System.out.println(Choice.trim());
		if(Choice.trim().equalsIgnoreCase("a")) {
			Customer.AddBookstoBasket((Customer) currentuser);
		}
		if(Choice.trim().equalsIgnoreCase("v")) {
			Customer.ViewBasket( (Customer) currentuser);
		}
		if(Choice.trim().equalsIgnoreCase("b")) {
			Customer.BuyBooks((Customer) currentuser);
		}
		if(Choice.trim().equalsIgnoreCase("l")) {
			main(null);
		}
		if(Choice.trim().equalsIgnoreCase("e")) {
			Customer.EmptyBasket((Customer) currentuser);
		}
		else {
			CustomerBasketMenu();
		}
	}
	
	
	
	public static void AdminMainMenu() throws IOException, ParseException {
		System.out.println("---------------");
		System.out.println("Would you like to go to the view books (v), add books to the stock (a) or logout(l)? ");
		Scanner reader = new Scanner(System.in);
		String Choice = reader.nextLine();
		System.out.println(Choice.trim());
		
		if(Choice.trim().equalsIgnoreCase("a")) {
			Books.AddBooks();
		}
		if(Choice.trim().equalsIgnoreCase("v")) {
			Books.viewBooks("admin");
		}
		if(Choice.trim().equalsIgnoreCase("l")) {
			main(null);
		}
		else {
			AdminMainMenu();
		}
	}
	

	
	
	
	
}
