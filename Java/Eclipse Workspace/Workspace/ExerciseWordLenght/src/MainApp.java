import java.util.ArrayList;
import java.util.TreeMap;

public class MainApp {
	public static void main(String[] args){
		MainApp theApp = new MainApp();
		theApp.start();
	}

	public void start() {
		String data = "I watched a great show last night It was called Akame Ga Kill I wish i could watch something as great again";
		
		TreeMap<Integer, ArrayList<String>> map = new TreeMap<Integer, ArrayList<String>>();
		String regex = "\\s+";
		map = getLenght(data , regex);
		System.out.println(map);
		
		System.out.println();
		TreeMap<Integer, ArrayList<String>> outerMap = new TreeMap<Integer, ArrayList<String>>();
		getLenght(outerMap,"today is wendsday",regex);
		System.out.println(outerMap);
		getLenght(outerMap,"tomorrow is thursday",regex);
		System.out.println(outerMap);
	}
	
	public void getLenght(TreeMap<Integer, ArrayList<String>>map, String data, String regex){
		String[] wordArray = data.split(regex);
		String word = "";
		int length = 0;
		
		for(int i=0; i<wordArray.length; i++){
			word = wordArray[i];
			word = word.toLowerCase();
			length = word.length();
			ArrayList<String> list = map.get(length);
			if(list == null){
				ArrayList<String> newList = new ArrayList<String>();
				newList.add(word);
				map.put(length, newList);
			}
			else{
				if(!list.contains(word)){
					list.add(word);
					map.put(length, list);
				}
			}
		}
	}
	
	public TreeMap<Integer, ArrayList<String>> getLenght(String data, String regex){
		String[] wordArray = data.split(regex);
		TreeMap<Integer, ArrayList<String>> map = new TreeMap<Integer, ArrayList<String>>();
		String word = "";
		int length = 0;
		
		for(int i=0; i<wordArray.length; i++){
			word = wordArray[i];
			word = word.toLowerCase();
			length = word.length();
			ArrayList<String> list = map.get(length);
			if(list == null){
				ArrayList<String> newList = new ArrayList<String>();
				newList.add(word);
				map.put(length, newList);
			}
			else{
				if(!list.contains(word)){
					list.add(word);
					map.put(length, list);
				}
			}
		}
		
		return map;
	}
}
