import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainApp {
	public static void main(String[] args) {
		MainApp theApp = new MainApp();
		theApp.start();
	}

	public void start() {
		LinkedList<Integer> list1 = new LinkedList<Integer>();
		list1.add(1);
		list1.add(2);
		list1.add(3);
		System.out.println();
		
		ArrayList<String> list2 = new ArrayList<String>();
		list2.add("a");
		list2.add("b");
		list2.add("c");
		System.out.println();
		
		LinkedList<String> list3 = new LinkedList<String>();
		list3.add("1");
		list3.add("2");
		list3.add("3");
		System.out.println();
		
		GenericListUtility.print(list1);
		GenericListUtility.print(list2);
		System.out.println();
		
		GenericListUtility.printReverse(list1);
		System.out.println();
		
		ArrayList<String> listOut = new ArrayList<String>();
		GenericListUtility.concatenate(list3, list2, listOut);
		GenericListUtility.print(listOut, "***************** CONCATINATED LIST *****************");
		
		listOut = (ArrayList<String>)GenericListUtility.interleave(list3, list2);
		GenericListUtility.print(listOut, "***************** INTERLEAVED LIST *****************");
		
		ArrayList<Product> list = new ArrayList<Product>();
		list.add(new Product("Apple iPad", 750));
		list.add(new Product("Samsung S7", 899));
		list.add(new Product("Apple iPad", 750));
		list.add(new Product("Samsung S7", 899));
		list.add(new Product("LG GH4", 650));		
		GenericListUtility.showObjectCount(list);
	}
}
