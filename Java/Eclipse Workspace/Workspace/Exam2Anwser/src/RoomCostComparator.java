import java.util.Comparator;

public class RoomCostComparator 
					implements Comparator<Room> 
{

	public int compare(Room r1, Room r2) 
	{
		float costDifference = r1.getCostPerNight()
					- r2.getCostPerNight();
		
		if(costDifference < 0)
			return -1;
		else if(costDifference > 0)
			return 1;
		else
			return 0;
	}


}
