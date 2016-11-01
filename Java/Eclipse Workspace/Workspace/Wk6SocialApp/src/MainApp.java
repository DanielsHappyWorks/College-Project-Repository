import java.util.ArrayList;

public class MainApp {
	public static void main(String[] args)
	{
		MainApp theApp = new MainApp();
		theApp.start();
	}
	
	public void start()
	{
		Contact c1 = new Contact("Anne Smith",22,10,1995);
		System.out.println(c1);
		
		ArrayList<Contact> cList = new ArrayList<Contact>();
		cList.add(c1);
		cList.add(new VirtualContact("lol@php.com","dan"));
		System.out.println(cList.get(1));
	}
}