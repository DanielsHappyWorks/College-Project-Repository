
public class AttackFilter implements IFilter{
		private double attack;
		public AttackFilter(int attack)
		{
			this.attack = attack;
		}
		
		public boolean matches(Object obj) 
		{
			CharacterClass c = (CharacterClass)obj;
			return (c.getAttack() < attack) ? true : false;
		}
}
