package Model;
import Utilities.appUtility;

public class Vehicle{
	private String make, licence;
	private byte colour;
	
	public Vehicle(String make, String licence, byte colour) {
		this.make = make;
		this.licence = licence;
		this.colour = colour;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getLicence() {
		return licence;
	}

	public void setLicence(String licence) {
		this.licence = licence;
	}

	public byte getColour() {
		return colour;
	}

	public void setColour(byte colour) {
		this.colour = colour;
	}

	@Override
	public String toString() {
		return "Vehicle [make=" + make + ", licence=" + licence + ", colour=" + appUtility.getColourFromIndex(colour)+ "]";
	}
}
