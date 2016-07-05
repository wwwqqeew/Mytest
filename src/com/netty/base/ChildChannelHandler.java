package com.netty.base;

import io.netty.channel.ChannelInitializer;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;

public class ChildChannelHandler extends ChannelInitializer<SocketChannel>{
	 
	@Override
	protected void initChannel(SocketChannel e) throws Exception {
 
		System.out.println("报告");
		System.out.println("信息：有一客户端链接到本服务端");
		System.out.println("IP:"+e.localAddress().getHostName());
		System.out.println("Port:"+e.localAddress().getPort());
		System.out.println("报告完毕");
		//在管道中添加我们自己的接收数据实现方法
		e.pipeline().addLast(new MyServerHanlder());
	}
 
}
