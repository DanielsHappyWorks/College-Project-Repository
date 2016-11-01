import java.util.Comparator;

public class PlayerNameComparator 
			implements Comparator<Player>
{
	public int compare(Player o1, Player o2) 
	{
		return -1 * o1.getName().compareToIgnoreCase(
							o2.getName());
	}
}
