
public class SimCard{
	private String provider, simNumber;
 	private int pinNumber;
 
 	public SimCard(String provider, int pinNumber, String simNumber) {
		super();
		this.provider = provider;
		this.pinNumber = pinNumber;
		this.simNumber = simNumber;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public String getSimNumber() {
		return simNumber;
	}

	public void setSimNumber(String simNumber) {
		this.simNumber = simNumber;
	}

	public int getPinNumber() {
		return pinNumber;
	}

	public void setPinNumber(int pinNumber) {
		this.pinNumber = pinNumber;
	}

	public String toString() {
		return "SimCard [provider=" + provider + ", simNumber=" + simNumber + ", pinNumber=" + pinNumber + "]";
	}
	
	public boolean equals(Object obj)
	{
		if (obj == null)
			return false;
		if(obj instanceof SimCard)
		{
			SimCard sim = (SimCard)obj;
			return this.getPinNumber() == sim.getPinNumber();
		}
		return false;
		
	}

	public double getValue() {
		return this.pinNumber;
	}
}
