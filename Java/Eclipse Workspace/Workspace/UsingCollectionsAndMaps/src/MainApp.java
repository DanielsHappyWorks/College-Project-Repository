import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.regex.Pattern;

public class MainApp {
	public static void main(String args[]){
		MainApp theApp = new MainApp();
		theApp.start();
	}

	public void start() {
		//Pattern pattern = Pattern.compile("\\b\\w+\\b");
			//countFrequency("monday is my least favourite day! I hate monday. Please let me go home. I want to sleep.", pattern);
		//demoHashMapInteger() 
		//demoLinkedList()
		//demoHashMap()
		//demoTreeMap();
		//demoTreeMapNumbers();
		//demoHashSet() ;
		//demoTreeSet() ;
		//demoTreeSetProducts() ;
		//demoStack() ;
		demoQueue() ;
	}
	
	private void demoTreeMapNumbers() {
		TreeMap<Integer, String> map = new TreeMap<Integer,String>();
		map.put(3,"john smith");
		map.put(5,"bob jones");
		map.put(2,"may west");
		
		System.out.println(map);
	}
	
	private void demoHashSet() {
		HashSet<String> set = new HashSet<String>();
		set.add("alan");
		set.add("bob");
		set.add("ciara");
		
		System.out.println(set);
		
		boolean bContains = set.contains("bob");
		System.out.println(bContains);
	}
	
	private void demoTreeSet() {
		TreeSet<String> set = new TreeSet<String>();
		set.add("z");
		set.add("h");
		set.add("d");
		
		System.out.println(set);
		
		boolean bContains = set.contains("z");
		System.out.println(bContains);
	}
	
	private void demoTreeSetProducts() {
		TreeSet<Product> set = new TreeSet<Product>();
		set.add(new Product("apple"));
		set.add(new Product("orange"));
		set.add(new Product("cherry"));

		
		System.out.println(set);
	}
	
	private void demoStack() {
		Stack<String> stack = new Stack<String>();
		stack.push("Monday");
		stack.push("Tuesday");
		stack.push("Wednesday");
		stack.push("Thursday");
		stack.push("Friday");

		
		System.out.println(stack);
		
		System.out.println();
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		
		System.out.println();
		for(int i= 0; i < stack.size();i++){
			System.out.println(stack.elementAt(i));
		}
		
		System.out.println();
		String s = stack.peek();
		System.out.println(s);
		
		System.out.println();
		System.out.println(stack);
	}
	
	private void demoQueue() {
		PriorityQueue<Customer> queue = new PriorityQueue<Customer>();
		queue.add(new Customer(1,"anna jones","salary not paid"));
		queue.add(new Customer(1,"Bob Casey","salary not paid"));
		queue.add(new Customer(5,"bob smith","interested in a deposit account"));
		queue.add(new Customer(2,"jane murphy","mortgage request callback"));
		
		System.out.println(queue);
		
		System.out.println();
		System.out.println("removes in proper priority");
		Customer c = queue.remove();
		System.out.println(c);
		c = queue.remove();
		System.out.println(c);
		c = queue.remove();
		System.out.println(c);
		c = queue.remove();
		System.out.println(c);
		
	}
	
	private void demoTreeMap() {
		TreeMap<String, String> map = new TreeMap<String,String>();
		map.put("bmw", "z3");
		map.put("audi", "a8");
		map.put("ford", "puma");
		
		System.out.println();
		System.out.println(map.containsKey("bmw"));
		System.out.println(map.containsValue("a8"));
		
		System.out.println(map);
		
		for(String key : map.keySet()){
			String value = map.get(key);
			System.out.println(key+":"+value);
		}
		System.out.println(map.size());
	}

	private void demoHashMapInteger() {
		HashMap<String, Integer> numMap = new HashMap<String, Integer>();
		
		numMap.put("alan", 21);
		numMap.put("bea", 38);
		numMap.put("ciara", 24);
		
		System.out.println(numMap);
		
		int age = numMap.get("bea");
		age++;
		numMap.put("bea", age);
		System.out.println(numMap);
	}
	public void countFrequency(String data,Pattern pattern){
		//monday is my least favourite day!
		ArrayList<String> wordList = RegexUtility.apply(data, pattern, 0);
		
		HashMap<String, Integer> wordMap = new HashMap<String, Integer>();
		for(String word : wordList){
			if(wordMap.containsKey(word)){
				int freq = wordMap.get(word);
				freq++;
				wordMap.put(word, freq);
			}
			else{
				wordMap.put(word, 1);
			}
		}
		System.out.println(wordMap);
	}

	public void demoLinkedList(){
		LinkedList<String> lList = new LinkedList<String>();
		lList.add("A");
		lList.add("B");
		lList.add("C");
		
		print(lList, "Capital Letters");
		
		lList.add(1,"D");
		lList.set(0,"Z");
		
		print(lList, "Capital Letters");
		
		lList.remove();
		lList.remove(2);
		
		print(lList, "Capital Letters");
	}
	private void demoHashMap(){
		HashMap<String, String> map = new HashMap<String, String>();
		
		//sorts in its own way
		map.put("audi", "a4");
		map.put("fiat", "500");
		map.put("mini", "metro");
		//does not tolerate duplicates (overwrites)
		map.put("fiat", "punto");
		
		System.out.println(map);
		
		String model = map.get("mini");
		System.out.println(model);
		
		for(String key : map.keySet()){
			String value = map.get(key);
			System.out.println(key +":"+value);
		}
	}
	public void demoList() {
		ArrayList<String> aList = new ArrayList<String>();
		LinkedList<String> lList = new LinkedList<String>();
		
		Collection<String> cList1 = new ArrayList<String>();
		cList1.add("a");
		cList1.add("b");
		cList1.add("c");
		
		System.out.println(cList1);
		
		print(cList1, "Letters");
		
		System.out.println();
		printOdd(cList1);
	}
	public void printOdd(Collection<String> list){
		int count=1;
		for(String str : list)
		{
			if(count%2==1){
				System.out.println(str);
			}
			count++;
		}
	}
	public void print(Collection<String> list, String header){
		System.out.println("*********** ");
		System.out.println(header);
		System.out.println("*********** ");
		
		for(String str : list)
		{
			System.out.println(str);
		}
	}
	public int getHashCode(String s){
		int sum=0;
		int seed = 31;
		for(int i = 0; i < s.length(); i++){
			sum += seed * s.codePointAt(i);
		}
		return sum;
	}
}
