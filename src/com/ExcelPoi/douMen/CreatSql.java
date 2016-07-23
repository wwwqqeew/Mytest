package com.ExcelPoi.douMen;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import yuyin.speechProduction.spring.baiduTranslateMain;
import yuyin.speechProduction.voice.CreateSQL;

import com.string.StringUt;
import com.util.o;

public class CreatSql {
	static HashMap<String , String> hsType = new HashMap<String , String>();
	static HashMap<String , String> hsTypeRpAll = new HashMap<String , String>();
	static HashMap<String , String> hsPropertyName = new HashMap<String , String>();
	public CreatSql(){
		ready();
	}
	
	private static void ready() {
		create("ID" , "idInit", hsPropertyName);
		create("id" , "idInit", hsPropertyName);
		create("X" , "lat", hsPropertyName);
		create("Y" , "lng", hsPropertyName);
		create("x" , "lat", hsPropertyName);
		create("y" , "lng", hsPropertyName);
		create("描述" , "lng", hsPropertyName);
		
		create("Integer" , "tinyint(50)", hsType);
		create("经度" , "varchar(255)", hsType);
		create("纬度" , "varchar(255)", hsType);
		
		create("Char" , "varchar", hsTypeRpAll);
		create("[" , "(", hsTypeRpAll);
		create("]" , ")", hsTypeRpAll);
//		.replace("Char", "varchar").replace("[", "(").replace("]", ")")
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
	public static void main(String[] args) throws Exception {
		ready();
		o.o(creatPropertySql("测试","","测试"));
//		o.o(creatTableSql("name",creatPropertySql("name","Char[50]","测试"),"测试"));
	}
	/**
	 * 属性替换，替换掉可能冲突的关键字
	 * @param name
	 * @return
	 */
	public static String replaceTypeStr(String name){
		return replaceStr(name,hsType);
	}
	
	/**
	 * 属性替换，替换掉可能冲突的关键字
	 * @param name
	 * @return
	 */
	public static String replacePropertyStr(String name){
		return replaceStr(name,hsPropertyName);
	}
	/**
	 * 替换全部 ，返回替换完成后的字段
	 * @param name
	 * @param hs
	 * @return
	 */
	public static String replaceStrAll(String name, HashMap<String , String> hs) {
		//是否
		//否：
		if (StringUt.isNotNullOrEmpty(name)) {
			Iterator iter = hs.entrySet().iterator();  
	        while (iter.hasNext()) {  
	            Map.Entry<String, String> entry = (Map.Entry<String, String>) iter.next();  
	            if (name.indexOf(entry.getKey()) > -1) {
	            	name = name.replace(entry.getKey(), entry.getValue());
				}
//		            System.out.println("key:["+entry.getKey()+"], value:["+entry.getValue()+"]");
	        } 
		} else {
			return " varchar(255) ";
		}

		return name;
	}
	
	/**
	 *  根据字段替换（基础方法），找到的字段
	 * @param name
	 * @param hs
	 * @return
	 */
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
	 * @throws Exception 
	 */
	public static String creatPropertySql(String name ,String type, String nameCN ) throws Exception {
//		`channel`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '渠道类型' 
		StringBuilder str = new StringBuilder();
		name = replaceEmpInit(name);
		if (StringUt.isNotNullOrEmpty(name)) {
			//是否包含中文
			//否：
			if (StringUt.isContainChinese(name)) {
//				 baiduTranslateMain.Translate(StringUt.filterChinese(name)).replaceAll(" ", "");
				 str.append("\n ,`"+ baiduTranslateMain.Translate(StringUt.filterChinese(name)).replaceAll(" ", "")+"` ");
			} else {
				str.append("\n ,`"+replacePropertyStr(name)+"` ");
			}
		}else{
			return "";
		}
		
		if (StringUt.isNotNullOrEmpty(type) && type.indexOf("Integer") > -1) {
			str.append(replaceStrAll(replaceTypeStr(type),hsTypeRpAll) +" NULL DEFAULT NULL ");
		}else{
			str.append(replaceStrAll(replaceTypeStr(type),hsTypeRpAll)  +" CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ");
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
