import java.util.ArrayList;
import java.util.Iterator;
import java.util.Date;
import java.io.PrintStream;

public class Order {
	private class PrivateOrderLine extends OrderLine{
		protected PrivateOrderLine(Product product, int quantity) {
			super(product, quantity);
		}		
	}

	private ArrayList<OrderLine> orderLines;
	private Customer customer;
	private int orderId;
	private Date dateReceived;
	
	public Order(Customer customer, int orderId, Date dateReceived) {
		orderLines = new ArrayList<OrderLine>();
		this.customer = customer;
		this.orderId = orderId;
		this.dateReceived = dateReceived;
	}
	
	public OrderLine addOrderLine(Product product, int quantity) {
		OrderLine newOrderLine = new PrivateOrderLine(product, quantity);
		orderLines.add(newOrderLine);
		return newOrderLine;
	}
	
	public Boolean removeOrderLine(OrderLine orderLine) {
		return orderLines.remove(orderLine);
	}
	
	public Iterator<OrderLine> getOrderLines() {
		return orderLines.iterator();
	}
	
	public Customer getCustomer() {
		return this.customer;
	}
	
	public int getOrderId() {
		return this.orderId;
	}
	
	public Date getDateReceived() {
		return this.dateReceived;
	}
	
	public double calculatePrice() {
		double price = 0;
		for (int i = 0; i < orderLines.size(); i++) {
			price += orderLines.get(i).calculatePrice();
		}
		price *= getCustomer().getDiscountRating();
		return price;
	}
	
	public void printDetails(PrintStream out) {
		out.println("Order " + getOrderId() + " Contents:");
		for (Iterator<OrderLine> it = getOrderLines(); it.hasNext(); out.println(it.next().getDetails()));
		out.println(getCustomer().getName() + " discount rating: " + getCustomer().getDiscountRating());
		out.println("Final price: $" + calculatePrice());
	}
}
