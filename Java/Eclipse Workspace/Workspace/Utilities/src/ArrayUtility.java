import java.util.ArrayList;

public class ArrayUtility {
	//int arrays
	public static void printArray(String id,int[] theArray)
	{
		printArray(id,theArray,true);
	}
	public static void printArray(String id,int[] theArray,boolean bForward)
	{
		if(bForward)
		{
			for(int i = 0; i < theArray.length; i++)
			{
				System.out.println(id + "["+ i + "]: " + theArray[i]);
			}
		}
		else
		{
			for(int i = theArray.length-1; i >= 0; i--)
			{
				System.out.println(id + "["+ i + "]: " + theArray[i]);
			}
		}
	}
	
	//double arrays
	public static void printArray(String id,double[] theArray)
	{
		printArray(id,theArray,true);
	}
	public static void printArray(String id,double[] theArray,boolean bForward)
	{
		if(bForward)
		{
			for(int i = 0; i < theArray.length; i++)
			{
				System.out.println(id + "["+ i + "]: " + theArray[i]);
			}
		}
		else
		{
			for(int i = theArray.length-1; i >= 0; i--)
			{
				System.out.println(id + "["+ i + "]: " + theArray[i]);
			}
		}
	}
	
	//string arrays
	public static void printArray(String id,String[] theArray)
	{
		printArray(id,theArray,true);
	}
	public static void printArray(String id,String[] theArray,boolean bForward)
	{
		if(bForward)
		{
			for(int i = 0; i < theArray.length; i++)
			{
				System.out.println(id + "["+ i + "]: " + theArray[i]);
			}
		}
		else
		{
			for(int i = theArray.length-1; i >= 0; i--)
			{
				System.out.println(id + "["+ i + "]: " + theArray[i]);
			}
		}
	}
	
	//boolean arrays
	public static void printArray(String id,boolean[] theArray)
	{
		printArray(id,theArray,true);
	}
	public static void printArray(String id,boolean[] theArray,boolean bForward)
	{
		if(bForward)
		{
			for(int i = 0; i < theArray.length; i++)
			{
				System.out.println(id + "["+ i + "]: " + theArray[i]);
			}
		}
		else
		{
			for(int i = theArray.length-1; i >= 0; i--)
			{
				System.out.println(id + "["+ i + "]: " + theArray[i]);
			}
		}
	}
	
	
	//char arrays
	public static void printArray(String id,char[] theArray)
	{
		printArray(id,theArray,true);
	}
	public static void printArray(String id,char[] theArray,boolean bForward)
	{
		if(bForward)
		{
			for(int i = 0; i < theArray.length; i++)
			{
				System.out.println(id + "["+ i + "]: " + theArray[i]);
			}
		}
		else
		{
			for(int i = theArray.length-1; i >= 0; i--)
			{
				System.out.println(id + "["+ i + "]: " + theArray[i]);
			}
		}
	}
	//prints array list
	/*public void print (ArrayList<Integer> list){
		int value = 0;
		
		for(int i = 0; i < list.size(); i++){
			value = list.get(i); //declare outside so you dont keep receclaring it over and over
			System.out.println(value);
		}
	}*/
	public void print (ArrayList<Integer> list){
		for(int i = 0; i < list.size(); i++){
			System.out.println(list.get(i));
		}
	}
}
