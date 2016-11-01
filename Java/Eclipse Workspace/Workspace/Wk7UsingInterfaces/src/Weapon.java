
public class Weapon implements IMesurable{
	private String name, PlayerClass;
	private int weaponId;
	
	public Weapon(String name, String playerClass, int weaponId) {
		super();
		this.name = name;
		PlayerClass = playerClass;
		this.weaponId = weaponId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPlayerClass() {
		return PlayerClass;
	}

	public void setPlayerClass(String playerClass) {
		PlayerClass = playerClass;
	}

	public int getWeaponId() {
		return weaponId;
	}

	public void setWeaponId(int weaponId) {
		this.weaponId = weaponId;
	}

	public String toString() {
		return "Weapon [name=" + name + ", PlayerClass=" + PlayerClass + ", weaponId=" + weaponId + "]";
	}

	public boolean equals(Object obj)
	{
		if (obj == null)
			return false;
		if(obj instanceof Weapon)
		{
			Weapon wep = (Weapon)obj;
			return this.weaponId == wep.weaponId;
		}
		return false;
		
	}
	
	@Override
	public double getValue() {
		return this.weaponId;
	}
	
	
}
