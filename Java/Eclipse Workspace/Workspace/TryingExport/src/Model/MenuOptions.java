package Model;
import java.util.ArrayList;
import java.util.List;
import Utility.ScannerUtility;

/**
 * This class stores and shows menu options. It does not need to be modified by you. 
 * See MainApp::initialiseMenus() for usage
 * @author NMCG
 * @version 1.0
 *
 */
public class MenuOptions 
{
	private static String MenuHeaderBorder = " *************************** ";
	
	private String name; 					//used for the header of the menu
	private int indexOfExitOption; 			//indicates which menu choice is exit
	private List<String> list;				//stores all the menu strings

	public MenuOptions(String name, int indexOfExitOption) 
	{
		this.name = name;
		this.indexOfExitOption = indexOfExitOption;
		this.list = new ArrayList<String>();
	}
	
	//used to show the menu and get the users choice - repeats if outside correct range
	public int showMenuGetChoice(String strPrompt)
	{
		if(this.list.size() == 0)
			return -1;
		
		System.out.println("\n" + MenuHeaderBorder + this.name + MenuHeaderBorder + "\n");
		
		
		int index = 1; //note we start the menu options at 1 - so valid range for choices is 1 -> list.size()
		for(String s : this.list)
		{
			System.out.println("[" + index + "] " + s);
			index++;
		}
		//obviously the user has to pick a valid option in the range
		int choice = ScannerUtility.getInt(strPrompt, 1, this.list.size());
		return choice;
	}
	
	//add, size, clear
	public boolean add(String s)
	{
		//if it is not in the list then add it
		if(!this.list.contains(s))
		{
			this.list.add(s);
			return true;
		}
		return false;
	}	
	public boolean addAll(String[] sArray)
	{
		boolean success = false;
		
		for(String s : sArray)
		{
			success = add(s);
		}
		
		return success;
	}
	public int size()
	{
		return this.list.size();
	}
	public void clear()
	{
		this.list.clear();
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIndexOfExitOption() {
		return indexOfExitOption;
	}

	public void setIndexOfExitOption(int indexOfExitOption) {
		this.indexOfExitOption = indexOfExitOption;
	}
}