import java.util.ArrayList;
import java.util.Collections;

public class MainApp 
{

	public static void main(String[] args) 
	{
		MainApp theApp = new MainApp();
		theApp.start();
	}

	private void start() 
	{
		System.out.println("Count: " + Room.getCount());
		
		Room r1 = new Room((short)101, (byte)3, (float)65.50);	
		Room r2 = new Room(101,4,129.99, RoomType.Standard);
		
		System.out.println("Count: " + Room.getCount());
		
		ArrayList<Room> rList = new ArrayList<Room>();
		
		rList.add(new Room(101, 4, 129.99, RoomType.Standard));
	
		rList.add(new Room(102, 2, 49.50, RoomType.Standard));

		rList.add(new Room(104, 1, 229.0, RoomType.Standard));

		System.out.println("Count: " + Room.getCount());
				
		Room sRoom1 = getSmallest(rList);
		System.out.println("Smallest Cost: " + sRoom1);
		/*
		Room sRoom2 = getSmallest(rList,
				new RoomCostMeasurer());
		System.out.println("Smallest Cost: " + sRoom2);
		
		Room sRoom3 = getSmallest(rList,
				new RoomOccupancyMeasurer());
		System.out.println("Smallest Occ.: " + sRoom3);
		*/
		
		ArrayList<Object> oList 
						= new ArrayList<Object>(rList);
		
		Room sRoom3 = (Room)getSmallest(oList,
				new RoomOccupancyMeasurer());
		System.out.println("Smallest Occ.: " + sRoom3);
		
		ArrayList<String> sList = new ArrayList<String>();
		sList.add("dfgdfgd");
		sList.add("456thfh56uue56");
		sList.add("sef");
		sList.add("45dfg3454t");
		sList.add("fgh554t54t54gt54ty");
		
		ArrayList<Object> oList2 
		= new ArrayList<Object>(sList);
		
		String sString = (String)getSmallest(oList2,
				new StringLengthMeasurer());
		System.out.println("Smallest Len.: " + sString);
		
		
		Collections.sort(rList, new RoomCostComparator());
		print(rList);	
		
		
		Room newRoom 
		= new Room(101, 4, 129.99, RoomType.Standard);
		
		Room newRoom1 
		= new Room(101, 4, 129.99, RoomType.Standard);
		
		if(newRoom.equals(newRoom1))
			System.out.println("same!!!!");
		
		
		
		
		
		
		
		
		if(!rList.contains(newRoom))
			rList.add(newRoom);
		
		
		
		
		
		
		
		
	}
	
	public Room getSmallest(ArrayList<Room> list)
	{
		float cost = 0, smallestValue = Float.MAX_VALUE;
		Room smallestRoom = null;
		
		for(Room r : list)
		{
			cost = r.getCostPerNight();
			
			if(cost < smallestValue)
			{
				smallestValue = cost;
				smallestRoom = r;
			}	
		}		
		return smallestRoom; //address in RAM of smallest
	}
	/*
	public Room getSmallest(ArrayList<Room> list,
			IMeasurer measurer)
	{
		float cost = 0, smallestValue = Float.MAX_VALUE;
		Room smallestRoom = null;
		
		for(Room r : list)
		{
			cost = (float)measurer.getValue(r);
			
			if(cost < smallestValue)
			{
				smallestValue = cost;
				smallestRoom = r;
			}	
		}		
		return smallestRoom; //address in RAM of smallest
	}
	*/
	
	public Object getSmallest(ArrayList<Object> list,
			IMeasurer measurer)
	{
		float cost = 0, smallestValue = Float.MAX_VALUE;
		Object smallestObj = null;
		
		for(Object obj : list)
		{
			cost = (float)measurer.getValue(obj);
			
			if(cost < smallestValue)
			{
				smallestValue = cost;
				smallestObj = obj;
			}	
		}		
		return smallestObj; //address in RAM of smallest
	}
	
	public float getTotalCost(ArrayList<Room> list)
	{
		float totalCost = 0;
		for(Room r : list)
			totalCost += r.getCostPerNight();
		
		return totalCost;
			
	}
		
	public void print(ArrayList<Room> list)
	{
		for(Room r : list)
			System.out.println(r);
	}
	/*
	public void print(ArrayList<Object> list)
	{
		for(Object o : list)
			System.out.println(o);
	}
	*/
	
}













