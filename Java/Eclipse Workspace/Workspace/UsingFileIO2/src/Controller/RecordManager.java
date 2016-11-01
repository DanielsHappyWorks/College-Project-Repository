package Controller;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import Model.Record;

public class RecordManager 
{
	private File file;
	private String strName;
	private String strPath;
	private DataOutputStream dos;
	private DataInputStream dis;

	//constructor
	public RecordManager(String strPath, String strName)
	{
		//regex tests?
		this.strPath = strPath;
	    this.strName = strName;
	    
	    File folder = new File(strPath);
	    if(folder.exists() == false)
	    	folder.mkdirs();
	    
	    this.file = new File(strPath + strName);
	}
	
	//open
	public boolean open(int bufferSize, boolean bAppend) 							
	{
		try 
		{
			//null checks?
			if(this.dos == null) //not already open?
				this.dos = new DataOutputStream(new BufferedOutputStream(
					new FileOutputStream(this.file, bAppend), bufferSize));
			
			if(this.dis == null) //not already open?
			this.dis = new DataInputStream(new BufferedInputStream(
					new FileInputStream(this.file), bufferSize));
					
			//mark the start of the file for all subsequent calls to reset - see print()
			if(this.dis.markSupported()){
				this.dis.mark(0);
			}
			
			return true;
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace(); //how am i handling the error?
			return false;
		}	
	}
	
	//close
	public boolean close()
	{
		try
		{
			if(this.dos != null)
			{
				//this.dos.flush();
				this.dos.close();
				this.dos = null;
			}
			if(this.dis != null)
			{
				this.dis.close();
				this.dis = null;
			}
			return true;
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return false;
	}
	
	
	//read and write record
	public Record read()
	{
		return Record.read(this.dis);
	}
	
	public void write(Record r)
	{
		r.write(this.dos);
		try 
		{
			this.dos.flush();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	//size
	public int size()
	{
		return (int)this.file.length()/Record.Size;
	}
	
	//print
	public void print()
	{	
		try 
		{
			//reset the read pointer to the start of file (SOF)
			//make sure that we marked the start by calling mark()
			this.dis.reset();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		//get record count
		int recordCount = this.size();
		Record r = null;
		
		//iterate through and print
		for(int i = 0; i < recordCount; i++)
		{
			r = read();
			System.out.println(r);
		}
	}
	
	//delete all
	
	//find
	
	//edit, delete
}
