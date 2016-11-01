
public class ConnectionUsageFilter 
				implements IFilter<Connection>
{
	private double usageLimit;
	
	public ConnectionUsageFilter(double usageLimit)
	{
		this.usageLimit = usageLimit;
	}
	
	@Override
	public boolean matches(Connection c) 
	{
		// TODO Auto-generated method stub
		return (c.getUsage() > usageLimit);
	}
	
	

}
