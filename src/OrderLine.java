
public class OrderLine {
	private Product product;
	private int quantity;
	
	protected OrderLine(Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
	}
	
	public Product getProduct() {
		return this.product;
	}
	
	public int getQuantity() {
		return this.quantity;
	}
	
	public double calculatePrice() {
		return getQuantity() * getProduct().getPrice();
	}
}
