import java.util.Comparator;

public class UserGenderComparator implements Comparator<User> {

	@Override
	public int compare(User o1, User o2) {
		if(o1.isGender() && !o2.isGender()){ //FM
			return -1;
		}
		else if(!o1.isGender() && o2.isGender()){ //MF
			return -1;
		}
		else{
			return 0; //MM FF
		}
	}

}
