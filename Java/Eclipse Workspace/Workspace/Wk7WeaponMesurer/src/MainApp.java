import java.util.ArrayList;

public class MainApp 
{
	public static void main(String[] args) 
	{
		MainApp theApp = new MainApp();
		theApp.start();
	}

	private void start() 
	{
		ArrayList<Object> wList = new ArrayList<Object>();
		//add
		
		double aver = getAverage(wList, new WeaponClipMeasurer());
		//syso
		
		Object largest = getLargest(wList, new WeaponClipMeasurer());
		System.out.println(largest);
	}
	
	public Object getLargest(ArrayList<Object> list,
			IMeasurer measurer)
	{
		double largest = Double.MIN_VALUE, aValue = 0;
		Object largestObject = null;
		
		for(Object obj : list)
		{
			aValue = measurer.getValue(obj);
			
			if(aValue > largest)
			{
				largest = aValue;
				largestObject = obj;
			}
		}
		
		return largestObject;
	}
	
	public double getAverage(ArrayList<Object> list,
			IMeasurer measurer)
	{
		double sum = 0;
		for(Object obj : list)
		{
			sum += measurer.getValue(obj);
		}
		
		return sum/list.size();
	}
}






















