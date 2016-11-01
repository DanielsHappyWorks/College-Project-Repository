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
		ArrayList<Object> sList = new ArrayList<Object>();
		sList.add( new SimCard("vodaphone",6,"03749565"));
		sList.add( new SimCard("vodaphone",4,"0374349565"));
		sList.add( new SimCard("3",8,"06456749565"));
		sList.add( new SimCard("meteor",1045,"03745565"));
		
		double average = getAverage(sList, new PlayerAgeMesurer());
		System.out.println("Average: " + average);
	}
	
	public double getAverage(ArrayList<Object> list, IMesurer mesurer)
	{
		double sum = 0;
		for(Object obj : list)
		{
			sum += mesurer.getValue(obj);
		}
		return sum/list.size();
	}
}