package net.chat;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Send implements Runnable{
	private BufferedReader br;
	private DataOutputStream dos;
	private boolean isRunning = true;
	
	public Send(){
		br = new BufferedReader(new InputStreamReader(System.in));
	}
	
	public Send(Socket client, String name){
		this();
		try {
			dos = new DataOutputStream(client.getOutputStream());
			send(name);
		} catch (IOException e) {
			stop();
		}
	}
	
	private String getMsgFromConsole(){
		try {
			String info = br.readLine();
			return info;
		} catch (IOException e) {
		}
		return "";
	}
	
	private void send(String info){
		try {
			if( null!=info && !info.equals("")){
				dos.writeUTF(info);
				dos.flush();
			}
		} catch (IOException e) {
			stop();
		}
	}
	
	private void stop(){
		isRunning = false;
		CloseUtil.closeAll(br, dos);
	}
	
	@Override
	public void run() {
		while(isRunning){
			send(getMsgFromConsole());
		}
	}
}
