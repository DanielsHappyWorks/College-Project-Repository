import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenericListUtility {
	public static <E> void print(List<E> list){
		for(E e : list){
			System.out.println(e);
		}
	}
	
	//print header
	public static <E> void print(List<E> list, String prompt){
		System.out.println(prompt);
		print(list);
	}
	
	//reverse print
	public static <E> void printReverse(List<E> list){
		for (int i = list.size()-1; i >= 0; i--) {
			System.out.println(list.get(i));
		}
	}
	
	public static <E> void printReverse(List<E> list, String prompt){
		System.out.println(prompt);
		printReverse(list);
	}
	
	//concatenate
	public static <E> void concatenate(List<E> listA, List<E> listB, List<E> listOut){
		listOut.addAll(listA);
		listOut.addAll(listB);
	}
	
	public static <E> List<E> concatenate(List<E> listA, List<E> listB){
		ArrayList<E> listOut = new ArrayList<E>();
		listOut.addAll(listA);
		listOut.addAll(listB);
		return listOut;
	}
	//interleave
	public static <E> List<E> interleave(List<E> listA, List<E> listB){
		if(listA.size() != listB.size()){
			return null;
		}
		
		int outSize = 2* listA.size();
		ArrayList<E> listOut = new ArrayList<E>(outSize);
		for(int i = 0; i<outSize;i++){
			if(i%2==0){
				listOut.add(listA.remove(0));
			}
			else{
				listOut.add(listB.remove(0));
			}
		}
		return listOut;
	}
	//filterBy
	public static <E> ArrayList<E> filterBy(List<E> list, IFilter<E> filter){
		ArrayList<E> listOut = new ArrayList<E>();
		for(E e : list){
			if(filter.matches(e))
				listOut.add(e);
		}
		return listOut;
	}
	//romoveBy
	
	//getSmallest
	//GetLargest
	
	//showCount
	public static <E> void showObjectCount(List<E> list){
		Map<E, Integer> map = new HashMap<E, Integer>();
		for(E e : list){
			if(map.containsKey(e)){//already there
				map.put(e, map.get(e)+1);
			}
			else{//not there
				map.put(e, 1);
			}
		}
		for(E e : map.keySet()){
			System.out.println("Object: "+ e +"\t Quantity:"+map.get(e));
		}
	}
	
	public static <E> HashMap<E, Integer> getObjectCount(List<E> list){
		HashMap<E, Integer> map = new HashMap<E, Integer>();
		int frequency;
		
		for(E e : list){
			if(map.containsKey(e)){//already there
				frequency = map.get(e);
				frequency++;
				map.put(e, frequency);
			}
			else{//not there
				map.put(e, 1);
			}
		}
		return map;
	}
}
