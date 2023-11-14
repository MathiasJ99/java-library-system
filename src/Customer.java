import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Customer extends User {
	private float balance;
	private List<Books> Basket= new ArrayList<Books>();
	
	public Customer(int userID,String username,String surname,Address addr, String role, float balance) {
		super(userID, username, surname, addr, role, balance);
		this.balance = balance;
	}

	///Getters
	public float getBalance() {
		return balance;
	}

	public List<Books> getBasketBooks() {
		return  Basket;
	}
	
	public float getBasketPrice() {
		float total = 0;
		for (Books i : Basket) {
			total +=i.getRetailPrice();
		}
		return(total);
	}
	
	public void getBasketTitles() {
		for (Books i : Basket) {
			System.out.println(i.getTitle());
		}
		
	}
	
	//Setters
	public void setBalance(float balance) {
		this.balance = balance;
	}

	
	public void setBasket(List<Books> basket) {
		this.Basket = basket;
	}
	
	//Custom
	private void updateBasket(Books book) {
		Basket.add(book);
	}

	private void emptyBasket() {
		 Basket= new ArrayList<Books>();
		 System.out.println("your basket has been emptied");
	}
	
	private static boolean OnlyLetters(String str) {
		return str.matches("[a-zA-Z ]+");
	}
	
	
	protected static void SearchBooks() throws ParseException, IOException {
		System.out.println("Enter the title of the book you want to search for " );
		Scanner reader = new Scanner(System.in);
		String title = reader.nextLine();
		
		boolean CheckTitle = OnlyLetters(title);
		if (CheckTitle == true) {
			List<Books> Stock = Books.CreateStock();
			for (Books i : Stock) {
				if (i.getTitle().equalsIgnoreCase(title)) {
					
					System.out.println("barcode | type |  title |  language |  genre |  release"
							+ "date |  quantity in stock |  retail price |  additional information 1 |  additional information 2");
					System.out.println(i.getBarcode() + " | "+i.getType() + " | "+ i.getTitle()+ " | "+
					 i.getLanguage() + " | "+i.getGenre() + " | "+ i.getRelaseDate() + " | "+ i.getQuantityInStock()
					 + " | "+ i.getRetailPrice() + " | "+ i.getAd1() + " | "+ i.getAd2());
				
					
				}
					
			}
			Main.CustomerMainMenu();
		}
		else {
			System.out.println("error: title can only contain letters");
			SearchBooks();
		}
	}
	
	
	protected static void ViewBasket(Customer currentuser) throws IOException, ParseException {
		System.out.println("your basket is currently ");
		System.out.println("-------");
		currentuser.getBasketTitles();
		Main.CustomerMainMenu();
	}
	
	protected static void EmptyBasket(Customer currentuser) throws IOException, ParseException {
		currentuser.emptyBasket();
		Main.CustomerMainMenu();
		
	}
	
	private static boolean OnlyNumbers(String str) {
		return str.matches("[0-9, ]+");
	}
	
	
	public static void AddBookstoBasket(Customer currentuser) throws ParseException, IOException {
		System.out.println("Enter the barcode of the books sepated by a comma to add to the basket " );
		Scanner r1 = new Scanner(System.in);

		String Choice = r1.nextLine();
		boolean CheckChoice = OnlyNumbers(Choice);
		
		if(CheckChoice == true) {
			List<Books> BooksArr = Books.CreateStock();
			String[] ToAddArr = Choice.split(",");
			
			for (int j=0; j<ToAddArr.length; j++)
				for (Books i : BooksArr) {
				{
					if (i.getBarcode() == Integer.parseInt(ToAddArr[j]))
						
					{///IDK Y ITS CASTING
						((Customer) currentuser).updateBasket(i);
						i.setQuantityInStock(i.getQuantityInStock()-1);
						break;
					}
				}
				}
			System.out.println("your basket is currently ");
			System.out.println("-------");
			((Customer) currentuser).getBasketTitles();
		}
		else {
			System.out.println("error: Barcodes can only contain numbers ");
			AddBookstoBasket(currentuser);
		}
		
		//System.out.println("would you like to buy these books (y/n)" );
		//Scanner reader = new Scanner(System.in);
//
		//String answer = reader.nextLine();
		//if (answer.equalsIgnoreCase("y")) {
		//	BuyBooks(currentuser);
		//}
		//else {
		//	Main.CustomerMainMenu();
		//}
		Main.CustomerMainMenu();
	}
	
	public static void BuyBooks(Customer currentuser) throws ParseException, IOException {
		
		float basketPrice = ((Customer) currentuser).getBasketPrice();
		if (basketPrice >0)
		{
			System.out.printf("current basket price is ");
			System.out.println(basketPrice);
			System.out.println("Would you like to buy the books in your basket? (y/n) ");
			Scanner r2 = new Scanner(System.in);
			String Choice = r2.nextLine();
			if (Choice.equalsIgnoreCase("y")) {
				if (currentuser.getBalance() >= basketPrice) {
					List<Books> Stock = Books.CreateStock();
					List<Books> Basket = ((Customer) currentuser).getBasketBooks();
					boolean basketInStock = true;
					for (Books j : Basket) {
						if (j.getQuantityInStock()<=0) {
							System.out.println(j.getTitle() +" is out of stock");
							basketInStock = false;
						}
							
						
					}
					if (basketInStock == true) {
						for (Books j : Basket) {
							for (Books i : Stock) {
								if (i.getBarcode() == j.getBarcode()){
									i.setQuantityInStock(i.getQuantityInStock()-1);
									break;
								}
									
							}
							
						}
						Books.UpdateStock(Stock, Basket);
					
						/// need to update whole file
						System.out.println("books have been bought ");
						float remainingCredit =currentuser.getBalance()-basketPrice;
						((Customer) currentuser).setBalance(remainingCredit);
						
						System.out.println("Thank you for the purchase! £" +basketPrice
								+ " paid and your remaining credit balance is £" + remainingCredit 
								+ ". Your delivery address is "  + currentuser.getAddress());
						
						currentuser.emptyBasket();
						UpdateBalance(currentuser,  remainingCredit);
					}
					else {
						System.out.println("error: cant buy basket as  book(s) in basket are not in stock");
					}
				}
				else{
					System.out.println("error: you have insufficient funds");
					Main.CustomerMainMenu();
				}
			}
			if(Choice.equalsIgnoreCase("n")) {
				Main.CustomerMainMenu();
			}
			else {
				System.out.println("error: please choose (y) or (n)");
				BuyBooks(currentuser);
			}
		}
		else {
			System.out.println("There is nothing in your basket");
			Main.CustomerMainMenu();
		}
	}
	
	private static void UpdateBalance(Customer currentuser, float newbalance) throws IOException {
	    try {
	        File inputFile = new File("UserAccounts.txt");

	        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
	        List<String> lines = new ArrayList<>();

	        String line;
	        while ((line = reader.readLine()) != null) {
	            String[] section = line.split(",");
	            String username = section[1].trim();
	            
	            if (username.equals(currentuser.getUsername())) {
	                // Update balance of existing customer object
	                section[6] = String.format("%.2f", newbalance);
	            }
	            
	            // Append updated line to list
	            String updatedLine = String.join(", ", section);
	            lines.add(updatedLine);
	        }

	        reader.close();

	        // Write updated lines to input file
	        BufferedWriter writer = new BufferedWriter(new FileWriter(inputFile));
	        for (String updatedLine : lines) {
	            writer.write(updatedLine);
	            writer.newLine();
	        }

	        writer.close();

	        //System.out.println("File updated successfully");
	    } catch (IOException e) {
	        //System.out.println("An error occurred while editing the file.");
	        e.printStackTrace();
	    }
	}


}
	

