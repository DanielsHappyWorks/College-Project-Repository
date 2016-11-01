
public class Connection //Broadband user connection data
{
	private String name;
	private double usage;
	private int subscriptionType;
	//other related fields/attributes
	
	public Connection(String name, double usage, int subscriptionType) {
		super();
		this.name = name;
		this.usage = usage;
		this.subscriptionType = subscriptionType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getUsage() {
		return usage;
	}

	public void setUsage(double usage) {
		this.usage = usage;
	}

	public int getSubscriptionType() {
		return subscriptionType;
	}

	public void setSubscriptionType(int subscriptionType) {
		this.subscriptionType = subscriptionType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + subscriptionType;
		long temp;
		temp = Double.doubleToLongBits(usage);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Connection other = (Connection) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (subscriptionType != other.subscriptionType)
			return false;
		if (Double.doubleToLongBits(usage) != Double.doubleToLongBits(other.usage))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Connection [name=" + name + ", usage=" + usage + ", subscriptionType=" + subscriptionType + "]";
	}
	
	

}
