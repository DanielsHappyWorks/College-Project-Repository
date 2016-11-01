import java.util.ArrayList;

public class Player 
{
	// class variables - static & shared
	private static int playerCount;
	
	//instance variables - accessed using object instance - one value per object
	private String name;
	private int wins;
	private ArrayList<Card> cList;
	
	//instance methods
	public Player(String name)
	{
		this.setName(name);
		this.resetWins();
		
		this.cList = new ArrayList<Card>();
		
		playerCount++;
	}
	public static int getPlayerCount(){
		return playerCount;
	}
	public static void resetPlayerCount(){
		playerCount = 0;
	}
	public void addWin() 
	{
		this.wins++;	
	}
	private void resetWins() 
	{
		this.wins = 0;	
	}

	private void setName(String name) 
	{
		this.name = (name.length() > 0) ? name : "default"; 
	}
	
	public void addCard(Card c)
	{
		this.cList.add(c);
	}
	
	//print
	public void print()
	{
		for (Card c : cList)
		{
			System.out.println(c);
		}
	}
	//count value of cards
	public int getCardTotal()
	{
		int sum =0;
		for(Card c : cList)
		{
			sum += c.getValue();
		}
		return sum;
	}
}
