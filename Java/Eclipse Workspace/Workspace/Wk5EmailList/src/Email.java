import java.util.ArrayList;

public class Email //container, composite
{
	//instance methods
	private Person sender;
	private ArrayList<Person> toList;
	private String subject, body;
	
	public Email(Person sender, String
			subject, String body)
	{
		this.sender = sender;
		this.subject = subject;
		this.body = body;		
		//this.toList = new ArrayList<Person>();
	}
	
	public void addPersonTo(Person p)
	{
		if(this.toList == null)
			this.toList = new ArrayList<Person>();
		
		this.toList.add(p);
	}
	public void print()
	{
		System.out.print("From:\t\t");
		System.out.println(sender.getName());
		
		System.out.print("To:\t\t");
		for(Person p : this.toList)
			System.out.print(p.getEmail() + ";");
		
		System.out.print("\nSubject:\t");
		System.out.println(this.subject);		
		System.out.println(this.body);	
	}
	
	
}








