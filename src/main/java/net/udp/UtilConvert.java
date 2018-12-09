package net.udp;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class UtilConvert {
	public static byte[] double2byte(double num) throws IOException {
		byte[] data = null;
		
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(bos);
		dos.writeDouble(num);
		dos.flush();

		// 获取数据
		data = bos.toByteArray();
		dos.close();
		return data;
	}
	
	public static double byte2double(byte[] data) throws IOException{
		DataInputStream dis =new DataInputStream(
				new ByteArrayInputStream(data));
		double num =dis.readDouble();
		dis.close();
		return num;
	}
}
