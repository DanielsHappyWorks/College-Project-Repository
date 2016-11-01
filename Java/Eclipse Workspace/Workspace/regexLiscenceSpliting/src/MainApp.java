import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainApp {
	
	public static void main(String[] args){
		MainApp theApp = new MainApp();
		theApp.start();
	}
	
	String[] ccArray = {"C","CE","CN","CW","D","DL","G","KE","KK","KY","L","LD","LH","LK","LM","LS","MH","MN","MO","OY","RN","SO","TN","TS","W","WD","WH","WX","WW"};
	
	public void start(){
		//StringBuilder object to store data from file
		StringBuilder data=null;
		//try to read the file
		try
		{
		//read data from file
		data = FileUtility.load("licenseplates.csv", "");
		}
		//catch any errors that occur
		catch(Exception e)
		{
		//error message to tell user that something bad happened!
			System.out.println("Error");
		}
		//convert data in StringBuilder to String object
		String myData = data.toString();
		//apply your regular expressions...
		/*
		String regexYear = "((0[0-9]{1})|([0-9]{1}0))";//the year contains a 0
		String regexCounty = "(W([A-Z]{1})|([A-Z]{1})W)";//contains W
		String regexNumber = "([2-9]{0,5}1[2-9]{0,5})";//must contain a 1
		
		String regex;
		String[] dArray = myData.split(",");
		
		ArrayList<String> newList = new ArrayList<String>();
		
		for(int i=0; i<dArray.length; i++){
			for(int j=0; j<ccArray.length; j++){
					if(ccArray[j].matches(regexCounty)){
						
						regex = regexYear + ccArray[j] + regexNumber;
				
						if(dArray[i].matches(regex)){
							newList.add(dArray[i]);
				}
				}
				
			}
		}
		System.out.println(newList);
		*/
		String[] dArray = myData.split(",");
		String regex = "((0[0-9]{1})|([0-9]{1}0))([A-Z]{1,2})([1-9]{3,5})";
		String dataPlates;
		ArrayList<String> searchedArray= new ArrayList<String>();
		
		for(int i=0; i<dArray.length; i++){
			dataPlates = dArray[i];
			Pattern pattern = Pattern.compile(regex);
			Matcher match = pattern.matcher(dataPlates);
			
			while(match.find()){
				searchedArray.add(dataPlates);
			}
		}
		System.out.println(searchedArray);
	}
}
