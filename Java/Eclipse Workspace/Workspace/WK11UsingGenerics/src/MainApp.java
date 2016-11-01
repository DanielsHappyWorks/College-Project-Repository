import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainApp
{

	public static void main(String[] args)
	{
		MainApp theApp = new MainApp();
		theApp.start();
	}

	private void start() {
		
		
	}
	public <E> void sortBy(ArrayList<E> list, Comparator c)
	{
		Collections.sort(list, c);
	}
	public <E> ArrayList<E> concat(ArrayList<E> alist,ArrayList<E> blist)
	{
		ArrayList<E> outList = new ArrayList<E>();
		
		for(E obj:alist)
		{
			outList.add(obj);
		}
		for(E obj:blist)
		{
			outList.add(obj);
		}
		
		return outList;
	}
}
