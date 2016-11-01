import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;
// to do improve method names and make generic

public final class StackUtility {

	public static void popAndPrint(Stack<String> stack){
		while(!stack.empty()){
			System.out.println(stack.pop()+",");
		}
	}
	
	public static Stack<String> popAndPush(Stack<String> source){
		Stack<String> dest = new Stack<String>();
		while(!source.empty()){
			dest.push(source.pop());
		}
		return dest;
	}
	
	public static Stack<String> addInRange(int lo, int hi){
		Stack<String> stack = new Stack<String>();
		
		for(int i=lo; i<=hi; i++){
			stack.push(Character.toString((char)i));
		}
		return stack;
	}
	public static void leaveTheParty(Stack<String> drive,Stack<String> street, String target){
		boolean bContinue = false;
		while(!drive.empty() || bContinue){
			String str = drive.pop();
			if(!str.equalsIgnoreCase(target)){
				street.push(str);
			}
			else{
				System.out.println("Bye "+str+"!");
				bContinue = false;
			}
		}
		while(!street.empty()){
			drive.push(street.pop());
		}
	}
	public static void leaveTheParty(Stack<String> drive, String target){
		Stack<String> street = new Stack<String>();
		 leaveTheParty(drive,street,target);
	}
	public static void sort(Stack<String> stack, Comparator<String> comp){
		ArrayList<String> list = new ArrayList<String>();
		list.addAll(stack); //???
		
		//clear stcak
		stack.clear();
		
		//sort list
		Collections.sort(list,comp);
		
		//repopulate stack
		for(String s : list){
			stack.push(s);
		}
	}
	public static boolean compare(Stack<String> a, Stack<String> b) {
		if (a.size() != b.size()){
			return false;
		}
		while(!a.empty()){
			if(!a.pop().equals( b.pop())){
				return false;
			}
		}
		return true;
	}

	public static Stack<String> interleave(Stack<String> a, Stack<String> b) {
		Stack<String> dest = new Stack<String>();
		if (a.size() != b.size()){
			return null;
		}
		int sizeOut = a.size() * 2;
		for(int i=0; i<sizeOut; i++){
			if(i%2==0){
				dest.push(b.pop());
			}
			else{
				dest.push(a.pop());
			}
		}
		return dest;
	}
	
}
