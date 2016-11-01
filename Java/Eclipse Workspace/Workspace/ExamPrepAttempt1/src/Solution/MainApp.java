package Solution;
import java.util.ArrayList;
import java.util.Collections;

/**
 * An example to demonstrate the use of Comparable, Comparator, Measurable.
 * This example also combines these techniques with an inheritance hierarchy where Vehicle
 * is the parent and Airplane and Car are the child classes.
 * 
 * Remember we use...
 * Comparable, Comparator - to sort a list
 * Measurer, Measurable - to get some numeric representation of the object e.g. for getAverage() type methods
 * 
 * @author NMCG
 * @version 1.0
 *
 */
public class MainApp 
{
	public static void main(String[] args) 
	{
		MainApp theApp = new MainApp();
		theApp.start();
	}
	
	public void start()
	{
		//initialize an array list to store objects of type Vehicle (remember Airplane and Car are Vehicles too!)
		ArrayList<Vehicle> list = new ArrayList<Vehicle>();
		
		//add some data
		list.add(new Car("hyundai", "i10", 1.0, 4, 5));
		list.add(new Airplane("boeing", "a320", 50, 380, 6000, 39000));
		list.add(new Airplane("learjet", "n35", 25, 8, 2789, 35000));
		list.add(new Car("bmw", "z4", 1.8, 2, 3));
		
			
		System.out.println("\nSort using the Vehicle::compareTo() by engine size...");
		Collections.sort(list);		
		print(list);
		
		System.out.println("\nSort using the VehicleMakeComparator::compareTo() by make...");
		int direction = 1;
		Collections.sort(list, new VehicleMakeComparator(direction));
		print(list);
		
		System.out.println("\nReverse sort using the VehicleMakeComparator::compareTo() by make and use an integer to specify order...");
		direction = -1;
		Collections.sort(list, new VehicleMakeComparator(direction));
		print(list);
		
		System.out.println("\nSort using the VehicleModelComparator::compareTo() and use an enum to specify order...");
		Collections.sort(list, new VehicleModelComparator(SortType.Ascending));
		print(list);
		
		System.out.println("\nGet the largest vehicle in the list by passenger size...");
		Vehicle largestVehicle = getLargest(list, new VehiclePassengerSizeMeasurer());
		System.out.println(largestVehicle);

	
	}
	
	public Vehicle getLargest(ArrayList<Vehicle> list, IMeasurer measure)
	{
		double largest = Double.MIN_VALUE;
		double actualValue = 0;
		Vehicle largestObj = null;
		
		for(Vehicle v : list)
		{
			//read the value from the vehicle
			actualValue = measure.getValue(v);
			
			//if its the biggest then...
			if(actualValue > largest)
			{
				//set largest read so far
				largest = actualValue;
				//record the vehicle address
				largestObj = v;
			}
		}
		
		//return the largest we found so far
		return largestObj;
	}
	
	
	public void print(ArrayList<Vehicle> list)
	{
		for(Vehicle v : list)
		{
			System.out.println(v.toString()); //dynamic method lookup
		}
	}
}
