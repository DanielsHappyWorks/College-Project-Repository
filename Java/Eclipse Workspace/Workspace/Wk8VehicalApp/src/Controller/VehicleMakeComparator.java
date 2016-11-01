package Controller;
import java.util.Comparator;

import Model.Vehicle;

public class VehicleMakeComparator implements Comparator<Vehicle>{

	@Override
	public int compare(Vehicle arg0, Vehicle arg1) {
		if(arg0 == arg1)
			return 0;

		if(arg0 == null)
			return 1;
		
		return arg0.getMake().compareToIgnoreCase(arg1.getMake());
	}

}
