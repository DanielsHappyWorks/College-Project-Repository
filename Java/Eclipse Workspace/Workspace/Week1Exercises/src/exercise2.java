
public class exercise2 {
	public static void main(String[] args){
		exercise2 theApp = new exercise2();
		theApp.start();
	}
	public void start(){
		int value=9;
		int position=3;
		boolean bitValue  = false;
	//	boolean bitValue = isSet(value,position);
//		System.out.println("The bit is set to: " +bitValue);
		int newValue=setBit(value,position,bitValue);
		System.out.println("The new value is: "+newValue);
	}
	public boolean isSet(int value, int position){
		//returns true if a bits position is set (equals to 1)
			int mask = 1 << position;
			int result = value & mask;
			return (result > 0);//can use if statement for return
	}
	public int setBit(int value,int position, boolean bitValue){
		int mask = 1 << position;
		if(bitValue){
			return  value | mask;
		}
		else{
			mask = ~mask; 
			return  value & mask;
		}
	}
}

//it broke