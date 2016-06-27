package com.socket.base;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import com.util.o;

public class client {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		Socket s= new Socket("191.168.230.45",3030);
//		Socket s= new Socket("127.0.0.1",3030);
		//超过2秒没有返回自动断开连接
//		s.setSoTimeout(2000);
//		DataOutputStream out = new DataOutputStream(s.getOutputStream());;
		OutputStream out = s.getOutputStream();
        System.out.println("连接已建立..."+s);  
                    
                  //发送消息  
        byte[] a = {0x0B,0x05};
        out.write(a);  
         o.o("发送完成");
        out.flush();  
//        out.close();
//		BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
//		String line = br.readLine();
//		o.o("服务器返回:",line);
//		br.close();
//		s.close();
        try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        out.close();
         try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
