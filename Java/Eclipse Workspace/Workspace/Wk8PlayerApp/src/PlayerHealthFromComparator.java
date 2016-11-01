import java.util.Comparator;

public class PlayerHealthFromComparator implements Comparator<Player> {

	private int health;
	private SortType sortType;
	
	public PlayerHealthFromComparator(SortType sortType, int health)
	{
		this.sortType = sortType;
		this.health = health;
	}
	
	public PlayerHealthFromComparator(SortType sortType, Player p)
	{
		this(sortType, p.getHealth());
	}
	@Override
	public int compare(Player p1, Player p2) {
		double healthToP0 = this.health-p1.getHealth();
		double healthToP1 = this.health-p2.getHealth();
		
		int direction =1;
		
		if(sortType == SortType.Ascending)
		{
			direction = -1;
		}
		
		return (int) (direction * (healthToP0-healthToP1));
	}
}
