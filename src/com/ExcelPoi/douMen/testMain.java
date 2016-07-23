package com.ExcelPoi.douMen;


import java.io.InputStream;
import java.util.List;

import com.ExcelPoi.ReadExcel;
import com.util.o;

public class testMain {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		List<List<String>> list = testPoiU("d:\\111.xlsx",1);
//		List<List<String>> list = testPoiU("E:\\公司资料\\珠海斗门\\嘉龙\\斗门数据2016年6月29日\\珠海斗门属性信息0701.xlsx",7);
		StringBuilder str = new StringBuilder();
		CreatSql creatSql = new CreatSql();
		System.out.println("数据条数："+list.size());
		for (int i = 0; i ==0; i++) {
			System.out.print(i +" ");
			for (int j = 0; j < list.get(i).size(); j++) {
				o.o(j, list.get(i).get(j), list.get(i).get(j).indexOf(" "),"".equals(list.get(i).get(j)));
				if (i == 0) {
					str.append(creatSql.creatPropertySql(list.get(i).get(j), "", list.get(i).get(j)));
				}
			}
//			str.append(creatSql.creatPropertySql(list.get(i).get(0), list.get(i).get(1), ""));//园区属性
			System.out.println("");
		}
//		park(str, creatSql);
//		System.out.println(creatSql.creatTableSql("tourism", str.toString() , "旅游"));
//		System.out.println(creatSql.creatTableSql("government", str.toString() , "政府"));
//		System.out.println(creatSql.creatTableSql("enterprise", str.toString() , "企业"));
//		System.out.println(creatSql.creatTableSql("individual", str.toString() , "个体"));
		System.out.println(creatSql.creatTableSql("basepoi", str.toString() , "基础poi"));
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
