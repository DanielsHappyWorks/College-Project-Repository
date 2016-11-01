import java.util.Calendar;

public class Contact
{
	private String name;
	private Calendar dateOfBirth;
	
	public Contact(String name)
	{
		this.name = name;
		this.dateOfBirth = Calendar.getInstance();
	}
	
	public Contact(String name, int date, int month, int year)
	{
		this.name = name;
		this.dateOfBirth = Calendar.getInstance();
		this.dateOfBirth.set(year, month-1, date, 9, 0, 0);
	}
	
	public String getName(){return this.name;}
	public Calendar getDateOfBirth(){return this.dateOfBirth;}
	
	public String toString()
	{
		return "Name: "+this.name+"\nDOB: "+DateUtility.getCalenderAsString(this.dateOfBirth,DateUtility.DateFormat);
	}
}
