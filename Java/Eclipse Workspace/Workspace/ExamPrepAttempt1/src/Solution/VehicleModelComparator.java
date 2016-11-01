package Solution;
import java.util.Comparator;


/**
 * Allows us to compare two vehicles by their model.
 * Also uses a SortType enum to allow us to change sort order.
 * @author NMCG
 * @version 1.0
 *
 */
public class VehicleModelComparator implements Comparator<Vehicle> 
{
	private SortType sortType;
	
	/*Compare the use of an enum to the approach used in the VehicleMakeComparator
	* where we pass an interger to specify direction. If we allow the user to enter
	* an integer then 
	* (a) not only is it hard to know which number represents the sort order(e.g. does 1 mean A-Z or Z-A?),
	* but 
	* (b), its also means the user can enter ANY integer they want - which wont break the program but it may become perilous.
	* 
	* An enum sorts this problem by restricting the user's input options to two - Ascending and Descending
	*/
	
	public VehicleModelComparator(SortType sortType)
	{
		this.sortType = sortType;
	}
	
	
	public int compare(Vehicle v1, Vehicle v2) 
	{
		//call SortType::getDirection() to see what value the sort type is set to i.e. 1 or -1
		int direction = sortType.getDirection();
		
		return direction * v1.getModel().compareToIgnoreCase(v2.getModel());
	}

}
