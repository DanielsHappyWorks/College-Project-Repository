import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;

public class ProductStore {
	private List<Product> list;
	private HashSet<Product> set;
	
	public ProductStore(){
		this.list = new ArrayList<Product>();
		this.set = new HashSet<Product>();
	}

	public List<Product> getList() {
		return list;
	}

	public void setList(List<Product> list) {
		this.list = list;
	}
	
	public void add(Product p){
		if(!this.set.contains(p))
			this.list.add(p);
			this.set.add(p);
	}
	
	public int size(){
		return this.list.size();
	}
	
	public void clear(){
		this.list.clear();
		this.set.clear();
	}
	
	public void print(){
		for(Product p : list){
			System.out.println(p);
		}
	}
	public void remove(Product p){
		if(this.set.contains(p)){
			this.list.remove(p);
			this.set.remove(p);
		}
	}
}
