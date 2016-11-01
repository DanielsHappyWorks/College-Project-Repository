import java.util.ArrayList;

public class TaskList
{
	//instance variables
	private String name;
	private ArrayList<Task> list;

	public TaskList(String name)
	{
		//add validation setters here normally...		
		this.name = name;
		this.list = new ArrayList<Task>();
	}
	
	//add, remove, print, searchBy, size, reset
	public ArrayList<Task> searchByDescription(
							String desc)
	{
		ArrayList<Task> sList = new ArrayList<Task>();
		
		for(Task t : this.list)
		{
			if(t.getDescription().equals(desc))
			{
				sList.add(t);
			}
		}
		
		return sList;
	}
	
	//a demo method to show how we pass and return array list objects
		public ArrayList<Task> getAllTasksOnDate(int date)
		{
			//create a list to store the address of the tasks that happen on the date specified
			ArrayList<Task> sList = new ArrayList<Task>();
			
			for(Task t : this.list)
			{
				if(t.getDate() == date) //is this the date I'm looking for?
					sList.add(t); //yes, so add the address of the task to the list
			}
			
			//return the address of the new list with all the found tasks
			return sList;
		}
		
		public void removeAllTasksBefore(int date)
		{
			Task t = null;
			for(int i = 0; i < this.list.size(); i++)  //2
			{
				t = this.list.get(i);
				if(t.getDate() < date)
				{
					this.list.remove(t);
					i--;
				}
			}
		}
	
	
	public void reset()
	{
		this.list.clear();
	}
	public int size()
	{
		return this.list.size();
	}
	
	public void add(Task t)
	{
		this.list.add(t);
	}
	
	public void print()
	{
		System.out.println("\n***** " + this.name + " task list *****\n");
		for(Task t : list)
			System.out.println(t);
	}
	
	
	
	
}











