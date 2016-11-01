import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Demonstrate the creation of non-static (i.e. MainApp::print)
 * and static (i.e. GenericListUtility) generic methods.
 * 
 * Why are generic methods so great? We write them once and they
 * can be re-used for any number of Java-defined or user-defined 
 * object types. 
 * 
 * Notice how the NumberRangeFilter, StringRegexFilter, and ConnectionUsageFilter
 * can be re-used by the GenericListUtility::filterBy() method for lists
 * containing String objects, Connection objects etc.
 * 
 * @author NMCG
 * @version 1.0
 *
 */
public class MainApp 
{
	public static void main(String[] args) 
	{
		MainApp theApp = new MainApp();
		theApp.start();
	}

	private void start() 
	{	
		System.out.println("\n*********** Demo of a non-static generic print method ***********");
		demoNonStaticGeneric();

		System.out.println("\n*********** Demo of a static generic print method ***********");
		demoStaticGeneric();		
		
		demoStaticUsefulListMethods();
		
		demoStaticPopulate();
		
		demoStaticGetMinimum();
		
		demoStaticGetAverage();
	}
	
	private void demoStaticGetAverage() {
		List<String> countryList = new ArrayList<String>();
	
		countryList.add("India");
		countryList.add("Lithuania");
		countryList.add("Cuba");
		
		double average = GenericListUtility.getAverage(countryList, new StringLengthMeasurer());
		System.out.println();
		System.out.println("*********AVERAGE DEMO*********");
		System.out.println(average);
	}

	private void demoStaticGetMinimum() 
	{

		List<String> countryList
			 = new ArrayList<String>();
		
		countryList.add("India");
		countryList.add("Lithuania");
		countryList.add("Cuba");
		
		char[] charArray = {'a','e','i','o','u'};
		
		String smallest = GenericListUtility.getMinimum(countryList, 
				new StringCharacterMeasurer(charArray));
		
		System.out.println("Smallest: " + smallest);
		
		Pair<String, Integer> smallestPair 
		= GenericListUtility.getMinimumAsPair(
			countryList, new StringCharacterMeasurer(charArray));
		
		System.out.println("Smallest Pair: " + smallestPair);

	}

	private void demoStaticPopulate() 
	{
		LinkedList<String> strList = new LinkedList<String>();
		GenericListUtility.populate(strList, 10, "default!");
		
		GenericListUtility.print(strList, 
		"***** Demo of generic populate for String *****");
		
		ArrayList<Player> pList = new ArrayList<Player>();
		Player defaultPlayer 
		= new Player("deflt name", "deflt team", 0, 0, 0);
		GenericListUtility.populate(pList, 5, defaultPlayer);
		
		GenericListUtility.print(pList, 
		"***** Demo of generic populate for Player *****");
		
	}

	
	
	private void demoStaticUsefulListMethods()
	{
		System.out.println("\n*********** Demo of GenericListUtility::filterBy(Integer) ***********");
		LinkedList<Integer> intList = new LinkedList<Integer>();
		intList.add(1); 
		intList.add(2);
		intList.add(3);
		
		ArrayList<Integer> filteredIntegerList = GenericListUtility.filterBy(intList, new NumberRangeFilter(1, 5));
		GenericListUtility.print(filteredIntegerList, "***** Filtered Integer list *****");

		System.out.println("\n*********** Demo of GenericListUtility::filterBy(String) ***********");
		ArrayList<String> strList = new ArrayList<String>();
		strList.add("programme"); 
		strList.add("ramification");
		strList.add("running");
			
		ArrayList<String> filteredStringList 
		= GenericListUtility.filterBy(strList, new StringRegexFilter("\\w*ram\\w*"));
		GenericListUtility.print(filteredStringList, "***** Filtered String list *****");
		
		System.out.println("\n*********** Demo of GenericListUtility::filterBy(Player) ***********");
		LinkedList<Player> pList = new LinkedList<Player>();
		pList.add(new Player("jack", "red", 10, 10, 2));
		pList.add(new Player("jane", "blue", 20, 20, 2));
		pList.add(new Player("steve", "blue", 5, 5, 2));
		pList.add(new Player("bea", "red", 0, 10, 2));
		
		ArrayList<Player> distanceFilteredList
			 = GenericListUtility.filterBy(pList, 
			new PlayerDistanceFromFilter(
					DistanceCriteriaType.Equal,
					0, 0, 2, 10));
		
		GenericListUtility.print(distanceFilteredList, 
			"***** Players filtered by distance from *****");	
		
		System.out.println("\n*********** Demo of GenericListUtility::concatenate() ***********");
		ArrayList<Integer> anotherIntList = new ArrayList<Integer>();
		anotherIntList.add(40); 
		anotherIntList.add(50);
		anotherIntList.add(60);		
		LinkedList<Integer> concatIntList = new LinkedList<Integer>();	
		GenericListUtility.concatenate(intList, anotherIntList, concatIntList);	
		GenericListUtility.print(concatIntList, "***** Concatenated Integer list *****");	
		
		System.out.println("\n*********** Demo of GenericListUtility::interleave() ***********");
		ArrayList<Integer> interleavedIntegerList = GenericListUtility.interleave(intList, anotherIntList);
		GenericListUtility.print(interleavedIntegerList, "***** Interleaved Integer list *****");
	}
	
	private void demoNonStaticGeneric() 
	{
		LinkedList<Integer> list1 = new LinkedList<Integer>();
		list1.add(1); 
		list1.add(2);
		list1.add(3);
		list1.add(11);
		list1.add(12);
		print(list1); //calls the non-static method below	
	}
	
	public void print(ArrayList<String> list)
	{
		for(String s : list)
			System.out.println(s);
	}

	public <E> void print(List<E> list)
	{
		for(E e : list)
			System.out.println(e);
	}
	
	private void demoStaticGeneric() 
	{
		LinkedList<Integer> list1 = new LinkedList<Integer>();
		list1.add(1); 
		list1.add(2);
		list1.add(3);
		list1.add(11);
		list1.add(12);
		GenericListUtility.print(list1);

		ArrayList<Integer> list2 = new ArrayList<Integer>();
		list2.add(4); 
		list2.add(5);
		list2.add(6);
		GenericListUtility.print(list2); //same print method different object type - it's generic!
	}
}










