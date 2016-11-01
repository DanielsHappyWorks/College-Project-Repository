import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

public class MainApp {
	
	public static void main(String[] args) {
		MainApp theApp = new MainApp();
		theApp.start();
	}

	private void start() {
		//exercise1AtoG();
		exercise2SplittingNumbers();
	}

	private void exercise1AtoG() {
		Stack<String> stack = new Stack<String>();
		stack.add("a");
		stack.add("b");
		stack.add("c");
		stack.add("d");
		stack.add("e");
		stack.add("f");
		stack.add("g");
		
		stack = reverseStack(stack);
		popWholeStack(stack);
	}

	private <E> void popWholeStack(Stack<E> stack) {
		Iterator<E> iter = stack.iterator();
			
			while(iter.hasNext()){
				System.out.println(stack.pop());
			}
	}

	private <E> Stack<E> reverseStack(Stack<E> stack) {
		Iterator<E> iter = stack.iterator();
		Stack<E> stack1 = new Stack<E>();
		
		while(iter.hasNext()){
			stack1.add(stack.pop());
		}
		
		return stack1;
	}

	private void exercise2SplittingNumbers() {
		
		
		int number;
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter a number");
		number = input.nextInt();
		
		input.close();
		
		Stack<Integer> stack = new Stack<Integer>();
		while(number>0){
			stack.add(number%10);
			number = number/10;
		}
		
		ArrayList<Integer> array = stackToArray(stack);
		System.out.println(array);
	}

	private <E> ArrayList<E> stackToArray(Stack<E> stack) {
			Iterator<E> iter = stack.iterator();
			ArrayList<E> array = new ArrayList<E>();
			
			while(iter.hasNext()){
				array.add(stack.pop());
			}
			
			return array;
		}
}
