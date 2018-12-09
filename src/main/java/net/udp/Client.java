package net.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class Client {

	public void udpClientTest() throws IOException{
		DatagramSocket client = new DatagramSocket();
		
//		String msg = "udp编程";
//		byte[] data = msg.getBytes();
		double msg = 12.34;
		byte[] data = UtilConvert.double2byte(msg);
		
		DatagramPacket packet = new DatagramPacket(data, data.length,
				new InetSocketAddress("localhost", 8888));
		
		client.send(packet);
		client.close();
	}
	
	public static void main(String[] args) {
		Client client = new Client();
		try {
			client.udpClientTest();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
