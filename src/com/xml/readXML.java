package com.xml;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.JSON.Point;

public class readXML {

	/**
	 * @param args
	 * @throws DocumentException
	 */
	public static void main(String[] args) throws DocumentException {
//		getRiTu();
//		test();
		getBaidu();
	}

	public static void test() {
		SAXReader reader = new SAXReader();
		Document document = null;
		try {
			document = reader.read("http://42.62.56.73:8080/BaiduPOIService/getrgcinfo.xml?lng=116.3017193083&lat=41.050743859593");
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		Element root = document.getRootElement();
//		Element rootResult = root.element("Result");
		Element rootResult = root.element("ReverseGeocoderResponse");
		System.out.println(root.elementText("description"));
//		List<Attribute> list = rootResult.attributes();
//		// 遍历属性节点
//		for (Attribute attr : list) {
//			System.out.println(attr.getText() + "-----" + attr.getName()
//					+ "---" + attr.getValue());
//		}
		listNodes(root);
//		BDgetXMLByXY(41.050743859593, 116.3017193083);
	}

	public static void getBaidu() {
		//http://api.365ditu.mobi/service/BaseService.ashx?action=coordtrans&userid=test&password=test&lng="+ lng + "&lat=" + lat + "&trans=rt2bd";
		// TODO Auto-generated method stub

		SAXReader reader = new SAXReader();
		Document document = null;
		try {
			document = reader.read("http://api.365ditu.mobi/service/BaseService.ashx?action=coordtrans&userid=test&password=test&lng=113.111&lat=23.001&trans=rt2bd");
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		Element root = document.getRootElement();
//		Element rootResult = root.element("Result");
		Element rootResult = root.element("Coordinate");
		System.out.println(rootResult.attributeValue("Longitude"));
		System.out.println(rootResult.attributeValue("Latitude"));
//		List<Attribute> list = rootResult.attributes();
//		// 遍历属性节点
//		for (Attribute attr : list) {
//			System.out.println(attr.getText() + "-----" + attr.getName()
//					+ "---" + attr.getValue());
//		}
		listNodes(rootResult);
	
	}
	
	public static void getRiTu() {
		SAXReader reader = new SAXReader();
		Document document = null;
		try {
			document = reader.read("http://api.365ditu.mobi/service/BaseService.ashx?action=coordtrans&trans=bd2rt&userid=test&password=test&lng=119.35777222694&lat=25.907462154244");
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		Element root = document.getRootElement();
//		Element rootResult = root.element("Result");
		Element rootResult = root.element("Coordinate");
		System.out.println(rootResult.attributeValue("Longitude"));
//		List<Attribute> list = rootResult.attributes();
//		// 遍历属性节点
//		for (Attribute attr : list) {
//			System.out.println(attr.getText() + "-----" + attr.getName()
//					+ "---" + attr.getValue());
//		}
		listNodes(rootResult);
	}
	
	/**
	 * 根据坐标在百度获取数据
	 * @param lat
	 * @param lng
	 */
	private static void BDgetXMLByXY(double lat,double lng) {
		SAXReader reader = new SAXReader();
		Document document = null;
		try {
			document = reader.read("http://api.map.baidu.com/geocoder/v2/?ak=QNhWGopfB1Gs8u2WNBTe8fDy&callback=renderReverse&location=25.90747,119.36470&output=xml&pois=1");
		} catch (DocumentException e) {
			e.printStackTrace();
//			System.out.println("通过接口数据获取失败[lat:"+lat+"],[lon:"+lng+"]");
		}
		Element root = document.getRootElement();
		Element rootResult = root.element("result");
		Element rootPois = rootResult.element("pois");
		
		List nodes = rootPois.elements();
		HashMap<String, Point> hm = new HashMap<String, Point>();
		Point point = new Point();
		for (Iterator it = nodes.iterator(); it.hasNext();) {
			Element elm = (Element) it.next();
			point = new Point();
			point.setLongitue(elm.element("point").elementText("x"));
			point.setLatitude(elm.element("point").elementText("y"));
			hm.put(elm.elementText("distance"), point);
		}
		showAll(hm);
	}
	
	/**
	 * 显示所有HashMap中的数据
	 * @param hashMap
	 */
	public static void showAll(HashMap hashMap) {
		if (hashMap != null) {
			Iterator iter = hashMap.entrySet().iterator();  
	        while (iter.hasNext()) {  
	            Map.Entry<String, Integer> entry = (Map.Entry<String, Integer>) iter.next();  
	            String key = entry.getKey();  
//	            Integer value = entry.getValue();  
	            System.out.println("["+key+","+ entry.getValue()+"]");  
	        } 
		} else {
			System.out.println("HashMap为"+hashMap);
		}
		   
	}
	
	private static void testCoordtrans() throws DocumentException {
		String str = "<?xml version=\"1.0\" encoding=\"utf-8\"?><Result Success=\"True\" TotalCount=\"1\" Count=\"1\">  <Coordinate Longitude=\"119.36470\" Latitude=\"25.90747\" /></Result>";
		System.out.println("" + coordtrans(str, "Longitude"));
	}

	
	
	/**
	 * coordtrans接口的经纬度获取
	 * 
	 * @param name
	 * @return
	 * @throws DocumentException
	 */
	private static String coordtrans(String str, String name)
			throws DocumentException {
		String s = "﻿<?xml version=\"1.0\" encoding=\"utf-8\"?>";
		str = str.substring(s.length(), str.length());
		Document document = DocumentHelper.parseText(str);
		Element root = document.getRootElement();
		Element element = root.element("Coordinate");

		return element.attribute(name).getValue();
	}

	/**
	 * 遍历当前节点元素下面的所有(元素的)子节点
	 * 
	 * @param node
	 */
	public static void listNodes(Element node) {
		System.out.println("当前节点的名称：：" + node.getName());
		// 获取当前节点的所有属性节点
		List<Attribute> list = node.attributes();
		// 遍历属性节点
		for (Attribute attr : list) {
			System.out.println(attr.getText() + "-----" + attr.getName()
					+ "---" + attr.getValue());
		}

		if (!(node.getTextTrim().equals(""))) {
			System.out.println("文本内容：：：：" + node.getText());
		}

		// 当前节点下面子节点迭代器
		Iterator<Element> it = node.elementIterator();
		// 遍历
		while (it.hasNext()) {
			// 获取某个子节点对象
			Element e = it.next();
			// 对子节点进行遍历
			listNodes(e);
		}
	}

}
