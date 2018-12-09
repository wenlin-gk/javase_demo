package net.tcp;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(8888);

		int times = 5;
		while(times-- > 0){
			Socket socket = server.accept();
			
			DataOutputStream dos = new DataOutputStream(
					socket.getOutputStream()
					);
			String msg = "Tcp server " + times + " test.";
			dos.writeUTF(msg);
			dos.flush();
		}
	}
}
