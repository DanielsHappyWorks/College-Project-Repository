
public class PlayerDistanceFromFilter 
					implements IFilter<Player>
{
	private DistanceCriteriaType distanceType;
	private int x, y, z;
	private double distanceLimit;
	
	public PlayerDistanceFromFilter(
			DistanceCriteriaType distanceType,
			int x, int y, int z, double distanceLimit)
	{
		this.distanceType = distanceType;
		this.x = x; this.y = y; this.z = z;
		this.distanceLimit = distanceLimit;
	}
	
	@Override
	public boolean matches(Player other) 
	{
		double distanceOtherFromTarget
			 = other.getDistanceTo(this.x, this.y, this.z);
		
		if(this.distanceType == DistanceCriteriaType.LessThan)
			return (distanceOtherFromTarget < distanceLimit);
		else if(this.distanceType == DistanceCriteriaType.LessThanEqual)
			return (distanceOtherFromTarget <= distanceLimit);
		else if(this.distanceType == DistanceCriteriaType.GreaterThan)
			return (distanceOtherFromTarget > distanceLimit);
		else if(this.distanceType == DistanceCriteriaType.GreaterThanEqual)
			return (distanceOtherFromTarget >= distanceLimit);
		else 
			return (Double.doubleToLongBits(
					distanceOtherFromTarget)
						== Double.doubleToLongBits(
								distanceLimit));	
	}
}





