public class StringLengthMeasurer implements IMeasurer<String>{

	@Override
	public double getValue(String str) {
		return str.length();
	}

}
