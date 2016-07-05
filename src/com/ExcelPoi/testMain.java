package com.ExcelPoi;


import java.io.InputStream;
import java.util.List;

public class testMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<String>> list = testPoiU("E:\\公司资料\\珠海斗门\\嘉龙\\斗门数据2016年6月29日\\珠海斗门属性信息0701.xlsx",0);
		System.out.println("数据条数："+list.size());
		for (int i = 0; i < list.size(); i++) {
			System.out.print(i +" ");
			for (int j = 0; j < list.get(i).size(); j++) {
				System.out.print("["+j+"]" + list.get(i).get(j)+"  ");
			}
			System.out.println(" ");
		}
		
		
//		for (int i = 584; i < list.size(); i++) {
//			System.out.print(i +" ");
//			for (int j = 0; j < list.get(i).size(); j++) {
//				System.out.print("["+j+"] " + list.get(i).get(j));
//			}
//			System.out.println(" ");
//		}
	}

	/**
	 * 根据文件名和InputStream获取Excel所有列表的数据
	 * 
	 * @param fileName 文件名
	 * @param s InputStream
	 * @return List<List<String>>
	 */
	public static List<List<String>> testPoiU(String fileName,int sheetInt) {
		ReadExcel poi = new ReadExcel();
		List<List<String>> list = poi.read(fileName,1);
		return list;
	}
}
