package net.chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
	private List<Server.Channel> channelList = new ArrayList<Server.Channel>();
	
	public static void main(String[] args) throws IOException {
		new Server().start();
	}
	
	public void start() throws IOException {
		ServerSocket server = new ServerSocket(9999);
		while(true){
			Socket socket = server.accept();
			Channel channel = new Channel(socket);
			channelList.add(channel);
			new Thread(channel).start();
		}
	}
	
	private class Channel implements Runnable{
		DataInputStream dis;
		DataOutputStream dos;
		boolean isRunning = true;
		String channelName;
		
		public Channel(Socket socket) {
			try {
				dis = new DataInputStream(socket.getInputStream());
				dos = new DataOutputStream(socket.getOutputStream());
				this.channelName = dis.readUTF();
				sendOthers(this.channelName + "进入聊天室", true);
			} catch (IOException e) {
				stop();
			}
		}

		private String receive(){
			String msg = "";
			try {
				msg = dis.readUTF();
			} catch (IOException e) {
				channelList.remove(this);
				stop();
			}
			return msg;
		}
		
		private void send(String msg){
			if(null==msg || msg.equals("")){
				return;
			}
			try {
				dos.writeUTF(msg);
				dos.flush();
			} catch (IOException e) {
				channelList.remove(this);
				stop();
			}
		}
		
		private void sendOthers(String msg, boolean isSystem){
			if(msg.startsWith("@") && msg.indexOf(":")>-1){
				String hisName = msg.substring(1, msg.indexOf(":"));
				String yourContent = msg.substring(msg.indexOf(":") + 1);
				for(Channel channel: channelList){
					if(channel.channelName.equals(hisName)){
						channel.send("user(" + this.channelName + ") to you: " + yourContent);
						return;
					}
				}
				StringBuilder sb  = new StringBuilder();
				sb.append("Please input correct username. User name list:\n");
				for(Channel channel: channelList){
					sb.append(channel.channelName).append("\n");
				}
				send(sb.toString());
			}else{
				for(Channel channel: channelList){
					if(channel == this){
						continue;
					}
					if(isSystem){
						channel.send("系统信息： " + msg);
					}else{
						channel.send("user(" + this.channelName + ") to everyone: " + msg);
					}
				}
			}
		}
		
		@Override
		public void run() {
			while(isRunning){
//				send(receive());
				sendOthers(receive(), false);
			}
		}
		
		private void stop(){
			isRunning = false;
			CloseUtil.closeAll(dis,dos);
		}
	}
}

