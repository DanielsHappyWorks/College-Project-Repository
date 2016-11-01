
public class MainApp 
	{
	public static void main(String[] args) 
	{
	MainApp theApp = new MainApp();
	theApp.start();
	}

	private void start() 
	{
		Primitive p1 = new Primitive (5,50);
		System.out.println(p1);
		
		Circle c1 = new Circle (10,20,12);
		System.out.println(c1);
		
		//Polymorphism
		Primitive p2 = new Square(20,40,50,100);
		System.out.println(p2);
		Square s1 = (Square)p2;
		System.out.println(p2.getArea());
	}
	public void printArea(Primitive p)
	{
		System.out.println("Area: " + p.getArea());
	}
}
