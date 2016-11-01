import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;

public class MainApp
{
	PriorityQueue<Airplane> queue1;
	
	public static void main(String[] args)
	{
		MainApp theApp = new MainApp();
		theApp.start();
	}

	private void start()
	{
		initialiseQueue();
		
		queue1.add(new Airplane("F1658", "Ryanair", 50, 100, 1));
		queue1.add(new Airplane("A3215", "Airlingus", 30, 200, 0.5));
		queue1.add(new Airplane("F7641", "Ryanair", 100, 300, 5));
		
		Iterator<Airplane> iter = queue1.iterator();
		while(iter.hasNext()){
			System.out.println(queue1.remove());
		}
	}
	private void initialiseQueue(){
		this.queue1 = new PriorityQueue<Airplane>(new AirplaneTimeToNoFuelComparator(SafetyRatio.Conservative));
	}

}