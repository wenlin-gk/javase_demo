package net.chat;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class Receive implements Runnable{
	DataInputStream dis;
	boolean isRunning = true;

	public Receive(Socket client) {
		try {
			dis = new DataInputStream(client.getInputStream());
		} catch (IOException e) {
			stop();
		}
	}
	
	public String receive(){
		String msg = "";
		try {
			msg = dis.readUTF();
		} catch (IOException e) {
			stop();
		}
		return msg;
	}
	
	@Override
	public void run() {
		while(isRunning){
			System.out.println(receive());
		}
	}
	
	private void stop(){
		isRunning = false;
		CloseUtil.closeAll(dis);
	}
}
