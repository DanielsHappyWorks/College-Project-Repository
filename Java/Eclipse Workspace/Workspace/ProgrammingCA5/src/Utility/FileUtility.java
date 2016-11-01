package Utility;

import java.io.File;
import java.io.IOException;

import Controller.ShowManager;
import View.MainApp;

public class FileUtility {
	public static boolean open(String path, String name, String permissions)
	{
		File file = new File(path,name);
	    if(file.exists() ){
	    	MainApp.manager = new ShowManager(path , name , permissions);
	    	return true;
	    }
	    else{
	    	System.out.println("File or path does not exist");
	    	return false;
	    }
	}
	
	public static boolean create(String path, String name)
	{
		try {
			File folder = new File(path);
			if(folder.exists() == false){
				folder.mkdirs();
			}

			 File file = new File(path,name);
			 if(file.exists() == false){
				 file.createNewFile();
				 System.out.println("The file was created");
				 return true;
			 }
			 else{
				 System.out.println("The file already exists or wrong path/file name was entered!");
				 return false;
			 }
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean delete(String path, String name)
	{
		File file = new File(path, name);
	    if(file.exists() ){
	    	file.delete();
	    	System.out.println("The file was deleated");
	    	return true;
	    }
	    else{
	    	System.out.println("File or path does not exist");
	    	return false;
	    }
	}
}