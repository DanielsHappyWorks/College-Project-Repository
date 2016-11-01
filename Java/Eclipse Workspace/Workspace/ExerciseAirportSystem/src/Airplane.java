
public class Airplane {
	private String callSign, companyName;
	private int soulsOnBoard;
	private double fuleCapacity, fuleConsumption; //liters liters/min capacity=remaining
	
	public double getTimeToNoFuel(float safetyRatio){
		return safetyRatio * fuleCapacity/fuleConsumption;
	}
	
	public Airplane(String callSign, String companyName, int soulsOnBoard, double fuleCapacity,
			double fuleConsumption) {
		this.callSign = callSign;
		this.companyName = companyName;
		this.soulsOnBoard = soulsOnBoard;
		this.fuleCapacity = fuleCapacity;
		this.fuleConsumption = fuleConsumption;
	}

	public String getCallSign() {
		return callSign;
	}

	public void setCallSign(String callSign) {
		this.callSign = callSign;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public int getSoulsOnBoard() {
		return soulsOnBoard;
	}

	public void setSoulsOnBoard(int soulsOnBoard) {
		this.soulsOnBoard = soulsOnBoard;
	}

	public double getFuleCapacity() {
		return fuleCapacity;
	}

	public void setFuleCapacity(double fuleCapacity) {
		this.fuleCapacity = fuleCapacity;
	}

	public double getFuleConsumption() {
		return fuleConsumption;
	}

	public void setFuleConsumption(double fuleConsumption) {
		this.fuleConsumption = fuleConsumption;
	}

	@Override
	public String toString() {
		return "Airplane [callSign=" + callSign + ", companyName=" + companyName + ", soulsOnBoard=" + soulsOnBoard
				+ ", fuleCapacity=" + fuleCapacity + ", fuleConsumption=" + fuleConsumption + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((callSign == null) ? 0 : callSign.hashCode());
		result = prime * result + ((companyName == null) ? 0 : companyName.hashCode());
		long temp;
		temp = Double.doubleToLongBits(fuleCapacity);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(fuleConsumption);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + soulsOnBoard;
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
		Airplane other = (Airplane) obj;
		if (callSign == null) {
			if (other.callSign != null)
				return false;
		} else if (!callSign.equals(other.callSign))
			return false;
		if (companyName == null) {
			if (other.companyName != null)
				return false;
		} else if (!companyName.equals(other.companyName))
			return false;
		if (Double.doubleToLongBits(fuleCapacity) != Double.doubleToLongBits(other.fuleCapacity))
			return false;
		if (Double.doubleToLongBits(fuleConsumption) != Double.doubleToLongBits(other.fuleConsumption))
			return false;
		if (soulsOnBoard != other.soulsOnBoard)
			return false;
		return true;
	}
	
	
}
