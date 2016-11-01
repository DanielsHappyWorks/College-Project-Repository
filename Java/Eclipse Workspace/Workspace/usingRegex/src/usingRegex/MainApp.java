package usingRegex;

import java.util.ArrayList;

public class MainApp {
	public static void main(String[] args){
		MainApp theApp = new MainApp();
		theApp.start();
	}

	private void start() {
		Question1();
	}
	private void Question1() {
		String data = "dhsfidshfsdkjhf 0.34 dsgdas5.34";
		String regex = "[0-9]{1,3}\\.[0-9]{1,2}";
		
		ArrayList<String> rList = new ArrayList<String>();
		
		rList = RegexUtility.apply(data, regex, 0);
		System.out.println(rList);
		
	}
}