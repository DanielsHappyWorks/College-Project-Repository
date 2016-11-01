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
		demoIMesurable();
	}
	

	private void demoIMesurable() {
		ArrayList<SimCard> sList = new ArrayList<SimCard>();
		sList.add( new SimCard("vodaphone",6,"03749565"));
		sList.add( new SimCard("vodaphone",4,"0374349565"));
		sList.add( new SimCard("3",8,"06456749565"));
		sList.add( new SimCard("meteor",10,"03745565"));
		
		ArrayList<IMesurable> mList1 = new ArrayList<IMesurable>(sList);
		
		double average1 = getAverage(mList1);
		System.out.println("average: " + average1);
		
		IMesurable Largest =getLargest(mList1);
		IMesurable Smallest = getSmallest(mList1);
		
		System.out.println(Largest);
		System.out.println(Smallest);
		
		
	}
	
	public IMesurable getLargest(ArrayList<IMesurable> list)
	{
		IMesurable LargestObject = null;
		double LargestValue= Double.MIN_VALUE;
		
		for(IMesurable m : list)
		{
			if(m.getValue()>LargestValue)
			{
				LargestValue = m.getValue();
				LargestObject = m;
			}
		}
		return LargestObject;
	}
	
	public IMesurable getSmallest(ArrayList<IMesurable> list)
	{
		IMesurable SmallestObject = null;
		double SmallestValue= Double.MAX_VALUE;
		
		for(IMesurable m : list)
		{
			if(m.getValue()<SmallestValue)
			{
				SmallestValue = m.getValue();
				SmallestObject = m;
			}
		}
		return SmallestObject;
	}
	
	public double getAverage(ArrayList<IMesurable> list)
	{
		double sum = 0;
		
		for(IMesurable m : list)
		{
			sum +=sum + m.getValue();
		}
		return sum/list.size();
	}
}