import java.io.File;
import java.io.IOException;

/**
 * Demonstrates the key concepts to be understood in relation to exceptions:
 *  - checked and unchecked 
 *  - try-catch
 *  - catch clause prioritisation (e.g. list most specific catch clause first)
 *  - finally clause
 *  - writing custom exception classes
 *  - using throw and throws
 * @author NMCG
 * @version 1.0
 *
 */
public class MainApp 
{
	public static void main(String[] args) 
	{
		MainApp theApp = new MainApp();
		try {
			theApp.start();
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (MyCustomException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void start() throws IOException, MyCustomException 
	{
		/*
		System.out.println("********** Unchecked exception - not detected by the compiler - results in run-time error **********");
		demoUncheckedException(); //run-time
		
		System.out.println("********** Checked exception - detected by the compiler - results in compile-time error **********");
		demoCheckedException(); //compile-time
		
		System.out.println("********** Finally clause - always executed - use for housekeeping the application **********");
		demoFinally();
		*/
		
		System.out.println("********** Creating a custom exception - use to write to define a custom responose (e.g. log file, send email, notify remove server) **********");
		demoCustomAndThrowException();
	}

	private void demoUncheckedException() 
	{
		int[] intArray = {2,4,6,8};
		
		try
		{
		//add code...
			for(int i = 0; i <= intArray.length; i++)
				System.out.println(intArray[i]);
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("ArrayIndexOutOfBoundsException!");
		}
		catch(Exception e)
		{
			System.out.println("Exception!");
		}
	}

	private void demoCheckedException() 
				throws IOException 
	{
		//reference a drive and/or folder that doesnt exist to create this exception
		String fileName = "c:/idontexist/bla.txt";	
		File theFile = new File(fileName);
		
		//add code...
		theFile.createNewFile();
		
	}

	
	private void demoFinally() 
	{
		File theFile = new File("V:/temp/bla.txt");
		
		try 
		{
			theFile.createNewFile();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			System.out.println("Housekeeping!!!");
		}
	}

	private void demoCustomAndThrowException() throws MyCustomException 
	{
		int x = -10;
		
		if(x < 1)
			throw new MyCustomException("x is too small at " + x);
			
		//continue with the code based on good x value	
	}
	
	private void demoThrowingException() 
	{
		//code added in lecture...
	}

}
