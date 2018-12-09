package net.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server {

	public void udpServerTest() throws IOException{
		//创建socket
		DatagramSocket server = new DatagramSocket(8888);
		//创建udp数据包
		byte[] container = new byte[1024];
		DatagramPacket packet = new DatagramPacket(container, container.length);
		server.receive(packet);
		//接收数据
//		byte[] data = packet.getData();
//		int len = packet.getLength();
//		System.out.println(new String(data, 0, len));
		
		double data = UtilConvert.byte2double(packet.getData());
		System.out.println(data);
		
		server.close();
	}
	
	public static void main(String[] args) {
		Server server = new Server();
		try {
			server.udpServerTest();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
