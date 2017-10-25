public class OrderApplication {

	public static void main(String[] args) {
		System.out.println("OrderApplication");
		Product product = new Product("name", 2.3, 2);
		System.out.println(product.getName());
		Customer customer = new Customer("name", "address", 1.2, 3.4);
	}

}
