public enum Contract 
{
	PayAsYouGo(50, 100, 0),
	Monthly(500, 1000, 2000); //; end od the enumerated list
	
	private int freeMins, freeTexts, freeData;
	private Contract(int freeMins,int freeTexts,int freeData)
	{
		this.freeMins =freeMins;
		this.freeTexts =freeTexts;
		this.freeData =freeData;
	}
	public int getFreeMins()
	{
		return this.freeMins;
	}
	public int getFreeTexts()
	{
		return this.freeTexts;
	}
	public int getFreeData()
	{
		return this.freeData;
	}

	public String toString()
	{
		String str = "";
		
		if(ordinal()==0)
			str += "Pay as you go Contract";
		else
			str += "Monthly Contract";
		
		str += "[Mins: "+this.freeMins;
		str += ", Texts: "+this.freeTexts;
		str += ", Data: "+this.freeData+"]";
		
		return str;
	}
}
