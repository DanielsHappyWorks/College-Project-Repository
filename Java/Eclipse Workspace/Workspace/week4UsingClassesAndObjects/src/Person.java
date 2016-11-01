public class Person 
{
	//instance variables
	//notice we use the private access modifier to prevent any code outside this class from changing the values directly.
	private String name, address;
	private int age;
	
	/***************************************************************************************
							Instance Methods - Constructors									
	****************************************************************************************/
	//default
	public Person()
	{
		this.setName("default name");
		this.setAge(0);
		this.setAddress("default address");
	}
	
	//notice we are overloading the Person() constructor by writing multiple constructors 
	//each with a different method signature (i.e. different parameter types, number, or order)
	public Person(String name, int age,
			String address)
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
	
	/***************************************************************************************
						Instance Methods - Accessors & Modifiers									
	****************************************************************************************/
	//getters/setters
	public int getAge()
	{
		return this.age;
	}
	public void setAge(int age)
	{
		//notice how we can add validation on the age to prevent user input error
		if(age < 0)
			this.age = 0;
		else
			this.age = age;
		
		//or use the ternary operator...
		//this.age = (age >= 0) ? age : 0;
	}
	
	public String getName()
	{
		return this.name;
	}
	public void setName(String name)
	{
		//notice how we can add validation on the age to prevent user input error
		if(name.length() == 0)
			this.name = "default name";
		else
			this.name = name;
	}
	
	public String getAddress()
	{
		return this.address;
	}
	public void setAddress(String address)
	{
		//notice how we can add validation on the age to prevent user input error
		if((address.length() > 0)
			&& (address.length() <= 32))
		{
			this.address = address;
		}
		else
			this.address = "default address";
	}
	
	
	/***************************************************************************************
						Instance Methods - toString & print									
	 ****************************************************************************************/
	public void print()
	{
		System.out.println("Name:\t\t" + this.name);
		System.out.println("Age:\t\t" + this.age);
		System.out.println("Address:\t" + this.address);
	}
	
	//Notice we are over-riding the Object::toString() method. 
	//Try commenting out this method and see what happens when you call
	//System.out.prinln(p1) in MainApp::toStringDemo().
	public String toString()
	{
		String out = "Name: " + this.name
				+ ", Age: " + this.age
					+ ", Address: " + this.address;
		
		return out;
	}
	
}








