package Solution;
/**
 * A Car class which extends the Vehicle class to add extra "car-specific" atttributes
 * @author NMCG
 * @version 1.0
 */
public class Car extends Vehicle 
{
	private int doorCount;
	
	public Car(String make, String model, 
			double engineSize, int passengerSize,
			int doorCount) 
	{
		//when we make an Car we must also make a Vehicle object and pass the required values to the Vehicle constructor using super()
		super(make, model, engineSize, passengerSize);		
		this.doorCount = doorCount;		
	}

	public int getDoorCount() {
		return doorCount;
	}

	public void setDoorCount(int doorCount) {
		this.doorCount = doorCount;
	}


	@Override
	public String toString() 
	{
		String strOut = "Car:\t\t";
		
		//notice how we user super. to call the Vehicle::toString() method
		strOut += super.toString();
		
		strOut += "\tdoorCount=" + doorCount;
		
		return strOut;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + doorCount;
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
		Car other = (Car) obj;
		if (doorCount != other.doorCount)
			return false;
		return true;
	}

}
