package Utilities;

public abstract class appUtility {
	private static final String[] colourAsString = {"red","green","blue","white","light blue"};
	
 	public static String getColourFromIndex(int index)
 	{
	  if((index >=0 ) &&(index < colourAsString.length))
	  {
		  return colourAsString[index];
	  }
	  else
	  {
		  return colourAsString[0];
	  }
 	}
 	
 	public static void printAllColours()
 	{
 		for (String s : colourAsString)
 			System.out.println(s);
 	}
}
