package myAnwser;
public class Vehicle {
	String make, model;
	int passengerNumber;
	double engineSize;
	
	public Vehicle(String make, String model, double engineSize, int passengerNumber) {
		super();
		this.make = make;
		this.model = model;
		this.engineSize = engineSize;
		this.passengerNumber = passengerNumber;
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
	public void setEngineSize(int engineSize) {
		this.engineSize = engineSize;
	}
	public int getPassengerNumber() {
		return passengerNumber;
	}
	public void setPassengerNumber(int passengerNumber) {
		this.passengerNumber = passengerNumber;
	}
	@Override
	public String toString() {
		return "Vehicle [make=" + make + ", model=" + model + ", engineSize=" + engineSize + ", passengerNumber="
				+ passengerNumber + "]";
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
		result = prime * result + passengerNumber;
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
		if (passengerNumber != other.passengerNumber)
			return false;
		return true;
	}
}
