package com.nio.lean;

import java.nio.file.*; 
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

public class Channel {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args)   {
		// TODO Auto-generated method stub
		System.out.println("开始了");
		try {
			RandomAccessFile aFile = new RandomAccessFile("d:/新建文本文档.txt", "rw");
			FileChannel inChannel = aFile.getChannel();

			ByteBuffer buf = ByteBuffer.allocate(48);

			
//			Charset latin1 = Charset.forName("ISO-8859-1");
//			CharsetDecoder decoder = latin1.newDecoder();
//			CharsetEncoder encoder = latin1.newEncoder();
//			CharBuffer cb = decoder.decode( buf );
//			buf = encoder.encode( cb );
			
			int bytesRead = inChannel.read(buf);
			while (bytesRead != -1) {

				//System.out.println("Read " + bytesRead);
				buf.flip();
	
				while(buf.hasRemaining()){
				System.out.print((char) buf.get());
				}
	
				buf.clear();
				bytesRead = inChannel.read(buf);
			}
			aFile.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
