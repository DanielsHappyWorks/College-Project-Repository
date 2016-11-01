import java.util.ArrayList;

public class MainApp 
{
	public static void main(String[] args) 
	{
		MainApp theApp = new MainApp();
		theApp.start();
	}


	
	private void start() 
	{
		PlayerList teamRed = new PlayerList("red team");
		
		teamRed.add(new Player("beatrix", 75, 20, 1, -40));	
		teamRed.add(new Player("andrea", 90, 10, 1, 20));
		teamRed.add(new Player("andrea", 100, 50, 1, 2000));
		teamRed.add(new Player("cian", 50, -40, 1, 30));	
		teamRed.add(new Player("me", 100, -30, 1, 30));
		teamRed.add(new Player("andrea", 100, 50, 1, 2000));
		
		System.out.println("Size: " + teamRed.size());
		
		teamRed.print();
		/*
		Player searchPlayer = teamRed.findBy("Cian");
		System.out.println("Search:\t" + searchPlayer);	
		
		boolean wasRemoved = teamRed.removeBy("AnDrEa");
		System.out.println("Andrea removed? " + wasRemoved);
		
		teamRed.print();
		*/
		int removeCount = teamRed.removeAll("ANDreA");
		System.out.println("Remove count: " + removeCount);
		
		System.out.println("\nPrint...");
		teamRed.print();
		
		System.out.println("\nSort...");
		ArrayList<Player> sortedList
		= teamRed.sortBy(new PlayerNameComparator());
		
		for(Player p : sortedList)
			System.out.println(p);
		
	}
}







