public class Task 
{
	//class/static/shared variables
	private static int taskCount;
	
	//class methods
	public static int getCount()
	{
		return taskCount;
	}
	
	//instance variables
	private String description;
	private int date, month, year;
	private boolean isCompleted;
	
	//instance methods
	public Task(String description)
	{
		this.setDescription(description);
		this.setDate(0);
		this.setMonth(0);
		this.setYear(0);
		this.setIsCompleted(false);
		
		//make sure you increment the (shared) class variable
		taskCount++;
	}
	public Task(String description, int date, int month, int year)
	{
		this.setDescription(description);
		this.setDate(date);
		this.setMonth(month);
		this.setYear(year);
		this.setIsCompleted(false);
		
		//make sure you increment the (shared) class variable
		taskCount++;
	}
	
	public int getDate()
	{
		return this.date;
	}
	public int getMonth()
	{
		return this.month;
	}
	public int getYear()
	{
		return this.year;
	}
	public String getDescription()
	{
		return this.description;
	}
	public boolean isCompleted()
	{
		return this.isCompleted;
	}
	public String toString()
	{
		return "Desc: " + this.description
			+ "\tDue: " + getDateAsString()
					+ "\tCompleted: " + this.isCompleted;
	}
	
	private String getDateAsString()
	{
		if((this.date == 0) || (this.month == 0) || (this.year == 0))
			return "No date set";
		else
			return this.date + "/" + this.month + "/" + this.year;
	}
	
	public void setMonth(int month) 
	{
		/*if you prefer then use...*/
		/*
		if(month >= 0)
			this.month = month;
		else
			this.month = 0;
		*/
		/*
		 * Ternary
		 * General form is
		 *     LHS = (boolean expression) ? <Tvalue> : <Fvalue>;
		 *     
		 *     boolean i.e. true or false
		 *     expression i.e. something which evaluates to a value
		 */
		
		this.month = (month >= 0) ? month : 0;
	}
	public void setIsCompleted(boolean isCompleted) 
	{
		this.isCompleted = isCompleted;
	}
	public void setYear(int year) 
	{
		this.year = (year >= 0) ? year : 0;			
	}
	public void setDate(int date) 
	{
		this.date = (date >= 0) ? date : 0;		
	}
	public void setDescription(String description) 
	{
		this.description 
		= (description.length() != 0) ? description : "default";
	}
}











