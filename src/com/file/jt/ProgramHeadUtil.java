package com.file.jt;

import com.util.ByteUtil;

public class ProgramHeadUtil {
	
	public static ProgramHead getProgramHead(String programHead) {
		ProgramHead phead = new ProgramHead();
		//获得信息分割符号
		phead.setInformationPartition(Byte.valueOf("1E",16));
		//获得数据头类型参数
		phead.setDataHeadType(Byte.valueOf("31",16));
		//节目编号
		String programNumber = programHead.substring(0,2);
		phead.setProgramNumber(Byte.valueOf(programNumber,16));
		//节目更新标志
		String programUpdateMark = ReadFromFile.hexString2binaryString("0" + programHead.substring(2,3)).substring(0,2);
		phead.setProgramUpdateMark(ByteUtil.BinStringToByte(programUpdateMark));//(Byte.valueOf(programUpdateMark,2));
		//内容项总数
		String contentTotal = ReadFromFile.hexString2binaryString("0" + programHead.substring(2,3)).substring(6)+ReadFromFile.hexString2binaryString("0" + programHead.substring(3,4)).substring(4);
		phead.setContentTotal(ByteUtil.BinStringToByte(contentTotal));
		//提示功能
		String notificationCapabilities = programHead.substring(4,6);
		phead.setNotificationCapabilities(Byte.valueOf(notificationCapabilities,16));
		//服务分类
		String serviceClassification = ReadFromFile.hexString2binaryString("0" + programHead.substring(6,7));
		phead.setServiceClassification(ByteUtil.BinStringToByte(serviceClassification));
		//图幅列编号
		byte[] figureColumnNumber = new byte[2];
		String figureColumnNumberHight = ReadFromFile.hexString2binaryString("0" + programHead.substring(16,17)).substring(0,4)+"0000";//高四位
		String figureColumnNumberLow = ReadFromFile.hexString2binaryString(programHead.substring(12,14));//低八位
		figureColumnNumber[0] = ByteUtil.BinStringToByte(figureColumnNumberHight);
		figureColumnNumber[1] = ByteUtil.BinStringToByte(figureColumnNumberLow);
		phead.setFigureColumnNumber(figureColumnNumber);
		//图幅行编号
		String figureLineNumberHight = "0000" + ReadFromFile.hexString2binaryString("0" + programHead.substring(17)).substring(4);//高四位
		String figureLineNumberLow = ReadFromFile.hexString2binaryString(programHead.substring(14,16));//低八位
		byte[] figureLineNumber = new byte[2];
		figureLineNumber[0] = ByteUtil.BinStringToByte(figureLineNumberHight);
		figureLineNumber[1] = ByteUtil.BinStringToByte(figureLineNumberLow);
		phead.setFigureLineNumber(figureLineNumber);
		return phead;
	}
	
	public static void main(String[] args) {
		ProgramHead ph = getProgramHead("154104100000c3df11");
		System.out.println(ph.getInformationPartition());
		System.out.println(ph.getDataHeadType());
		System.out.println(ph.getProgramNumber());
		System.out.println(ph.getProgramUpdateMark());
		System.out.println(ph.getContentTotal());
		System.out.println(ph.getNotificationCapabilities());
		System.out.println(ph.getServiceClassification());
		System.out.println(ph.getFigureColumnNumber());
		System.out.println(ph.getFigureLineNumber());
	
	}
	
}
