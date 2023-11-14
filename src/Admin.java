
public class Admin extends User {

	public Admin(int userID,String username,String surname,Address addr, String role, float balance) {
		super(userID, username, surname, addr,role, balance);
		this.balance = 0;
	}

	

}
