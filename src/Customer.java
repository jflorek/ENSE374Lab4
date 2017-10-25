
public class Customer {
	private String name;
	private String address;
	private double creditRating;
	private double discountRating;
	
	public Customer(String name, String address, double creditRating, double discountRating) {
		this.name = name;
		this.address = address;
		this.creditRating = creditRating;
		this.discountRating = discountRating;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getAddress() {
		return this.address;
	}
	
	public double getCreditRating() {
		return this.creditRating;
	}
	
	public double getDiscountRating() {
		return this.discountRating;
	}
}
