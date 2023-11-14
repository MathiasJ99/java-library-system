import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User {
	private int userID;
	private String username;
	private String surname;
	private Address addr;
	private String role;
	protected float balance;

	
	
	public User(int userID,String username,String surname,Address addr, String role,float balance) {
		this.userID = userID;
		this.username = username;
		this.surname = surname;
		this.addr = addr;
		this.role = role;
		this.balance = balance;
	}
	
	public int getUserID() {
		return userID;
	}
	public float getBalance() {
		return balance;
	}
	
	public String getRole() {
		return role;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public Address getAddress() {
		return addr;
	}
	
	public void setUserID(int userID) {
		this.userID = userID;

	}
	
	protected static User[] CreateUsers() throws FileNotFoundException  {
		// should go through useraccounts text file and create a list of users (admin/customer) and store in userArr
		File inputFile = new File("UserAccounts.txt");
		Scanner fileScan =new Scanner(inputFile);
		User[] userArr = new User[4];

		int count = 0;
		while (fileScan.hasNextLine()) {
			String line = fileScan.nextLine();
			
			String[] tempArr = line.split(",");
			
			int userID = Integer.parseInt(tempArr[0].trim());
			String username = tempArr[1].trim();
			String surname = tempArr[2].trim();
			int houseNo = Integer.parseInt(tempArr[3].trim());
			String postcode = tempArr[4].trim();
			String city = tempArr[5].trim();
			//System.out.print(userID);
			//System.out.print(surname);
			
		
			
			
			
			String temp = tempArr[6].trim();
			try {// if it has a float it is a customer as it has a balance
				float balance = Float.parseFloat(temp);
				String role = tempArr[7].trim();
				
				
				Address tempAddr = new Address(houseNo,postcode,city);
				
				//System.out.print(balance);
				//System.out.print(tempAddr);
				//System.out.print(role);
				//System.out.println("-----");
				
				Customer newCustomer = new Customer(userID,username,surname, tempAddr, role, balance);
				userArr[count] = newCustomer;
				count+=1;
				
				
			}
			catch(Exception e) {
				String role = tempArr[7].trim();
				
				Address tempAddr = new Address(houseNo,postcode,city);
				
				//System.out.print(tempAddr);
				//System.out.print(role);
				//System.out.println("-----");
				

				Admin newAdmin = new Admin(userID,username,surname, tempAddr,role,0);
				userArr[count] = newAdmin;
				count+=1;
				
			}

		}
		return userArr;
	}
			
		

		// takes userArr as input and returns all usernames
	protected static List<String> GetUsernames(User[] userArr) {
		List<String> Allusernames = new ArrayList<>();
		for (User i : userArr) {
			Allusernames.add(i.username);
		}
		//System.out.print(Allusernames.toString());
		return Allusernames;
		
	}
	
	
	
	//public static void main(String[] args) throws FileNotFoundException  {
	//	System.out.println(GetUsernames(CreateUsers()).toString());
	//}
	
}
