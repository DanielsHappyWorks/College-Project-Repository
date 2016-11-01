import java.util.ArrayList;

/*
 * Removing elements from an ArrayList
 * -----------------------------------
 * When you remove an element from an arraylist
 * always decrement the value of the i variable (indexer)
 * i.e. (for int i = 0;...)
 * 
 * Think about what happens to a stack of books when we remove
 * one from the middle.
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
		TaskList tList1 = new TaskList("nmcg's list");
		tList1.add(new Task("Wash car", 28, 10, 2015));
		tList1.add(new Task("Pay electricity bill", 31, 10, 2015));
		
		tList1.removeAllTasksBefore(32);
		tList1.print();
	}

}






