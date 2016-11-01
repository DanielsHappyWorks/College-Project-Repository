public class MainApp
{
	public static void main(String[] args)
	{
		MainApp theApp = new MainApp();
		theApp.start();
	}
private void start()
	{
		for(int i=0; i<1000; i++)
		{
			System.out.println("start");
		MailUtility.send("adamolo96@gmail.com", "Test  "+i+"", "Test Test Test", "text/plain");
		System.out.println("sent");
		}
		System.out.println("Finished");
	}
}
