package com.netty.base;

import java.net.SocketAddress;
import java.util.Date;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;

public class MyServerHanlder implements ChannelHandler {

	@Override
	public void bind(ChannelHandlerContext arg0, SocketAddress arg1, ChannelPromise arg2) throws Exception {
		// TODO Auto-generated method stub

	}

	/*
	 * channelAction 
	 * channel 通道
	 * action  活跃的
	 * 当客户端主动链接服务端的链接后，这个通道就是活跃的了。也就是客户端与服务端建立了通信通道并且可以传输数据
	 * 
	 */
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(ctx.channel().localAddress().toString()+" channelActive");
	}

	/*
	 * channelInactive
	 * channel 	通道
	 * Inactive 不活跃的
	 * 当客户端主动断开服务端的链接后，这个通道就是不活跃的。也就是说客户端与服务端的关闭了通信通道并且不可以传输数据
	 * 
	 */
	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(ctx.channel().localAddress().toString()+" channelInactive");
	}

	/*
	 * channelRead
	 * channel 通道
	 * Read    读
	 * 简而言之就是从通道中读取数据，也就是服务端接收客户端发来的数据
	 * 但是这个数据在不进行解码时它是ByteBuf类型的后面例子我们在介绍
	 * 
	 */
	@Override
	public void channelRead(ChannelHandlerContext arg0, Object msg) throws Exception {
		// TODO Auto-generated method stub
		ByteBuf buf = (ByteBuf) msg;
		
		byte[] msgByte = new byte[buf.readableBytes()];
		buf.readBytes(msgByte);
		System.out.println(new Date()+" "+new String(msgByte,"UTF-8"));
	}

	/*
	 * channelReadComplete
	 * channel  通道
	 * Read     读取
	 * Complete 完成
	 * 在通道读取完成后会在这个方法里通知，对应可以做刷新操作
	 * ctx.flush()
	 */
	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		// TODO Auto-generated method stub
		ctx.flush();
	}

	@Override
	public void channelRegistered(ChannelHandlerContext arg0) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void channelWritabilityChanged(ChannelHandlerContext arg0) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void close(ChannelHandlerContext arg0, ChannelPromise arg1) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void connect(ChannelHandlerContext arg0, SocketAddress arg1, SocketAddress arg2, ChannelPromise arg3) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void disconnect(ChannelHandlerContext arg0, ChannelPromise arg1) throws Exception {
		// TODO Auto-generated method stub

	}

	/*
	 * exceptionCaught
	 * exception	异常
	 * Caught		抓住
	 * 抓住异常，当发生异常的时候，可以做一些相应的处理，比如打印日志、关闭链接
	 * 
	 */
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		// TODO Auto-generated method stub
		ctx.close();
		System.out.println("异常信息：\r\n"+cause.getMessage());
	}

	@Override
	public void flush(ChannelHandlerContext arg0) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void handlerAdded(ChannelHandlerContext arg0) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void handlerRemoved(ChannelHandlerContext arg0) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void read(ChannelHandlerContext arg0) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void userEventTriggered(ChannelHandlerContext arg0, Object arg1) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void write(ChannelHandlerContext arg0, Object arg1, ChannelPromise arg2) throws Exception {
		// TODO Auto-generated method stub

	}

}
