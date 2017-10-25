import java.util.ArrayList;

@SuppressWarnings("serial")
public class ProductCatalogue extends ArrayList<Product> {
	public Product getProductById(int productId) {
		for (int i = 0; i < size(); i++) {
			Product product = get(i);
			if (product.getId() == productId)
				return product;
		}
		return null;
	}
	
	public Product getProductByName(String name) {
		for (int i = 0; i < size(); i++) {
			Product product = get(i);
			if (product.getName().equals(name))
				return product;
		}
		return null;
	}
}
