import java.io.Serializable;
public class Person implements Serializable
{
	private String name;
	
	//pay as you go or monthly
	private Contract contractType;
	
	public Person(String name, Contract contractType)
	{
		this.name = name;
		this.contractType = contractType;
	}
	
	public String toString()
	{
		return "Name: "+this.name +"Type: " + this.contractType;
	}
}
