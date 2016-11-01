
import java.io.*;
import java.net.*;

public class NetExercise03UDPServer {

	public static void main(String[] args) throws IOException{
		// The client does not need to have a well defined/published port
		// however a server does. Define our server port number
		int SERVER_PORT = 6789;
		
		DatagramSocket socket = new DatagramSocket(SERVER_PORT);

		//create data for our data in and out
		byte[] inServer = new byte[1024];
		byte[] outServer = new byte[1024];

		//receive pkt
		DatagramPacket rcvPkt = new DatagramPacket(inServer,inServer.length);
		socket.receive(rcvPkt);
		
		//retrive pkt info to send response to same sender
		InetAddress IP = rcvPkt.getAddress();
		int port = rcvPkt.getPort();

		//display that we received a request
		System.out.println("Packet Received form " + IP.toString() + " and source port " + port);

		
		//process data
		String temp = new String(rcvPkt.getData());
		temp = temp.toUpperCase();
		outServer = temp.getBytes();

		//send response packet to sender
		DatagramPacket sndPkt = new DatagramPacket(outServer, outServer.length, IP, port);
		socket.send(sndPkt);

	}
}