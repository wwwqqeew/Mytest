package com.xml;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.JSON.showAllJSON;
import com.util.URLResource;
import com.util.Xml2Json;
import com.zhenZhe.StringUtils;

public class rituXML {

	public static void main(String[] args) {
		getHtml();
	}

	public static void getHtml() {
		String[] namesA =  {"福州","防城港","佛山","抚顺","抚州","阜新","阜阳"};
		HashMap<String ,String[]> hashMap = new HashMap();
		
		hashMap.put("A", namesA);
		
		String html = ""; 
		
		Iterator iter = hashMap.entrySet().iterator();  
        while (iter.hasNext()) {  
            Map.Entry<String, String[]> entry = (Map.Entry<String, String[]>) iter.next();  
//            System.out.println("["+entry.getKey()+","+entry.getValue()+"]"); 
            String[] names = entry.getValue();
            html +="\r\n "+entry.getKey();
    		for (String name : names) {
//    			String name = "白银";
    			String cityID = showAllJSON.getCityId(getCityidByName(name), "DistrictId");
    			html += "\r\n<div class='select-content-sub' id='"+cityID+"'>"+name+"</div>";
    		}
        } 
        

		
		System.out.println(html);
	}
	
	/**
	 *显示所有
	 * @param hashMap
	 */
	public static void showAll(HashMap hashMap) {
		if (hashMap != null) {
			Iterator iter = hashMap.entrySet().iterator();  
	        while (iter.hasNext()) {  
	            Map.Entry<String, String> entry = (Map.Entry<String, String>) iter.next();  
	            System.out.println("["+entry.getKey()+","+entry.getValue()+"]");  
	        } 
		} else {
			System.out.println("HashMapΪ"+hashMap);
		}
		   
	}

	public static String getCityidByName(String cityName) {
		String url ="http://api.365ditu.mobi/service/BaseService.ashx?action=getdistrict&userid=test&password=test&name="+cityName;
		URLResource urlResource = new URLResource();
		String json = "";
		try{
			String xml = urlResource.getURLResource(url);
//			System.out.println(xml);
			Xml2Json xml2Json = new Xml2Json();
			String xmlSubString = xml.substring(0, xml.indexOf("<Result"));
			xml = xml.replace(xmlSubString, "");
//			System.out.println(xml);
			json = xml2Json.toJson(xml).replace("@", "");
			
		}catch(Exception e){
			System.out.println("不能获取POI资源"+e.getMessage());
		}
//		json.
		json = StringUtils.replaceBlank(json);
//		System.out.println(json);
		return json;
	}
}
