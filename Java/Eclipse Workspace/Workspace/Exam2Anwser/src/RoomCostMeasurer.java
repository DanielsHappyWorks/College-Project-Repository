
public class RoomCostMeasurer implements IMeasurer
{
	public double getValue(Object obj) 
	{	
		Room r = (Room) obj;	
		return r.getCostPerNight();
	}

}
