import java.util.Random;

public class MainApp {
	public static void main(String[] args){
		MainApp theApp = new MainApp();
		theApp.start();
	}
	
	public void start()
{
		//demoIntroArrays();
		//exercise6_1();
		exercise6_2();
	}
	
	public void demoIntroArrays() 
	{
		int[] ageArray=new int[6];
		
		System.out.println("ageArray: " + ageArray);
		
		ageArray[0] = 19;
		ageArray[1] = 20;
		ageArray[2] = 21;
		ageArray[3] = 30;
		ageArray[4] = 17;
		ageArray[5] = 35;
		
		ArrayUtility.printArray("Age",ageArray,false);
		String[] lol = {"ggnore","~fork"};
		ArrayUtility.printArray("LEL",lol,true);
		/*
		System.out.println("Array printed forward");//prints array forward
		for(int i = 0; i < ageArray.length; i++){
			System.out.println(ageArray[i]);
		}

		System.out.println("Array printed backwards");//prints array backwards
		for(int i = ageArray.length-1; i >= 0; i--){
			System.out.println(ageArray[i]);
		}

		System.out.println("Even positions ");//prints out every even positions
		for(int i = 0; i < ageArray.length; i++){//can be done using i=i+2 or using the modulus
			if(i%2==0){
				System.out.println(ageArray[i]);
			}
		}*/
	}
	public void exercise6_1()
	{
		//initialises random number generator and array
		int[] theArray = new int[10]; 
		Random number = new Random();
		
		//generates and assigns random numbers
		for(int i = 0; i < theArray.length; i++)
		{
			theArray[i] = number.nextInt(10) + 1;
		}
		
		//finds and prints all elements with an even index
		System.out.print("Even Index: ");
		for(int i = 0; i < theArray.length; i++)
		{
			if(i%2==0)
			{
			System.out.print("theArray["+i+"]: "+theArray[i]+" ");
			}
		}
		System.out.println();
		
		//prints every even element
		System.out.print("Even Elements: ");
		for(int i = 0; i < theArray.length; i++)
		{
			if(theArray[i]%2==0)
			{
			System.out.print("theArray["+i+"]: "+theArray[i]+" ");
			}
		}
		System.out.println();
		
		//prints all elements in reverse order
		System.out.print("Backwards: ");
		for(int i = theArray.length-1; i >= 0; i--)
		{
			System.out.print("theArray["+i+"]: "+theArray[i]+" ");
		}
		System.out.println();
		
		//only first and last element
		System.out.print("First and Last elements: ");
		System.out.print("theArray["+0+"]: "+theArray[0]+" ");
		System.out.print("theArray["+(theArray.length-1)+"]: "+theArray[theArray.length-1]+" ");
	}
	public void exercise6_2()
	{
			//initialises array
			int[] theArray = new int[8]; 
			theArray[0] = 10;
			theArray[1] = 12;
			theArray[2] = 19;
			theArray[3] = 18;
			theArray[4] = 46;
			theArray[5] = 20;
			theArray[6] = 24;
			theArray[7] = 24;
			
			//exercise6_2a(theArray);
			//exercise6_2b(theArray);
			//exercise6_2c(theArray);
			//exercise6_2d(theArray);
			//exercise6_2e(theArray);
			//exercise6_2f(theArray);
			//exercise6_2g(theArray);
			//boolean anwser = exercise6_2h(theArray);
			//boolean anwser = exercise6_2i(theArray);
			boolean anwser = exercise6_2j(theArray);
			System.out.println(anwser);
				
	}
	//swap the first and last elements in the array
	public void exercise6_2a(int[] theArray)
	{
		int firstElement; 
		int lastElement;

		firstElement = theArray[0];
		lastElement = theArray[(theArray.length-1)];
		
		theArray[0] = lastElement;
		theArray[(theArray.length-1)] = firstElement;
		
		for(int i = 0; i < theArray.length; i++){
			System.out.println(theArray[i]);
		}
	}
	//shift all elements by one to the right and move the last element into the first position
	public void exercise6_2b(int[] theArray)
	{
		int lastElement;
		
		lastElement = theArray[(theArray.length-1)];
		
		for(int i = (theArray.length-1); i > 0; i--){
			theArray[i]=theArray[i-1];
		}
		
		theArray[0] = lastElement;
		
		for(int i = 0; i < theArray.length; i++){
			System.out.println("theArray["+i+"]"+theArray[i]);
		}
	}
	//replace all even elements with 0
	public void exercise6_2c(int[] theArray)
	{
		for(int i = 0; i < theArray.length; i++){
			if(theArray[i]%2==0){
				theArray[i]=0;
			}
			System.out.println("theArray["+i+"]"+theArray[i]);
		}
	}
	//replace each element except the first and the last by the larger of its two neighbors
	public void exercise6_2d(int[] theArray)
	{
		int[] theArray2 = new int[theArray.length];
		//sets the arrays to be the same
		for(int i = 0; i < theArray.length; i++){
				theArray2[i] = theArray[i];
			}
		//starts at second position (is 1) and finishes on second last , changes value id neighbour is bigger then the number
		for(int i = 1; i < theArray.length-1; i++){
			if(theArray[i-1]>theArray[i]){
				theArray2[i] = theArray[i-1];
			}
			else if(theArray[i+1]>theArray[i]){
				theArray2[i] = theArray[i+1];
			}
		}
		//sets the changed values into original array
		for(int i = 0; i < theArray.length; i++){
			theArray[i] = theArray2[i];
		}
		//prints result
		for(int i = 0; i < theArray.length; i++){
			System.out.println("theArray["+i+"] = "+theArray[i]);
		}
	}
	//remove the middle element if array length is odd and two middle elements if element is even NOT WORKING
	public void exercise6_2e(int[] theArray)
	{
		//checks if even
		if(theArray.length%2==0){
			
		}
		else{
			
		}
		
		//prints result
		for(int i = 0; i < theArray.length; i++){
			System.out.println("theArray["+i+"] = "+theArray[i]);
		}
	}
	//move all even elements to front otherwise preserving the order NOT WORKING
	public void exercise6_2f(int[] theArray)
	{
		
		//prints result
		for(int i = 0; i < theArray.length; i++){
			System.out.println("theArray["+i+"] = "+theArray[i]);
		}
	}
	//return the second largest element in the array
	public void exercise6_2g(int[] theArray)
	{
		int largestElement= Integer.MIN_VALUE;
		int secondLargestElement = Integer.MIN_VALUE;
		
		for(int i = 0; i < theArray.length; i++){
			if(theArray[i]>largestElement){
				largestElement = theArray[i];
			}
		}
		
		for(int i = 0; i < theArray.length; i++){
			if(theArray[i]<largestElement && theArray[i]>secondLargestElement){
				secondLargestElement = theArray[i];
			}
		}
		System.out.println("The second largest element is: "+secondLargestElement);
	}
	//return true if the array is sorted in increasing order
	public boolean exercise6_2h(int[] theArray)
	{
		boolean output;
		int count=0;
		for(int i = 0; i < theArray.length-1; i++){
			if(theArray[i]==theArray[i+1]){
				count++;
			}
		}
		if(count==0){
			output=false;
		}
		else{
			output=true;
		}
		return output;
	}
	//Return true if contains two adjacent duplicate elements
	public boolean exercise6_2i(int[] theArray)
	{
		boolean output;
		int count=0;
		for(int i = 0; i < theArray.length-1; i++){
			if(theArray[i]==theArray[i+1]){
				count++;
			}
		}
		if(count != 0){
			output = true;
		}
		else{
			output = false;
		}
		return output;
	}
	//Return true if contains two of the same elements that dont need to be adjacent to eachother
	public boolean exercise6_2j(int[] theArray)
	{
		boolean output;
		int count=0;
		for(int i = 0; i < theArray.length; i++){
			for(int j = 0; j < theArray.length; j++){
				if(theArray[i]==theArray[j]){
					count++;
				}
			}
		}
		if(count <= theArray.length){
			output = false;
		}
		else{
			output = true;
		}
		return output;
	}
}