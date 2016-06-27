package com.socket.base;

import java.awt.print.PrinterGraphics;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.ServerSocketChannel;
import java.util.Date;

import com.util.o;

public class service {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		ServerSocket ss = new ServerSocket();
		ss.bind(new InetSocketAddress("127.0.0.1",3030));
//		new InetSocketAddress("192.168.1.100",3030)
		System.out.println("启动："+ss);
		BufferedReader br = null;
		String content = null;
		while (true) {
			//每当接受到客户的的Snocket请求时候，执行
			Socket s = ss.accept();
			InputStream in = s.getInputStream(); 
			DataOutputStream out = new DataOutputStream(s.getOutputStream());
			System.out.println("开始连接:"+s);
			
//			br = new BufferedReader(new InputStreamReader(s.getInputStream()));
//			content = br.readLine();
			o.o(new Date(),s,content);
			
			
//			 byte[] b = new byte[100];  
//	            int len;  
//	            try {  
//	                while ((len = in.read(b)) != -1) {  
//	                    String value = new String(b, 0, len);  
//	                    o.o("获取的：",value);
//	                    System.out.println("获取一次完成");
//	                }  
//	            } catch (Exception ex) {  
//	                //handle exception  
//	                ex.printStackTrace();  
//	            }
			
			System.out.println("11111");
//			Thread.sleep(10000);
//			PrintStream ps = new PrintStream(s.getOutputStream());
//			ps.println("收到信息");
//			o.o("服务器发送结束：");
//			ps.close();
//			s.close();
			
			
		}
	}

}
