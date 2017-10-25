import java.util.Date;

public class OrderApplication {

	public static void main(String[] args) {
		Customer customer = new Customer("name", "address", 1.2, 3.4);
		Order order = new Order(customer, 23, new Date());
		System.out.println("OrderApplication");
		Product product = new Product("name", 2.3, 2);
		System.out.println(product.getName());
		OrderLine line = order.addOrderLine(product, 23);
		System.out.println(line.calculatePrice());
	}

}
