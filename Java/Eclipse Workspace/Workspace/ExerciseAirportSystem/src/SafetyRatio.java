
public enum SafetyRatio {
	Conservative(0.8),
	Moderate(0.9),
	Risky(0.95);
	
	private double value;
	
	private SafetyRatio(double value){
		this.value = value;
	}
	
	public float getValue(){
		return (float)this.value;
	}
}
