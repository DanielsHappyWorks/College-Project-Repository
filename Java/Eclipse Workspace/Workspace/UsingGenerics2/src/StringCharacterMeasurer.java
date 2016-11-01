public class StringCharacterMeasurer 
				implements IMeasurer<String>
{
	private char[] characterArray;
	
	public StringCharacterMeasurer(char[] characterArray)
	{
		this.characterArray = characterArray;
	}
	
	public double getValue(String str) //cuba
	{	
		int count = 0;
		char aChar = ' ';	
		int wordLength = str.length();
		int i = 0, j = 0;
		
		//remove case sensitivity
		str = str.toLowerCase();
		
		for(i = 0; i < wordLength; i++)
		{
			aChar = str.charAt(i);		
			for(j = 0; j < characterArray.length; j++)
			{
				if(aChar == characterArray[j])
					count++;
			}	
		}
		
		return count;
	}
}
