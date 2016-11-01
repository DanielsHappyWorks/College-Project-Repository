/**
 * Provides suggestion solutions to a selection of the Regex exercises listed in the notes.
 * @author  NMCG
 * @version 1.0
 */
 
import java.util.ArrayList;

public class MainApp 
{
	public static void main(String[] args) 
	{
		MainApp theApp = new MainApp();
		theApp.start();
	}

	private void start() 
	{
		//ex1 - 0|01|111		
		ex2a();
	    ex2e();
		ex2i(); 
		ex3();
		ex4();
		ex6();
		ex10();
		ex11();
		ex14();
		ex15();
		ex15a();
		additionalEx10();
	}

	private void ex2a() 
	{
		String data = "10101010111";
		String regex = "[10]+";  //or LAZY and look for 1 i.e. [01]+?
		ArrayList<String> rList 
				= RegexUtility.apply(data, regex, 0);		
		System.out.println(rList);
	}
	
	private void ex2e() 
	{
		String data = "00110000111";
		String regex = "[01]*111[01]*";  
		ArrayList<String> rList 
				= RegexUtility.apply(data, regex, 0);		
		System.out.println(rList);
	}
	
	private void ex2i() 
	{
		String data = "1101";
		String regex = "[01]{2}0[01]+";  
		ArrayList<String> rList 
				= RegexUtility.apply(data, regex, 0);		
		System.out.println(rList);
	}
	
	private void ex3() 
	{
		String data = "04MH213";//31";
		String regex = "([0-9]4|4[0-9])"
						+ "(H[A-Z]|[A-Z]H)"
						+ "(1[0-9]{2}"
						+ "|[0-9]1[0-9]"
						+ "|[0-9]{2}1)"; 
		
		ArrayList<String> rList 
				= RegexUtility.apply(data, regex, 0);		
		System.out.println(rList);
	}
	
	private void ex4() 
	{
		String data = "talkbljcg";
		String regex = "\\b[d-z]*a"
						+ "[d-z]*b"
						+ "[d-z]*c"
						+ "[d-z]*\\b"; 
		
		ArrayList<String> rList 
				= RegexUtility.apply(data, regex, 0);		
		System.out.println(rList);
	}
	
	private void ex6() 
	{
		String data = "this is a	tab";
		String regex = "\\t";  //or we can use "[\t]" 
		String replacement = " ";
		
		data = data.replaceAll(regex, replacement);
		System.out.println(data);
	}
	
	private void ex10() 
	{
		String data = "arkansas";
		String regex = "\\b[aeiou][a-z]*\\b"; 
		
		ArrayList<String> rList 
				= RegexUtility.apply(data, regex, 0);		
		System.out.println(rList);
	}
	
	private void ex11() 
	{
		String data = "I walked and talked with Ted.";
		String regex = "\\b[a-z]{1,}ed\\b"; 
		
		ArrayList<String> rList 
				= RegexUtility.apply(data, regex, 0);		
		System.out.println(rList);
	}
	
	private void ex14() 
	{
		String data = "John's number is +(353)42-9312345"
				+ " and Maeve's is 42-9354321.";
		
		String regex = "(\\+\\(353\\)){0,1}"  //note the use of '\\' to indicate we are looking for '(', ')', and '+'
							+ "[0-9]{2}"
							+ "-"
							+ "[0-9]{7}"; 
		
		ArrayList<String> rList 
				= RegexUtility.apply(data, regex, 0);		
		System.out.println(rList);
	}
	
	
	private void ex15() 
	{
		String data = "<a href='https://www.dkit.ie/'/>"
				+ "<b>bla bla bla</b>"
				+ "<a href='https://www.ibm.com/'/>";
		
		/*
		 * Note the use of the ? to make the quantifier (i.e. + which means {1,}) lazy rather than greedy).
		 * Greedy means that the RegEx will try to find the longest match in the string, lazy means is will stop at the smallest match.
		 * Remove the ? and run the code. Notice how it now runs all the way to the last ' found in the string data.
		 */
		String regex = "href='(.+?)'";  
		
		ArrayList<String> rList 
				= RegexUtility.apply(data, regex, 1);		
		System.out.println(rList);
	}
	
	//A slight variation on ex15 which shows how to use the ? to make the 's' of https optional
	private void ex15a() 
	{
		String data = "<a href='https://www.dkit.ie/'/>"
				+ "<b>bla bla bla</b>"
				+ "<a href='http://www.ibm.com/'/>";
		
		String regex = "https?://(.+?)/"; 
		
		ArrayList<String> rList 
				= RegexUtility.apply(data, regex, 1);		
		System.out.println(rList);
	}
	
	/************************** Additional Exercises **************************/
	
	public void additionalEx10()
	{
		String data = "sendmail%john@hotmail.com%bob@gmail.com%"
				+ "hi%how are you? lunch at 1 J.";
		
		String msgArray[] = data.split("%");
		
		for(int i = 0; i < msgArray.length; i++)
			System.out.println(msgArray[i]);
		
		Message m = new Message(msgArray[1], 
				msgArray[2], msgArray[3], msgArray[4]);
		System.out.println(m);
	}	
}







