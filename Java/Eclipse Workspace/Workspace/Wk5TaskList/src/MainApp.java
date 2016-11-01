import java.util.ArrayList;

public class MainApp 
{
	public static void main(String[] args) 
	{
		MainApp theApp = new MainApp();
		theApp.start();
	}
	
	public void start()
	{
		Task t1 = new Task("Go to Dentist", 20, 10, 2015);
		System.out.println(t1);
		
		ArrayList<Task> tList = new ArrayList<Task>();
		tList.add(new Task("Wash Car"));
		tList.add(new Task("Go to Dentist", 20, 10, 2015));
		tList.add(new Task("GG NO RE", 20, 10, 2015));
		
		System.out.println(getAllOnDate(tList, 0));
	}
	
	public ArrayList<Task> getAllOnDate(ArrayList<Task> list, int date){
		ArrayList<Task> result = new ArrayList<Task>();
		for(Task t : list){
			if(t.getDate()==date){
				result.add(t);
			}
		}
		return result;
	}
}