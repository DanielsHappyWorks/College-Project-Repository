import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PlayerList //storage container i.e. list of...
{
	private String name;
	private ArrayList<Player> list;
	
	public PlayerList(String name)
	{
		this(name, 10);
	}
	public PlayerList(String name, int initialSize)
	{
		this.setName(name);
		this.list = new ArrayList<Player>(initialSize);
	}
	
	//add, remove, searchBy, sortBy, print, clear, size
	public void add(Player p)
	{
		this.list.add(p); //allows duplicates!
	}
	//returns the index of the player with playerName
	public int findIndexBy(String playerName)
	{
		Player p = null;		
		for(int i = 0; i < this.list.size(); i++)
		{
			p = this.list.get(i);			
			if(p.getName().equalsIgnoreCase(playerName))
			{
				return i;
			}
		}				
		return -1;
	}
	//returns the address of the player with playerName
	public Player findBy(String playerName)
	{
		int index = findIndexBy(playerName);
		if(index != -1)
			return this.list.get(index);
		else
			return null;
	}
	public boolean removeBy(String playerName)
	{
		int index = findIndexBy(playerName);
		if(index != -1)
		{
			this.list.remove(index);
			return true;
		}
		else
			return false;
	}	
	public int removeAll(String playerName)
	{
		int count = 0;
		Player p = null;
		
		for(int i = 0; i < this.list.size(); i++)
		{
			p = this.list.get(i);
			if(p.getName().equalsIgnoreCase(playerName))
			{
				this.list.remove(p);
				count++;
				i--;   //bug?
			}
		}
		return count;
	}
	public ArrayList<Player> findAll(String playerName)
	{
		ArrayList<Player> findList = new ArrayList<Player>();
		for(Player p : this.list)
		{
			if(p.getName().equalsIgnoreCase(playerName))
				findList.add(p);
		}
		if(findList.size() == 0)
			return null;
		else
			return findList;
	}

	public ArrayList<Player> sortBy(Comparator<Player> comp)
	{		
		Collections.sort(this.list, comp);
		return this.list;
	}
	
	public static ArrayList<Player> sortBy(
			ArrayList<Player> list, Comparator<Player> comp)
	{
		Collections.sort(list, comp);
		return list;
	}
	
	public void print()
	{
		for(Player p : this.list)
			System.out.println(p);
	}
	public int size()
	{
		return this.list.size();
	}
	public void clear()
	{
		this.list.clear();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 public boolean removeBy(String playerName)
	{
		for(Player p : this.list)
		{
			if(p.getName().equalsIgnoreCase(playerName))
			{
				this.list.remove(p);
				return true;
			}
		}		
		return false;
	}
	public Player searchBy(String playerName)
	{
		for(Player p : this.list)
		{
			if(p.getName().equalsIgnoreCase(playerName))
			{
				return p;
			}
		}		
		return null;
	}
	 */
	
	
	

}









