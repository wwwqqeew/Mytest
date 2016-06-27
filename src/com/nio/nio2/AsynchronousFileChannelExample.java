package com.nio.nio2;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousCloseException;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import com.util.o;

public class AsynchronousFileChannelExample {

    public static void main(String[] args) throws IOException {
        new AsynchronousFileChannelExample();
    }
    
    public AsynchronousFileChannelExample() throws IOException {
        System.out.println("Opening file channel for reading and writing");
//        可通过将 java.nio.file.Path 对象传递到静态 open() 方法中，来创建一个新的通道：
//        open() 方法可利用附加选项来指定如何打开该文件。
//        例如，此调用打开文件以供读取或写入，如果必要将创建该文件，并在通道关闭或者 JVM 终止时尝试删除文件：
        final AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(Paths.get("afile"), 
                StandardOpenOption.READ, StandardOpenOption.WRITE,
                StandardOpenOption.CREATE, StandardOpenOption.DELETE_ON_CLOSE);

        CompletionHandler<Integer, Object> handler = new CompletionHandler<Integer, Object>() {
            @Override
            public void completed(Integer result, Object attachment) {
            	o.o("这是弄完了？");
                System.out.println(attachment + " completed with " + result + " bytes written");
            }
            
            @Override
            public void failed(Throwable e, Object attachment) {
            	o.o("出错了");
                if (e instanceof AsynchronousCloseException) {
                    System.out.println("File was closed before " + attachment + " executed");
                } else {
                    System.err.println(attachment + " failed with:");
                    e.printStackTrace();
                }
            }
        };
        
        byte[] contents = "hello  要发送的".getBytes();
        System.out.println("Initiating write operation 1");
        fileChannel.write(ByteBuffer.wrap(contents), 0, "Write operation 1", handler);
        contents = "goodbye".getBytes();
        System.out.println("Initiating write operation 2");
        fileChannel.write(ByteBuffer.wrap(contents), 0, "Write operation 2", handler);
        
        final ByteBuffer buffer = ByteBuffer.allocate(contents.length);
        System.out.println("Initiating read operation");
        fileChannel.read(buffer, 0, null, new CompletionHandler<Integer, Object>(){
            @Override
            public void completed(Integer result, Object attachment) {
                System.out.println("获取的：Read operation completed, file contents is: " + new String(buffer.array()));
                clearUp();
            }
            @Override
            public void failed(Throwable e, Object attachment) {
                System.err.println("获取出错了：Exception performing write");
                e.printStackTrace();
                clearUp();
            }
            
            private void clearUp() {
                try {
                    fileChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
