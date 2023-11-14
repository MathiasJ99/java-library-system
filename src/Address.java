
public class Address {
	private int number;
	private String postcode;
	private String city;
	
	public Address (int number, String postcode, String city) {
		this.number = number;
		this.postcode = postcode;
		this.city = city;
	}
	
	@Override
	public String toString() {
		return (this.number + " " + this.postcode + " " +this.city);
		}	
	
	public String formatted() {
		return (this.number + ", " + this.postcode + ", " +this.city);
		}	
}
