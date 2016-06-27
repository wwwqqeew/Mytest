package com;

import java.nio.ByteBuffer;
import java.util.Date;

import com.util.ByteUtil;

public class testByteBuffer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ByteBuffer bb = ByteBuffer.allocate(16);
		byte[] b = {5,4,8,6};
		bb.put(b);
		System.out.println(bb);
		bb.flip();
		System.out.println(bb);
		show("最后",bb.array());
//		StringBuffer
//		StringBuilder
	}

	/**
	 * 显示byte数组
	 * @param title
	 * @param bs
	 */
	private static void show(String title,byte[] bs) {
		StringBuffer sbMsg = new StringBuffer();
		for (int i = 0; i < bs.length; i++) {
			sbMsg.append(ByteUtil.toInt(bs[i])).append("-");
		}
		System.out.println(new Date()+"  "+title+"："+sbMsg);

	}
}
