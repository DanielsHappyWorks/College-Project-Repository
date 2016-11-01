public class CostMeasurer implements IMeasurer
{
	public double getValue(Object obj)
	{
		Dvd dd = (Dvd)obj;
		return dd.getCost();
	}
}