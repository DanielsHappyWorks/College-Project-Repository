
public class Card 
{
	public static String String_Hearts = "Hearts";
	public static String String_Clubs = "Clubs";
	public static String String_Spades = "Spades";
	public static String String_Diamonds = "Diamonds";
	//public static int Low_Hearts_value = 1;
	
	private int position; //1-52
	private int value;    //1 - 10, 11 for an Ace
	private String suit, valueAsString; //"Hearts", "2"
	
	public Card(int position)
	{
		this.setPosition(position);		
		this.setSuit(position);
		this.setValueAndString(position);
	}

	private void setSuit(int position) 
	{
		if((position >= 1) && (position <= 13))
			this.suit = String_Hearts;
		else if((position >= 14) && (position <= 26))
			this.suit = String_Diamonds;
		else if((position >= 27) && (position <= 39))
			this.suit = String_Spades;
		else
			this.suit = String_Clubs;
	}

	private void setValueAndString(int position) 
	{
		//maps position from 1-52 to range 0-12
		int tempValue = position%13; 
		
		//Jack
		if(tempValue == 0) //e.g. 13, 26, 39, 52
		{
			this.value = 10;
			this.valueAsString = "Jack";
		}
		else if(tempValue == 1)
		{
			this.value = tempValue;
			this.valueAsString = "Ace";
		}
		else if (tempValue == 11) //11, 24, 37, 50
		{
			this.value = 10;
			this.valueAsString = "Queen";
		}
		else if (tempValue == 12) //11, 24, 37, 50
		{
			this.value = 10;
			this.valueAsString = "King";
		}	
		else //values 1-10 
		{
			this.value = tempValue;
			
			//use the Integer::toString() method to convert int -> String
			this.valueAsString = new Integer(this.value).toString();
             
             this.valueAsString = this.value + "";

	
		}
	}
		
	private void setPosition(int position) 
	{
		if((position >= 1) && (position <= 52))
			this.position = position;
		else
			this.position = 1;
	}
	
	public String toString()
	{
		return this.valueAsString + " of " + this.suit;
	}
	
	public int getValue()
	{
		return this.value;
	}
}
