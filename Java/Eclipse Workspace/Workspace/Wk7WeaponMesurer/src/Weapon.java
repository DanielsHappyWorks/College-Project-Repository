
public class Weapon 
{
	private String name;
	private int clipSize;
	private int damageRate;
	

	public Weapon(String name, int clipSize, int damageRate) {
	//	super();
		this.name = name;
		this.clipSize = clipSize;
		this.damageRate = damageRate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getClipSize() {
		return clipSize;
	}
	public void setClipSize(int clipSize) {
		this.clipSize = clipSize;
	}
	public int getDamageRate() {
		return damageRate;
	}
	public void setDamageRate(int damageRate) {
		this.damageRate = damageRate;
	}
	@Override
	public String toString() {
		return "Weapon [name=" + name + ", clipSize=" + clipSize + ", damageRate=" + damageRate + "]";
	}
	
	
	

}
