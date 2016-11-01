/*
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class NetExercise01{
	public static void main(String [] args) {
		// this method prints local machine details 
		printLocalAddress();
		
		// create new keyboard scanner to read hostnames in
		Scanner kbd = new Scanner(System.in);

		String name2Resolve;
		do {
			System.out.print("Enter host name or IP address, null to quit: ");
			System.out.flush();
			name2Resolve = kbd.nextLine();
			if(!name2Resolve.isEmpty()){
				printRemoteAddress (name2Resolve);
			}else{
				break;
			}
		} while (true);
		System.out.println("Exiting...");
			
	}
	
	static void printLocalAddress() {
		try {
			InetAddress myself = InetAddress.getLocalHost ();
			System.out.println("name: "+myself.getHostName());
			System.out.println("IP: "+myself.getHostAddress());
		} catch (UnknownHostException ex) {
			System.out.println("Oh dear, I can not find myself...");
			ex.printStackTrace();
		}
	}

	static void printRemoteAddress(String name) {
		try {
			InetAddress remote = InetAddress.getByName(name);
			System.out.println("name: "+remote.getHostName());
			System.out.println("IP: "+remote.getHostAddress());
		} catch (UnknownHostException ex) {
			System.out.println("Can not find the host "+name);
		}
	}
}*/