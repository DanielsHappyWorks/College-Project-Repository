import java.util.ArrayList;
import java.util.Collections;


public class MainApp 
{
	public static void main(String[] args) 
	{
		MainApp theApp = new MainApp();
		theApp.start();
	}
	
	public void start()
	{
		//testCard();
		//testShuffle();
		//testPlayer();
		playGame();
	}

	private void playGame() {
		//make some players
		/*ArrayList<Player> pList = new ArrayList<Player>();
		pList.add(new Player("Player 1"));
		pList.add(new Player("Player 2"));*/
		Player p1 = new Player("Player 1");
		Player p2 = new Player("Player 2");
		
		//make a deck
		ArrayList<Card> cList = getCardList();
		Collections.shuffle(cList);
		
		//deal a card to each player - Twice!
		deal(cList, p1, 1);
		p1.print();
		p1.getCardTotal();

	}
	public void deal(ArrayList<Card> cList, Player p, int number){
		if(cList.size() < number)
			return;
		
		Card c = null;
		
		for(int i =0; i > number; i++){
			c = cList.get(0);  //remove?
			p.addCard(c);
			cList.remove(i);
		}
		
	}

	private void testPlayer() {
		Player p1 = new Player("stephanie");
		Player p2 = new Player("ben");
		
		System.out.println("Count: " + Player.getPlayerCount());
	}

	private void testCard() 
	{
		Card c = null;
		
		for(int i = 1; i <= 52; i++)
		{
			c = new Card(i);
			System.out.println(c);
		}	
	}
	
	private void testShuffle() 
	{
		ArrayList<Card> cList = getCardList();
		Collections.shuffle(cList);
		print(cList);
	}
	
	public ArrayList<Card> getCardList()
	{
		ArrayList<Card> cList = new ArrayList<Card>();
		
		for(int i = 0; i < 52; i++)
		{ 
			cList.add(new Card(i));
		}	
		return cList;
	}
	
	public void print(ArrayList<Card> list)// Card[] cArray
	{
		for(Card c : list)
			System.out.println(c);
	}
}
