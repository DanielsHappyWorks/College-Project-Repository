import java.util.Comparator;

public class AirplaneTimeToNoFuelComparator implements Comparator<Airplane> {
	SafetyRatio safetyRatio;
	
	public AirplaneTimeToNoFuelComparator(SafetyRatio safetyRatio){
		this.safetyRatio = safetyRatio;
	}
	
	@Override
	public int compare(Airplane a0, Airplane a1) {
		if(a0.getTimeToNoFuel(safetyRatio.getValue())>a1.getTimeToNoFuel(safetyRatio.getValue())){
			return 1;
		}
		else if(a0.getTimeToNoFuel(safetyRatio.getValue())<a1.getTimeToNoFuel(safetyRatio.getValue())){
			return -1;
		}
		else{
			return 0;
		}
	}

}
