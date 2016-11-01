
public class Task {
	//class variables
	private static int totalTasks;
	//class methods
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
	}
	public Task(String description, int date , int month, int year)
	{
		this.setDescription(description);
		this.setDate(date);
		this.setMonth(month);
		this.setYear(year);
		this.setIsCompleted(false);
	}
	public int getDate(){
		return this.date;
	}
	public int getMonth(){
		return this.month;
	}
	public int getYear(){
		return this.year;
	}
	public String getDescription(){
		return this.description;
	}
	public boolean getIsCompleted(){
		return this.isCompleted;
	}
	public void setIsCompleted(boolean isCompleted) {
		this.isCompleted=isCompleted;
	}
	public void setYear(int year) {
		this. year= ( year >= 0 ) ? year : 0;
	}
	public void setMonth(int month) {
		this.month=(month >= 0 ) ? month : 0;
	}
	public void setDate(int date) {
		this.date= (date >= 0 ) ? date : 0;
	}
	public void setDescription(String description) {
		this.description=(description.length() != 0 ) ? description : "default";
	}
	public String toString(){
		return "Description: " +this.description+ " Due: " +this.date+ "/" +this.month+"/"+this.year+" Completed: "+this.isCompleted;
	}
}
