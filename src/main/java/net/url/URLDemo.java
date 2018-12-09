package net.url;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import org.junit.jupiter.api.Test;


public class URLDemo {
	@Test
	public void URLMethodTest() throws IOException {
		//绝对路径构建
		URL url = new URL("http://www.baidu.com:80/index.html?uname=bjsxt");
		System.out.println("协议:"+url.getProtocol());
		System.out.println("域名:"+url.getHost());
		System.out.println("端口:"+url.getPort());
		System.out.println("资源:"+url.getFile());
		System.out.println("相对路径:"+url.getPath());
		System.out.println("锚点:"+url.getRef()); //锚点
		System.out.println("参数:"+url.getQuery());//?参数 :存在锚点  返回null ,不存在，返回正确
		
		url = new URL("http://www.baidu.com:80/a/");
		url = new URL(url,"b.txt"); //相对路径
		System.out.println(url.toString());
	}
	
	@Test
	public void URLStreamTest() throws IOException{
		URL url = new URL("http://www.baidu.com");
		
		InputStream is = url.openStream();
		
		byte[] flush = new byte[1024];
		int len = -0;
		while(-1 != (len = is.read(flush))){
			System.out.println(new String(flush, 0, len));
		}
		is.close();
	}
	
	@Test
	public void URLStreamEncodingTest() throws IOException{
		URL url = new URL("http://www.baidu.com");
		
		InputStreamReader is = new InputStreamReader(
				url.openStream(), "utf-8");
		OutputStreamWriter os = new OutputStreamWriter(
				new FileOutputStream("baidu.html"), "utf-8");
		
		BufferedReader br = new BufferedReader(is);
		BufferedWriter bw = new BufferedWriter(os);
		
		String msg = null;
		while(null != (msg=br.readLine())){
			bw.write(msg);
			bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	
}
