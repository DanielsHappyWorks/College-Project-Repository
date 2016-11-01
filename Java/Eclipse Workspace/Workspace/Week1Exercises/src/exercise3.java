/**
 * Exercise solutions - Primitive data types
 * @author Niall McGuinness
 * @version 1.0
 */
public class exercise3
{
	public static void main(String[] args) 
	{
		exercise3 theApp = new exercise3();
		theApp.start();
	}
	
	public void start()
	{
		testSetBit();
		testIsSet();
		exercise4();
	}
	
	//Exercise 3 - Encode Sky TV choices using these methods 
	public void exercise4()
	{
		System.out.println("\nSetting Sky TV config...");
		
		int moviesPosition = 4;
		int sportsPosition = 3;
		int kidsPosition = 2;
		int plusPosition = 1;
		int hdPosition = 0;
		
		int userConfig = 0;	
		userConfig = setBit(userConfig, moviesPosition, true);
		userConfig = setBit(userConfig, plusPosition, true);
		userConfig = setBit(userConfig, hdPosition, true);
		
		//Do we need to explicitly set the sports and kids values to false? Why not? Comment out these lines.
		userConfig = setBit(userConfig, sportsPosition, false);
		userConfig = setBit(userConfig, kidsPosition, false);
		
		System.out.println("Sky TV user configuration: " + userConfig);
		
	}
	
	
	/********************************************************************** Methods **********************************************************************/
	
	//Tests if a bit at a position within a value is set
	public boolean isSet(int value, int position)
	{
		//generate a simple mask based on position specified
		int mask = 1 << position; //e.g. 0001 0000
		
		//e.g. for a value 9 (i.e. 1001) and a position 3 (i.e. 1000) the result of the AND should be 8 (i.e. 1000)
		int result = value & mask;
		
		//if the result > 0 then the bit at the position was 1, otherwise 0
		return result > 0;
	}
	
	//Sets (or unsets) the value of a bit at a position within a value
	public int setBit(int value, int position, boolean bitValue)
	{
		//holds the output value
		int newValue = 0;
		
		//generate a simple mask based on position specified
		int mask = 1 << position; //e.g. 0001 0000
		
		//bit to 1
		if(bitValue)
		{
			//OR existing value with the mask
			newValue = value | mask;
		}
		//bit to 0
		else
		{
			//complement the mask so it is not 1110 1111 
			mask = ~mask;
			
			//AND with mask to set the bit to 0
			newValue = value & mask;
		}	
		
		return newValue;
	}
	
	/********************************************************************** Test Methods **********************************************************************/
	//tests the isSet()
	public void testIsSet() 
	{
		boolean bSet = false;
		
		System.out.println("\nTesting isSet...");
		
		//choose a value (e.g. 9) and test each of the bits to see if they're set to 1
		bSet = isSet(9, 3);
		System.out.println("bSet (9, 3): " + bSet);
		
		bSet = isSet(9, 2);
		System.out.println("bSet (9, 2): " + bSet);
		
		bSet = isSet(9, 1);
		System.out.println("bSet (9, 1): " + bSet);
		
		bSet = isSet(9, 0);
		System.out.println("bSet (9, 0): " + bSet);
	}
	
	//test the setBit method
	public void testSetBit()
	{
		int newValue = 0;	
		
		System.out.println("\nSetting to true...");
		
		//take 0 and set each bit to 1 
		for(int i = 0; i < 8; i++)
		{
			newValue = setBit(newValue, i, true);
			System.out.println("Setting bit " + i + " to true - newValue: " + newValue);		
		}

		System.out.println("\nSetting to false...");
		
		//take 255 and set each bit to 0
		for(int i = 0; i < 8; i++)
		{
			newValue = setBit(newValue, i, false);
			System.out.println("Setting bit " + i + " to false - newValue: " + newValue);		
		}
	}
}








