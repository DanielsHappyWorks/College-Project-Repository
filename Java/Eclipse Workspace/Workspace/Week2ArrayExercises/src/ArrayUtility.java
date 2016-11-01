

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
}