
public class Product implements Comparable<Product>{
	private String name;

	public Product(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + "]";
	}

	@Override
	public int compareTo(Product obj) {
		return this.name.compareToIgnoreCase(obj.name);
	}
}
