import java.util.ArrayList;
import java.util.HashMap;

public class MainApp {
	public static void main(String[] args){
		MainApp theApp = new MainApp();
		theApp.start();
	}

	public void start() {
		HashMap<Student,Module> map = new HashMap<Student,Module>();
		
		map.put(new Student("John","Smith",1), new Module("oop",100,0));
		map.put(new Student("Sarah","doe",2), new Module("math",60,40));
		
		print(map);
		
		HashMap<Student, ArrayList<Module>> multiMap = new HashMap<Student, ArrayList<Module>>();
		
		Student s = new Student("jim","murphy",3);
		ArrayList<Module> list = new ArrayList<Module>();
		list.add(new Module("oop",100,0));
		list.add(new Module("math",60,40));
		multiMap.put(s, list);
		
		System.out.println();
		
		ArrayList<Module> rList = multiMap.get(s);
		for(Module m : rList)
			System.out.println(m);
		
	}
	public void print(HashMap<Student,Module> map){
		for(Student key : map.keySet()){
			System.out.println(key + " : " + map.get(key));
		}
	}
	
	public void print2(HashMap<Student,ArrayList<Module>> map){
		for(Student key : map.keySet()){
			ArrayList<Module> list = map.get(key);
			System.out.println(list);
		}
	}
}
