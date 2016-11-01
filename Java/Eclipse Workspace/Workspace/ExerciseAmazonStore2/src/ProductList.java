import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
//container of products
public class ProductList {
	private String name;
	private List<Product> list;
	
	public ProductList(String name) {
		this(name,10); //calls constructor bellow
	}
	
	public ProductList(String name, int initialSize) {
		this.name = name;
		this.list = new ArrayList<Product> (initialSize);
	}
	
	//add remove print size clear
	public void add(Product p){
		//if(!this.list.contains(p))
		this.list.add(p);
	}
	public boolean removeFirst(String name){
		Product p = null;
		for(int i =0; i<this.list.size(); i++){
			p = this.list.get(i);
			if(p.getName().equalsIgnoreCase(name)){
				this.list.remove(p);
				return true;
			}
		}
		return false;
	}
	public int removeAll(String name){
		int removeCount=0;
		Product p = null;
		for(int i =0; i<this.list.size(); i++){
			p = this.list.get(i);
			if(p.getName().equalsIgnoreCase(name)){
				this.list.remove(p);
				removeCount++;
				i--; //necessary to delete duplicates that are consecutive
			}
		}
		return removeCount;
	}
	public void print(String headerDelimiter){
		//not changing size of list so we can use 5.0 for loop
		System.out.println(headerDelimiter + " "+name+" "+headerDelimiter);
		for(Product p : this.list){
			System.out.println(p);
		}
	}
	public int size(){
		return this.list.size();
	}
	public void clear(){
		this.list.clear();;
	}
	//app specific e.g getTotalCost
	public ArrayList<Product> filterBy(IFilter filter)
	{
		ArrayList<Product> rList = new ArrayList<Product>();
		for(Product p : this.list)
		{
			if(filter.matches(p))
				rList.add(p);
		}
		
		return rList;
	}

	public ArrayList<Product> filterByType(ProductType type)
	{
		ArrayList<Product> rList = new ArrayList<Product>();
		for(Product p : this.list)
		{
			if(type == p.getProductType())
				rList.add(p);
		}
		
		return rList;
	}

	public void sortBy(Comparator<Product> comp)
	{
		Collections.sort(list, comp);
	}
	
	public double getTotalCost()
	{
		double sum = 0;
		for(Product p : this.list)
		{
			sum += p.getPrice();
		}
		return sum;
	}
	
	public double getAverageCost()
	{
		double sum = getTotalCost();
		return sum/list.size();
		
	//	return getTotalPrice(list)/list.size();
	}
}
