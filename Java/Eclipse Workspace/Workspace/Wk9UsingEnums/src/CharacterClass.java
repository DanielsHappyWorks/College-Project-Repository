
public enum CharacterClass 
{
	//(attack, Magic/Physical, SpecialAbility)
	Warrior(500, false, "Dragon Force"),
	Mage(400, true, "Fire Dragon Roar"),
	Healer(250, true, "9000 Hp Heal");
	
	private int attack;
	private boolean attackType;
	private String specialAbility;
	
	private CharacterClass(int attack, boolean attackType, String specialAbility)
	{
		this.attack =attack;
		this.attackType = attackType;
		this.specialAbility = specialAbility;
	}

	public int getAttack() {
		return attack;
	}

	public boolean isAttackType() {
		return attackType;
	}

	public String getSpecialAbility() {
		return specialAbility;
	}
	
}
