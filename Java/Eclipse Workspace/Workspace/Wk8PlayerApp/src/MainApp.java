import java.util.ArrayList;
import java.util.Collections;

public class MainApp {
	public static void main(String[] args)
	{
		MainApp theApp = new MainApp();
		theApp.start();
	}
	
	public void start()
	{
		ArrayList<Player> pList = new ArrayList<Player>();
		
		Player p = null;
		p = new Player("beatrix", 75);
		p.moveTo(20, 1, -40);
		pList.add(p);
		
		pList.add(new Player("andrea", 90, 10, 1, 20));
		pList.add(new Player("cian", 50, -40, 1, 30));
		
		p = new Player("me", 100, -30, 1, 30);
		
		Collections.sort(pList, new PlayerHealthFromComparator(SortType.Ascending,p));
		
		for(Player player : pList)
		{
			System.out.println(player);
		}
	}
}
