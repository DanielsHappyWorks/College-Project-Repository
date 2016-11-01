
public class Sensor {
	private int id;
	private String location, ipAddress;
	private boolean bAlarm;
	
	Sensor(int id, String location, String ipAddress)
	{
		this.id = id;
		this.location = location;
		this.ipAddress = ipAddress;
		this.bAlarm = false;
	}
	public void triggerAlarmOn(){
		this.bAlarm = true;
	}
	public int getId()
	{
		return this.id;
	}
	public String getLocation()
	{
		return this.location;
	}
	public String getIpAddress()
	{
		return this.ipAddress;
	}
	public boolean getBAlarm()
	{
		return this.bAlarm;
	}
}
