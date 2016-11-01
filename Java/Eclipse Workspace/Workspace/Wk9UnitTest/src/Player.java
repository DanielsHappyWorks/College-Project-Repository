public class Player
{
	public static final String game = "Fallout 4";
	
	//instance variables
	private String name;
	private int health;
	private int x, y, z; //position
	
	public Player(String name, int health, 
			int x, int y, int z) 
	{
		this.name = name;
		this.health = health;
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public Player(String name, int health) 
	{
		this(name, health, 0, 0, 0);
/*
		this.name = name;
		this.health = health;
		this.x = 0;
		this.y = 0;
		this.z = 0;
*/
	}
	
	public void moveTo(int x, int y, int z)
	{
		this.x = x; 
		this.y = y; 
		this.z = z;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getZ() {
		return z;
	}

	
	@Override
	public String toString() {
		return "Player [name=" + name + ", health=" + health + ", x=" + x + ", y=" + y + ", z=" + z + "]";
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		
		if (obj == null)
			return false;
		
		if (getClass() != obj.getClass())
			return false;
		
		Player other = (Player) obj;
		if (health != other.health)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		if (z != other.z)
			return false;
		return true;
	}
	
	
	
	

	
	

}
