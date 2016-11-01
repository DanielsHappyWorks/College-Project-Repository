
public class StringLengthMeasurer implements IMeasurer 
{

	public double getValue(Object obj) 
	{
		String s = (String)obj;
		return s.length();
	}

}
