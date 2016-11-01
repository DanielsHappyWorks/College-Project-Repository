
public class MainApp {
	String data;
	String regex;
	
	public static void main(String args[]){
		MainApp thisApp = new MainApp();
		thisApp.start();
	}

	public void start() {
		question2i();
	}
	
	public void matches(String d,String r){
		if(d.matches(r)){
			System.out.println("Matches!!!");
		}
		else{
			System.out.println("Doesn't Match");
		}
	}
	
	public void question1() {
		//regex has to match 0,01 or 111
		data = "11";
		regex = "[0]{1}|[0]{1}[1]{1}|[1]{3}";
		
		matches(data,regex);
	}
	
	public void question2a() {
		//regex has to match all binary strings
		data = "10101";
		regex = "[0-1]{0,}";
		
		matches(data,regex);
	}
	
	public void question2b() {
		//regex has to match except an empty string
		data = "1010101";
		regex = "[0-1]{1,}";
		
		matches(data,regex);
	}
	
	public void question2c() {
		//regex beging with 1 and ends with 1
		data = "101";
		regex = "[1]{1}[0-1]{0,}[1]{1}";
		
		matches(data,regex);
	}
	
	public void question2d() {
		//regex ends with 00
		data = "00100";
		regex = "[0-1]{0,}[0]{2}";
		
		matches(data,regex);
	}
	
	public void question2e() {
		//regex has 3 1s in it
		data = "10011";
		regex = "[0-1]{0,}1[0-1]{0,}1[0-1]{0,}1[0-1]{0,}";
		
		matches(data,regex);
	}
	
	public void question2f() {
		//regex has 3 consecutive 1s in it
		data = "0011100";
		regex = "[0-1]{0,}[1]{3}[0-1]{0,}";
		
		matches(data,regex);
	}
	
	public void question2g() {
		//regex has substring 110
		data = "0011100";
		regex = "[0-1]{0,}110[0-1]{0,}";
		
		matches(data,regex);
	}
	public void question2h() {
		//regex has substring 1101100
		data = "00111011000";
		regex = "[0-1]{0,}1101100[0-1]{0,}";
		
		matches(data,regex);
	}
	public void question2i() {
		//regex has at least 4 characters 3rd is 0 
		data = "00011111";
		regex = "[0-1]{2}0[0-1]{1,}";
		
		matches(data,regex);
	}
	
	public void question3() {
		//regex has 4 H and one on a liscence plate
		data = "04 MH 231";
		regex = "";
		
		matches(data,regex);
	}
}
