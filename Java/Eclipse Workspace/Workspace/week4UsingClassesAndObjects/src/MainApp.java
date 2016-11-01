import java.util.ArrayList;

/** Demonstrate how to...
 * - add validation to a class
 * - over-ride the Object::toString() method
 * - Store, access and modify object instances in an array
 * - Store, access and modify object instances in an arraylist
 * - Pass an array or arraylist of user-defined objects (i.e. Person) into a method)
 * 
 * @author Niall McGuiness
 * @version 1.0
 */
public class MainApp 
{
	public static void main(String[] args) 
	{
		MainApp theApp = new MainApp();
		theApp.start();
	}
	public void start()
	{
		System.out.println("\n************************ inputValidationDemo ************************");
		inputValidationDemo();
		
		System.out.println("\n************************ toStringDemo ************************");
		toStringDemo();
		
		System.out.println("\n************************ simpleArrayDemo ************************");
		simpleArrayDemo();
		
		System.out.println("\n************************ populateArrayDemo ************************");
		populateArrayDemo();
		
		System.out.println("\n************************ simpleArrayListDemo ************************");
		simpleArrayListDemo();
		
		//A populateArrayListDemo has not been included. It should be obvious how to write that
		//code by comparing how simpleArrayDemo() and simpleArrayListDemo() have been written.
	
	
		Person[] empArray = getPersonArray(20, "Apple Employee", 25, "Cupertino, CA, USA");
		print(empArray);
		
		ArrayList<Person>  emplist = this.getPersonArrayList(5, "John", 30, "Dublin");
		System.out.println(emplist.toString());
	}
	

	//Demonstrates how input validation prevents the user from entering erroneous data
	public void inputValidationDemo()
	{		
		//calling the default constructor
		Person p1 = new Person();
		System.out.println(p1);
		
		System.out.println(); //space
		
		//setting variable values using the setters
		Person p2 = new Person();
		p2.setName("maeve");
		
		//notice that we are trying to set an invalid age
		p2.setAge(-30);
		p2.setAddress("main st.");
		
		//using a print method to show object state
		p2.print();
		
		System.out.println(); //space	
	
		//using the data from one Person object to set the data in another object
		Person p3 = new Person("ciara", 22, "dublin");
		p3.setAge(p1.getAge());
		System.out.println(p3.getAge());	
		
		System.out.println(); //space
		
		//using input validation on the setters to reset erroneous input parameters
		Person p4 = new Person("", -90, "");
		p4.print();
		
		System.out.println(); //space
	}
	
	//Demonstrates the use of the toString() method 
	public void toStringDemo()
	{
		Person p1 = new Person("dave", 32, "galway");
		//calling toString()
		String str = p1.toString();
		System.out.println(str);
				
		//notice that an object inside a println() or print() will automatically have its toString() method called
		System.out.println(p1);
		
		//another way to call the toString without having to make the str variable
		System.out.print(p1.toString());

	}
	
	//Demonstrates how we can create an array of Person objects
	public void simpleArrayDemo() 
	{	
		Person[] pArray = new Person[4];
		
		//how do we set elements in an array of Person objects?
		pArray[0] = new Person("ann", 20, "cork");
		pArray[1] = new Person("barry", 48, "dublin");
		pArray[2] = new Person("ciara", 27, "drogheda");
		pArray[3] = new Person();
		print(pArray);
		
		System.out.println(); //space
		
		//how can we access a Person object?
		Person p = pArray[0];
		p.setName("Ann's new name");
		System.out.println(pArray[0]);
	}
	
	//Demonstrates how we can create an arraylist of Person objects
	public void simpleArrayListDemo() 
	{
		ArrayList<Person> list = new ArrayList<Person>();
		
		//how do we add to an arraylist of Person objects?
		list.add(new Person("steve", 45, "london"));
		list.add(new Person("joe", 17, "paris"));
		print(list);
		
		System.out.println(); //space
		
		//how can we access and modify a Person object in a list?
		Person p = list.get(1);
		p.setAddress("Joe's new address");
		System.out.println(p);
	}
	
	//Demonstrates how we can write a method - populateAge() - that takes an array of Person objects
	public void populateArrayDemo()
	{
		Person[] anotherArray = new Person[5];
		populateAge(anotherArray, 20);		
		print(anotherArray);
	}
	
	//Fills an array with Person objects. We can also specify the default age for all objects
	public void populateAge(Person[] array, int defaultAge)
	{
		Person p = null;
	
		for(int i = 0; i < array.length; i++)
		{
			p = new Person();
			p.setAge(defaultAge);
			array[i] = p;
		}
	}
	
	//Prints an array of Person objects. This method also demonstrates how to pass an array to a method.
	public void print(Person[] array)
	{
		for(int i = 0; i < array.length; i++)
			System.out.println(array[i]);
	}
	
	//Prints an array list of Person objects. This method also demonstrates how to pass an array list to a method.
	public void print(ArrayList<Person> list)
	{
		//notice we don't declare p inside the array - this would waste CPU cycles
		Person p = null;
		
		for(int i = 0; i < list.size(); i++)
		{
			p = list.get(i);
			System.out.println(p);
		}
	}
	
	
	public Person[] getPersonArray(int size, String name, int age, String address){
		Person[] array = new Person[size];
		
		for(int i = 0; i < array.length; i++){
			array[i] = new Person(name, i, address);
		}
		return array;
	}
	public ArrayList<Person> getPersonArrayList(int size, String name, int age, String address){
		ArrayList<Person> list = new ArrayList<Person>(size);
		for(int i = 0; i < size; i++){
			list.add(new Person(name, i, address));
		}
		return list;
	}
}





















