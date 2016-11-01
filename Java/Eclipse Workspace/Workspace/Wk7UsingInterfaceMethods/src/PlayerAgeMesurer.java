
public class PlayerAgeMesurer implements IMesurer {

	public double getValue(Object obj) {
		SimCard p = (SimCard)obj;
		
		return p.getPinNumber();
	}

}
