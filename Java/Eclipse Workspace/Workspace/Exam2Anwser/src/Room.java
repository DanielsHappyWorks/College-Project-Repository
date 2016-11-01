public class Room 
{
	private static int count;
	
	public static int getCount() {
		return count;
	}
	public static void setCount(int count) {
		Room.count = count;
	}

	
	
	//2 bytes = 16 bits = 65536/2 = -32768 -> 32,767
	private short roomNumber;
	private byte maxOccupancy;
	private float costPerNight;
	private RoomType roomType;
	
	
	public Room(short roomNumber, 
			byte maxOccupancy, float costPerNight) 
	{
		this.roomNumber = roomNumber;
		this.maxOccupancy = maxOccupancy;
		this.costPerNight = costPerNight;
		this.roomType = RoomType.Standard;
		count++;
	}
	
	public Room(int roomNumber, 
			int maxOccupancy, double costPerNight,
			RoomType roomType) 
	{
		this.roomNumber = (short)roomNumber;
		this.maxOccupancy = (byte)maxOccupancy;
		this.costPerNight = (float)costPerNight;
		this.roomType = roomType;
		count++;
	}

	public short getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(short roomNumber) {
		this.roomNumber = roomNumber;
	}

	public byte getMaxOccupancy() {
		return maxOccupancy;
	}

	public void setMaxOccupancy(byte maxOccupancy) {
		this.maxOccupancy = maxOccupancy;
	}

	public float getCostPerNight() {
		return costPerNight;
	}

	public void setCostPerNight(float costPerNight) {
		this.costPerNight = costPerNight;
	}
	
	
	public RoomType getRoomType() {
		return roomType;
	}
	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}
	@Override
	public String toString() {
		return "Room [roomNumber=" + roomNumber + ", maxOccupancy=" + maxOccupancy + ", costPerNight=" + costPerNight
				+ ", roomType=" + roomType + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(costPerNight);
		result = prime * result + maxOccupancy;
		result = prime * result + roomNumber;
		result = prime * result + ((roomType == null) ? 0 : roomType.hashCode());
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
		Room other = (Room) obj;
		if (Float.floatToIntBits(costPerNight) != Float.floatToIntBits(other.costPerNight))
			return false;
		if (maxOccupancy != other.maxOccupancy)
			return false;
		if (roomNumber != other.roomNumber)
			return false;
		if (roomType != other.roomType)
			return false;
		return true;
	}


}
