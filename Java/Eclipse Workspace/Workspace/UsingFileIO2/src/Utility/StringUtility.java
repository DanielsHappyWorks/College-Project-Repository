package Utility;
public class StringUtility 
{
	public static int StandardPadLength = 16;
	public static String PadString = "*";
	
	//john, 8, * => john****
	public static String pad(String data, 
			int padLength, String padString)
	{
		if((data == null) || (padString == null)
				|| (padLength == 0))
			return null;
		
		int paddingRequired = padLength - data.length();
		
		if(paddingRequired < 0) //john12345 => john1234
			return data.substring(0, padLength);
		
		for(int i = 0; i < paddingRequired; i++)
			data += padString;	
		return data;
	}
	//john****, * => john
	public static String unpad(String data, 
				String padString)
	{
		if((data == null) || (padString == null))
			return null;
		
		int indexPadString = data.indexOf(padString);
		if(indexPadString != -1)
		{
			return data.substring(0, indexPadString);
		}
		
		return data; //john1234 or john$$$$
	}

}
