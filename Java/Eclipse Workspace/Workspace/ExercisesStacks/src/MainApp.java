import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;

public class MainApp {
	
	public static void main(String[] args) {
		MainApp theApp = new MainApp();
		theApp.start();
	}

	public void start() {
		//ex1();//A-Z
		//ex3();//driveway
		//ex4();//sort
		//ex5();//compare
		ex6();//interleave
	}
	private void ex1(){
		Stack<String> source = StackUtility.addInRange(65,90);
		Stack<String> dest = StackUtility.popAndPush(source);
		StackUtility.popAndPrint(dest);
	}
	private void ex3(){
		Stack<String> drive = new Stack<String>();
		Stack<String> street = new Stack<String>();

		drive.push("Alan");
		drive.push("Bob");
		drive.push("Ciara");
		drive.push("Danielle");
		
		StackUtility.leaveTheParty(drive,street, "Ciara");
		StackUtility.popAndPrint(drive);
	}
	private void ex4(){
		Stack<String> stack = new Stack<String>();

		stack.push("Alan");
		stack.push("Bob");
		stack.push("steve");
		stack.push("Ciara");
		stack.push("Danielle");
		
		StackUtility.sort(stack, new StringComparator());
		StackUtility.sort(stack, new StringLengthComparator());
		
		StackUtility.popAndPrint(stack);
		
	}
	private void ex5(){
		Stack<String> a = new Stack<String>();
		Stack<String> b = new Stack<String>();

		a.push("Alan");
		a.push("Bob");
		a.push("Ciara");
		a.push("Danielle");
		
		b.push("Bob");
		b.push("Danielle");
		b.push("Ciara");
		b.push("Alan");
		
		StackUtility.sort(a, new StringComparator());
		StackUtility.sort(b, new StringComparator());
		
		boolean bEqual = StackUtility.compare(a,b);
		System.out.println("Stack equal: "+bEqual);
	}
	private void ex6(){
		Stack<String> a = new Stack<String>();
		Stack<String> b = new Stack<String>();

		a.push("A");
		a.push("B");
		a.push("C");
		a.push("D");
		
		b.push("1");
		b.push("2");
		b.push("3");
		b.push("4");
		
		Stack<String> interStack = StackUtility.interleave(a,b);
		
		StackUtility.popAndPrint(interStack);
	}
}