/*
import java.net.*;
import java.io.*;
import java.util.Scanner;

public class NetExercise02{
   public static void main(String [] args)
   {
	   // create new keyboard scanner to read URL in
		Scanner kbd = new Scanner(System.in);
		String URL2Check;
		do {
			System.out.print("Enter URL to check, null to quit: ");
			System.out.flush();
			URL2Check = kbd.nextLine();
			if(!URL2Check.isEmpty()){
				try{
					URL url = new URL(URL2Check);
					printURLData (url);
				}catch(IOException e){
					e.printStackTrace();
				}
			}else{
				break;
			}
		} while (true);
		System.out.println("Exiting...");
			
	}
	  
	static void printURLData(URL url) {
		System.out.println("Protocol:" + url.getProtocol());	
		System.out.println("File:" + url.getFile());	
		System.out.println("Host:" + url.getHost());	
		System.out.println("Port:" + url.getPort());	
		System.out.println("Authority:" + url.getAuthority());	
		System.out.println("Path:" + url.getPath());	
		System.out.println("DefaultPort:" + url.getDefaultPort());	
		System.out.println("Query:" + url.getQuery());	
		System.out.println("Ref:" + url.getRef());	
		System.out.println();
	}
}*/