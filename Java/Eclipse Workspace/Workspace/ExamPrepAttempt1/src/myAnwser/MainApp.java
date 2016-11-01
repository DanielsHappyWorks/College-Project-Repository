package myAnwser;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainApp {
	public static void main(String[] args)
	{
		MainApp theApp = new MainApp();
		theApp.start();
	}

	private void start() {
		ArrayList<Vehicle> aList = new ArrayList<Vehicle>();
		aList=initializeArray();
		
		printList(aList);
		
		Collections.sort(aList, new engineSizeComparator(), orderBy.Ascending);
		System.out.println();
		printList(aList);
	}

	private void printList(ArrayList<Vehicle> aList) {
		for(Object obj : aList){
			System.out.println(obj);
		}
		
	}

	private ArrayList<Vehicle> initializeArray() {
		ArrayList<Vehicle> arrayList = new ArrayList<Vehicle>();
		
		arrayList.add(new Car("Volkswagen", "Passat", 1.9, 5, 5));
		arrayList.add(new Car("Nissan", "Micra", 1.2, 5, 5));
		arrayList.add(new Car("Volkswagen", "Golf", 1.6, 5, 4));
		arrayList.add(new Airplane("Hoover", "Mk1", 15, 2, 30000, 2000, 500));
		arrayList.add(new Airplane("Hoover", "Mk2", 32, 5, 100000, 3000, 750));
		arrayList.add(new Airplane("Hoover", "Mk3", 25, 10, 500000, 3500, 850));
		
		return arrayList;
	}
}
