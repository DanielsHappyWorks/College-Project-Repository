package myAnwser;
public class Car  extends Vehicle{
	int numberOfDoors;

	public Car(String make, String model, double engineSize, int passengerNumber, int numberOfDoors) {
		super(make, model, engineSize, passengerNumber);
		this.numberOfDoors = numberOfDoors;
	}

	public int getNumberOfDoors() {
		return numberOfDoors;
	}

	public void setNumberOfDoors(int numberOfDoors) {
		this.numberOfDoors = numberOfDoors;
	}

	@Override
	public String toString() {
		return "Car [numberOfDoors=" + numberOfDoors + ", make=" + make + ", model=" + model + ", engineSize="
				+ engineSize + ", passengerNumber=" + passengerNumber + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + numberOfDoors;
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
		if (numberOfDoors != other.numberOfDoors)
			return false;
		return true;
	}
 	
}
