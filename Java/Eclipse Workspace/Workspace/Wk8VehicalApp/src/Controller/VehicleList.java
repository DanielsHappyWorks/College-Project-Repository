package Controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import Model.Vehicle;

public class VehicleList {
	
	private String  name;
	private ArrayList<Vehicle> list;
	
	public VehicleList(String name)
	{
		this.name = name;
		this.list = new ArrayList<Vehicle>();
	}
	
	public void add(Vehicle v)
	{
		this.list.add(v);
	}
	
	public Vehicle search(String licence)
	{
		for (Vehicle v : list)
		{
			if(v.getLicence().equals(licence))
				return v;
		}
		return null;
	}
	
	public void print()
	{
		for (Vehicle v : list)
		{
			System.out.println(v);
		}
	}
	
	public ArrayList<Vehicle> sort(Comparator<Vehicle> comp)
	{
		Collections.sort(this.list, comp);
		return this.list;
	}
	public ArrayList<Vehicle> clear()
	{
		return this.list = null;
	}
}
