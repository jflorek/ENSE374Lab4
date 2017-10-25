import java.nio.file.Paths;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

public class OrderApplication {

	public static void main(String[] args) {
		System.out.println("OrderApplication");
		ProductCatalogue catalogue = new ProductCatalogue();
		populateCatalogue(catalogue);
		System.out.println("Catalogue Products:");
		for (int i = 0; i < catalogue.size(); i++) {
			Product product = catalogue.get(i);
			System.out.println(product.getId() + ": " + product.getName() + "; $" + product.getPrice());
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
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
