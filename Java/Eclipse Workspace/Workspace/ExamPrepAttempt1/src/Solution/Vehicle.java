package Solution;

/**
 * A common parent class for cars and airplanes. This class contains all the common attributes for Car and Airplane
 * @author NMCG
 * @version 1.0
 */
public class Vehicle implements Comparable<Vehicle>
{
	private String make, model;
	private double engineSize;
	private int passengerSize;
	
	public Vehicle(String make, String model, double engineSize, int passengerSize) 
	{
		this.make = make;
		this.model = model;
		this.engineSize = engineSize;
		this.passengerSize = passengerSize;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getEngineSize() {
		return engineSize;
	}

	public void setEngineSize(double engineSize) {
		this.engineSize = engineSize;
	}

	public int getPassengerSize() {
		return passengerSize;
	}

	public void setPassengerSize(int passengerSize) {
		this.passengerSize = passengerSize;
	}

	@Override
	public int compareTo(Vehicle o) 
	{
		/*
		 * Notice that because we're comparing double values that we must use an if..else
		 * 
		 * The general rule is as follows:
		 * - byte, short, int, long - use a simple subtraction of the values
		 * - float, double - use an if...else like we see below
		 * - String - use a compareTo() or compareToIgnoreCase() - see VehicleMakeComparator()
		 */
		double diff = this.engineSize - o.getEngineSize();
		
		if(diff > 0)
			return 1;
		else if (diff < 0)
			return -1;
		else
			return 0;
	}
	
	

	@Override
	public String toString() {
		return "make=" + make 
				+ "\tmodel=" + model 
				+ "\tengineSize=" + engineSize 
				+ "\tpassengerSize=" + passengerSize;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(engineSize);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((make == null) ? 0 : make.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + passengerSize;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicle other = (Vehicle) obj;
		if (Double.doubleToLongBits(engineSize) != Double.doubleToLongBits(other.engineSize))
			return false;
		if (make == null) {
			if (other.make != null)
				return false;
		} else if (!make.equals(other.make))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (passengerSize != other.passengerSize)
			return false;
		return true;
	}
	
	
	
	
	
	
	
}
