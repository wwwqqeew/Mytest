package com.nio.my;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import com.nio.nioPG.AIOServer;

public class testNio extends Thread{

	private int port = 3300;
    final static String UTF_8 = "utf-8";
    static List<AsynchronousSocketChannel> channelList = new ArrayList<>();
	@Override
	public void run() {
		try {
			final AsynchronousServerSocketChannel server = AsynchronousServerSocketChannel.open();
			server.bind(new InetSocketAddress(this.port ));
			server.accept(null, new CompletionHandler<AsynchronousSocketChannel, Void>() {
				private AsynchronousServerSocketChannel serverChannel;

		        // 定义一个ByteBuffer准备读取数据
		        ByteBuffer buff = ByteBuffer.allocate(1024);
		        // 当实际IO操作完成时候触发该方法

				@Override
				public void completed(AsynchronousSocketChannel sc, Void attachment) {
					System.out.println("dfdsf");
                    buff.flip();
                    // 将buff中内容转换为字符串
                    String content = StandardCharsets.UTF_8.decode(buff).toString();
                    // 遍历每个Channel，将收到的信息写入各Channel中
                    for(AsynchronousSocketChannel c : testNio.channelList){
                            try{
                            	System.out.println("33333333");
                                    c.write(ByteBuffer.wrap(content.getBytes(testNio.UTF_8))).get();
                            }catch (Exception ex){
                                    ex.printStackTrace();
                            }
                    }
                    buff.clear();
                    // 读取下一次数据
                    server.accept( null , this);
            }

				@Override
				public void failed(Throwable exc, Void arg1) {
					server.accept(null, this);
				}
			});
			try {
				Thread.sleep(Long.MAX_VALUE);
			} catch (InterruptedException e) {
			}
		} catch (Exception e) {
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testNio testNio = new testNio();
		System.out.println("开始了");
		testNio.start();
	}

}
