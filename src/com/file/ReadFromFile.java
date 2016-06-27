package com.file;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import com.util.ByteUtil;
public class ReadFromFile {
	/**
	 * 以字节为单位读取文件，并进行数据分组。
	 * 
	 * @param fileName
	 *            文件的名
	 */
	public static StringBuffer[] readFileByBytes(String fileName) {
		//File file = new File(fileName);
		InputStream in = null;
		StringBuffer[] buffers = new StringBuffer[500];
		buffers[0] = new StringBuffer();
		try {
			//System.out.println("以字节为单位读取文件内容，一次读多个字节：");
			// 一次读多个字节
			byte[] tempbytes = new byte[8];
			//int byteread = 0;
			int n=0;
			in = new FileInputStream(fileName);				
			while (( in.read(tempbytes)) != -1) {
				if (tempbytes != null) {
					for (int i = 0; i < tempbytes.length; i++) {
						if(buffers[n].length()>1)//数组长度超过2时判断是否有1e31出现
						{	//若当前读取的值为31且前一个值为1e，则删除前面的1e，并将数组下标加1，因此buffers[0]的数据为空，数组下标从1开始有数据
							if(ByteUtil.toInt16(tempbytes[i]).equals("31")&&buffers[n].substring(buffers[n].length() -2,buffers[n].length() ).equals("1e"))
							{								
								buffers[n].delete (buffers[n].length() -2,buffers[n].length() );							
								n++;	
								buffers[n] = new StringBuffer();
							}else{	//继续添加数据							
								String s=ByteUtil.toInt16(tempbytes[i]);
								if(s.length()<2)
								{s="0"+s;}
								buffers[n].append(s);
								//buffers[n].append(s).append("-");
							}
						}else//数组长度未超过2时添加数据
						{
							String s=ByteUtil.toInt16(tempbytes[i]);
							if(s.length()<2)
							{s="0"+s;}
							buffers[n].append(s);
						}
					}
				}
			}
			/*for(int i=1;i<n+1;i++)
			{
				System.out.println(buffers[i]);
			}*/
			
			
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
		return buffers;
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
	            tmp = "0000"+ Integer.toBinaryString(Integer.parseInt(hexString  
	                            .substring(i, i + 1), 16));  
	            System.out.println(i+":"+tmp);
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
		StringBuffer[] buff = new StringBuffer[500];
		StringBuffer[] buffHead = new StringBuffer[500];
		buff=ReadFromFile.readFileByBytes(fileName);
		for(int i=1;i<buff.length;i++)
		{
			if(buff[i]!=null)
			System.out.println(buff[i]);
		}
		buffHead=DataSeparate.getProgramHead(buff);
		for(int i=1;i<buffHead.length;i++)
		{
			if(buffHead[i]!=null)
			System.out.println(buffHead[i]+"-");
		}
//		ReadFromFile.readFileByChars(fileName);
//		ReadFromFile.readFileByLines(fileName);
//		ReadFromFile.readFileByRandomAccess(fileName);
	}
}
