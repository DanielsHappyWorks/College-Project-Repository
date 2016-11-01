public class Person 
{
	//instance methods
	private String name, email, tel;
	
	public Person(String name, String email)
	{
		this.name = name;
		this.email = email;
	}
	public Person(String name, 
			String email, String tel)
	{
		this.name = name;
		this.email = email;
		this.tel = tel;
	}
	public String getName() {return this.name;}
	public String getEmail() {return this.email;}
	public String getTel() {return this.tel;}
	public String toString()
	{
		return this.name 
				+ " - " + this.email
					+ " - " + this.tel;
	}
}
