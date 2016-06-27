package com.socket.sk3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import com.util.o;

public class SocketClient {

	public static void main(String[] args) {
		Socket socket = null;
		try {
			socket = new Socket("127.0.0.1", 3030);
			//向服务器端第一次发送字符串   
			OutputStream netOut = socket.getOutputStream();
			DataOutputStream doc = new DataOutputStream(netOut);
			DataInputStream in = new DataInputStream(socket.getInputStream());
			//向服务器端第二次发送字符串   
			doc.writeUTF("list");
			doc.flush();
			o.o("发送完成");
			String res = in.readUTF();
			System.out.println(res);
			doc.writeUTF("bye");
			res = in.readUTF();
			System.out.println(res);
			doc.close();
			in.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
				}
			}
		}
	}
}

