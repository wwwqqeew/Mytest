package com.ExcelPoi.douMen;


import java.io.InputStream;
import java.util.List;

import com.ExcelPoi.ReadExcel;

public class testMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<List<String>> list = testPoiU("E:\\公司资料\\珠海斗门\\嘉龙\\斗门数据2016年6月29日\\珠海斗门属性信息0701.xlsx",3);
		StringBuilder str = new StringBuilder();
		CreatSql creatSql = new CreatSql();
		System.out.println("数据条数："+list.size());
		for (int i = 0; i < list.size(); i++) {
			System.out.print(i +" ");
			for (int j = 0; j < list.get(i).size(); j++) {
				System.out.print("["+j+"]" + list.get(i).get(j)+"  "+list.get(i).get(j).indexOf(" "));
				if (i == 0) {
					str.append(creatSql.creatPropertySql(list.get(i).get(j), list.get(i+1).get(j), list.get(i+2).get(j)));
				}
			}
//			str.append(creatSql.creatPropertySql(list.get(i).get(0), list.get(i).get(1), ""));//园区属性
			System.out.println("");
		}
//		park(str, creatSql);
//		System.out.println(creatSql.creatTableSql("tourism", str.toString() , "旅游"));
//		System.out.println(creatSql.creatTableSql("government", str.toString() , "政府"));
//		System.out.println(creatSql.creatTableSql("enterprise", str.toString() , "企业"));
		System.out.println(creatSql.creatTableSql("individual", str.toString() , "个体"));
	}

	/**
	 * 园区
	 * @param str
	 * @param creatSql
	 */
	public static void park(StringBuilder str, CreatSql creatSql) {
		System.out.println(creatSql.creatTableSql("park", str.toString() , "园区"));
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
		List<List<String>> list = poi.read(fileName,sheetInt);
		return list;
	}
}
