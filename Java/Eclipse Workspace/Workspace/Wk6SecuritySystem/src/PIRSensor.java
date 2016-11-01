
public class PIRSensor extends Sensor{
	private int maxTemp,minTemp,threshold;
	
	PIRSensor(int id, String location, String ipAddress, int maxTemp, int minTemp, int threshold)
	{	
		super(id, location,ipAddress);
		this.minTemp = minTemp;
		this.maxTemp = maxTemp;
		this.threshold = threshold;
		
	}
	
	public int getMaxTemp()
	{
		return this.maxTemp;
	}
	public int getMinTemp()
	{
		return this.minTemp;
	}
	public int getThreshold()
	{
		return this.threshold;
	}
}