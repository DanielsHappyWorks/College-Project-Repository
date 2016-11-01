import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;

public class MainApp
{
	public static void main(String[] args)
	{
		MainApp theApp = new MainApp();
		theApp.start();
	}

	private void start()
	{
		//sortNameUsingQueue();
		//demoUserQueue();
		//demoUserComparator();
		demoUserGenderComarator();
	}
	private void demoUserGenderComarator(){
		PriorityQueue<User> queue1 = new PriorityQueue<User>(new UserGenderComparator());
		
		queue1.add(new User("john", "brown", (short)23, false));
		queue1.add(new User("maeve", "green", (short)18, true));
		queue1.add(new User("scarlet", "brown", (short)37, true));
		queue1.add(new User("maeve", "green", (short)19, false));
		queue1.add(new User("bea", "scarlet", (short)28, false));
		
		Iterator<User> iter1 = queue1.iterator();
		while(iter1.hasNext()){
			System.out.println(queue1.remove());
		}
	}
	private void demoUserComparator(){
		PriorityQueue<User> queue = new PriorityQueue<User>(new UserAgeComparator(SortType.Ascending));
		
		queue.add(new User("john", "brown", (short)23, false));
		queue.add(new User("maeve", "green", (short)18, true));
		queue.add(new User("scarlet", "brown", (short)37, true));
		queue.add(new User("maeve", "green", (short)19, false));
		queue.add(new User("bea", "scarlet", (short)28, false));
		
		Iterator<User> iter = queue.iterator();
		while(iter.hasNext()){
			System.out.println(queue.remove());
		}
	}
	
	private void demoUserQueue()
	{
		PriorityQueue<User> queue = new PriorityQueue<User>();
		
		queue.add(new User("john", "brown", (short)23, false));
		queue.add(new User("maeve", "green", (short)18, true));
		queue.add(new User("scarlet", "brown", (short)37, true));
		queue.add(new User("maeve", "green", (short)19, false));
		queue.add(new User("bea", "scarlet", (short)28, false));
		
		//PriorityQueue<User> copy = new PriorityQueue<User>();
		//copy.addAll(queue);
		
		//System.out.println(queue);
		
		Iterator<User> iter = queue.iterator();
		while(iter.hasNext()){
			System.out.println(queue.remove());
		}
	}
	
	public void addToQueue(PriorityQueue<User> queue, User u){
		if(!queue.contains(u))
			queue.add(u);
	}
	
	private void sortNameUsingQueue()
	{
		PriorityQueue<String> queue = new PriorityQueue<String>();
		
		queue.add("ben black");
		queue.add("edward grey");
		queue.add("alan white");
		
		System.out.println(queue);
		
		Iterator<String> iter =queue.iterator();
		
		while(iter.hasNext())
		{
			//System.out.println(queue.remove());
			//System.out.println(queue.peek());
			//System.out.println(queue.poll());
			//System.out.println(iter.next());
		}
		
	}

}