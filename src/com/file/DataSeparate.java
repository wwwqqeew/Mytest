package com.file;

import java.io.InputStream;

public class DataSeparate {
	/**
	 * 获取节目头部
	 * 
	 * @param bufferName
	 *            数据的名
	 */
	public static StringBuffer[] getProgramHead(StringBuffer[] buffers) {
		StringBuffer[] buff = new StringBuffer[500];
		for(int i=1;i<buffers.length;i++)
		{
			if(buffers[i]!=null){
				System.out.println("删除了的"+buffers[i]);
				buff[i]=buffers[i].delete (buffers[i].indexOf("1e33"),buffers[i].length() );	
				}
		}
		
		return buff;
	}
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
