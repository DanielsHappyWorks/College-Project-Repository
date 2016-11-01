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
		ArrayList<Object> cList = new ArrayList<Object>();
		cList.add(new Character("maya", true, 155));
		cList.add(new Character("joe", false, 176));
		cList.add(new Character("lala", true, 147));
		
		System.out.println("Average: " + getAverage(cList, new characterHeightMesurer()));
	}
	
	public double getAverage(ArrayList<Object> list, IMeasurer measurer)
	{
		double sum = 0;
		for(Object obj : list)
		{
			sum += measurer.getValue(obj);
		}
		return sum/list.size();
	}
}