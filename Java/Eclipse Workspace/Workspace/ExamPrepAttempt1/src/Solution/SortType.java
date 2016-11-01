package Solution;

public enum SortType 
{
	Ascending(1),
	Descending(-1);
	
	private int direction;
	public int getDirection()
	{
		return this.direction = direction;
	}
	private SortType(int direction)
	{
		this.direction = direction;
	}
}
