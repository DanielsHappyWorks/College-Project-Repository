package usingRegex;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Provides common regex related methods e.g. match, print
 * @author  NMCG
 * @version 1.0
 */
public class RegexUtility 
{
	
	/**
	 * Apply the regex provided to the string, returning an ArrayList of 
	 * strings which match the groupNumber specified
	 * @param data Source string
	 * @param regex Regex to be applied
	 * @param groupNumber Group number within the regex
	 * @return ArrayList of all matching strings
	 */
	public static ArrayList<String> apply(
			String data, String regex, int groupNumber)
	{
		if((data == null) || (data.length() == 0))
			return null;
		
		if((regex == null) || (regex.length() == 0))
			return null;
		
		if(groupNumber < 0)
			return null;
		
		Pattern pattern = Pattern.compile(regex);
		Matcher match = pattern.matcher(data);
		
		ArrayList<String> resultList = new ArrayList<String>();
		
		while(match.find())
		{
			resultList.add(match.group(groupNumber));
		}			
		return resultList;
	}
	
	/**
	 * Apply the compiled regex provided to the string, returning an ArrayList of 
	 * strings which match the groupNumber specified
	 * 
	 * Note: This represents a more efficient version of apply() since the pattern is pre-compiled and passed in
	 * Imagine if we called apply() thousands of times per second.
	 * Using the apply() method would result in the pattern being
	 * compiled each time - this would be very CPU intensive!
	 * 
	 * @param data Source string
	 * @param regex Regex to be applied
	 * @param groupNumber Group number within the regex
	 * @return ArrayList of all matching strings
	 */
	public static ArrayList<String> apply(
			String data, Pattern pattern, int groupNumber)
	{
		if((data == null) || (data.length() == 0))
			return null;
		
		if(pattern == null)
			return null;
		
		if(groupNumber < 0)
			return null;
		
	//	Pattern pattern = Pattern.compile(regex);
		Matcher match = pattern.matcher(data);
		
		ArrayList<String> resultList = new ArrayList<String>();
		
		while(match.find())
		{
			resultList.add(match.group(groupNumber));
		}			
		return resultList;
	}
}