package View;
import java.util.ArrayList;
import java.util.Collections;

import Controller.VehicleMakeComparator;
import Model.Vehicle;

public class mainApp {
	public static void main(String[] args)
	{
		mainApp theApp = new mainApp();
		theApp.start();
	}
	
	public void start()
	{
		ArrayList<Vehicle> vList = new ArrayList<Vehicle>();
		vList.add(new Vehicle("Ford Focus", "151 LH 1234", (byte)0));
		vList.add(new Vehicle("BMW Z3", "10 CN 1347", (byte)2));
		vList.add(new Vehicle("Volkswagen Passat", "11 D 6524", (byte)1));
		vList.add(new Vehicle("Ford Focus", "152 LH 1564", (byte)4));
		vList.add(new Vehicle("Masda MX8", "6 D 9274", (byte)5));
		
		//sort by make
		System.out.println("Sort by make");
		Collections.sort(vList, new VehicleMakeComparator());
		for(Vehicle v : vList)
			System.out.println(v);
	}
}
