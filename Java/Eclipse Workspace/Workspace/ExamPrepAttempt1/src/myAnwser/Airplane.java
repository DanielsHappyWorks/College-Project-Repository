package myAnwser;
public class Airplane extends Vehicle{
	int maxRange, maxAltitude, maxAirspeed;

	public Airplane(String make, String model, double engineSize, int passengerNumber, int maxRange, int maxAltitude,
			int maxAirspeed) {
		super(make, model, engineSize, passengerNumber);
		this.maxRange = maxRange;
		this.maxAltitude = maxAltitude;
		this.maxAirspeed = maxAirspeed;
	}

	public int getMaxRange() {
		return maxRange;
	}

	public void setMaxRange(int maxRange) {
		this.maxRange = maxRange;
	}

	public int getMaxAltitude() {
		return maxAltitude;
	}

	public void setMaxAltitude(int maxAltitude) {
		this.maxAltitude = maxAltitude;
	}

	public int getMaxAirspeed() {
		return maxAirspeed;
	}

	public void setMaxAirspeed(int maxAirspeed) {
		this.maxAirspeed = maxAirspeed;
	}

	@Override
	public String toString() {
		return "Airplane [maxRange=" + maxRange + ", maxAltitude=" + maxAltitude + ", maxAirspeed=" + maxAirspeed
				+ ", make=" + make + ", model=" + model + ", engineSize=" + engineSize + ", passengerNumber="
				+ passengerNumber + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + maxAirspeed;
		result = prime * result + maxAltitude;
		result = prime * result + maxRange;
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
		if (maxAirspeed != other.maxAirspeed)
			return false;
		if (maxAltitude != other.maxAltitude)
			return false;
		if (maxRange != other.maxRange)
			return false;
		return true;
	}
	
}
