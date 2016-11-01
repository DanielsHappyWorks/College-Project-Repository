
public class NumberRangeFilter implements IFilter<Integer>
{
	private int lo, hi;
	
	public NumberRangeFilter(int lo, int hi)
	{
		this.lo = lo; this.hi = hi;
	}

	@Override
	public boolean matches(Integer obj) 
	{
		int intValue = obj.intValue();
		return ((intValue >= lo) && (intValue <= hi));
	}
}
