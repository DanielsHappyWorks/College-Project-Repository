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
		testAll();
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
	
	public Object getSmallest(ArrayList<Object> list,
			IMeasurer measurer)
	{
		double smallest = Double.MAX_VALUE, aValue = 0;
		Object smallestObject = null;
		
		for(Object obj : list)
		{
			aValue = measurer.getValue(obj);
			
			if(aValue < smallest)
			{
				smallest = aValue;
				smallestObject = obj;
			}
		}
		
		return smallestObject;
	}

	public double getStandardDeviation(ArrayList<Object> list, double average, IMeasurer measurer)
	{
		double sum=0;
		double sumAverage,standardDeviation;
		
		for(Object obj : list)
		{
			sum = sum + ((measurer.getValue(obj)-average)*(measurer.getValue(obj)-average));
		}
		
		sumAverage =  sum/list.size();
		standardDeviation = Math.sqrt(sumAverage);
		
		return standardDeviation;
	}
	
	public void testAll(){
		testPrint();
		testEquals();
		testAverage();
		testSmallest();
		testStandardDeviation();
	}
	public void testPrint()
	{
		System.out.println("Test for Print");
		Dvd d1 = new Dvd("lion king","peter",54.54,200);
		d1.print();
		System.out.println();
	}
	public void testEquals(){
		System.out.println("Test for Equals");
		//testing all against d1
		Dvd d1 = new Dvd("lion king","peter",54.54,43);
		Dvd d2 = new Dvd("lion king","peter",54.54,43);
		Dvd d3 = new Dvd("lols","peter",54.54,43);
		Dvd d4 = new Dvd("lion king","ggs",54.54,43);
		Dvd d5 = new Dvd("lion king","peter",54.21,43);
		Dvd d6 = new Dvd("lion king","peter",54.574,69);
		
		boolean check = d1.equals(d2);
		System.out.println(check);
		boolean check2 = d1.equals(d3);
		System.out.println(check2);
		boolean check3 = d1.equals(d4);
		System.out.println(check3);
		boolean check4 = d1.equals(d5);
		System.out.println(check4);
		boolean check5 = d1.equals(d6);
		System.out.println(check5);
		System.out.println();
	}
	public void testAverage(){
		System.out.println("Test for Average");
		ArrayList<Object> dList = new ArrayList<Object>();
		dList.add( new Dvd("lion king","peter",54.54,10));
		dList.add( new Dvd("Frozen","Daniel",54.21,3));
		dList.add( new Dvd("Toy Story","Adam",54.574,12));
		
		double average = getAverage(dList, new CostMeasurer());
		System.out.println("Average: " +average);
		System.out.println();
	}
	public void testSmallest(){
		System.out.println("Test for Smallest");
		ArrayList<Object> dList = new ArrayList<Object>();
		dList.add( new Dvd("lion king","peter",54.54,140));
		dList.add( new Dvd("Frozen","Daniel",54.21,130));
		dList.add( new Dvd("Toy Story","Adam",54.574,200));
		
		Object obj = getSmallest(dList, new RuntimeMeasurer());
		System.out.println("Smallest: " +obj);
		System.out.println();
	}
	public void testStandardDeviation(){
		System.out.println("Test for Standard Deviation");
		ArrayList<Object> dList = new ArrayList<Object>();
		dList.add( new Dvd("lion king","peter",54.54,140));
		dList.add( new Dvd("Frozen","Daniel",54.21,130));
		dList.add( new Dvd("Toy Story","Adam",60,200));
		dList.add( new Dvd("Charile from the chocolate factory","The Orphans",46.2,140));
		dList.add( new Dvd("Terminator","I am back",35.23,130));
		dList.add( new Dvd("The Luck Of The Irish","The Leprechauns",97.5,200));
		
		//test 1
		double average = getAverage(dList, new CostMeasurer());
		
		double standardDeviation = getStandardDeviation(dList, average,new CostMeasurer());
		System.out.println("Standard Deviation: " +standardDeviation);
		
		//test 2
		double average2 = getAverage(dList, new RuntimeMeasurer());
		
		double standardDeviation2 = getStandardDeviation(dList, average2,new RuntimeMeasurer());
		System.out.println("Standard Deviation: " +standardDeviation2);
		System.out.println();
	}
}






















