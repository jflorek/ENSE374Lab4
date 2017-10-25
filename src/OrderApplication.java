public class OrderApplication {

	public static void main(String[] args) {
		Order order = new Order();
		System.out.println("OrderApplication");
		Product product = new Product("name", 2.3, 2);
		System.out.println(product.getName());
		Customer customer = new Customer("name", "address", 1.2, 3.4);
		OrderLine line = order.addOrderLine(product, 23);
		System.out.println(line.calculatePrice());
	}

}
