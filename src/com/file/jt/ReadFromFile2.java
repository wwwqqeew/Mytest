package com.file.jt;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import com.util.ByteUtil;

public class ReadFromFile2 {
	/**
	 * 以字节为单位读取文件，常用于读二进制文件，如图片、声音、影像等文件。
	 * 
	 * @param fileName
	 *            文件的名
	 */
	public static void readFileByBytes(String fileName) {
		//File file = new File(fileName);
		InputStream in = null;
		try {
			//System.out.println("以字节为单位读取文件内容，一次读多个字节：");
			// 一次读多个字节
			byte[] tempbytes = new byte[8];
			//int byteread = 0;
			int n=0;
			in = new FileInputStream(fileName);
			//ReadFromFile.showAvailableBytes(in);
			// 读入多个字节到字节数组中，byteread为一次读入的字节数
			StringBuffer[] buffers = new StringBuffer[500];
			for(int j=0;j<buffers.length;j++)
			{
				 buffers[j] = new StringBuffer();
			}
			StringBuffer[] buffers1 = new StringBuffer[500];
			for(int j=0;j<buffers1.length;j++)
			{
				 buffers1[j] = new StringBuffer();
			}
			
			while (( in.read(tempbytes)) != -1) {
//				System.out.write(tempbytes, 0, byteread);
				//StringBuffer sbMsg = new StringBuffer();
				if (tempbytes != null) {
					for (int i = 0; i < tempbytes.length; i++) {
						//System.out.println(buffers[n].length());
						//buffers[n].append(ByteUtil.toInt16(tempbytes[i])).append("-");
						if(buffers[n].length()>2)
						{
							if(ByteUtil.toInt16(tempbytes[i]).equals("31")&&buffers[n].substring(buffers[n].length() -3,buffers[n].length() -1).equals("1e"))
							{	
								//System.out.println("1111111111");
								buffers[n].delete (buffers[n].length() -3,buffers[n].length() -1);							
								n++;							
							}else{								
								String s=ByteUtil.toInt16(tempbytes[i]);
								if(s.length()<2)
								{s="0"+s;}
								buffers[n].append(s).append("-");
							}
						}else
						{
							String s=ByteUtil.toInt16(tempbytes[i]);
							if(s.length()<2)
							{s="0"+s;}
							buffers[n].append(s).append("-");
						}
					}
				}
				//System.out.println(hexString2binaryString(hexString));
			}
			for(int i=1;i<n+1;i++)
			{
				System.out.println("line:"+i+"  "+buffers[i]);
			}
			
			
			
			
			
			
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e1) {
				}
			}
		}
	}
	//16进制转2进制----实例
	 
	   /* String hexString = "ABCD";  
	    System.out.println(hexString2binaryString(hexString));  */
		
	
	
	 public static String hexString2binaryString(String hexString)  
	    {  
	        if (hexString == null || hexString.length() % 2 != 0)  
	            return null;  
	        String bString = "", tmp;  
	        for (int i = 0; i < hexString.length(); i++)  
	        {  
	            tmp = "0000"  
	                    + Integer.toBinaryString(Integer.parseInt(hexString  
	                            .substring(i, i + 1), 16));  
	            bString += tmp.substring(tmp.length() - 4);  
	        }  
	        return bString;  
	    }  
	/**
	 * 显示输入流中还剩的字节数
	 * 
	 * @param in
	 */
	private static void showAvailableBytes(InputStream in) {
		try {
			System.out.println("当前字节输入流中的字节数为:" + in.available());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		String fileName = "20150128000500.dti";
		ReadFromFile2.readFileByBytes(fileName);
//		ReadFromFile.readFileByChars(fileName);
//		ReadFromFile.readFileByLines(fileName);
//		ReadFromFile.readFileByRandomAccess(fileName);
	}
}
