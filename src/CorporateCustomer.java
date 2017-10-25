public class CorporateCustomer extends Customer {

	private String contactName;
	
	public CorporateCustomer(String name, String address, double creditRating, double discountRating, String contactName) {
		super(name, address, creditRating, discountRating);
		this.contactName = contactName;
	}

	public String getContactName() {
		return this.contactName;
	}
}
