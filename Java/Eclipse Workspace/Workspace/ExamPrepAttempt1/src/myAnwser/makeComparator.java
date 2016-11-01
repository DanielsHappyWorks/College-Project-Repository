package myAnwser;
import java.util.Comparator;
public class makeComparator implements Comparator<Vehicle>{

	@Override
	public int compare(Vehicle v1, Vehicle v2) {
		if(v1.engineSize>v2.engineSize){
			return -1;
		}
		else if(v1.engineSize<v2.engineSize){
			return 1;
		}
		else{
			return 0;
		}
	}

}
