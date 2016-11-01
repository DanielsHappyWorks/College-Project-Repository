import java.util.ArrayList;

public class MainApp {
	public static void main(String[] args)
	{
		MainApp theApp = new MainApp();
		theApp.start();
	}
	private void start()
	{
		demoSerializationUtil();
	}
	private void demoSerializationUtil()
	{
		boolean exists = SerializationUtility.exists("", "myNme.txt");
		
		System.out.println("Exists? " + exists);
		
		String myName = "John Smith";
		SerializationUtility.save("", "name.txt", myName);
		
		String loadedName = (String) SerializationUtility.load("", "name.txt");
		System.out.println(loadedName);
		System.out.println();
		
		ArrayList<String> sList = new ArrayList<String>();
		sList.add("lol");
		sList.add("gg");
		sList.add("wp");
		sList.add("I win");
		
		SerializationUtility.save("", "name.txt", sList);
		
		@SuppressWarnings("unchecked")
		ArrayList<String> loadList = (ArrayList<String>) SerializationUtility.load("", "name.txt");
		System.out.println(loadList);
		System.out.println();
		
		Person p = new Person("peter", Contract.PayAsYouGo);
		
		SerializationUtility.save("", "name.txt", p);
		Person loaderPerson = (Person) SerializationUtility.load("", "name.txt");
		System.out.println(loaderPerson);
	}
	private void demoEnums()
	{
		Person p1 = new Person("Joan Smith",Contract.Monthly);
		System.out.println(p1);
		
		System.out.println("Ordinal: "+Contract.Monthly.ordinal());
		System.out.println("Free mins: "+Contract.Monthly.getFreeMins());
	}
}
