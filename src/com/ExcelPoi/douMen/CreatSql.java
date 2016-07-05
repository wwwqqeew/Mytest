package com.ExcelPoi.douMen;

import java.util.HashMap;

import yuyin.speechProduction.voice.CreateSQL;

import com.string.StringUt;
import com.util.o;

public class CreatSql {
	static HashMap<String , String> hsType = new HashMap<String , String>();
	static HashMap<String , String> hsPropertyName = new HashMap<String , String>();
	public CreatSql(){
		ready();
	}
	
	private static void ready() {
		create("Integer" , "tinyint(50)", hsType);
		create("ID" , "idInit", hsPropertyName);
		create("id" , "idInit", hsPropertyName);
		create("X" , "lat", hsPropertyName);
		create("Y" , "lng", hsPropertyName);
		create("经度" , "Char[255]", hsType);
		create("纬度" , "Char[255]", hsType);
	}
	
	/**
	 * 命令以及SQL语句带入
	 * @param name
	 * @param sql
	 */
	private static void create(String name, String nameReplace, HashMap<String , String> hs){
		if (StringUt.isNotNullOrEmpty(name) && StringUt.isNotNullOrEmpty(nameReplace)) {
			hs.put(name, nameReplace);
		}
	}
	public static void main(String[] args) {
		ready();
		o.o(creatPropertySql("name","Integer","测试"));
		o.o(creatTableSql("name",creatPropertySql("name","Char[50]","测试"),"测试"));
	}
	
	public static String replaceTypeStr(String name){
		return replaceStr(name,hsType);
	}
	public static String replacePropertyStr(String name){
		return replaceStr(name,hsPropertyName);
	}
	
	public static String replaceStr(String name, HashMap<String , String> hs){
		String str = hs.get(name);
		//是否
		//否：
		if (str != null) {
			return str;
		} else {
			return name;
		}
	}
	
	/**
	 * 创建表格
	 * @param name
	 * @param propertySql
	 * @param nameCN
	 * @return
	 */
	public static String creatTableSql(String name ,String propertySql, String nameCN ) {
		StringBuilder str = new StringBuilder();
		if (StringUt.isNotNullOrEmpty(name) && StringUt.isNotNullOrEmpty(propertySql)) {
			str.append("CREATE TABLE `"+name+"` (`id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '"+nameCN+"' "+propertySql+" ,PRIMARY KEY (`id`))");
		}else{
			return "";
		}
		return str.toString();
	}
	
	/**
	 * 创建属性
	 * @param name
	 * @param type
	 * @param nameCN
	 * @return
	 */
	public static String creatPropertySql(String name ,String type, String nameCN ) {
//		`channel`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '渠道类型' 
		StringBuilder str = new StringBuilder();
		name = replaceEmpInit(name);
		if (StringUt.isNotNullOrEmpty(name)) {
			str.append("\n ,`"+replacePropertyStr(name)+"` ");
		}else{
			return "";
		}
		
		if (StringUt.isNotNullOrEmpty(type) && type.indexOf("Integer") > -1) {
			str.append(replaceTypeStr(type).replace("Char", "varchar").replace("[", "(").replace("]", ")") +" NULL DEFAULT NULL");
		}else{
			str.append(replaceTypeStr(type).replace("Char", "varchar").replace("[", "(").replace("]", ")") +" CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL");
		}
		
		if (StringUt.isNotNullOrEmpty(nameCN)) {
			str.append(" COMMENT '"+nameCN+"'");
		}else{
		}
		return str.toString();
	}
	
	/**
	 * 中途有空格的话，空格后的小写转大写
	 * @param name
	 * @return
	 */
	private static String replaceEmpInit(String name ) {
		int emptyInt = name.indexOf(" ");
		if (StringUt.isNotNullOrEmpty(name) && emptyInt >-1) {
			//非最后一位
			if (emptyInt != (name.length() -1)) {
				 char[] cs = name.toCharArray();
				 //是小写的话，小写转大学
				 if (StringUt.isLowercase(cs[emptyInt+2])) {
					 cs[emptyInt+1] -= 32;
				}
				 return String.valueOf(cs).replace(" ", "");
			}
		}
		return name;
	}
}
