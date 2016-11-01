package Solution;
/**
 * An Airplane class which extends the Vehicle class to add extra "airplane-specific" atttributes
 * @author NMCG
 * @version 1.0
 */
public class Airplane extends Vehicle 
{
	private double maxRange, maxAltitude;
	
	public Airplane(String make, String model, 
			double engineSize, int passengerSize,
			double maxRange, double maxAltitude) 
	{
		//when we make an Airplane we must also make a Vehicle object and pass the required values to the Vehicle constructor using super()
		super(make, model, engineSize, passengerSize);
		this.maxRange = maxRange;
		this.maxAltitude = maxAltitude;
	}

	public double getMaxRange() {
		return maxRange;
	}

	public void setMaxRange(double maxRange) {
		this.maxRange = maxRange;
	}

	@Override
	public String toString() 
	{	
		String strOut = "Airplane\t";
		
		//notice how we user super. to call the Vehicle::toString() method
		strOut += super.toString();
		
		strOut += "\tmaxRange=" + maxRange + "\tmaxAltitude=" + maxAltitude;
		
		return strOut;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(maxAltitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(maxRange);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Airplane other = (Airplane) obj;
		if (Double.doubleToLongBits(maxAltitude) != Double.doubleToLongBits(other.maxAltitude))
			return false;
		if (Double.doubleToLongBits(maxRange) != Double.doubleToLongBits(other.maxRange))
			return false;
		return true;
	}

	
	
	
	
			

}
