import java.io.*;
import java.net.*;

public class NetExercise03UDPClient {

	public static void main(String[] args) throws IOException{

		// port number of the server we want to send data to
		int SERVER_PORT = 6789;
		
		//In Section 1 and 2 we used a scanner class, we can also use a buffered reader 
		//and input  stream reader to obtain data from the keyboard 
		BufferedReader kbd = new BufferedReader(new InputStreamReader(System.in));

		//create udp socket that we will use to send and receive our client data with
		DatagramSocket socket = new DatagramSocket();

		//creat buffers to process data
		byte[] inData = new byte[1024];
		byte[] outData = new byte[1024];

		//get ip destination wanted
		InetAddress IP = InetAddress.getByName("localhost");

		//read data from user
		System.out.println("Enter some lower case text to convert: ");
		outData = kbd.readLine().getBytes();

		//process user data and package up for sending
		DatagramPacket sendPkt = new DatagramPacket(outData, outData.length, IP, SERVER_PORT);
		socket.send(sendPkt);

		//create a packet object to reveive our response
		DatagramPacket recievePkt = new DatagramPacket(inData, inData.length);
		socket.receive(recievePkt);

		String inStr =  new String(recievePkt.getData());
		System.out.println("Replay from Server: " + inStr.trim());

	}
}