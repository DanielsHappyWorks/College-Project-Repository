import java.util.ArrayList;
import java.util.Collections;

public class MainApp {
	
	public static void main(String[] args){
		MainApp theApp = new MainApp();
		theApp.start();
	}

	public void start() {
		ArrayList<CharacterClass> cList = new ArrayList<CharacterClass>();
		cList.add(new CharacterClass("Tank", 200, 300, attackType.Physical));
		cList.add(new CharacterClass("Rogue", 250, 250, attackType.Both));
		cList.add(new CharacterClass("Mage", 350, 150, attackType.Magical));
		cList.add(new CharacterClass("Knight", 300, 200, attackType.Physical));
		
		ArrayList<Object> oList = new ArrayList<Object>(cList);
		Object largestAttack = getLargestAttack(oList, new AttackMeasurer());
		System.out.println(largestAttack);
		
		Collections.sort(cList, new DefenceComparator());
		
		System.out.println(cList);
		ArrayList<Object> nList = searchBy(oList, new AttackFilter(260));
		System.out.println();
		System.out.println(nList);
	}
	
	public Object getLargestAttack(ArrayList<Object> oList, IMeasurer m){
		double largestValue = Double.MIN_VALUE;
		Object object = null;
		
		for(Object obj : oList){
			if(m.getValue(obj)>largestValue){
				largestValue = m.getValue(obj);
				object = obj;
			}
		}
		return object;
	}
	public ArrayList<Object> searchBy(ArrayList<Object> list, IFilter filter)
	{
		ArrayList<Object> returnList = new ArrayList<Object>();
		for(Object obj : list)
		{
			if(filter.matches(obj))
				returnList.add(obj);
		}
		
		return returnList;
	}
}

