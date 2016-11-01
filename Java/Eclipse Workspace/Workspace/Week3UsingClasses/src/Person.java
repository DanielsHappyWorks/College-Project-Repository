public class Person 
{
	//instance variables
	private String name, address;
	private int age;
	
	//constructors - default  - notice we are overloading the constructor
	public Person(/*no parameters*/)
	{
		this.setName("default name");
		this.setAge(0);
		this.setAddress("default address");
	}
	public Person(String name, int age, String address)
	{
		this.setName(name);
		this.setAge(age);
		this.setAddress(address);
	}
	public Person(String name, String address)
	{
		this.setName(name);
		this.setAge(0);
		this.setAddress(address);
	}
	//instance methods - getters/setters
	public int getAge(){
		return this.age;
	}
	public void setAge(int age){
		if(age<0)
			this.age = 0;
		else
			this.age=age;
		
		//or use the ternary operator...
		//this.age = (age >= 0) ? age : 0;
	}
	
	public String getName(){
		return this.name;
	}
	public void setName(String name){
		if((name.length() > 0) && (name.length() <= 32))
		{
			this.name=name;
		}
		else
			this.name = "default address";
	}
	
	public String getAddress(){
		return this.name;
	}
	public void setAddress(String address){
		if((address.length() > 0) && (address.length() <= 32))
		{
			this.address=address;
		}
		else
			this.address = "default address";
	}
	
	//other instance methods
	public void print(){
		System.out.println("Name:\t\t" + this.name);
		System.out.println("Address:\t" + this.address);
		System.out.println("Age:\t\t" + this.age);
	}
	
	//notice we are over-riding the Object::toString
	public String toString(){
		String out = "Name: " + this.name + ", Age: "+ this.age + ", Address: " + this.address;
		return out;
	}
}
