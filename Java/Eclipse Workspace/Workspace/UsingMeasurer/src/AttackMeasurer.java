
public class AttackMeasurer implements IMeasurer{

	@Override
	public double getValue(Object obj) {
		CharacterClass c = (CharacterClass)obj;
		return c.getAttack();
	}

}
