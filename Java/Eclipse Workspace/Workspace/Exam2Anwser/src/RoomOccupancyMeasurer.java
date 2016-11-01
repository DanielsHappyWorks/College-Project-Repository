
public class RoomOccupancyMeasurer 
	implements IMeasurer
{
	public double getValue(Object obj) 
	{
		Room r = (Room) obj;
		return r.getMaxOccupancy();
	}
}
