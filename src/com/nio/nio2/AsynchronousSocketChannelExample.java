package com.nio.nio2;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import com.util.o;

public class AsynchronousSocketChannelExample extends Thread  {

//	AsynchronousSocketChannelExample( AsynchronousServerSocketChannel server){
//		
//	}
	public static int port = 3333;
	public static Client client = null;
	public static  AsynchronousServerSocketChannel server = null;
	
    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
    	 server = AsynchronousServerSocketChannel.open().bind(new InetSocketAddress(port));
    	AsynchronousSocketChannelExample ss =  new AsynchronousSocketChannelExample();
    	ss.start();
//        AsynchronousServerSocketChannel server = AsynchronousServerSocketChannel.open().bind(new InetSocketAddress(port));
         client = new Client(server.getLocalAddress());
        client.start();
    }
    
    @Override
    public void run() {
    	try {
    		// TODO Auto-generated method stub
       	 System.out.println("Open server channel");
           
            System.out.println("Initiate accept");
            Future<AsynchronousSocketChannel> future = server.accept();
            
            // create a client
//            Client client = new Client(server.getLocalAddress());

            // wait for the accept to finish
            AsynchronousSocketChannel worker = future.get();
            System.out.println("Accept completed");
            
            // start client thread
//            client.start();
            o.o("线程开启结束 ");
            
            ByteBuffer readBuffer = ByteBuffer.allocate(100);
            try {
                // read a message from the client, timeout after 10 seconds
//                worker.read(readBuffer).get();
                worker.read(readBuffer).get(10, TimeUnit.SECONDS);
                System.out.println("Message received from client: " + new String(readBuffer.array()));
            } catch (Exception e) {
                System.out.println("Client didn't respond in time");
            }
            
//            client.join();
//            client.close();
//            server.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
    	
    }
    
 
}

class Client extends Thread {
    AsynchronousSocketChannel client;
    Future<Void> connectFuture;
    
    public Client(SocketAddress server) throws IOException {
        // open a new socket channel and connect to the server
        System.out.println("Open client channel");
        client = AsynchronousSocketChannel.open();
        System.out.println("Connect to server");
        connectFuture = client.connect(server);
    }
    
    public void run() {
        // if the connect hasn't happened yet cancel it
    	System.out.println("线程开始了");
        if (!connectFuture.isDone()) {
            connectFuture.cancel(true);
            return;
        }
        try {
            // send a message to the server
            ByteBuffer message = ByteBuffer.wrap("ping".getBytes());
            // wait for the response
            System.out.println("Sending message to the server...");
            int numberBytes = client.write(message).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
    
    public void close() throws IOException {
        client.close();
    }
}
