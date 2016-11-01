public class WeaponClipMeasurer implements IMeasurer
{
	public double getValue(Object obj)
	{
		Weapon w = (Weapon)obj;
		return w.getClipSize();
	}
}