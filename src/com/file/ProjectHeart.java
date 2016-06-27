package com.file;

import com.util.ByteUtil;

public class ProjectHeart {
	
	public static final byte SEPARATOR = 0x1e;//固定的信息分隔符1e
	public static final byte HEART_PARAMETER = 0x33;//固定的头参数33
	public static final String itemUpdateMarkALL = "0123";//所有的项更新标志
	
	public static final byte ITEMNO_0 = 0x00;//节目头
	public static final byte ITEMNO_1 = 0x01;//道路交通状况和旅行时间
	public static final byte ITEMNO_2 = 0x02;//交通管制和事件信息
	public static final byte ITEMNO_3 = 0x03;//停车诱导信息
	public static final byte ITEMNO_MAX = 0x63;//最大项目（其他位未定义）
	
	public static final byte CONTENT_TYPE_0 = 0x00;//无指定
	public static final byte CONTENT_TYPE_1 = 0x01;//道路交通状况和旅行时间
	public static final byte CONTENT_TYPE_2 = 0x02;//交通管制和事件信息
	public static final byte CONTENT_TYPE_3 = 0x03;//停车诱导信息
	public static final byte CONTENT_TYPE_MAX = 0x15;//最大（其他位未定义）
	
	public static final byte IF_TIME_MARK_0 = 0x00;//含有信息生成时间(否)
	public static final byte IF_TIME_MARK_1 = 0x01;//含有信息生成时间(是)
	
	private byte separator;//信息分隔符1e
	private byte heartParameter;//头参数
	private byte programNo;//节目编号
	private byte itemUpdateMark;//项更新标记
	private byte itemNo;//项编号
	private byte contentType;//内容种类
	private byte iFTimeMark;//信息提供时间标记
	private byte iFTimeHour;//信息提供时间（小时）
	private byte iFTimeMinute;//信息提供时间（分钟）
	
	/*
	 * 十六进制String转项头部
	 */
	public ProjectHeart strToProjectHeart(String data){
		int multiple = 2;//每一行byte数目
		int len = 1;
		data.substring(0*multiple, 1*len);
		if (Byte.parseByte(data.substring(0*multiple, 1*multiple), 16) != ProjectHeart.SEPARATOR) {
			System.out.println("固定的信息分隔符不正确");
			return null;
		}else{
			this.setSeparator(ProjectHeart.SEPARATOR);
		}
		len += 1;//加上信息分隔符长度
		if (Byte.parseByte(data.substring((len - 1) * multiple, len * multiple), 16) != ProjectHeart.HEART_PARAMETER) {
			System.out.println("数据头参数不正确");
			return null;
		}else{
			this.setHeartParameter(ProjectHeart.HEART_PARAMETER);
		}
		len += 1;//加数据头参数长度
		this.setProgramNo(Byte.parseByte(data.substring((len - 1) * multiple, len * multiple), 16));
		len += 1;//加节目编号长度
		String b3 = hexString2binaryString(""+Byte.parseByte(data.substring((len - 1) * multiple, len * multiple), 16));
		this.setItemUpdateMark(Byte.parseByte(b3.substring(0, 2),16));//（貌似有问题）
		this.setItemNo(Integer.valueOf(b3.substring(2, b3.length()),2).byteValue());//（貌似有问题）
		len += 1;//加项更新标志，项编号长度
		String b4 = hexString2binaryString(""+Byte.parseByte(data.substring((len - 1) * multiple, len * multiple), 16));
		this.setContentType(contentType);
//		Byte.parseByte(hexString2binaryString("41").substring(0, 2),16);
		return null;
	};
	
	public byte getSeparator() {
		return separator;
	}

	public void setSeparator(byte separator) {
		this.separator = separator;
	}

	public byte getHeartParameter() {
		return heartParameter;
	}

	public void setHeartParameter(byte heartParameter) {
		this.heartParameter = heartParameter;
	}

	public byte getProgramNo() {
		return programNo;
	}

	public void setProgramNo(byte programNo) {
		this.programNo = programNo;
	}

	public byte getItemUpdateMark() {
		return itemUpdateMark;
	}

	public void setItemUpdateMark(byte itemUpdateMark) {
		this.itemUpdateMark = itemUpdateMark;
	}

	public byte getItemNo() {
		return itemNo;
	}

	public void setItemNo(byte itemNo) {
		this.itemNo = itemNo;
	}

	public byte getContentType() {
		return contentType;
	}

	public void setContentType(byte contentType) {
		this.contentType = contentType;
	}

	public byte getiFTimeMark() {
		return iFTimeMark;
	}

	public void setiFTimeMark(byte iFTimeMark) {
		this.iFTimeMark = iFTimeMark;
	}

	public byte getiFTimeHour() {
		return iFTimeHour;
	}

	public void setiFTimeHour(byte iFTimeHour) {
		this.iFTimeHour = iFTimeHour;
	}

	public byte getiFTimeMinute() {
		return iFTimeMinute;
	}

	public void setiFTimeMinute(byte iFTimeMinute) {
		this.iFTimeMinute = iFTimeMinute;
	}

	private byte getItemUpdateMarkByB3(String b3Binary){
		return contentType;
	}
	
//	private static void getBinary(String b3Binary, int str,int end) {
//		String rt = b3Binary.substring(str, end);
//		for (int i = 0; rt.length() < 8; i++) {
//			rt = "0"+rt;
//		}
//		System.out.println(rt);
//	}
	
	/**
	 * 十六进制String（01 或者 1）转二进制String
	 * @param hexString 十六进制String
	 * @return 二进制String
	 */
	 public static String hexString2binaryString(String hexString)  
	    {  
	        if (hexString == null ){
	        	return null;  
	        }
	        if (hexString.length() % 2 != 0){
	        	if (hexString.length() == 1) {
	        		hexString = "0"+hexString;
				}else{
					return null;  
				}
	        }
	        String bString = "";
	        String tmp;  
	        for (int i = 0; i < hexString.length(); i++)  
	        {  
	            tmp = "0000"+ Integer.toBinaryString(Integer.parseInt(hexString  .substring(i, i + 1), 16));  
//	            System.out.println(i+":"+tmp);
	            bString += tmp.substring(tmp.length() - 4);  
	        }  
	        return bString;  
	    } 
	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		"1e332f411805";
		byte[] pj = "1e332f411805".getBytes();
		int multiple = 2;
		System.out.println(Integer.valueOf("111111",2).byteValue());
		;
//		System.out.println(hexString2binaryString("41"));
//		System.out.println(Byte.parseByte(hexString2binaryString("41").substring(0, 2),16));
//		System.out.println(Byte.parseByte("1e332f411805".substring(0*multiple, 1*multiple), 16) == ProjectHeart.SEPARATOR);
//		StringBuffer sm = new StringBuffer();
//		System.out.println(hexString2binaryString("e"));
//		for (int i = 0; i < pj.length; i++) {
//			sm.append(pj[i]+"-");
//		}
//		System.out.println(sm);
		
//		String programHead = "154104100000c3df11";
//		System.out.println(programHead .substring(0,2));
	}

}
