package com.socket.dxc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

import com.util.o;

public class ServerThread implements Runnable{

	//当前线程处理的socket
	Socket s = null;
	//当前线程处理的Socket对应的输入流
	BufferedReader br = null;
	
	public ServerThread(Socket s) throws IOException{
		this.s = s;
		//初始化该Socket对应的输入流
		br = new BufferedReader(new InputStreamReader(s.getInputStream()));
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			String content = null;
			//循环从Socket中读取客户端发送过来的数据
			while ((content = redFromClient()) != null) {
				//遍历SockerList中的Socket
				//将读到的内容向每个Socket发送一次
				for (Socket sk : MyService.socketList) {
					PrintStream ps = new PrintStream(s.getOutputStream());
					o.o(sk,ps);
					ps.print(content);
				}
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	//读取客户端数据的方法
	private String redFromClient() {
		try {
			return br.readLine();
			//异常，则表示该Socket对应的客户端已经关闭
		} catch (Exception e) {
			// TODO: handle exception
			MyService.socketList.remove(s);
		}
		return null;
	}
}
