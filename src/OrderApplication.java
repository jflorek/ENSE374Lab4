import java.nio.file.Paths;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class OrderApplication {
	
	public static final int randSeed = 10;

	public static void main(String[] args) {
		System.out.println("OrderApplication");
		ProductCatalogue catalogue = new ProductCatalogue();
		populateCatalogue(catalogue);
		System.out.println("Catalogue Products:");
		for (int i = 0; i < catalogue.size(); i++) {
			Product product = catalogue.get(i);
			System.out.println(product.getId() + ": " + product.getName() + "; $" + product.getPrice());
		}
		Customer customer = new PersonalCustomer("Jethro Levi", "12 Regency City", 1.2, 0.95, 123456789);
		Order order = new Order(customer, 1, new Date());
		populateOrder(order, catalogue);
		System.out.println();
		
		order.printDetails(System.out);
		
		Iterator<OrderLine> allOrderLines = order.getOrderLines();
		if (allOrderLines.hasNext()) {
			OrderLine firstOrder = allOrderLines.next();
			System.out.println("Deleting order line: " + firstOrder.getDetails());
			order.removeOrderLine(firstOrder);
			System.out.println("Order line deleted");
			System.out.println();
			order.printDetails(System.out);
		}
	}
	
	public static void populateCatalogue(ProductCatalogue catalogue) {
		try {
			Scanner in = new Scanner(Paths.get("Data.txt"));
			while(in.hasNextLine()) {
				String[] str = in.nextLine().split("\\|");
				int productId = Integer.parseInt(str[0]);
				String name = str[1];
				double price = Double.parseDouble(str[2]);
				Product product = new Product(name, price, productId);
				catalogue.add(product);
			}
			in.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void populateOrder(Order order, ProductCatalogue catalogue) {
		Random rand = new Random(randSeed);
		int numLines = rand.nextInt(50) + 10;
		for (int i = 0; i < numLines; i++) {
			int index = rand.nextInt(catalogue.size());
			Product product = catalogue.get(index);
			int quantity = rand.nextInt(100);
			order.addOrderLine(product, quantity);
		}
	}
}
