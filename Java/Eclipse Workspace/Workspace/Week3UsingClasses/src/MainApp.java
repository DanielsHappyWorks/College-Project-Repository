public class MainApp {
	public static void main(String[] args)
	{
		MainApp theApp = new MainApp();
		theApp.start();
	}
	
	public void start()
	{
		
		Person p1 = new Person();
		p1.setName("maeve");
		p1.setAge(30);
		p1.setAddress("Dundalk");
		
		Person p2 = new Person();
		
		Person p3 = new Person("ciara" , 22, "dublin");
		p3.setAge(p1.getAge());
		//System.out.println(p3.getAge());
		
		Person p4 = new Person("" , -22, "");		
		p4.print();
		
		String lol = p4.toString();
		System.out.println(lol);
		System.out.println(p4);
	}
}
