package net.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {

	public static void main(String[] args) throws IOException {
		String name = null;
		while(true){
			System.out.println("请输入name: ");
			BufferedReader br = new BufferedReader(
					new InputStreamReader(System.in));
			name = br.readLine();
			if(name.equals("")){
				continue;
			}
			break;
		}
		
		Socket client = new Socket("localhost", 9999);
		
		new Thread(new Send(client, name)).start();
		new Thread(new Receive(client)).start();
	}
}
