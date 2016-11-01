package View;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import Controller.RecordManager;
import Model.Record;

public class MainApp 
{
	public static void main(String[] args) 
	{
		MainApp theApp = new MainApp();
		try 
		{
			theApp.start();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

	private void start() throws IOException 
	{
		String strPath = "";
		String strName = "";
		
		System.out.println("\n********* demoFileOutputStream & demoFileInputStream *********");
		strPath = "c:/temp/";
		strName = "myFileStream.txt";		
		demoFileOutputStream(strPath, strName);		
		demoFileInputStream(strPath, strName);	
		
		System.out.println("\n********* demoBufferedOutputStream & demoBufferedInputStream *********");
		strPath = "c:/temp/";
		strName = "myBufferedStream.txt";
		demoBufferedOutputStream(strPath, strName);
		demoBufferedInputStream(strPath, strName);
	
		System.out.println("\n********* demoDataOutputStream & demoDataInputStream *********");
		strPath = "c:/temp/";
		strName = "myDataStream.txt";
		demoDataOutputStream(strPath, strName);
		demoDataInputStream(strPath, strName);

		System.out.println("\n********* demoRecordManager *********");
		strPath = "c:/temp/";
		strName = "myRecordManager.txt";
		demoRecordManager(strPath, strName);	
	}
	
	
	private void demoRecordManager(String strPath, String strName) 
	{
		RecordManager rManager = new RecordManager(strPath, strName);
		
		//check how many, should be zero since we delete the file if already exists
		System.out.println("Size (just opened): " + rManager.size());
		
		//open the streams
		rManager.open(Record.Size, true);
		
		//write records with flush for each write
		rManager.write(new Record("Steve Murphy", 31, 11, 1955));
		rManager.write(new Record("Jessica Jones", 17, 2, 1990));
		rManager.write(new Record("Lukas M. Haas", 14, 1, 2001));
		
		//should obviously be three
		System.out.println("Size (after addition): " + rManager.size());
		
		//close
		rManager.close();	
		
		/********** Open and print some time later **********/
		//open the streams
		rManager.open(Record.Size, true);
		//print contents
		rManager.print();
		//close
		rManager.close();
	}

	
	private void demoDataOutputStream(String strPath, 
				String strName) throws IOException 
	{
		boolean bAppend = false;
		
		FileOutputStream fos 
				= new FileOutputStream(strPath + strName, bAppend);	
		BufferedOutputStream bos 
				= new BufferedOutputStream(fos, 1024);
		DataOutputStream dos
				= new DataOutputStream(fos);
			
		Record r = new Record("john", 14, 1, 1990);
		r.write(dos);
		
		
		/*
		dos.writeUTF("niall***"); //1 per char + 2 ctrl = 10
		dos.writeUTF("cuba****");  //1 per char + 2 ctrl = 10
		dos.writeInt(2016);    //int = 4
		*/
		
		dos.flush();		   //total = 10 + 10 + 4 = 24 bytes
		dos.close();
	}

	private void demoDataInputStream(String strPath, 
				String strName) throws IOException 
	{
		FileInputStream fis 
				= new FileInputStream(strPath + strName);	
		BufferedInputStream bis 
					= new BufferedInputStream(fis, 10);
		DataInputStream dis 
					= new DataInputStream(fis);
		
		Record r = Record.read(dis);
		
		System.out.println("Record:" + r);
		dis.close();
	}

	private void demoBufferedOutputStream(String strPath, 
					String strName) throws IOException 
	{
		FileOutputStream fos = new FileOutputStream(strPath + strName);	
		BufferedOutputStream bos = new BufferedOutputStream(fos, 1024);
		
		byte[] byteArray = "This is some data for the file".getBytes();
		bos.write(byteArray);
		
		bos.flush();
		bos.close();
	}
	
	
	private void demoBufferedInputStream(String strPath, 
					String strName) throws IOException 
	{
		FileInputStream fis = new FileInputStream(strPath + strName);	
		BufferedInputStream bis = new BufferedInputStream(fis, 64);
		
		System.out.println("Mark Supported: " + bis.markSupported());
		/*
		bis.mark(0); //mark read position - start of the file
		bis.read();
		bis.skip(2);
		bis.read();
		bis.skip(-1);
		bis.reset();
		
		int data = bis.read();
		System.out.println((char) data);
		bis.close();
		*/
		System.out.println("\nAvailable bytes: " + bis.available());
		while(bis.available() != 0)
		{
			int data = bis.read();
			System.out.print((char) data);
		}
		System.out.println("\nAvailable bytes: " + bis.available());
		
		bis.close();
	}

	private void demoFileInputStream(String strPath, 
			String strName) throws IOException 
	{
		FileInputStream fis = new FileInputStream(strPath + strName);
		
		int data = fis.read();
		
		while(data != -1)
		{		
			System.out.print((char)data);
			data = fis.read();
		}

		fis.close();
	}

	private void demoFileOutputStream(String strPath, 
			String strName) throws IOException 
	{
		FileOutputStream fos = new FileOutputStream(strPath
							+ strName);
		
		byte[] byteArray = "Hello, it's Friday".getBytes();
		fos.write(byteArray);
		fos.close();
	}
	
	
	
	
	
}











