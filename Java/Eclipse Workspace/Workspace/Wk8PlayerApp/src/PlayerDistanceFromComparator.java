import java.util.Comparator;

public class PlayerDistanceFromComparator implements Comparator<Player> {
	private int x, y, z;
	private SortType sortType;
	
	public PlayerDistanceFromComparator(SortType sortType, int x,int y, int z)
	{
		this.sortType = sortType;
		this.x=x;
		this.y=y;
		this.z=z;
	}
	
	public PlayerDistanceFromComparator(SortType sortType, Player p)
	{
		this(sortType,p.getX(),p.getY(),p.getZ());
	}
	
	@Override
	public int compare(Player p0, Player p1)
	{
		double distToP0 = getDistanceBetween(p0);
		double distToP1 = getDistanceBetween(p1);
		
		int direction =1;
		
		if(sortType == SortType.Ascending)
		{
			direction = 1;
		}
		else if(sortType == SortType.Descending)
		{
			direction = -1;
		}
		
		if (distToP0 > distToP1)
		{
			return direction;
		}
		else if(distToP0 < distToP1)
		{
			return -direction;
		}
		else
		{
			return 0;
		}
	}
	
	public double getDistanceBetween(Player p)
	{
		double diffSquaredX = Math.pow(this.x-p.getX(), 2);
		double diffSquaredY = Math.pow(this.y-p.getY(), 2);
		double diffSquaredZ = Math.pow(this.z-p.getZ(), 2);
		
		return Math.sqrt(diffSquaredX+diffSquaredY+diffSquaredZ);
	}
}

/*
public class PlayerDistanceFromComparator implements Comparator<Player> {
	private int x, y, z;
	
	public PlayerDistanceFromComparator(int x,int y, int z)
	{
		this.x=x;
		this.y=y;
		this.z=z;
	}
	
	public PlayerDistanceFromComparator(Player p)
	{
		this(p.getX(),p.getY(),p.getZ());
	}
	
	@Override
	public int compare(Player p0, Player p1)
	{
		double distToP0 = getDistanceBetween(p0);
		double distToP1 = getDistanceBetween(p1);
		
		if (distToP0 > distToP1)
		{
			return 1;
		}
		else if(distToP0 < distToP1)
		{
			return -1;
		}
		else
		{
			return 0;
		}
	}
	
	public double getDistanceBetween(Player p)
	{
		double diffSquaredX = Math.pow(this.x-p.getX(), 2);
		double diffSquaredY = Math.pow(this.y-p.getY(), 2);
		double diffSquaredZ = Math.pow(this.z-p.getZ(), 2);
		
		return Math.sqrt(diffSquaredX+diffSquaredY+diffSquaredZ);
	}
}

*/