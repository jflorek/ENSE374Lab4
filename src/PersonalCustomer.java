
public class PersonalCustomer extends Customer {

	private int creditCardNumber;

	public PersonalCustomer(String name, String address, double creditRating, double discountRating, int creditCardNumber) {
		super(name, address, creditRating, discountRating);
		this.creditCardNumber = creditCardNumber;
	}

	public int getCreditCardNumber() {
		return this.creditCardNumber;
	}
}
