
public class characterHeightMesurer implements IMeasurer {

	public double getValue(Object obj) {
		Character chr = (Character)obj;
		double value = chr.getHeight();
		return value;
	}

}
