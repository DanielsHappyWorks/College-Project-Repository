import java.util.ArrayList;

public class MainApp {
	public static void main(String[] args)
	{
		MainApp theApp = new MainApp();
		theApp.start();
	}
	
	public void start()
	{
		ArrayList<Integer> ageList = new ArrayList<Integer>();
		//System.out.println("AgeList: "+ageList);
		//System.out.println("Size: "+ageList.size());
		ageList.add(0);
		ageList.add(0);
		ageList.add(0);
		//add ,print ,remove ,search
		
		//ageList.add(new Integer(17)); boxing the value manually

		//ageList.add(16);//since java 7 its done automatically
		
		int pos = findFirst(ageList,16);
		System.out.println("Found at pos: "+pos);
		
		int posl = findLast(ageList,16);
		System.out.println("Found at pos: "+posl);
		
		boolean dup = searchDuplicate(ageList,16);
		System.out.println("There is a duplicate "+dup);
		
		int sum = sumOfValues(ageList);
		System.out.println("The sum of the values is: "+sum);
		
		double average = averageOfValues(ageList);
		System.out.println("The average of the values is: "+average);
		/*ArrayList<String> nameList = new ArrayList<String>();
		nameList.add("a");
		nameList.add("b");
		nameList.add("c");
		nameList.add("d");
		print(nameList);
	} 
	public void print(ArrayList<String> list){
		for(int i = 0; i < list.size(); i++){
			System.out.println(list.get(i));
		}*/
	}
	public void print (ArrayList<Integer> list){
		for(int i = 0; i < list.size(); i++){
			System.out.println(list.get(i));
		}
	}
	public int findFirst(ArrayList<Integer> list, int target){
		for(int i = 0; i < list.size(); i++){
			if(list.get(i)==target)
				return i;
		}
		return -1;
	}
	public int findLast(ArrayList<Integer> list, int target){
		for(int i = list.size()-1; i >= 0; i--){
			if(list.get(i)==target)
				return i;
		}
		return -1;
	}
	public boolean searchDuplicate(ArrayList<Integer> list, int target){
		int count=0;
		for(int i = list.size()-1; i >= 0; i--){
			if(list.get(i)==target){
				count++;
			}
		}
		if(count==0)
		{
			return false;
		}
		else{
			return true;
		}
	}
	// adds all of the values in the array list
	public int sumOfValues(ArrayList<Integer> list){
		if(list==null){
			return 0;
		}
		
		if(list.size()==0){
			return 0;
		}
		
		int sum=0;
		for(int i = 0; i < list.size(); i++){
			sum = sum + list.get(i);
		}
		return sum;
		
	}
	public double averageOfValues(ArrayList<Integer> list){
		int sum=0;
		for(int i = 0; i < list.size(); i++){
			sum = sum + list.get(i);
		}
		double average = (double)sum/list.size();
		return average;
		
	}
}
/*
000 zeros
0 0 1 decimal
1 2 3 positives
-1 -2 -3 negatives
12 -32 45 both*/