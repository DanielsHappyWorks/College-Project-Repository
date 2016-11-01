package Solution;


/**
 * USe this class to query a Vehicle for a value. Basically it allows us to define how a Vehicle is "measured"
 * @author NMCG
 * @version 1.0
 *
 */
public class VehiclePassengerSizeMeasurer implements IMeasurer 
{
	@Override
	public double getValue(Object o) 
	{
		Vehicle v = (Vehicle)o;
		return v.getPassengerSize();
	}

}
