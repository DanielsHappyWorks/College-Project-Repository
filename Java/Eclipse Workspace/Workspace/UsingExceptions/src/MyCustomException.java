import java.io.File;
import java.io.IOException;


public class MyCustomException 
		extends Exception
{
	public MyCustomException(String msg)
	{
		super(msg);
		handleException(msg);
	}

	private void handleException(String msg) 
	{
		System.out.println("Exception: " + msg);
		//write to a log file with current time
		//send an email
		//send a webtext
		//inform a remote server i.e. similar to Microsoft's method of handling crashes
	}
	
	
	
	

}
