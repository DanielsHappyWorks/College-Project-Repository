package Solution;
import java.util.Comparator;

/**
 * Used in MainApp with Collections.sort() to specify how to sort an ArrayList of Vehicles
 * @author NMCG
 * @version 1.0
 */
public class VehicleMakeComparator implements Comparator<Vehicle>	
{
	private int direction; //used to reverse the sort i.e. A-Z or Z-A
	public VehicleMakeComparator(int direction)
	{
		this.direction = direction;
	}	

	@Override
	public int compare(Vehicle v1, Vehicle v2) 
	{
		return direction * v1.getMake().compareToIgnoreCase(
				v2.getMake());
	}

}
