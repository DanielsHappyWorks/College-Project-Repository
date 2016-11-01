import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class MainApp {
	public static void main(String[] args){
		MainApp theApp = new MainApp();
		theApp.start();
	}

	public void start() {
		HashMap<Customer,ArrayList<Product>> map = new HashMap<Customer,ArrayList<Product>>();
		
		Customer c1 = new Customer("Sarah","Behan","sarahB@hotmail.com");
		ArrayList<Product> pList1 = new ArrayList<Product>();
		pList1.add(new Product("Hp Pavilion", "Laptop", 1, 499.99));
		pList1.add(new Product("BullGuard", "Antivirus", 2, 89.99));
		pList1.add(new Product("Lenovo", "Tablet", 3, 99.99));
		
		Collections.sort(pList1, new ProductPriceComparator());
		
		Customer c2 = new Customer("Sean","Clarke","sc6842@hotmail.com");
		ArrayList<Product> pList2 = new ArrayList<Product>();
		pList2.add(new Product("Dell", "Desktop", 4, 799.99));
		pList2.add(new Product("Avast", "Antivirus", 5, 49.99));
		pList2.add(new Product("Samsung Galaxy", "Smart Phone", 8, 399.99));
		
		Collections.sort(pList2, new ProductNameComparator());
		
		Customer c3 = new Customer("Peter","Boyne","petDog@hotmail.com");
		ArrayList<Product> pList3 = new ArrayList<Product>();
		pList3.add(new Product("Sony Xperia", "Smart Phone", 6, 199.99));
		pList3.add(new Product("Dog Food", "Food", 7, 14.99));
		
		map.put(c1, pList1);
		map.put(c2, pList2);
		map.put(c3, pList3);

		print(map);
		
		System.out.println("Total cost: "+ getTotalCost(map));
		System.out.println("Total Average cost: "+ getTotalAverageCost(map));
		
	}
	public void sortBy(ArrayList<Product> list, Comparator<Product> comp){
		Collections.sort(list,comp);
	}
	public void print(HashMap<Customer,ArrayList<Product>> map){
		for(Customer key : map.keySet()){
			ArrayList<Product> list = map.get(key);
			System.out.println(key +" : ");
			for(Product p : list){
				System.out.println(p);
			}
			System.out.println();
		}
	}
	public double getTotalCost(HashMap<Customer,ArrayList<Product>> map){
		double sum = 0;
		for(Customer key : map.keySet()){
			ArrayList<Product> list = map.get(key);
			for(Product p : list){
				sum += p.getPrice();
			}
		}
		return sum;
	}
	public double getTotalAverageCost(HashMap<Customer,ArrayList<Product>> map){
		double sum = 0;
		int count=0;
		for(Customer key : map.keySet()){
			ArrayList<Product> list = map.get(key);
			for(Product p : list){
				sum += p.getPrice();
				count++;
			}
		}
		return sum/count;
		
		//return getTotalCost(map)/lenght of all things in list?
	}
}
