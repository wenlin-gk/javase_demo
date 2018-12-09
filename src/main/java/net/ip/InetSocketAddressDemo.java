package net.ip;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

public class InetSocketAddressDemo {

	public static void main(String[] args) throws UnknownHostException {
		InetSocketAddress  address = new InetSocketAddress("127.0.0.1",9999);
		address = new InetSocketAddress(InetAddress.getByName("127.0.0.1"),9999);
		System.out.println("hostname: " + address.getHostName());
		System.out.println("port: " + address.getPort());
		
		InetAddress addr =address.getAddress();
		System.out.println(addr.getHostAddress());  //返回：地址
		System.out.println(addr.getHostName());  //输出计算机名
	}
}
