public class CharacterClass {
	
	private String name;
	private int attack;
	private int defence;
	private attackType type;
	
	public CharacterClass(String name, int attack, int defence, attackType type) {
		this.name = name;
		this.attack = attack;
		this.defence = defence;
		this.type = type;
	}

	public attackType getType() {
		return type;
	}

	public void setType(attackType type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getDefence() {
		return defence;
	}

	public void setDefence(int defence) {
		this.defence = defence;
	}

	@Override
	public String toString() {
		return "CharacterClass [name=" + name + ", attack=" + attack + ", defence=" + defence + ", type=" + type + "]";
	}
	
	
	
}
