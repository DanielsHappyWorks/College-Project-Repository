import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class MainApp 
{

	//add map as an instance variable so it is visible across methods
	private HashMap<Customer, ProductList> salesMap;
	
	public static void main(String[] args) 
	{
		MainApp theApp = new MainApp();
		theApp.start();
	}


	private void start() 
	{
		initializeMap();
		loadData();
		demoMethods();
	}
	
	private void demoMethods() 
	{
		//make the customer object and use as key for the query
		Customer c1 = new Customer("jane", "jones", "jj@gmail.com");
		ProductList pList = this.salesMap.get(c1);
		
		//now call our methods to get total, average etc
		double total = pList.getTotalCost();
		System.out.println("total: " + total);
		
		double average = pList.getAverageCost();
		System.out.println("average: " + average);
		
		System.out.println("Sorted...");
		pList.sortBy(new ProductPriceComparator());	
		System.out.println(pList);
		
		System.out.println("Filtered...");
		ArrayList<Product> fList = pList.filterBy(new ProductTypeFilter(ProductType.Book));
		System.out.println(fList);
	}

	private void loadData() 
	{
		Customer c1 = new Customer("jane", "jones", "jj@gmail.com");
		//ArrayList<Product> list1 = new ArrayList<Product>();
		ProductList pList = new ProductList(c1.getFirstName() + "'s list");
		
		pList.add(new Product("ipad air 2", 749, "E12345", 
				ProductType.Electronic));
		
		pList.add(new Product("The Revenant", 12.99, "M54321", 
				ProductType.Movie));
		
		pList.add(new Product("Big Java Late Objects", 45, "B76543", 
				ProductType.Book));
		
		this.salesMap.put(c1, pList);
		
		//add more customers and products if required...
		
	}

	private void initializeMap() 
	{
		this.salesMap = new HashMap<Customer, ProductList>();
		
	}
}







